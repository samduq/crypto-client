package com.cryptoclient.application.views.index;

import com.cryptoclient.application.views.View;

import javax.swing.*;
import java.awt.*;

public class Login extends View {

    // Login components
    private JLabel usernameLabel;
    private JTextField usernameField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JButton button;

    public Login() {
        super();

        // Define dimensions
        int WIDTH = 500;
        int HEIGHT = 160;

        // Define the used layout and fix the content
        GridLayout layout = new GridLayout(3, 1);
        layout.setHgap(-180);
        this.setLayout(layout);
        this.setSize(WIDTH, HEIGHT);
        //this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        this.loadComponents();
    }

    public JLabel getUsernameLabel() {
        return this.usernameLabel;
    }

    public JTextField getUsernameField() {
        return this.usernameField;
    }

    public JLabel getPasswordLabel() {
        return this.passwordLabel;
    }

    public JPasswordField getPasswordField() {
        return this.passwordField;
    }

    public JButton getButton() {
        return this.button;
    }

    @Override
    public void loadComponents() {
        // Username fields
        this.usernameLabel = new JLabel("Username");
        this.usernameField = new JTextField();
        this.usernameField.setOpaque(false);
        this.usernameField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        this.usernameField.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0, 34)));

        // Password fields
        this.passwordLabel = new JLabel("Password");
        this.passwordField = new JPasswordField();
        this.passwordField.setOpaque(false);
        this.passwordField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        this.passwordField.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0, 34)));

        // Button field
        this.button = new JButton("Login!");

        this.add(this.usernameLabel);
        this.add(this.usernameField);
        this.add(this.passwordLabel);
        this.add(this.passwordField);
        this.add(new JLabel(""));
        this.add(this.button);
    }
}
