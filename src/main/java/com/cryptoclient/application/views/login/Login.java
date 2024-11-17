package com.cryptoclient.application.views.login;

import com.cryptoclient.application.views.View;
import com.cryptoclient.application.views.login.components.PasswordField;
import com.cryptoclient.application.views.login.components.UsernameField;

import javax.swing.*;
import java.awt.*;

public class Login extends View {

    private int textSize;
    private int inputColumns;

    private JLabel title;
    private UsernameField usernameField;
    private PasswordField passwordField;
    private JButton loginButton;

    public Login() {
        this.textSize = 23;
        this.inputColumns = 11;
        this.title = new JLabel("Bienvenue !");
        this.usernameField = new UsernameField("Pseudo", this.getInputColumns(), this.getTextSize());
        this.passwordField = new PasswordField("Mot de passe", this.getInputColumns(), this.getTextSize());
        this.loginButton = new JButton("Se connecter");
    }

    public int getTextSize() {
        return this.textSize;
    }

    public int getInputColumns() {
        return this.inputColumns;
    }

    public JLabel getTitle() {
        return this.title;
    }

    public UsernameField getUsernameField() {
        return this.usernameField;
    }

    public PasswordField getPasswordField() {
        return this.passwordField;
    }

    public JButton getLoginButton() {
        return this.loginButton;
    }

    public void setTextSize(int textSize) {
        this.textSize = textSize;
    }

    public void setInputColumns(int inputColumns) {
        this.inputColumns = inputColumns;
    }

    public void setTitle(JLabel title) {
        this.title = title;
    }

    public void setUsernameField(UsernameField usernameField) {
        this.usernameField = usernameField;
    }

    public void setPasswordField(PasswordField passwordField) {
        this.passwordField = passwordField;
    }

    public void setLoginButton(JButton loginButton) {
        this.loginButton = loginButton;
    }

    @Override
    public void loadComponents() {
        this.setLayout(new GridBagLayout());
        this.setBackground(new Color(39, 33, 37));
        GridBagConstraints gbc = new GridBagConstraints();

        this.getTitle().setFont(new Font("Arial", Font.PLAIN, 40));
        this.getTitle().setForeground(new Color(133, 122, 129));
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 40, 0);
        this.add(this.getTitle(), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 20, 0);
        this.add(this.getUsernameField(), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.insets = new Insets(0, 0, 20, 0);
        this.add(this.getPasswordField(), gbc);

        this.getLoginButton().setFont(new Font("Arial", Font.PLAIN, this.getTextSize()));
        this.getLoginButton().setForeground(Color.WHITE);
        this.getLoginButton().setBackground(new Color(244, 69, 46));
        this.getLoginButton().setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        this.getLoginButton().setFocusPainted(false);
        this.getLoginButton().setCursor(new Cursor(Cursor.HAND_CURSOR));
        gbc.gridx = 1;
        gbc.gridy = 3;
        this.add(this.getLoginButton(), gbc);
    }
}
