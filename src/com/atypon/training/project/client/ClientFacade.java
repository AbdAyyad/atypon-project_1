package com.atypon.training.project.client;

import com.atypon.training.project.common.Operation;
import com.atypon.training.project.common.Request;
import com.atypon.training.project.common.Response;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ClientFacade {
    private Scanner sc;

    public ClientFacade() {
        sc = new Scanner(System.in);
    }

    public void createUser() {
        Map<String, String> params = new HashMap<>();
        Response response;
        int choice;
        String name;
        String password;
        int privilege;
        System.out.print("0 for user 1 for Admin :");
        choice = sc.nextInt();
        params.put("choice", String.valueOf(choice));
        System.out.print("enter name: ");
        name = sc.next();
        params.put("userName", name);
        System.out.print("enter password: ");
        password = sc.next();
        params.put("password", password);
        System.out.println("0 for Base Privilege");
        System.out.println("1 for Premium Privilege");
        privilege = sc.nextInt();
        if (choice == 0) {
            params.put("userPrivilege", String.valueOf(privilege));
        } else if (choice == 1) {
            params.put("adminPrivilege", String.valueOf(privilege));
        }
        response = SocketConnection.sendRequestAndReceiveResponse(new Request(Operation.CreateUser, params));
        System.out.println(response.getBody());
    }

    public void updateUser() {
        Map<String, String> params = new HashMap<>();
        Response response;
        int choice;
        int id;
        String name;
        String password;
        int privilege;
        int licenseId;
        LocalDate timeStamp;

        System.out.print("0 for user 1 for Admin :");
        choice = sc.nextInt();
        params.put("choice", String.valueOf(choice));

        System.out.print("enter id: ");
        id = sc.nextInt();
        params.put("id", String.valueOf(id));

        System.out.print("enter name: ");
        name = sc.next();
        params.put("userName", name);

        System.out.print("enter password: ");
        password = sc.next();
        params.put("password", password);

        timeStamp = LocalDate.now();
        params.put("timeStamp", timeStamp.toString());

        System.out.println("0 for Base Privilege");
        System.out.println("1 for Premium Privilege");
        privilege = sc.nextInt();
        if (choice == 0) {
            params.put("userPrivilege", String.valueOf(privilege));
            System.out.print("enter license id: ");
            licenseId = sc.nextInt();
            params.put("licenseId", String.valueOf(licenseId));
        } else if (choice == 1) {
            params.put("adminPrivilege", String.valueOf(privilege));
        }

        response = SocketConnection.sendRequestAndReceiveResponse(new Request(Operation.UpdateUser, params));
        System.out.println(response.getBody());
    }

    public void getUser() {
        Map<String, String> params = new HashMap<>();
        Response response;
        System.out.print("id :");
        params.put("id", sc.next());
        response = SocketConnection.sendRequestAndReceiveResponse(new Request(Operation.GetUser, params));
        System.out.println(response.getBody());
    }

    public void deleteUser() {
        Map<String, String> params = new HashMap<>();
        Response response;
        System.out.print("id :");
        params.put("id", sc.next());
        response = SocketConnection.sendRequestAndReceiveResponse(new Request(Operation.DeleteUser, params));
        System.out.println(response.getBody());
    }

    public void createJournal() {
        Map<String, String> params = new HashMap<>();
        Response response;
        System.out.print("journal Name : ");
        params.put("journalName", sc.next());
        response = SocketConnection.sendRequestAndReceiveResponse(new Request(Operation.CreateJournal, params));
        System.out.println(response.getBody());
    }

    public void updateJournal() {
        Map<String, String> params = new HashMap<>();
        Response response;
        System.out.print("id :");
        params.put("id", sc.next());
        System.out.print("journal Name : ");
        params.put("journalName", sc.next());
        params.put("timeStamp", LocalDate.now().toString());
        response = SocketConnection.sendRequestAndReceiveResponse(new Request(Operation.UpdateJournal, params));
        System.out.println(response.getBody());
    }

    public void getJournal() {
        Map<String, String> params = new HashMap<>();
        Response response;
        System.out.print("id :");
        params.put("id", sc.next());
        response = SocketConnection.sendRequestAndReceiveResponse(new Request(Operation.GetJournal, params));
        System.out.println(response.getBody());
    }

    public void deleteJournal() {
        Map<String, String> params = new HashMap<>();
        Response response;
        System.out.print("id :");
        params.put("id", sc.next());
        response = SocketConnection.sendRequestAndReceiveResponse(new Request(Operation.DeleteJournal, params));
        System.out.println(response.getBody());
    }

    public void createContent() {
        Map<String, String> params = new HashMap<>();
        Response response;
        System.out.print("title :");
        params.put("title", sc.next());
        System.out.print("body :");
        params.put("body", sc.next());
        System.out.print("authorId :");
        params.put("authorId", sc.next());
        System.out.print("journalId :");
        params.put("journalId", sc.next());

        response = SocketConnection.sendRequestAndReceiveResponse(new Request(Operation.CreateContent, params));
        System.out.println(response.getBody());

    }

    public void updateContent() {
        Map<String, String> params = new HashMap<>();
        Response response;
        System.out.print("id :");
        params.put("id", sc.next());
        System.out.print("title :");
        params.put("title", sc.next());
        System.out.print("body :");
        params.put("body", sc.next());
        System.out.print("authorId :");
        params.put("authorId", sc.next());
        System.out.print("journalId :");
        params.put("journalId", sc.next());
        params.put("timeStamp", LocalDate.now().toString());

        response = SocketConnection.sendRequestAndReceiveResponse(new Request(Operation.UpdateContent, params));
        System.out.println(response.getBody());

    }

    public void getContent() {
        Map<String, String> params = new HashMap<>();
        Response response;
        System.out.print("id :");
        params.put("id", sc.next());
        System.out.print("licenseId :");
        params.put("licenseId", sc.next());

        response = SocketConnection.sendRequestAndReceiveResponse(new Request(Operation.GetContent, params));
        System.out.println(response.getBody());
    }

    public void deleteContent() {
        Map<String, String> params = new HashMap<>();
        Response response;
        System.out.print("id :");
        params.put("id", sc.next());
        response = SocketConnection.sendRequestAndReceiveResponse(new Request(Operation.DeleteContent, params));
        System.out.println(response.getBody());
    }

    public void createLicence() {
    }

    public void updateLicence() {
    }

    public void getLicence() {
        Map<String, String> params = new HashMap<>();
        Response response;
        System.out.print("id :");
        params.put("id", sc.next());
        response = SocketConnection.sendRequestAndReceiveResponse(new Request(Operation.GetLicense, params));
        System.out.println(response.getBody());
    }

    public void deleteLicence() {
        Map<String, String> params = new HashMap<>();
        Response response;
        System.out.print("id :");
        params.put("id", sc.next());
        response = SocketConnection.sendRequestAndReceiveResponse(new Request(Operation.DeleteLicense, params));
        System.out.println(response.getBody());
    }
}
