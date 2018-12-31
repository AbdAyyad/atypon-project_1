package com.atypon.training.project.controller;

public class DiskStorage {
    private static DiskStorage ourInstance = new DiskStorage();

    public static DiskStorage getInstance() {
        return ourInstance;
    }

    private DiskStorage() {
    }
}
