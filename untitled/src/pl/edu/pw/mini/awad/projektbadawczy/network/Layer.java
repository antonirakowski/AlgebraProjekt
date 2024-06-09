package pl.edu.pw.mini.awad.projektbadawczy.network;

import java.util.ArrayList;
import java.util.Random;

public class Layer {
    public ArrayList<Neuron> neurons;

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
        return null;
    }

    public Layer multiplyByScalar(double scalar) {
        ArrayList<Neuron> neurons = new ArrayList<>();
        for (Neuron neuron : this.neurons) {
            neurons.add(neuron.multiplyByScalar(scalar));
        }
        return  new Layer(neurons);
    }
}
