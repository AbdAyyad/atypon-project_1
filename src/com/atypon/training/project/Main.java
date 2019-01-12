package com.atypon.training.project;

import com.atypon.training.project.common.Constants;
import com.atypon.training.project.server.controller.IdGenerator;
import com.atypon.training.project.server.controller.database.DataBase;
import com.atypon.training.project.server.controller.database.DataBaseFactory;
import com.atypon.training.project.server.model.content.BaseContent;
import com.atypon.training.project.server.model.content.PublicationContent;
import com.atypon.training.project.server.model.liscense.BaseLicense;
import com.atypon.training.project.server.model.liscense.ContentLicense;
import com.atypon.training.project.server.model.liscense.DateLicense;
import com.atypon.training.project.server.model.liscense.JournalLicense;
import com.atypon.training.project.server.model.user.BaseUser;
import com.atypon.training.project.server.model.user.User;
import com.atypon.training.project.server.model.user.UserPrivilege;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Thread[] arr = new Thread[5];
        for (int i = 0; i < 5; ++i) {
            arr[i] = new ThTest();
            arr[i].start();
        }
    }
}

class ThTest extends Thread {
    @Override
    public void run() {
        IdGenerator idGenerator = IdGenerator.getInstance();
        DataBase<BaseLicense> licenseDataBase = DataBaseFactory.getLicenseDataBaseInstance(Constants.LICENSES_FOLDER);
        DataBase<BaseContent> contentDataBase = DataBaseFactory.getContentDataBaseInstance(Constants.CONTENTS_FOLDER);

        LocalDate timeStamp = LocalDate.now();
        LocalDate end = LocalDate.now();
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        for (int i = 0; i < 3000; ++i) {
            if (i % 100 == 0) {
                System.out.println(i);
                System.out.println(Thread.currentThread());
            }
            BaseLicense license = new DateLicense(idGenerator.createLicenseIdentity(), timeStamp, end);
//            System.out.println(license);
            licenseDataBase.add(license);

            license = new ContentLicense(idGenerator.createLicenseIdentity(), timeStamp, set);
//            System.out.println(license);
            licenseDataBase.add(license);

            license = new JournalLicense(idGenerator.createLicenseIdentity(), timeStamp, 0);
//            System.out.println(license);
            licenseDataBase.add(license);

            BaseContent content = new PublicationContent(idGenerator.createContentIdentity(), timeStamp, 0, 0, "title", "body");
//            System.out.println(content);
            contentDataBase.add(content);
        }
    }
}
