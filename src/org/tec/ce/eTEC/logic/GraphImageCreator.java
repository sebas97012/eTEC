package org.tec.ce.eTEC.logic;

import org.graphstream.graph.implementations.DefaultGraph;
import org.graphstream.stream.file.FileSinkImages;
import org.tec.ce.eTEC.datastructures.Graph;
import org.tec.ce.eTEC.datastructures.GraphEdge;
import org.tec.ce.eTEC.datastructures.GraphNode;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arturo on 16/6/2017.
 */
public class GraphImageCreator<k, v> {
    /**
     * Metodo para convertir un grafo nuestro a un grafo de la libreria GraphStream para su posterior graficacion
     * @param graph Grafo que se desea convertir
     * @return DefaultGraph con los vertices y aristas del grafo ingresado
     */
    public static DefaultGraph convertGraph(Graph graph){
        DefaultGraph defaultGraph = new DefaultGraph("graph");
        List list = new ArrayList();
        graph.getAdjacencyList().forEach((k, v) -> list.add(v));

        //Se añaden los vertices al nuevo grafo
        for (int i = 0; i < list.size(); i++) {
            GraphNode vertex = (GraphNode) list.get(i);
            defaultGraph.addNode(String.valueOf(vertex.getVertex()));
        }

        //Se le pone como atributo un label con el data para que a la hora de graficarlo se dibuje
        for (org.graphstream.graph.Node node : defaultGraph) {
            node.addAttribute("ui.label", node.getId());
            node.addAttribute("ui.style" , ("size: 10px, 10px; fill-color: white; stroke-mode: plain; stroke-color: gray;"));
        }

        //Se añaden las aristas al nuevo grafo
        for (int x = 0; x < list.size(); x++) {
            GraphNode vertex = (GraphNode) list.get(x);
            List edges = vertex.getEdges();

            for (int y = 0; y < edges.size(); y++) {
                GraphEdge edge = (GraphEdge) edges.get(y);
                String vertex1 = String.valueOf(edge.getNode1().getVertex());
                String vertex2 = String.valueOf(edge.getNode2().getVertex());
                defaultGraph.addEdge(String.valueOf(y + x), vertex1, vertex2, true);
            }
        }

        return defaultGraph;
    }

    /**
     * Metodo para crear una imagen .png de un DefaultGraph
     * @param graph Grafo a graficar
     */
    public static void createImage(DefaultGraph graph){
        FileSinkImages pic=new FileSinkImages(FileSinkImages.OutputType.PNG, FileSinkImages.Resolutions.HD720);
        pic.setLayoutPolicy(FileSinkImages.LayoutPolicy.COMPUTED_FULLY_AT_NEW_IMAGE);
        pic.setQuality(FileSinkImages.Quality.HIGH);
        pic.setRenderer(FileSinkImages.RendererType.SCALA);
        PrintStream tmp=System.out;
        System.setOut(new PrintStream(new OutputStream(){
            @Override public void write(int b) throws IOException {
            }
        }
        ));
        try {
            pic.writeAll(graph,System.getProperty("user.home") + "/image.png");
        }
        catch (  IOException e) {
            e.printStackTrace();
        }
        System.setOut(tmp);
    }
}
