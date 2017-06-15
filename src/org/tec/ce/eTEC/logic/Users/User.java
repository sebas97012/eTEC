package org.tec.ce.eTEC.logic.Users;

/**
 * Created by sebas97012 on 6/14/17.
 */
public abstract class User implements Comparable<User>{
    protected String userName;
    protected String password;

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
