package org.tec.ce.eTEC.logic;

import org.tec.ce.eTEC.datastructures.LinkedList;

/**
 * Created by Arturo on 14/6/2017.
 */
public class Route {
    private int distance;
    private int time;
    private LinkedList<Establishment> route;
    private String dangerLevel;
    private int truckGasolineCapacity;

    public Route(int distance, int time, LinkedList<Establishment> route, String dangerLevel, int truckGasolineCapacity) {
        this.distance = distance;
        this.time = time;
        this.route = route;
        this.dangerLevel = dangerLevel;
        this.truckGasolineCapacity = truckGasolineCapacity;
    }
}
