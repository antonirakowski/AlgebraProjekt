package pl.edu.pw.mini.awad.projektbadawczy;

import pl.edu.pw.mini.awad.projektbadawczy.network.NeuralNetwork;

import java.util.ArrayList;
import java.util.Arrays;

public class Demonstrator {
    public static void main(String[] args) {
        NeuralNetwork network = new NeuralNetwork(new ArrayList<>(Arrays.asList(new Integer[] {2, 3, 1})));
    }
}