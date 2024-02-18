package org.fastrackit;

public class ValidAccount extends Account{

    private final String greetingsMsg;
    public ValidAccount(String user, String password) {
        super(user, password);
        this.greetingsMsg = "Hi " + user + "!";
    }

    public String getGreetingsMsg() {
        return greetingsMsg;
    }
}