package edu.def.solid;

public class AuthorizerGoogle implements Authorizer {
    private boolean authorized = false;

    public void verifyCode(int code){
        System.out.print("Verifying Google code " + code);
        this.authorized = true;
    }

    @Override
    public boolean isAuthorized() {
        return this.authorized;
    }
}
