package com.cryptoclient;

import com.cryptoclient.application.Application;
import com.cryptoclient.client.Client;
import com.cryptoclient.config.Configuration;

public class Main {
    public static void main(String[] args) {
        new Client();

        //testApp();
    }

    public static void testApp() {
        Application app = new Application(Configuration.WINDOW_TITLE, Configuration.WINDOW_WIDTH, Configuration.WINDOW_HEIGHT, Configuration.WINDOW_RESIZABLE);
        app.getViewManager().displayView(Configuration.VIEW_LOGIN);
        app.setVisible(true);
    }
}
