package com.atypon.training.project.server.controller;

import com.atypon.training.project.common.Constants;
import com.atypon.training.project.common.Response;
import com.atypon.training.project.server.controller.database.DataBase;
import com.atypon.training.project.server.controller.database.DataBaseFactory;
import com.atypon.training.project.server.model.content.BaseContent;
import com.atypon.training.project.server.model.jouranl.Journal;
import com.atypon.training.project.server.model.liscense.BaseLicense;
import com.atypon.training.project.server.model.user.BaseUser;

import java.util.Map;

public class ServerFacade {
    private DataBase<BaseUser> usersDataBase;
    private DataBase<BaseContent> contentDataBase;
    private DataBase<BaseLicense> licenseDataBase;
    private DataBase<Journal> journalDataBase;

    public ServerFacade() {
        usersDataBase = DataBaseFactory.getUserDataBaseInstance(Constants.USERS_FOLDER);
        contentDataBase = DataBaseFactory.getContentDataBaseInstance(Constants.CONTENTS_FOLDER);
        licenseDataBase = DataBaseFactory.getLicenseDataBaseInstance(Constants.LICENSES_FOLDER);
        journalDataBase = DataBaseFactory.getJournalDataBaseInstance(Constants.JOURNALS_FOLDER);
    }

    public Response loginUser(Map<String, String> params) {
        return null;
    }

    public Response getUser(Map<String, String> params) {
        return null;
    }

    public Response createUser(Map<String, String> params) {
        return null;
    }

    public Response updateUserLicense(Map<String, String> params) {
        return null;
    }

    public Response deleteUser(Map<String, String> params) {
        return null;
    }

    public Response getJournal(Map<String, String> params) {
        return null;
    }

    public Response createJournal(Map<String, String> params) {
        return null;
    }

    public Response updateJournal(Map<String, String> params) {
        return null;
    }

    public Response deleteJournal(Map<String, String> params) {
        return null;
    }

    public Response getContent(Map<String, String> params) {
        return null;
    }

    public Response createContent(Map<String, String> params) {
        return null;
    }

    public Response updateContent(Map<String, String> params) {
        return null;
    }

    public Response deleteContent(Map<String, String> params) {
        return null;
    }


    public Response getLicense(Map<String, String> params) {
        return null;
    }

    public Response createLicense(Map<String, String> params) {
        return null;
    }

    public Response updateLicense(Map<String, String> params) {
        return null;
    }

    public Response deleteLicense(Map<String, String> params) {
        return null;
    }


}
