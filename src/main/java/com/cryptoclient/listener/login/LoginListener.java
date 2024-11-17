package com.cryptoclient.listener.login;

import com.cryptoclient.application.Application;
import com.cryptoclient.application.views.index.login.Login;
import com.cryptoclient.config.Configuration;
import com.cryptoclient.listener.ViewListener;
import com.cryptoclient.networking.Connection;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginListener extends ViewListener<Login> {

    public LoginListener(Application application, Connection connection) {
        super(application, connection, (Login) application.getViewManager().getViews().get(Configuration.VIEW_LOGIN));
    }

    @Override
    public void listen() {
        this.listenCreateAnAccount();
    }

    private void listenCreateAnAccount() {
        this.getView().getCreateAccountLabel().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                getApp().getViewManager().displayView(Configuration.VIEW_REGISTER);
            }
        });
    }
}
