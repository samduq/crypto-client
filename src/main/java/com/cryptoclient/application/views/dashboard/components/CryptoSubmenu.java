package com.cryptoclient.application.views.dashboard.components;

import javax.swing.*;
import java.awt.*;
import java.util.stream.IntStream;

public class CryptoSubmenu extends JPanel {

    private DefaultListModel<String> cryptocurrenciesName;
    private JList<String> cryptocurrenciesItems;
    private JScrollPane listScroller;
    private JTextField searchField;

    public CryptoSubmenu(DefaultListModel<String> cryptocurrenciesName) {
        this.setCryptocurrenciesName(cryptocurrenciesName);
        this.setLayout(new BorderLayout());
        this.setCryptocurrenciesItems(new JList<>());
        this.searchField = new JTextField();
        this.searchField.setPreferredSize(new Dimension(200, 25));
        this.loadItems();
    }

    public JTextField getSearchField() {
        return searchField;
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

    public DefaultListModel<String> getCryptocurrenciesName() {
        return cryptocurrenciesName;
    }

    public void setCryptocurrenciesName(DefaultListModel<String> cryptocurrenciesName) {
        this.cryptocurrenciesName = cryptocurrenciesName;
    }

    public void loadItems() {
        this.getCryptocurrenciesItems().setModel(this.getCryptocurrenciesName());
        this.getCryptocurrenciesItems().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.getCryptocurrenciesItems().setFont(new Font("Arial", Font.PLAIN, 17));
        this.getCryptocurrenciesItems().setBackground(Color.WHITE);
        this.getCryptocurrenciesItems().setForeground(Color.BLACK);

        this.setListScroller(new JScrollPane(this.getCryptocurrenciesItems()));

        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        searchPanel.add(this.getSearchField());
        this.add(searchPanel, BorderLayout.NORTH);
        this.add(this.getListScroller(), BorderLayout.CENTER);
    }

    public void filterCryptocurrencies(String query) {
        DefaultListModel<String> filteredModel = new DefaultListModel<>();
        IntStream.range(0, this.getCryptocurrenciesName().size())
                .mapToObj(this.getCryptocurrenciesName()::getElementAt)
                .filter(name -> name.toLowerCase().contains(query.toLowerCase()))
                .forEach(filteredModel::addElement);

        this.updateCryptocurrencies(filteredModel);
    }

    public void updateCryptocurrencies(DefaultListModel<String> newModel) {
        this.getCryptocurrenciesItems().setModel(newModel);

        for (javax.swing.event.ListSelectionListener listener : this.getCryptocurrenciesItems().getListSelectionListeners()) {
            this.getCryptocurrenciesItems().removeListSelectionListener(listener);
        }
    }
}
