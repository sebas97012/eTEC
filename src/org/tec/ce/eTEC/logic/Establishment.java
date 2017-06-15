package org.tec.ce.eTEC.logic;

/**
 * Created by Arturo on 14/6/2017.
 */
public abstract class Establishment implements Comparable<Establishment> {
    protected String name;
    protected int phoneNumber;
    protected int id;

    public String getName() {
        return name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public int getId() {
        return id;
    }
}
