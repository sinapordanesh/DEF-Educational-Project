package com.def.solid;

public class AuthorizerSMS implements Authorizer{
    private boolean authorized = false;

    public void verifyCode(int code){
        System.out.print("Verifying SMS code " + code);
        this.authorized = true;
    }

    @Override
    public boolean isAuthorized() {
        return this.authorized;
    }

}
