package org.tec.ce.eTEC.beans;

import org.tec.ce.eTEC.logic.Establishment;


import javax.faces.bean.ManagedBean;

/**
 * Created by pelon_000 on 17/06/2017.
 */

import java.util.ArrayList;
import java.util.List;


import static org.tec.ce.eTEC.ApplicationManager.eTECManager;

@ManagedBean(name="distance")
public class DistanceBean {

    private String establishment1;
    private String establishment2;
    private List<String> e2 = new ArrayList<>();
    private String weight;
    private List<String> w1 = new ArrayList<>();

    public String getEstablishment1() {
        return establishment1;
    }

    public void setEstablishment1(String establishment1) {
        this.establishment1 = establishment1;
    }

    public String getEstablishment2() {
        return establishment2;
    }

    public void setEstablishment2(String establishment2) {
        this.establishment2 = establishment2;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void addConection(){

        Establishment e1 = eTECManager.searchEstablishment(establishment1);
        e2.add(establishment2);
        w1.add(weight);
        eTECManager.addEdge(e1,e2, w1);
    }

}
