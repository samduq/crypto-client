package com.cryptoclient.application;

import com.cryptoclient.application.views.ViewManager;

import javax.swing.*;
import java.awt.*;

public class Application extends JFrame {

    private ViewManager viewManager;

    public Application(String title, int width, int height, boolean resizable) {
        super();

        this.setTitle(title);
        this.setSize(width, height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(255, 229, 172));
        this.setResizable(resizable);

        this.setViewManager(new ViewManager(this));
    }

    public void setViewManager(ViewManager viewManager) {
        this.viewManager = viewManager;
    }

    public ViewManager getViewManager() {
        return this.viewManager;
    }

}
