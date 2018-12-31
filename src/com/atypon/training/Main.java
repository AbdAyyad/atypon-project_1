package com.atypon.training;

import com.atypon.training.project.controller.cache.DiskStorage;
import com.atypon.training.project.model.liscense.BaseLicense;
import com.atypon.training.project.model.liscense.ContentLicense;
import com.atypon.training.project.model.liscense.DateLicense;
import com.atypon.training.project.model.liscense.JournalLicense;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        DiskStorage diskStorage = DiskStorage.getInstance();
        LocalDate now = LocalDate.now();
        Set<Integer> s = new HashSet<>();
        s.add(1);
        s.add(2);
        s.add(3);
        LocalDate after = LocalDate.now().plusMonths(1);
        BaseLicense l = new ContentLicense(1, now, s);
        System.out.println(diskStorage.testXml(l));

        l = new DateLicense(2, now, after);
        System.out.println(diskStorage.testXml(l));

        l = new JournalLicense(3, now, 1);
        System.out.println(diskStorage.testXml(l));

    }
}
