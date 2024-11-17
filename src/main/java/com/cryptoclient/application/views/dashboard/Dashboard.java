package com.cryptoclient.application.views.dashboard;

import com.cryptoclient.application.views.View;
import com.cryptoclient.application.views.dashboard.components.Content;
import com.cryptoclient.application.views.dashboard.components.MenuPanel;

import java.awt.*;

public class Dashboard extends View {

    private MenuPanel menu;
    private Content content;
    private int menuBarWidth;

    public Dashboard() {
        this.setMenuBarWidth(250);
        this.setMenu(new MenuPanel(this.getMenuBarWidth()));
        this.setContent(new Content());
    }

    public int getMenuBarWidth() {
        return menuBarWidth;
    }

    public void setMenuBarWidth(int menuBarWidth) {
        this.menuBarWidth = menuBarWidth;
    }

    public MenuPanel getMenu() {
        return menu;
    }

    public void setMenu(MenuPanel menu) {
        this.menu = menu;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    @Override
    public void loadComponents() {
        this.setLayout(new BorderLayout());

        // Add the two main components to the view
        this.add(this.getMenu(), BorderLayout.WEST);
        this.add(this.getContent(), BorderLayout.CENTER);
    }
}
