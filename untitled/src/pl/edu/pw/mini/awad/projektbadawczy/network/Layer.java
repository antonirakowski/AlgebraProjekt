package pl.edu.pw.mini.awad.projektbadawczy.network;

import java.util.ArrayList;

public class Layer {
    ArrayList<Neuron> neurons;

    public Layer(ArrayList<Neuron> neurons) {
        this.neurons = neurons;
    }

    public Layer(int size) {
        ArrayList<Neuron> neurons = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            neurons.add(new Neuron());
        }
        this.neurons = neurons;
    }
}
