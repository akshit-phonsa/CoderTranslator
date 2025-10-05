package com.example.codeTranslator.code_translator.util;

public class PromptBuilder {

    public static String buildPrompt(String sourceLang, String targetLang, String code) {
        // Clear instructions and a short few-shot example could be added here.
        StringBuilder sb = new StringBuilder();
        sb.append("You are an expert programmer and transpiler. Translate the following ")
                .append(sourceLang)
                .append(" code into ")
                .append(targetLang)
                .append(". Keep the same semantics and provide working, idiomatic ")
                .append(targetLang)
                .append(" code. If the translation requires additional imports or setup, include them. ")
                .append("Do NOT include commentary—only the code.\n\n");
        sb.append("### SOURCE CODE (").append(sourceLang).append("):\n");
        sb.append("```").append("\n");
        sb.append(code).append("\n");
        sb.append("```\n\n");
        sb.append("### TRANSLATED CODE (").append(targetLang).append("):\n");
        sb.append("```").append("\n");
        // model will finish with code block content
        return sb.toString();
    }
}