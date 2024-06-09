package pl.edu.pw.mini.awad.projektbadawczy.network;

import pl.edu.pw.mini.awad.projektbadawczy.MichalS.FeedForward;
import pl.edu.pw.mini.awad.projektbadawczy.algebraicstructures.Matrix;
import pl.edu.pw.mini.awad.projektbadawczy.algebraicstructures.Vector;
import pl.edu.pw.mini.awad.projektbadawczy.network.NeuralNetwork;

import java.util.ArrayList;
import java.util.Arrays;

public class NetworkDemonstrator {
    public static void main(String[] args) {
        ArrayList<Integer> sizes = new ArrayList<>(Arrays.asList(2, 3, 1));
        NeuralNetwork network = new NeuralNetwork(sizes);
        Vector aprym = new Vector(new ArrayList<>(Arrays.asList(3.0, 4.0)));
        Matrix a = new Matrix(new ArrayList<>(Arrays.asList(aprym)));
        FeedForward.feedForward(network, a);

    }

}