package pl.edu.pw.mini.awad.projektbadawczy.network;

public class Neuron {
    public double bias;

    public Neuron( double bias) {
        this.bias = bias;
    }

    public Neuron add(Neuron neuron) {
        return new Neuron(this.bias + neuron.bias);
    }

    public Neuron multiplyByScalar(double scalar) {
        return new Neuron(this.bias * scalar);
    }
}
