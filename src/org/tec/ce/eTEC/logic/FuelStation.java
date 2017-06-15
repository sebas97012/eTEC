package org.tec.ce.eTEC.logic;

/**
 * Created by Arturo on 14/6/2017.
 */
public class FuelStation extends Establishment {
    /**
     * Constructor
     * @param name Nombre de la gasolinera
     * @param phoneNumber Numero de telefono de la gasolinera
     */
    public FuelStation(String name, int phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public int compareTo(Establishment o) {
        return 0;
    }
}
