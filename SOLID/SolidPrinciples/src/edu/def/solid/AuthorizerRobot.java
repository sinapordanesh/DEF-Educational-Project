package edu.def.solid;

public class AuthorizerRobot implements Authorizer {
    private boolean authorized = false;

    public void notARobot(){
        this.authorized = true;
    }

    @Override
    public boolean isAuthorized() {
        return this.authorized;
    }
}
