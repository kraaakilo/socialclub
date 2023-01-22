package dev.kraaakilo.socialclub.services;

import org.springframework.stereotype.Component;

@Component
public class ValidateContent {
    public boolean validate(String s1, String s2) {
        return s1 != null || s2 != null;
    }
}
