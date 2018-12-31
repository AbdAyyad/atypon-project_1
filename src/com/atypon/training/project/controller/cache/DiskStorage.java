package com.atypon.training.project.controller;

import com.atypon.training.project.model.Identifiable;

public class DiskStorage {
    private static DiskStorage ourInstance = new DiskStorage();

    public static DiskStorage getInstance() {
        return ourInstance;
    }

    private DiskStorage() {
    }

    public void write(Identifiable object) {
    }

    public Identifiable read(int id) {
        return null;
    }

    public void delete(int id){

    }
}
