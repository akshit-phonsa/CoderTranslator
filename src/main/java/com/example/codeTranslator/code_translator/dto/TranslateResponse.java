package com.example.codeTranslator.code_translator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TranslateResponse {
    private String translatedCode;
    private String model;
    private String rawModelOutput; // keep raw output for debugging
}