package com.example.codeTranslator.code_translator.dto;

import jakarta.validation.constraints.NotBlank;

public class FixOptimizeRequest {
    @NotBlank
    private String code;

    @NotBlank
    private String sourceLang;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSourceLang() {
        return sourceLang;
    }

    public void setSourceLang(String sourceLang) {
        this.sourceLang = sourceLang;
    }
}