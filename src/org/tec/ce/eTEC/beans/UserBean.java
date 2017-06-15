package org.tec.ce.eTEC.beans;

import org.tec.ce.eTEC.logic.Users.DistributionCenter;
import org.tec.ce.eTEC.logic.Users.Store;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by sebas97012 on 6/14/17.
 */

@ManagedBean(name="user")
@SessionScoped
public class UserBean {
    private int ID;
    private String name;
    private String password;
    private String password2;
    private String apellido_1;
    private String message;
    private String apellido_2;
    private String email;
    private String type;
    private int phoneNumber;

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getApellido_1() {
        return apellido_1;
    }

    public void setApellido_1(String apellido_1) {
        this.apellido_1 = apellido_1;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getApellido_2() {
        return apellido_2;
    }

    public void setApellido_2(String apellido_2) {
        this.apellido_2 = apellido_2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String registerUser(){
        if (password.equals(password2)) {
            if (type.equals("CD")) {//estos tipos se definen en las páginas, en este caso CD y T se definen en un selecOneRadio en admin_sign_up
                DistributionCenter nuevo = new DistributionCenter();
            }
            else if (type.equals("S")){
                Store nuevo = new Store();
            }
            return "success";
        }else{
            return "error";
        }
    }

}

