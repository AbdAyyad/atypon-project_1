package com.atypon.training.project.server.controller;

public class Identities {
    private static Identities instance;

    private int userId;
    private int licenseId;
    private int journalId;
    private int contentId;

    private Identities() {
//        this.userId = userId;
//        this.licenseId = licenseId;
//        this.journalId = journalId;
//        this.contentId = contentId;
    }

    public static synchronized Identities getInstance() {
        if (instance == null) {
            instance = new Identities();
        }
        return instance;
    }

    public int createUserIdentity() {
        int id = userId;
        userId++;
        return id;
    }

    public int createLicenseIdentity() {
        int id = licenseId;
        licenseId++;
        return id;
    }

    public int createJournalIdentity() {
        int id = journalId;
        journalId++;
        return id;
    }

    public int createContentIdentity() {
        int id = contentId;
        contentId++;
        return id;
    }
}
