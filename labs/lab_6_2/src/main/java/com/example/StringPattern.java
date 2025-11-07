package com.example;

public enum StringPattern {
    CONTAINS_NUMBERS(".*\\d.*"),
    CONTAINS_UPPERCASE(".*[A-Z].*"),
    CONTAINS_SPECIAL_CHARACTERS(".*[!@#$%^&*(),.?\":{}|<>].*");
    
    private final String pattern;
    
    StringPattern(String pattern) {
        this.pattern = pattern;
    }
    
    public String getPattern() {
        return pattern;
    }
}
