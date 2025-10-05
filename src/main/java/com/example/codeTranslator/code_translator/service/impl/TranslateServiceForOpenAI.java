package com.example.codeTranslator.code_translator.service.impl;


import com.example.codeTranslator.code_translator.dto.TranslateRequest;
import com.example.codeTranslator.code_translator.dto.TranslateResponse;
import com.example.codeTranslator.code_translator.util.PromptBuilder;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import java.time.Duration;

@Service
public class TranslateServiceForOpenAI {

    private final WebClient openAiWebClient;
    private final ObjectMapper mapper = new ObjectMapper();

    @Value("${openai.api.model}")
    private String model;

    @Value("${openai.api.timeout-ms:60000}")
    private long timeoutMs;

    public TranslateServiceForOpenAI(WebClient openAiWebClient) {
        this.openAiWebClient = openAiWebClient;
    }

    public Mono<TranslateResponse> translate(TranslateRequest req) {
        String prompt = PromptBuilder.buildPrompt(req.getSourceLang(), req.getTargetLang(), req.getCode());
        System.out.println(prompt);
        // Build request body for OpenAI Responses API
        // Minimal example; adapt if you need messages or function calling
        JsonNode body = mapper.createObjectNode()
                .put("model", model)
                .put("input", prompt);

        return openAiWebClient.post()
                .uri("/responses")
                .bodyValue(body.toString())
                .retrieve()
                .bodyToMono(String.class)
                .timeout(Duration.ofMillis(timeoutMs))
                .map(raw -> {
                    // parse raw to get text content - exact path depends on model response shape
                    String translated = extractTextFromResponsesRaw(raw);
                    TranslateResponse resp = new TranslateResponse();
                    resp.setModel(model);
                    resp.setRawModelOutput(raw);
                    resp.setTranslatedCode(translated);
                    return resp;
                });
    }

    // Simple extractor: try to find "output" or "content" fields
    private static String extractTextFromResponsesRaw(String rawJson) {
        try {
            ObjectMapper m = new ObjectMapper();
            JsonNode root = m.readTree(rawJson);
            // New Responses API usually places text content in: output[0].content[0].text or similar.
            // We'll attempt multiple fallbacks for robustness:
            if (root.has("output")) {
                JsonNode output = root.get("output");
                if (output.isArray() && output.size() > 0) {
                    JsonNode first = output.get(0);
                    // look for "content"
                    if (first.has("content") && first.get("content").isArray()) {
                        for (JsonNode c : first.get("content")) {
                            if (c.has("text")) {
                                return c.get("text").asText();
                            } else if (c.has("type") && c.get("type").asText().equals("output_text") && c.has("text")) {
                                return c.get("text").asText();
                            }
                        }
                    }
                }
            }
            // fallback: try "choices" array (older completions-style)
            if (root.has("choices")) {
                JsonNode choices = root.get("choices");
                if (choices.isArray() && choices.size() > 0) {
                    JsonNode msg = choices.get(0);
                    if (msg.has("message") && msg.get("message").has("content")) {
                        JsonNode content = msg.get("message").get("content");
                        // content could be string or array
                        if (content.isTextual()) return content.asText();
                        if (content.isArray()) {
                            StringBuilder sb = new StringBuilder();
                            content.forEach(n -> sb.append(n.asText()));
                            return sb.toString();
                        }
                    }
                    if (msg.has("text")) return msg.get("text").asText();
                }
            }
            // last fallback: return original JSON
            return rawJson;
        } catch (Exception e) {
            return rawJson;
        }
    }
}


