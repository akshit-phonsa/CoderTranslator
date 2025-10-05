package com.example.codeTranslator.code_translator.dto;


import jakarta.validation.constraints.NotBlank;

public class ExplainRequest {
    @NotBlank
    private String code;

    @NotBlank
    private String sourceLang;

    // Default explanation language = English
    private String targetLang = "English";

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

    public String getTargetLang() {
        return targetLang;
    }

    public void setTargetLang(String targetLang) {
        this.targetLang = targetLang;
    }
}