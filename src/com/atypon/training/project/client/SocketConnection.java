package com.atypon.training.project.client;

import com.atypon.training.project.common.Constants;
import com.atypon.training.project.common.Request;
import com.atypon.training.project.common.Response;
import com.atypon.training.project.common.ResponseStatus;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SocketConnection {
    private SocketConnection() {
    }

    public static Response sendRequestAndReceiveResponse(Request request) {
        try (Socket socket = new Socket(Constants.HOST, Constants.PORT);
             ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream in = new ObjectInputStream(socket.getInputStream())
        ) {
            out.writeObject(request);
            out.flush();
            return (Response) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Response("", ResponseStatus.ServerError);
    }
}
