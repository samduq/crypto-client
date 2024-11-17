package com.cryptoclient.application.views.login.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class UsernameField extends JTextField {

    private Color placeHolderColor = new Color(191, 191, 191);

    public UsernameField(String placeHolder, int columns, int textSize) {
        super(columns);
        //this.setFocusable(false);
        this.setFont(new Font("Arial", Font.PLAIN, textSize));
        this.setBackground(new Color(133, 122, 129));
        this.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        this.setForeground(placeHolderColor);
        this.setText(placeHolder);

        // Ajoutez un rayon d'arrondi au bord// 10 est le rayon du coin arrondi

        this.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (getText().equals(placeHolder)) {
                    setText("");
                    setForeground(Color.WHITE);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (getText().isEmpty()) {
                    setForeground(placeHolderColor);
                    setText(placeHolder);
                }
            }
        });
    }
}
