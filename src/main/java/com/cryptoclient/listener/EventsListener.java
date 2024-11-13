package com.cryptoclient.listener;

import com.cryptoclient.application.Application;
import com.cryptoclient.application.views.index.Login;
import com.cryptoclient.config.Configuration;
import com.cryptoclient.networking.Connection;
import com.cryptoclient.networking.packets.headers.OutgoingHeaders;
import org.json.JSONObject;

public class EventsListener {

    private final Application application;
    private final Connection connection;

    public EventsListener(Application application, Connection connection) {
        this.application = application;
        this.connection = connection;

        this.listenLoginSubmit();
    }

    public Connection getConnection() {
        return this.connection;
    }

    public Application getApplication() {
        return this.application;
    }

    public void listenLoginSubmit() {
        Login login = (Login) this.getApplication().getViewManager().getViews().get(Configuration.VIEW_LOGIN);
        login.getButton().addActionListener(e -> {
            JSONObject packet = new JSONObject();
            packet.put("header", OutgoingHeaders.LOGIN_SUBMIT_REQUEST);
            packet.put("username", login.getUsernameField().getText());
            packet.put("password", login.getPasswordField().getText());
            this.getConnection().sendPacket(packet);
        });
    }
}
