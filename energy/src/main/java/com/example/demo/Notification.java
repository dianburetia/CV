package com.example.demo;

public class Notification {

    private String content;

    // Default constructor (required for Jackson)
    public Notification() {
    }

    // Constructor with content
    public Notification(String content) {
        this.content = content;
    }

    // Getter and setter for content
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
