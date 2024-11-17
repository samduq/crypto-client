package com.cryptoclient.application.views.index.components;

import javax.swing.*;
import java.awt.*;

public class SubmitButton extends JButton {
    public SubmitButton(String text, int textSize) {
        super(text);
        this.setFont(new Font("Arial", Font.PLAIN, textSize));
        this.setForeground(Color.WHITE);
        this.setBackground(new Color(244, 69, 46));
        this.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        this.setFocusPainted(false);
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
}
