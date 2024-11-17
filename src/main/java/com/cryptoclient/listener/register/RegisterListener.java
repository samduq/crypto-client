package com.cryptoclient.listener.register;

import com.cryptoclient.application.Application;
import com.cryptoclient.application.views.index.register.Register;
import com.cryptoclient.config.Configuration;
import com.cryptoclient.listener.ViewListener;
import com.cryptoclient.networking.Connection;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegisterListener extends ViewListener<Register> {

    public RegisterListener(Application application, Connection connection) {
        super(application, connection, (Register) application.getViewManager().getViews().get(Configuration.VIEW_REGISTER));
    }

    @Override
    public void listen() {
        this.listenGoToLogin();
    }

    private void listenGoToLogin() {
        this.getView().getLoginLabel().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                getApp().getViewManager().displayView(Configuration.VIEW_LOGIN);
            }
        });
    }
}
