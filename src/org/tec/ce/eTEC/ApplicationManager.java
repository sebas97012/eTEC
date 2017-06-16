package org.tec.ce.eTEC;

import org.tec.ce.eTEC.datastructures.Graph;
import org.tec.ce.eTEC.logic.IDGenerator;
import org.tec.ce.eTEC.logic.eTECManager;

/**
 * Created by Arturo on 15/6/2017.
 */
public class ApplicationManager {
    public static eTECManager eTECManager = new eTECManager();
    public static IDGenerator IDGenerator = new IDGenerator();
    public static Graph graph = new Graph();
}
