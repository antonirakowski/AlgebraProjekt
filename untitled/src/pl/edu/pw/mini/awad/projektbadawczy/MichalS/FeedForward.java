package pl.edu.pw.mini.awad.projektbadawczy.MichalS;

import pl.edu.pw.mini.awad.projektbadawczy.algebraicstructures.Vector;
import pl.edu.pw.mini.awad.projektbadawczy.network.NeuralNetwork;


public class FeedForward {
    public static double feedForward(NeuralNetwork net, Vector c) {
        for (int i=0; i<net.numLayers-1; i++){

            c= Sigmoid.sigmoidVector(c);
        }
        return 0;
    }
 }
