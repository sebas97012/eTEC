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
    private StreamedContent bStatus;

    public ImageBean(){
        try{
            bStatus = new DefaultStreamedContent(new FileInputStream(new File(System.getProperty("user.home") + "/graph.png")), "image/png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public StreamedContent getbStatus() {
        return bStatus;
    }

    public void setbStatus(StreamedContent bStatus) {
        this.bStatus = bStatus;
    }
}