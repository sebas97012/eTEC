package org.tec.ce.eTEC.beans;

import org.tec.ce.eTEC.logic.DistributionCenter;
import org.tec.ce.eTEC.logic.FuelStation;
import org.tec.ce.eTEC.logic.Shop;
import org.tec.ce.eTEC.logic.Users.AdminUser;
import org.tec.ce.eTEC.logic.Users.Customer;

import static org.tec.ce.eTEC.ApplicationManager.eTECManager;

import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.Arrays;


/**
 * Created by sebas97012 on 6/14/17.
 */

@ManagedBean(name= "registeruser")
public class RegisterUserBean {
    private int ID;
    private String name;
    private String password;
    private String password2;
    private String apellido_1;
    private String message;
    private String apellido_2;
    private String email;
    private String type = " ";
    private String establishmentID;
    private String userName;
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

    public String getEstablishmentID() {
        return establishmentID;
    }

    public void setEstablishmentID(String establishmentID) {
        this.establishmentID = establishmentID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String registerUser(){
        if (password.equals(password2)) {
            if (type.equals("CD")) {
                DistributionCenter newCD = new DistributionCenter(name, password, phoneNumber);
                eTECManager.addEstablishment(newCD);

            }else if (type.equals("T")){
                Shop newShop = new Shop(this.name, this.phoneNumber);
                eTECManager.addEstablishment(newShop);

            }else if(type.equals("G")) {
                FuelStation newFuel = new FuelStation(this.name, this.phoneNumber);
                eTECManager.addEstablishment(newFuel);


            }else if(type.equals("A")){
                AdminUser user= new AdminUser(name,password,userName);
                eTECManager.addUser(user);
            }else {
                Customer newUser = new Customer(userName, password, name, email, phoneNumber, Integer.valueOf(establishmentID));
                eTECManager.addUser(newUser);
            }
            return "success";
        }else{
            return "error";
        }
    }
    public ArrayList<String> stringToList(String e){
        String[] strValues = e.split(",");
        ArrayList<String> aList = new ArrayList<String>(Arrays.asList(strValues));
        return aList;
    }

}


