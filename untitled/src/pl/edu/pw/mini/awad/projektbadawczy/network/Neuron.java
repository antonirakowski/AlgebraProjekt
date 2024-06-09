package pl.edu.pw.mini.awad.projektbadawczy.network;
import java.util.*;

public class Neuron {
    final double bias;

    public Neuron( double bias) {
        this.bias = bias;
    }

    public Neuron add(Neuron neuron) {
        return  new Neuron(this.bias + neuron.bias);
    }
}
