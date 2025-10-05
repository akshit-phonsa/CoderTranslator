package com.example.codeTranslator.code_translator.controller;

import com.example.codeTranslator.code_translator.dto.*;
import com.example.codeTranslator.code_translator.service.impl.TranslateServiceForOpenAI;
import com.example.codeTranslator.code_translator.service.impl.TranslateServiceForPerplexity;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class TranslateController {

    private final TranslateServiceForPerplexity service;

    public TranslateController(TranslateServiceForPerplexity service) {
        this.service = service;
    }

    @PostMapping(value = "/translate")
    public Mono<TranslateResponse> translate(@Valid @RequestBody TranslateRequest req) {
        return service.translate(req);
    }

    @PostMapping(value = "/explain")
    public Mono<TranslateResponse> explain(@Valid @RequestBody ExplainRequest req) {
        return service.explain(req);
    }

    @PostMapping("/fix")
    public Mono<TranslateResponse> fix(@Valid @RequestBody FixRequest req) {
        return service.fixCode(req);
    }

    @PostMapping("/optimize")
    public Mono<TranslateResponse> optimize(@Valid @RequestBody OptimizeRequest req) {
        return service.optimizeCode(req);
    }

    @PostMapping("/fix-optimize")
    public Mono<TranslateResponse> fixAndOptimize(@Valid @RequestBody FixOptimizeRequest req) {
        return service.fixAndOptimizeCode(req);
    }
}