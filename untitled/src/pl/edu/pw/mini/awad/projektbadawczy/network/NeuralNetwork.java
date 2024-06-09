

package pl.edu.pw.mini.awad.projektbadawczy.network;

import pl.edu.pw.mini.awad.projektbadawczy.dataloader.TrainingItem;

import java.util.*;

public class NeuralNetwork {
    private ArrayList<Layer> layers;
    private ArrayList<Edges> edges;

    NeuralNetwork (ArrayList<Integer> sizes) {
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

    NeuralNetwork (ArrayList<Layer> layers, ArrayList<Edges> edges) {
        this.layers = layers;
        this.edges = edges;
    }

    NeuralNetwork emptyCopy() {
        ArrayList<Layer> layers = new ArrayList<>();
        for (int i = 0; i < this.layers.size(); i++) {
            layers.add(new Layer(this.layers.get(i).neurons.size(), 0));
        }
        ArrayList<Edges> edgesSet = new ArrayList<>();
        for (int i = 0; i < layers.size() - 1; i++) {
            Edges edges = new Edges(layers.get(i), layers.get(i + 1), 0);
            edgesSet.add(edges);
        }
        return new NeuralNetwork(layers, edgesSet);
    }

    public NeuralNetwork add(NeuralNetwork other) {
        ArrayList<Layer> layers = new ArrayList<>();
        for (int i = 0; i < this.layers.size(); i++) {
            layers.add(this.layers.get(i).add(other.layers.get(i)));
        }
        ArrayList<Edges> edgesSet = new ArrayList<>();
        for (int i = 0; i < layers.size() - 1; i++) {
            edgesSet.add(this.edges.get(i).add(other.edges.get(i)));
        }
        return new NeuralNetwork(layers, edgesSet);
    }

//    void updateMiniBatch(ArrayList<TrainingItem> trainingItems, double eta) {
//        for (var trainingItem : trainingItems) {
//
//        }
//    }

    NeuralNetwork backprop(TrainingItem item) {
        NeuralNetwork network = this.emptyCopy(); //kopiuje szkielet

        return network;
    }

}
