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
    private ArrayList<Establishment> shopList;

    @PostConstruct
    public void init(){
        //String.valueOf()
        this.shopList = eTECManager.getShopList();
    }

    public ArrayList<Establishment> getShopList() {
        return shopList;
    }

    public void setShopList(ArrayList<Establishment> shopList) {
        this.shopList = shopList;
    }
}
