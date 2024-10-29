package com.cryptoclient.window;

import com.cryptoclient.vues.Login;

import javax.swing.*;
import java.awt.*;

public class ClientApp extends JFrame {

    public ClientApp(String title, int width, int height, boolean resizable) {
        super();
        this.setTitle(title);
        this.setSize(width, height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(255, 229, 172));

        this.loadLoginVue();
    }

    private void loadLoginVue() {
        // Size
        int width = 500;
        int height = 160;

        // Creation of the vue
        Login loginVue = new Login(width, height);
        loginVue.setOpaque(false);

        // Position: center
        loginVue.setBounds((this.getWidth() - width) / 2, (this.getHeight() - height) / 2, width, height);

        // Add it to the content pane
        this.getContentPane().add(loginVue);
    }
}
