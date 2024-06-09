package pl.edu.pw.mini.awad.projektbadawczy.network;

import java.util.*;

public class NeuralNetwork {

    private int numLayers;
    private ArrayList<Layer> layers;
    private ArrayList<Edges> edges;

    public NeuralNetwork(ArrayList<Integer> sizes) {
        numLayers = sizes.size();
        ArrayList<Layer> layers = new ArrayList<>();
        for (int i = 0; i < sizes.size(); i++) {
            layers.add(new Layer(sizes.get(i)));
        }
        this.layers = layers;
        ArrayList<Edges> edges = new ArrayList<>();
        for (int i = 0; i < sizes.size() - 1; i++) {
            edges.add(new Edges(layers.get(i), layers.get(i + 1)));
        }
        this.edges = edges;
    }
}
