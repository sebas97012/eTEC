package org.tec.ce.eTEC.beans;

import org.tec.ce.eTEC.datastructures.LinkedList;
import org.tec.ce.eTEC.logic.Product;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Arturo on 15/6/2017.
 */
@ManagedBean(name = "producstview")
@ViewScoped
public class ProductsView {
    private LinkedList<Product> products;
    //private BufferedImage imgBook;

    public LinkedList<Product> getProducts() {
        return products;
    }

    /*
    public BufferedImage getImgBook(){
        try {
            imgBook = ImageIO.read(new URL("https://d30y9cdsu7xlg0.cloudfront.net/png/5020-200.png"));
        }catch(Exception e){

        }
        return imgBook;
    }*/
}
