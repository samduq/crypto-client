package com.cryptoclient.listener;

import com.cryptoclient.application.Application;
import com.cryptoclient.application.views.index.login.Login;
import com.cryptoclient.config.Configuration;
import com.cryptoclient.listener.login.LoginListener;
import com.cryptoclient.listener.register.RegisterListener;
import com.cryptoclient.networking.Connection;
import com.cryptoclient.networking.packets.headers.OutgoingHeaders;
import org.json.JSONObject;

public class EventsListener {

    private final Application application;
    private final Connection connection;

    // Define listeners
    private LoginListener loginListener;
    private RegisterListener registerListener;

    public EventsListener(Application application, Connection connection) {
        this.application = application;
        this.connection = connection;
    }

    public void listenAll() {
        // listen login
        this.setLoginListener(new LoginListener(this.getApplication(), this.getConnection()));
        this.getLoginListener().listen();

        // listen register
        this.setRegisterListener(new RegisterListener(this.getApplication(), this.getConnection()));
        this.getRegisterListener().listen();
    }

    public RegisterListener getRegisterListener() {
        return this.registerListener;
    }

    public void setRegisterListener(RegisterListener registerListener) {
        this.registerListener = registerListener;
    }

    public LoginListener getLoginListener() {
        return this.loginListener;
    }

    public void setLoginListener(LoginListener loginListener) {
        this.loginListener = loginListener;
    }

    public Connection getConnection() {
        return this.connection;
    }

    public Application getApplication() {
        return this.application;
    }

    public void listenLoginSubmit() {
        Login login = (Login) this.getApplication().getViewManager().getViews().get(Configuration.VIEW_LOGIN);
        login.getLoginButton().addActionListener(e -> {
            JSONObject packet = new JSONObject();
            packet.put("header", OutgoingHeaders.LOGIN_SUBMIT_REQUEST);
            packet.put("username", login.getUsernameField().getText());
            packet.put("password", login.getPasswordField().getText());
            this.getConnection().sendPacket(packet);
        });
    }
}
