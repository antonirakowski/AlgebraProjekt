package pl.edu.pw.mini.awad.projektbadawczy.network;

import java.util.ArrayList;
import java.util.Random;

public class Layer {
    ArrayList<Neuron> neurons;

    public Layer(ArrayList<Neuron> neurons) {
        this.neurons = neurons;
    }

    public Layer(int size) {
        ArrayList<Neuron> neurons = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            neurons.add(new Neuron(random.nextDouble()));
        }
        this.neurons = neurons;
    }

    public Layer(int size, double value) {
        ArrayList<Neuron> neurons = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            neurons.add(new Neuron(value));
        }
        this.neurons = neurons;
    }

    public Layer add(Layer layer) {
        ArrayList<Neuron> neurons = new ArrayList<Neuron>();
        for (int i = 0; i < layer.neurons.size(); i++) {
            neurons.add(this.neurons.get(i).add(layer.neurons.get(i)));
        }
        return new Layer(neurons);
    }
}
