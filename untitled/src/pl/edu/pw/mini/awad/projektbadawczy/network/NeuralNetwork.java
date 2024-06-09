

package pl.edu.pw.mini.awad.projektbadawczy.network;

import pl.edu.pw.mini.awad.projektbadawczy.dataloader.TrainingItem;

import java.util.*;

public class NeuralNetwork {
    public ArrayList<Layer> layers;
    public ArrayList<Edges> edges;

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
            int size = this.layers.get(i).neurons.size();
            Layer layer = new Layer(size);
            for (var neuron : layer.neurons) {
                neuron.bias = 0;
            }
            layers.add(layer);
        }
        ArrayList<Edges> edges = new ArrayList<>();
        for (int i = 0; i < layers.size() - 1; i++) {
            edges.add(new Edges(layers.get(i), layers.get(i + 1)));
        }
        return new NeuralNetwork(layers, edges);
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
