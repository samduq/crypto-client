package com.cryptoclient.vues;

import javax.swing.*;
import java.awt.*;

public class Login extends JPanel {
    public Login(int width, int height) {
        super();
        GridLayout layout = new GridLayout(3, 1);
        layout.setHgap(-180);

        this.setLayout(layout);
        this.setSize(width, height);
        //this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        this.loadComponents();
    }

    private void loadComponents() {
        // Username fields
        JLabel usernameLabel = new JLabel("Username");
        JTextField usernameField = new JTextField();
        usernameField.setOpaque(false);
        usernameField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        usernameField.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0, 34)));

        // Password fields
        JLabel passwordLabel = new JLabel("Password");
        JPasswordField passwordField = new JPasswordField();
        passwordField.setOpaque(false);
        passwordField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        passwordField.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0, 34)));

        JButton loginButton = new JButton("Login!");

        this.add(usernameLabel);
        this.add(usernameField);
        this.add(passwordLabel);
        this.add(passwordField);
        this.add(new JLabel(""));
        this.add(loginButton);
    }
}
