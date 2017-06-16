package org.tec.ce.eTEC.beans;

import org.tec.ce.eTEC.logic.FileXMLManager;

import static org.tec.ce.eTEC.ApplicationManager.graph;

/**
 * Created by Arturo on 16/6/2017.
 */

import javax.faces.bean.ManagedBean;

@ManagedBean(name= "graph")
public class GraphTestBean {
    private String vertex;
    private String edgeVertex1;
    private String edgeVertex2;

    public String getVertex() {
        return vertex;
    }

    public void setVertex(String vertex) {
        this.vertex = vertex;
    }

    public String getEdgeVertex1() {
        return edgeVertex1;
    }

    public void setEdgeVertex1(String edgeVertex1) {
        this.edgeVertex1 = edgeVertex1;
    }

    public String getEdgeVertex2() {
        return edgeVertex2;
    }

    public void setEdgeVertex2(String edgeVertex2) {
        this.edgeVertex2 = edgeVertex2;
    }

    public void addVertex(){
        graph.addVertex(vertex);
    }

    public void addEdge(){
        graph.addEdge(edgeVertex1, edgeVertex2);
    }

    public void saveGraph(){
        FileXMLManager.writeContent(graph, "graph.xml");
    }
}
