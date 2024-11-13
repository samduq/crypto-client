package com.cryptoclient.networking.packets;

import com.cryptoclient.application.Application;
import org.json.JSONObject;

import java.util.HashMap;

public class PacketsHandler {
    private final HashMap<Integer, Event> events;
    private final Application application;

    public PacketsHandler(Application application) {
        this.events = new HashMap<>();
        this.application = application;
        // Load all events the client can receive from the server
        this.registerEvents();
    }

    private Application getApplication() {
        return this.application;
    }

    private void registerEvents() {
        //this.getEvents().put(1, new LoginEvent());
    }

    public HashMap<Integer, Event> getEvents() {
        return this.events;
    }

    public void handle(JSONObject packet) {
        if (packet.has("header")) {
            int header = packet.getInt("header");
            if (this.getEvents().containsKey(header)) {
                // Trigger the event corresponding to this header
                this.getEvents().get(header).handle(this.getApplication(), packet);
            } else {
                System.out.println("Unregistered event header");
            }
        } else {
            System.out.println("Invalid packet format");
        }
    }
}
