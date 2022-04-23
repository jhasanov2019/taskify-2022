package com.project.abbTask.model.enums;


public enum TaskStatus {
    BACKLOG("BACKLOG"), TODO("TODO"), INPROGRESS("INPROGRESS"), INREVIEW("INREVIEW"), DONE("DONE");

    private String status;

    TaskStatus(String status) {
        this.status = status;
    }
}
