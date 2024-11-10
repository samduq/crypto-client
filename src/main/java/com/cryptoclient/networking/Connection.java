package com.cryptoclient.networking;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Connection {

    private final String host;
    private final int port;

    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;

    public Connection(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public String getHost() {
        return this.host;
    }

    public int getPort() {
        return this.port;
    }

    public Socket getSocket() {
        return this.socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public BufferedReader getReader() {
        return this.reader;
    }

    public void setReader(BufferedReader reader) {
        this.reader = reader;
    }

    public PrintWriter getWriter() {
        return this.writer;
    }

    public void setWriter(PrintWriter writer) {
        this.writer = writer;
    }

    public void connect() {
        try (Socket socket = new Socket(this.getHost(), this.getPort())) {
            System.out.println("Connected to the server.");
            this.setSocket(socket);
            this.setReader(new BufferedReader(new InputStreamReader(this.getSocket().getInputStream())));
            this.setWriter(new PrintWriter(this.getSocket().getOutputStream(), true));
            this.sendMessage(new JSONObject().put("key", "data")); // test
        } catch (Exception e) {
            System.out.println("Can not connect to the server.");
            System.out.println(e.getMessage());
        }
    }

    private void listenMessages() {

    }

    public void sendMessage(JSONObject message) {
        this.getWriter().println(message.toString());
        System.out.println("Message sent.");
    }
}
