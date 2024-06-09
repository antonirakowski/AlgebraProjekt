package pl.edu.pw.mini.awad.projektbadawczy.MichalS;

import pl.edu.pw.mini.awad.projektbadawczy.algebraicstructures.Matrix;
import pl.edu.pw.mini.awad.projektbadawczy.algebraicstructures.Vector;
import pl.edu.pw.mini.awad.projektbadawczy.network.NeuralNetwork;
import pl.edu.pw.mini.awad.projektbadawczy.network.Neuron;

import java.util.ArrayList;


public class FeedForward {
    public static Matrix feedForward(NeuralNetwork net, Matrix a) {
        for (int i=0; i<net.layers.size()-1; i++){
            ArrayList<Neuron> neurony = net.layers.get(i+1).neurons;
            ArrayList<Double> wynik = new ArrayList<>();
            for (Neuron neuron : neurony) {
                wynik.add(neuron.bias);
            }
           Vector b = new Vector(wynik);
           Matrix w = net.edges.get(i).weights;
           System.out.println(w);
           System.out.println(i);
           System.out.println(b);
           System.out.println(a);
           System.out.println(Matrix.multiply(a,w));
           a= Sigmoid.sigmoidMatrix(Matrix.addVector(Matrix.Transpose(Matrix.multiply(a,w)), b));


        }

        System.out.println(a.getClass());
        return a;
    }
 }
