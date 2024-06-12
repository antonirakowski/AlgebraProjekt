package pl.edu.pw.mini.awad.projektbadawczy.network;

import java.util.ArrayList;
import java.util.Random;
import pl.edu.pw.mini.awad.projektbadawczy.algebraicstructures.Vector;

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

    public Vector getBiasesInVector(){
        ArrayList<Double> biases = new ArrayList<>();
        for (Neuron neuron : neurons) {
            biases.add(neuron.bias);
        }
        return new Vector(biases);
    }

    public void setBiasesFromVector(Vector biases){
        for (int i = 0; i < neurons.size(); i++) {
            neurons.get(i).bias = biases.values.get(i);
        }
    }

}
