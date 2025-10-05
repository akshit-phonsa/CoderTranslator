//package com.example.codeTranslator.code_translator;
//
//import com.example.codeTranslator.code_translator.dto.*;
//import com.example.codeTranslator.code_translator.service.impl.TranslateServiceForPerplexity;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
//
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.web.reactive.server.WebTestClient;
//import reactor.core.publisher.Mono;
//
//@WebFluxTest
//class TranslateControllerTest {
//
//    @Autowired
//    private WebTestClient webTestClient;
//
//    @MockBean
//    private TranslateServiceForPerplexity service;
//
//    private final String MOCK_RESPONSE = "System.out.println(\"Hello World\");";
//
//    private TranslateResponse response;
//
//    @BeforeEach
//    void setup() {
//        response = new TranslateResponse(MOCK_RESPONSE, "sonar", "{ raw mock json }");
//    }
//
//    @Test
//    void testTranslate() {
//        TranslateRequest req = new TranslateRequest();
//        req.setCode("print('hello')");
//        req.setSourceLang("Python");
//        req.setTargetLang("Java");
//
//        Mockito.when(service.translate(req)).thenReturn(Mono.just(response));
//
//        webTestClient.post().uri("/api/translate")
//                .bodyValue(req)
//                .exchange()
//                .expectStatus().isOk()
//                .expectBody()
//                .jsonPath("$.translatedCode").isEqualTo(MOCK_RESPONSE);
//    }
//
//    @Test
//    void testExplain() {
//        ExplainRequest req = new ExplainRequest();
//        req.setCode("System.out.println(\"Hello\");");
//        req.setSourceLang("Java");
//
//        Mockito.when(service.explain(Mockito.any(ExplainRequest.class)))
//                .thenReturn(Mono.just(response));
//
//        webTestClient.post().uri("/api/explain")
//                .bodyValue(req)
//                .exchange()
//                .expectStatus().isOk()
//                .expectBody()
//                .jsonPath("$.translatedCode").isEqualTo(MOCK_RESPONSE);
//    }
//
//    @Test
//    void testFix() {
//        FixRequest req = new FixRequest();
//        req.setCode("System.out.println(Hello");
//        req.setSourceLang("Java");
//
//        Mockito.when(service.fixCode(Mockito.any(FixRequest.class)))
//                .thenReturn(Mono.just(response));
//
//        webTestClient.post().uri("/api/fix")
//                .bodyValue(req)
//                .exchange()
//                .expectStatus().isOk()
//                .expectBody()
//                .jsonPath("$.translatedCode").isEqualTo(MOCK_RESPONSE);
//    }
//
//    @Test
//    void testOptimize() {
//        OptimizeRequest req = new OptimizeRequest();
//        req.setCode("for(int i=0;i<10;i++){sum+=i;}");
//        req.setSourceLang("Java");
//
//        Mockito.when(service.optimizeCode(Mockito.any(OptimizeRequest.class)))
//                .thenReturn(Mono.just(response));
//
//        webTestClient.post().uri("/api/optimize")
//                .bodyValue(req)
//                .exchange()
//                .expectStatus().isOk()
//                .expectBody()
//                .jsonPath("$.translatedCode").isEqualTo(MOCK_RESPONSE);
//    }
//
//    @Test
//    void testFixOptimize() {
//        FixOptimizeRequest req = new FixOptimizeRequest();
//        req.setCode("public class A { public static void main(String[] args) { System.out.println(Hello) } }");
//        req.setSourceLang("Java");
//
//        Mockito.when(service.fixAndOptimizeCode(Mockito.any(FixOptimizeRequest.class)))
//                .thenReturn(Mono.just(response));
//
//        webTestClient.post().uri("/api/fix-optimize")
//                .bodyValue(req)
//                .exchange()
//                .expectStatus().isOk()
//                .expectBody()
//                .jsonPath("$.translatedCode").isEqualTo(MOCK_RESPONSE);
//    }
//}