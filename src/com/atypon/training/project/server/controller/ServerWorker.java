package com.atypon.training.project.server.controller;

import com.atypon.training.project.common.Request;
import com.atypon.training.project.common.Response;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerWorker implements Runnable {
    private Socket socket;
    private ObjectInputStream in;
    private ObjectOutputStream out;


    public ServerWorker(Socket socket) {
        initializeConnection(socket);
    }

    private void initializeConnection(Socket socket) {
        try {
            initializeConnectionWithException(socket);
        } catch (Exception e) {
        }
    }

    private void initializeConnectionWithException(Socket socket) throws Exception {
        this.socket = socket;
        in = new ObjectInputStream(socket.getInputStream());
        out = new ObjectOutputStream(socket.getOutputStream());
    }

    @Override
    public void run() {
        Request request = readRequest();
        Response response = null;
        if (request == null) {
            response = new Response();
        } else {
switch (request.getOperation()){}
        }
        sendResponse(response);
        closeConnection();
    }

    private Request readRequest() {
        try {
            return readRequestWithException();
        } catch (Exception e) {
            return null;
        }
    }

    private Request readRequestWithException() throws Exception {
        return (Request) in.readObject();
    }

    private void sendResponse(Response response) {
        try {
            sendResponseWithException(response);
        } catch (Exception e) {
        }
    }

    private void sendResponseWithException(Response response) throws Exception {
        out.writeObject(response);
        out.flush();
    }

    private void closeConnection() {
        try {
            closeConnectionWithException();
        } catch (Exception e) {
        }
    }

    private void closeConnectionWithException() throws Exception {
        in.close();
        out.close();
        socket.close();
    }

}
