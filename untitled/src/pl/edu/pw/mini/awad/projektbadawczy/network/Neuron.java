package pl.edu.pw.mini.awad.projektbadawczy.network;
import java.util.*;

public class Neuron {
    double bias;

    public Neuron( double bias) {
        this.bias = bias;
    }

    public Neuron() {
        Random random = new Random();
        this.bias = random.nextDouble();
    }
}
