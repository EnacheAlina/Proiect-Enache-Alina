package org.fastrackit;

public class InvalidAccount extends Account{
    private final String errorMsg;
    public InvalidAccount(String user, String password , String errorMsg) {
        super(user, password);
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
