package com.example.contentcalendar.model.Enums;

public enum Roles {
    ADMIN("admin"),
    USER("user");

    private final String description;

    Roles(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
