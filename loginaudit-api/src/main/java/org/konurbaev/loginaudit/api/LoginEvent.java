package org.konurbaev.loginaudit.api;

public interface LoginEvent {

    String TOPIC = "konurbaev/login";

    String USERID = "userid";

    String TIMESTAMP = "timestamp";

    default void sendLoginEvent(String userid) {

    }

}