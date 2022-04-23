package com.project.abbTask.model.enums;

public enum CustomerStatus {
    ADMIN("ADMIN"),USER("USER");

    String status;

    CustomerStatus(String status) {
        this.status = status;
    }
}
