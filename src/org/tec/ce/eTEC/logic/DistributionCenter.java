package org.tec.ce.eTEC.logic;

import org.tec.ce.eTEC.datastructures.LinkedList;

import static org.tec.ce.eTEC.ApplicationManager.IDGenerator;

/**
 * Created by Arturo on 14/6/2017.
 */
public class DistributionCenter extends Establishment{
    private LinkedList<Package> packageList;
    private String password;

    /**
     * Constructor
     * @param name Nombre del centro de distribucion
     * @param phoneNumber Numero de telefono del centro de distribucion
     */
    public DistributionCenter(String name, String password, int phoneNumber) {
        this.name = name;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.id = IDGenerator.createEstablishmentID();
        this.packageList = new LinkedList<Package>();
    }

    public LinkedList<Package> getPackageList() {
        return packageList;
    }

    @Override
    public int compareTo(Establishment o) {
        return 0;
    }
}
