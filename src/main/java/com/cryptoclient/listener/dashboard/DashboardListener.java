package com.cryptoclient.listener.dashboard;

import com.cryptoclient.application.Application;
import com.cryptoclient.application.views.dashboard.Dashboard;
import com.cryptoclient.listener.ViewListener;
import com.cryptoclient.networking.Connection;

public class DashboardListener extends ViewListener<Dashboard> {

    public DashboardListener(Application app, Connection connection, Dashboard view) {
        super(app, connection, view);
    }

    @Override
    public void listen() {
        listenCryptocurrencySelection();
    }

    private void listenCryptocurrencySelection() {
        this.getView().getMenu().getCryptoSubmenu().getCryptocurrenciesItems().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String selectedCryptocurrency = getView().getMenu().getCryptoSubmenu().getCryptocurrenciesItems().getSelectedValue();
                System.out.println(selectedCryptocurrency);
            }
        });
    }
}
