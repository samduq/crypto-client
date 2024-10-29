package com.cryptoclient;

import com.cryptoclient.window.ClientApp;

public class Main {
    public static void main(String[] args) {
        ClientApp app = new ClientApp("Cryptoapp: client", 1080, 720, false);

        app.setVisible(true);
        app.setResizable(false);
    }
}
