package com.github.enesusta.validator.email;

public class EmailBean {

    @Email
    private String emailField;

    public String getEmailField() {
        return emailField;
    }

    public void setEmailField(String emailField) {
        this.emailField = emailField;
    }
}
