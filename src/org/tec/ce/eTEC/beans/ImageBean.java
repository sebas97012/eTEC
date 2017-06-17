package org.tec.ce.eTEC.beans;

import javax.faces.bean.ManagedBean;
import java.io.*;


import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
/**
 * Created by sebas97012 on 6/17/17.
 */


@ManagedBean(name="imageBean")
public class ImageBean {
    private StreamedContent image;
    public void DynamicImageController() {
        InputStream stream = this.getClass().getResourceAsStream(System.getProperty("user.home")+"/"+"graph.png");
        image = new DefaultStreamedContent(stream, "image/png");
    }
    public StreamedContent getImage() {
        return this.image;
    }
}