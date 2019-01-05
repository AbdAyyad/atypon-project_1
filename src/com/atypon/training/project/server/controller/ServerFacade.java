package com.atypon.training.project.server.controller;

import com.atypon.training.project.common.Constants;
import com.atypon.training.project.common.Response;
import com.atypon.training.project.common.ResponseStatus;
import com.atypon.training.project.server.controller.database.DataBase;
import com.atypon.training.project.server.controller.database.DataBaseFactory;
import com.atypon.training.project.server.model.content.BaseContent;
import com.atypon.training.project.server.model.jouranl.Journal;
import com.atypon.training.project.server.model.liscense.BaseLicense;
import com.atypon.training.project.server.model.user.*;

import java.time.LocalDate;
import java.util.Map;

public class ServerFacade {
    private DataBase<BaseUser> usersDataBase;
    private DataBase<BaseContent> contentDataBase;
    private DataBase<BaseLicense> licenseDataBase;
    private DataBase<Journal> journalDataBase;
    private Identities identities;

    public ServerFacade() {
        usersDataBase = DataBaseFactory.getUserDataBaseInstance(Constants.USERS_FOLDER);
        contentDataBase = DataBaseFactory.getContentDataBaseInstance(Constants.CONTENTS_FOLDER);
        licenseDataBase = DataBaseFactory.getLicenseDataBaseInstance(Constants.LICENSES_FOLDER);
        journalDataBase = DataBaseFactory.getJournalDataBaseInstance(Constants.JOURNALS_FOLDER);
        identities = Identities.getInstance();
    }

    private int getId(Map<String, String> params) {
        return Integer.parseInt(params.get("id"));
    }

    public Response loginUser(Map<String, String> params) {
        Response response;
        int id = getId(params);
        if (usersDataBase.contains(id)) {
            BaseUser user = usersDataBase.get(id);
            if (user.authenticate(params.get("password"))) {
                response = new Response("authenticate success", ResponseStatus.Success);
            } else {
                response = new Response("password mismatch", ResponseStatus.UnAuthorized);
            }
        } else {
            response = new Response("not found", ResponseStatus.NotFound);
        }
        return response;
    }

    public Response getUser(Map<String, String> params) {
        Response response;
        int id = getId(params);
        if (usersDataBase.contains(id)) {
            BaseUser user = usersDataBase.get(id);
            response = new Response(user.toString(), ResponseStatus.Success);
        } else {
            response = new Response("not found", ResponseStatus.NotFound);
        }
        return response;
    }

    public Response createUser(Map<String, String> params) {
        int choice = Integer.parseInt(params.get("choice"));
        BaseUser user;
        if (choice == 0) {
            user = createNormalUser(params);
        } else {
            user = createAdmin(params);
        }
        usersDataBase.add(user);
        return new Response("user/admin created successfully", ResponseStatus.Success);
    }

    private User createNormalUser(Map<String, String> params) {
        int userId = identities.createUserIdentity();
        String userName = params.get("userName");
        String password = params.get("password");
        LocalDate timeStamp = LocalDate.now();
        int userPrivilege = Integer.parseInt(params.get("userPrivilege"));
        return new User(userId, userName, password, timeStamp, 0, UserPrivilege.getPrivilege(userPrivilege));
    }

    private Admin createAdmin(Map<String, String> params) {
        int userId = identities.createUserIdentity();
        String userName = params.get("userName");
        String password = params.get("password");
        LocalDate timeStamp = LocalDate.now();
        int adminPrivilege = Integer.parseInt(params.get("adminPrivilege"));
        return new Admin(userId, userName, password, timeStamp, AdminPrivilege.getPrivilege(adminPrivilege));
    }


    public Response updateUser(Map<String, String> params) {
        return null;
    }

    public Response deleteUser(Map<String, String> params) {
        int id = getId(params);
        usersDataBase.delete(id);
        return new Response("delete success", ResponseStatus.Success);
    }

    public Response getJournal(Map<String, String> params) {
        Response response;
        int id = getId(params);
        if (journalDataBase.contains(id)) {
            Journal journal = journalDataBase.get(id);
            response = new Response(journal.toString(), ResponseStatus.Success);
        } else {
            response = new Response("not found", ResponseStatus.NotFound);
        }
        return response;
    }

    public Response createJournal(Map<String, String> params) {
        return null;
    }

    public Response updateJournal(Map<String, String> params) {
        return null;
    }

    public Response deleteJournal(Map<String, String> params) {
        int id = getId(params);
        journalDataBase.delete(id);
        return new Response("delete success", ResponseStatus.Success);
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
        int id = getId(params);
        contentDataBase.delete(id);
        return new Response("delete success", ResponseStatus.Success);

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
        int id = getId(params);
        licenseDataBase.delete(id);
        return new Response("delete success", ResponseStatus.Success);

    }


}
