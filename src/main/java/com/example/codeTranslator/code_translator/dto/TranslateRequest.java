package com.example.codeTranslator.code_translator.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TranslateRequest {
    @NotBlank
    private String sourceLang;
    @NotBlank
    private String targetLang;
    @NotBlank
    private String code;
}