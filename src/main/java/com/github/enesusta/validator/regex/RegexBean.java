package com.github.enesusta.validator.regex;

class RegexBean {

    @Regex(pattern = "\\d")
    private String test1;

    void setTest1(String test1) {
        this.test1 = test1;
    }
}
