package pl.edu.pw.mini.awad.projektbadawczy.network;
import java.util.*;

public class Neuron {
    double weight;
    double bias;

    public Neuron(double weight, double bias) {
        this.weight = weight;
        this.bias = bias;
    }

    public Neuron() {
        Random random = new Random();
        this.weight  = random.nextDouble();
        this.bias = random.nextDouble();
    }
}
