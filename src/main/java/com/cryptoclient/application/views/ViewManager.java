package com.cryptoclient.application.views;

import com.cryptoclient.application.views.index.Login;
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

//    public void loadLoginView() {
//        // Define the size of the view
//        int width = 500;
//        int height = 160;
//
//        // Creation of the view
//        //Login loginVue = new Login(this.getApplication().getConnection(), width, height);
//        //loginVue.setOpaque(false);
//
//        // Center it
//        //loginVue.setBounds((this.getApplication().getWidth() - width) / 2, (this.getApplication().getHeight() - height) / 2, width, height);
//
//        // Add it to the registered view
//        //this.getViews().put(Configuration.VIEW_LOGIN, loginVue);
//    }

    public void displayLoginView() {
        if (this.getViews().containsKey(Configuration.VIEW_LOGIN)) {
            View loginView = this.getViews().get(Configuration.VIEW_LOGIN);
            loginView.setOpaque(false);
            loginView.setBounds((this.getApplication().getWidth() - loginView.getWidth()) / 2, (this.getApplication().getHeight() - loginView.getHeight()) / 2, loginView.getWidth(), loginView.getHeight());
            this.getViews().get(Configuration.VIEW_LOGIN).setVisible(true);
            // Add it to the content pane of the application
            this.getApplication().getContentPane().add(this.getViews().get(Configuration.VIEW_LOGIN));
        }
    }
}
