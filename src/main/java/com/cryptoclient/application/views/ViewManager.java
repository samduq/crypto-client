package com.cryptoclient.application.views;

import com.cryptoclient.application.views.dashboard.Dashboard;
import com.cryptoclient.application.views.index.login.Login;
import com.cryptoclient.application.views.index.register.Register;
import com.cryptoclient.application.views.loading.Loading;
import com.cryptoclient.application.views.registrationfailed.Registrationfailed;
import com.cryptoclient.config.Configuration;
import com.cryptoclient.application.Application;

import java.util.HashMap;

public class ViewManager {

    private final HashMap<String, View> views;
    private final Application application;

    public ViewManager(Application application) {
        this.views = new HashMap<>();
        this.application = application;
        this.loadViews();
    }

    private void loadViews() {
        this.getViews().put(Configuration.VIEW_LOGIN, new Login());
        this.getViews().put(Configuration.VIEW_REGISTER, new Register());
        this.getViews().put(Configuration.VIEW_DASHBOARD, new Dashboard());
        this.getViews().put(Configuration.VIEW_LOADING, new Loading());
        this.getViews().put(Configuration.VIEW_REGISTRATIONFAILED, new Registrationfailed());
    }

    private Application getApplication() {
        return this.application;
    }

    public HashMap<String, View> getViews() {
        return this.views;
    }

    public void displayView(String viewName) {
        // Rendre toutes les vues invisibles
        for (View view : this.getViews().values()) {
            if (view.isVisible()) {
                view.setVisible(false);
            }
        }

        // Vider le conteneur principal
        this.getApplication().getContentPane().removeAll();

        // Afficher la vue demandée
        if (this.getViews().containsKey(viewName)) {
            View view = this.getViews().get(viewName);
            view.loadComponents();
            this.getApplication().getContentPane().add(view);
            view.setVisible(true);
        }
    }

    public void reloadAllViews() {
        for (View view : this.getViews().values()) {
            view.loadComponents();
        }
    }
}
