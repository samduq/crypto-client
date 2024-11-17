package com.cryptoclient.application.views.dashboard.components;

import javax.swing.*;
import java.awt.*;

public class CryptoSubmenu extends JPanel {

    private DefaultListModel<String> cryptocurrenciesName;
    private JList<String> cryptocurrenciesItems;
    private JScrollPane listScroller;

    public CryptoSubmenu(DefaultListModel<String> cryptocurrenciesName) {
        this.setCryptocurrenciesName(cryptocurrenciesName);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setCryptocurrenciesItems(new JList<>());
        //this.loadItems();
    }

    public JScrollPane getListScroller() {
        return listScroller;
    }

    public void setListScroller(JScrollPane listScroller) {
        this.listScroller = listScroller;
    }

    public JList<String> getCryptocurrenciesItems() {
        return cryptocurrenciesItems;
    }

    public void setCryptocurrenciesItems(JList<String> cryptocurrenciesItems) {
        this.cryptocurrenciesItems = cryptocurrenciesItems;
    }

    public void loadItems() {
        this.getCryptocurrenciesItems().setModel(this.getCryptocurrenciesName());
        this.getCryptocurrenciesItems().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.getCryptocurrenciesItems().setFont(new Font("Arial", Font.PLAIN, 17));
        this.getCryptocurrenciesItems().setBackground(Color.WHITE);
        this.getCryptocurrenciesItems().setForeground(Color.BLACK);

        this.setListScroller(new JScrollPane(this.getCryptocurrenciesItems()));
        this.add(this.getListScroller());
    }

    public DefaultListModel<String> getCryptocurrenciesName() {
        return cryptocurrenciesName;
    }

    public void setCryptocurrenciesName(DefaultListModel<String> cryptocurrenciesName) {
        this.cryptocurrenciesName = cryptocurrenciesName;
    }
}
