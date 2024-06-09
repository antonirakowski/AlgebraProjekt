package pl.edu.pw.mini.awad.projektbadawczy.network;

import java.util.ArrayList;
import java.util.Random;

public class Layer {
    ArrayList<Neuron> neurons;

    public Layer(ArrayList<Neuron> neurons) {
        this.neurons = neurons;
    }

    public Layer(int size, boolean isRandom) {
        ArrayList<Neuron> neurons = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            double value = 0;
            if (isRandom) {
                value = random.nextDouble();
            }
            neurons.add(new Neuron(value));
        }
        this.neurons = neurons;
    }
}
