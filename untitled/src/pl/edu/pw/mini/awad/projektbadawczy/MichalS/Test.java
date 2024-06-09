package pl.edu.pw.mini.awad.projektbadawczy.MichalS;

import pl.edu.pw.mini.awad.projektbadawczy.network.NeuralNetwork;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> sizes = new ArrayList<>();
        sizes.add(3);
        sizes.add(2);
        sizes.add(4);
        NeuralNetwork network = new NeuralNetwork(sizes);
        NeuralNetwork xd = network.emptyCopy();
        network.add(xd);

    }
}
