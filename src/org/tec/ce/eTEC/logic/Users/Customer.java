package org.tec.ce.eTEC.logic.Users;

import org.tec.ce.eTEC.logic.Package;

/**
 * Created by sebas97012 on 6/14/17.
 */
public class Customer extends User {
    private String name;
    private String email;
    private int phoneNumber;
    private int distributionCenterID;
    private Package cart;

    /**
     * Constructor
     * @param userName Nombre de usuario
     * @param password Contraseña
     * @param name Nombre del usuario
     * @param email Correo electronico
     * @param phoneNumber Numero telefonico
     * @param distributionCenterID ID del centro de distribucion
     */
    public Customer(String userName, String password, String name, String email, int phoneNumber, int distributionCenterID) {
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.distributionCenterID = distributionCenterID;
        this.cart = new Package();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public int getDistributionCenterID() {
        return distributionCenterID;
    }

    public Package getCart() {
        return cart;
    }

    @Override
    public int compareTo(User o) {
        return 0;
    }
}
