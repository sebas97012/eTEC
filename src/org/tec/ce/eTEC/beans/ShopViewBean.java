package org.tec.ce.eTEC.beans;

import org.tec.ce.eTEC.logic.Establishment;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;

import static org.tec.ce.eTEC.ApplicationManager.eTECManager;

/**
 * Created by pelon_000 on 16/06/2017.
 */

@ManagedBean(name = "shopView")
@ViewScoped
public class ShopViewBean implements Serializable {
    private ArrayList<String> shopList = new ArrayList<>();
    private ArrayList<String> establishmentList = new ArrayList<>();

    @PostConstruct
    public void init(){
        ArrayList<Establishment> list = eTECManager.getShopList();
        int index = list.size();
        for (int i = 0; i < index; i++){
            this.shopList.add(list.get(i).getName());
        }

        ArrayList<Establishment> establishments = eTECManager.getEstablishmentsNames();
        int index2 = list.size();
        for (int i = 0; i < index2; i++){
            this.establishmentList.add(establishments.get(i).getName());
        }

    }

    public ArrayList<String> getShopList() {
        return shopList;
    }

    public void setShopList(ArrayList<String> shopList) {
        this.shopList = shopList;
    }

    public ArrayList<String> getEstablishmentList() {
        return establishmentList;
    }

    public void setEstablishmentList(ArrayList<String> establishmentList) {
        this.establishmentList = establishmentList;
    }
}
