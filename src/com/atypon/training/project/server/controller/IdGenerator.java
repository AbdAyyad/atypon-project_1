package com.atypon.training.project.server.controller;

import com.atypon.training.project.common.Constants;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class IdGenerator {
    private static IdGenerator instance;

    private int userId;
    private int licenseId;
    private int journalId;
    private int contentId;

    private IdGenerator() {
        initialize();
    }

    private void initialize() {
        try (Scanner sc = new Scanner(new FileInputStream(Constants.ID_FILE))) {
            initializeWithException(sc);
        } catch (Exception e) {
        }
    }

    private void initializeWithException(Scanner sc) throws Exception {
        this.userId = sc.nextInt();
        this.licenseId = sc.nextInt();
        this.journalId = sc.nextInt();
        this.contentId = sc.nextInt();
    }

    public static synchronized IdGenerator getInstance() {
        if (instance == null) {
            instance = new IdGenerator();
        }
        return instance;
    }

    private void updateFile() {
        try (PrintWriter printWriter = new PrintWriter(new FileOutputStream(Constants.ID_FILE))) {
            updateFileWithException(printWriter);
        } catch (Exception e) {
        }
    }

    private void updateFileWithException(PrintWriter printWriter) throws Exception {
        printWriter.println(userId);
        printWriter.println(licenseId);
        printWriter.println(journalId);
        printWriter.println(contentId);
        printWriter.flush();
    }

    public int createUserIdentity() {
        int id = userId;
        userId++;
        updateFile();
        return id;
    }

    public int createLicenseIdentity() {
        int id = licenseId;
        licenseId++;
        updateFile();
        return id;
    }

    public int createJournalIdentity() {
        int id = journalId;
        journalId++;
        updateFile();
        return id;
    }

    public int createContentIdentity() {
        int id = contentId;
        contentId++;
        updateFile();
        return id;
    }
}
