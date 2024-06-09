
package pl.edu.pw.mini.awad.projektbadawczy.network;

import pl.edu.pw.mini.awad.projektbadawczy.dataloader.TrainingItem;

import java.util.*;

public class NeuralNetwork {

    public int numLayers;
    public ArrayList<Layer> layers;
    public ArrayList<Edges> edges;

    NeuralNetwork (ArrayList<Integer> sizes, boolean isRandom) {
        numLayers = sizes.size();
        ArrayList<Layer> layers = new ArrayList<>();
        for (int i = 0; i < sizes.size(); i++) {
            layers.add(new Layer(sizes.get(i), isRandom));
        }
        this.layers = layers;
        ArrayList<Edges> edges = new ArrayList<>();
        for (int i = 0; i < sizes.size() - 1; i++) {
            edges.add(new Edges(layers.get(i), layers.get(i + 1), isRandom));
        }
        this.edges = edges;
    }

//    void updateMiniBatch(ArrayList<TrainingItem> trainingItems, double eta) {
//        for (var trainingItem : trainingItems) {
//
//        }
//    }
//
//    void backprop(NeuralNetwork network, TrainingItem item) {
//
//    }

}
