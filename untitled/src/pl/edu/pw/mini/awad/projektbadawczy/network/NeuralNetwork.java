
package pl.edu.pw.mini.awad.projektbadawczy.network;

import java.util.*;

public class NeuralNetwork {

    private int numLayers;
    private ArrayList<Layer> layers;

    NeuralNetwork (ArrayList<Integer> sizes) {
        numLayers = sizes.size();
        ArrayList<Layer> layers = new ArrayList<>();
        for (int i = 1; i < sizes.size(); i++) {
            layers.add(new Layer(sizes.get(i)));
        }
        this.layers = layers;
    }
}
