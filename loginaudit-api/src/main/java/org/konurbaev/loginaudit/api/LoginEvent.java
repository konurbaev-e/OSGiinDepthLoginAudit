package org.konurbaev.loginaudit.api;

public interface LoginEvent {

    static final String TOPIC = "konurbaev/login";

    static final String USERID = "userid";

    static final String TIMESTAMP = "timestamp";

    default public void sendLoginEvent(String userid) {

    };

}