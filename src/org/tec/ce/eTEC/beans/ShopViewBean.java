package org.tec.ce.eTEC.beans;

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
    private ArrayList<String> shopList;

    @PostConstruct
    public void init(){
        this.shopList = eTECManager.getShopList();
    }

    public ArrayList<String> getShopList() {
        return shopList;
    }

    public void setShopList(ArrayList<String> shopList) {
        this.shopList = shopList;
    }
}
