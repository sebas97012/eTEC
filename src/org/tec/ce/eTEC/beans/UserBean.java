package org.tec.ce.eTEC.beans;

import org.tec.ce.eTEC.logic.FileXMLManager;
import org.tec.ce.eTEC.logic.Users.User;
import static org.tec.ce.eTEC.ApplicationManager.eTECManager;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by Arturo on 15/6/2017.
 */
@ManagedBean(name = "user")
@SessionScoped
public class UserBean {
    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Metodo para iniciar sesion por parte de un usuario
     */
    public String logIn() {
        User user = eTECManager.getUser(userName);

        if (user.getPassword().equals(password)) {
            System.out.println("Sesión iniciada!");
            return "success";
        } else {
            return "error";
        }
    }
}
