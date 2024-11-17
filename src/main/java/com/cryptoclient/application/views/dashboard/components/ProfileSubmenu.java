package com.cryptoclient.application.views.dashboard.components;

import javax.swing.*;

public class ProfileSubmenu extends JPanel {

    private JButton profileButton;
    private JButton editProfileButton;
    private JButton logoutButton;

    public ProfileSubmenu() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Set buttons
        this.setProfileButton(new JButton("Mon profil"));
        this.setEditProfileButton(new JButton("Édition"));
        this.setLogoutButton(new JButton("Déconnexion"));

        // Add them
        this.add(this.getProfileButton());
        this.add(this.getEditProfileButton());
        this.add(this.getLogoutButton());
    }

    public JButton getProfileButton() {
        return profileButton;
    }

    public void setProfileButton(JButton profileButton) {
        this.profileButton = profileButton;
    }

    public JButton getEditProfileButton() {
        return editProfileButton;
    }

    public void setEditProfileButton(JButton editProfileButton) {
        this.editProfileButton = editProfileButton;
    }

    public JButton getLogoutButton() {
        return logoutButton;
    }

    public void setLogoutButton(JButton logoutButton) {
        this.logoutButton = logoutButton;
    }
}
