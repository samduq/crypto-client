package com.cryptoclient.application.views.index.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class PasswordField extends JPasswordField {

    private Color placeHolderColor = new Color(191, 191, 191);

    public PasswordField(String placeHolder, int columns, int textSize) {
        super(columns);
        //this.setFocusable(false);
        this.setFont(new Font("Arial", Font.PLAIN, textSize));
        this.setBackground(new Color(133, 122, 129));
        this.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        this.setEchoChar((char) 0);
        this.setForeground(placeHolderColor);
        this.setText(placeHolder);

        this.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (getText().equals(placeHolder)) {
                    setText("");
                    setEchoChar('•');
                    setForeground(Color.WHITE);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (getText().isEmpty()) {
                    setForeground(placeHolderColor);
                    setEchoChar((char) 0);
                    setText(placeHolder);
                }
            }
        });
    }
}
