package com.atypon.training.project.server.view;

import com.atypon.training.project.Constants;
import com.atypon.training.project.server.controller.ServerWorker;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        try {
            runServer();
        } catch (IOException e) {
        }
    }

    private static void runServer() throws IOException {
        Socket socket;
        ServerSocket serverSocket = new ServerSocket(Constants.PORT);
        ExecutorService executorService = Executors.newCachedThreadPool();

        while ((socket = serverSocket.accept()) != null) {
            executorService.submit(new ServerWorker(socket));
        }
    }
}
