package pl.edu.pw.mini.awad.projektbadawczy.network;

import pl.edu.pw.mini.awad.projektbadawczy.network.NeuralNetwork;

import java.util.ArrayList;
import java.util.Arrays;

public class NetworkDemonstrator {
    public static void main(String[] args) {
        ArrayList<Integer> sizes = new ArrayList<>(Arrays.asList(2, 3, 1));
        NeuralNetwork network = new NeuralNetwork(sizes);
        System.out.println(network.edges.get(0).weights.getClass());

    }

}