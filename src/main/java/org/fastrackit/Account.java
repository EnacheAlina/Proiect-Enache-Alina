package org.fastrackit;

public class Account {
    private final String user;
    private final String password;

    public Account(String user, String password) {
        this.user = user;
        this.password = password;
    }
    public String getUser() {
        return user;
    }
    public String getPassword() {
        return password;
    }
    @Override
    public String toString() {
        return user + " / " + password;
    }
}

