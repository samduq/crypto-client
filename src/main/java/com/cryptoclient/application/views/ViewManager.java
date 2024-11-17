package com.cryptoclient.application.views;

import com.cryptoclient.application.views.login.Login;
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
    }

    private Application getApplication() {
        return this.application;
    }

    public HashMap<String, View> getViews() {
        return this.views;
    }

    public void displayView(String viewName) {
        this.getApplication().getContentPane().removeAll();
        if (this.getViews().containsKey(viewName)) {
            // Get the view
            View view = this.getViews().get(viewName);
            view.loadComponents();
            // Show it
            this.getApplication().getContentPane().add(view);
            view.setVisible(true);
        }
    }
}
