package com.example.codeTranslator.code_translator.service.impl;

import com.example.codeTranslator.code_translator.dto.*;
import com.example.codeTranslator.code_translator.service.TranslateService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

@Service
public class TranslateServiceForPerplexity implements TranslateService {

    private static final Logger log = LoggerFactory.getLogger(TranslateServiceForPerplexity.class);

    private static final String MODEL = "sonar";

    private final WebClient client;
    private final ObjectMapper mapper = new ObjectMapper();

    public TranslateServiceForPerplexity(@Value("${perplexity.api.key}") String apiKey, WebClient.Builder builder) {
        this.client = builder
                .baseUrl("https://api.perplexity.ai")
                .defaultHeader("Authorization", "Bearer " + apiKey)
                .defaultHeader("Content-Type", "application/json")
                .build();
    }

    // Accept TranslateRequest directly
    public Mono<TranslateResponse> translate(TranslateRequest req) {
        String prompt = "Translate this " + req.getSourceLang() + " code to " + req.getTargetLang() + ":\n" + req.getCode();

        ObjectNode body = buildRequestBody(prompt);

        log.info("Perplexity API request body: {}", body.toPrettyString());

        return client.post()
                .uri("/chat/completions")
                .bodyValue(body.toString())
                .retrieve()
                .bodyToMono(String.class)
                .map(rawJson -> {
                    try {
                        JsonNode jsonNode = mapper.readTree(rawJson);
                        System.out.println("=== Perplexity API Response ===");
                        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    String translated = extractText(rawJson);
                    return new TranslateResponse(translated, MODEL, rawJson);
                })
                .onErrorResume(WebClientResponseException.class, ex -> {
                    log.error("Perplexity API error: {}", ex.getResponseBodyAsString(), ex);
                    return Mono.just(new TranslateResponse("", MODEL, ex.getResponseBodyAsString()));
                });
    }

    // Build the JSON request body
    private ObjectNode buildRequestBody(String prompt) {
        ObjectNode body = mapper.createObjectNode();
        body.put("model", MODEL);

        ArrayNode messages = mapper.createArrayNode();

        ObjectNode system = mapper.createObjectNode();
        system.put("role", "system");
        system.put("content", "You are a helpful assistant that translates code between programming languages.");
        messages.add(system);

        ObjectNode user = mapper.createObjectNode();
        user.put("role", "user");
        user.put("content", prompt);
        messages.add(user);

        body.set("messages", messages);
        body.put("temperature", 0.2);
        body.put("max_tokens", 512);

        return body;
    }

    // Extract the translated code from Perplexity response
    private String extractText(String rawJson) {
        try {
            JsonNode root = mapper.readTree(rawJson);
            JsonNode choices = root.get("choices");
            if (choices != null && choices.isArray() && choices.size() > 0) {
                JsonNode content = choices.get(0).get("message").get("content");
                if (content != null) {
                    return content.asText();
                }
            }
        } catch (Exception e) {
            log.error("Failed to parse Perplexity response", e);
        }
        return rawJson; // fallback
    }

    // Explain code in simple English (or given target language)
    public Mono<TranslateResponse> explain(ExplainRequest req) {
        String prompt = "Explain this " + req.getSourceLang() + " code in " + req.getTargetLang()
                + " in a simple and detailed way:\n" + req.getCode();

        ObjectNode body = buildRequestBody(prompt);

        // Print request
        try {
            System.out.println("=== Perplexity API Request Body (Explain) ===");
            System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(body));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return client.post()
                .uri("/chat/completions")
                .bodyValue(body.toString())
                .retrieve()
                .bodyToMono(String.class)
                .map(rawJson -> {
                    String explanation = extractText(rawJson);

                    // Print response
                    try {
                        JsonNode jsonNode = mapper.readTree(rawJson);
                        System.out.println("=== Perplexity API Response (Explain) ===");
                        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    return new TranslateResponse(explanation, MODEL, rawJson);
                })
                .onErrorResume(WebClientResponseException.class, ex -> {
                    System.err.println("Perplexity API error (Explain):");
                    System.err.println(ex.getResponseBodyAsString());
                    return Mono.just(new TranslateResponse("", MODEL, ex.getResponseBodyAsString()));
                });
    }
    // Fix errors in code and return corrected version
    public Mono<TranslateResponse> fixCode(FixRequest req) {
        String prompt = "Fix all syntax errors, bugs, and best practices in this "
                + req.getSourceLang() + " code. Return only the corrected code:\n" + req.getCode();

        ObjectNode body = buildRequestBody(prompt);

        // Print request
        try {
            System.out.println("=== Perplexity API Request Body (Fix Code) ===");
            System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(body));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return client.post()
                .uri("/chat/completions")
                .bodyValue(body.toString())
                .retrieve()
                .bodyToMono(String.class)
                .map(rawJson -> {
                    String fixedCode = extractText(rawJson);

                    // Print response
                    try {
                        JsonNode jsonNode = mapper.readTree(rawJson);
                        System.out.println("=== Perplexity API Response (Fix Code) ===");
                        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    return new TranslateResponse(fixedCode, MODEL, rawJson);
                })
                .onErrorResume(WebClientResponseException.class, ex -> {
                    System.err.println("Perplexity API error (Fix Code):");
                    System.err.println(ex.getResponseBodyAsString());
                    return Mono.just(new TranslateResponse("", MODEL, ex.getResponseBodyAsString()));
                });
    }

    // Optimize code for performance, readability, and best practices
    public Mono<TranslateResponse> optimizeCode(OptimizeRequest req) {
        String prompt = "Optimize this " + req.getSourceLang() +
                " code for performance, readability, and best practices. " +
                "Do not change functionality. Return only the optimized code:\n" + req.getCode();

        ObjectNode body = buildRequestBody(prompt);

        // Print request
        try {
            System.out.println("=== Perplexity API Request Body (Optimize Code) ===");
            System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(body));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return client.post()
                .uri("/chat/completions")
                .bodyValue(body.toString())
                .retrieve()
                .bodyToMono(String.class)
                .map(rawJson -> {
                    String optimizedCode = extractText(rawJson);

                    // Print response
                    try {
                        JsonNode jsonNode = mapper.readTree(rawJson);
                        System.out.println("=== Perplexity API Response (Optimize Code) ===");
                        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    return new TranslateResponse(optimizedCode, MODEL, rawJson);
                })
                .onErrorResume(WebClientResponseException.class, ex -> {
                    System.err.println("Perplexity API error (Optimize Code):");
                    System.err.println(ex.getResponseBodyAsString());
                    return Mono.just(new TranslateResponse("", MODEL, ex.getResponseBodyAsString()));
                });
    }

    // Fix errors AND optimize code in one request
    public Mono<TranslateResponse> fixAndOptimizeCode(FixOptimizeRequest req) {
        String prompt = "Fix all syntax errors and bugs in this " + req.getSourceLang() +
                " code, then optimize it for performance, readability, and best practices. " +
                "Do not change functionality. Return only the corrected and optimized code:\n" + req.getCode();

        ObjectNode body = buildRequestBody(prompt);

        // Print request
        try {
            System.out.println("=== Perplexity API Request Body (Fix + Optimize Code) ===");
            System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(body));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return client.post()
                .uri("/chat/completions")
                .bodyValue(body.toString())
                .retrieve()
                .bodyToMono(String.class)
                .map(rawJson -> {
                    String fixedOptimizedCode = extractText(rawJson);

                    // Print response
                    try {
                        JsonNode jsonNode = mapper.readTree(rawJson);
                        System.out.println("=== Perplexity API Response (Fix + Optimize Code) ===");
                        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    return new TranslateResponse(fixedOptimizedCode, MODEL, rawJson);
                })
                .onErrorResume(WebClientResponseException.class, ex -> {
                    System.err.println("Perplexity API error (Fix + Optimize Code):");
                    System.err.println(ex.getResponseBodyAsString());
                    return Mono.just(new TranslateResponse("", MODEL, ex.getResponseBodyAsString()));
                });
    }
}
