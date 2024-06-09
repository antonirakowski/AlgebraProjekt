package pl.edu.pw.mini.awad.projektbadawczy.MichalS;

import pl.edu.pw.mini.awad.projektbadawczy.algebraicstructures.Vector;
import pl.edu.pw.mini.awad.projektbadawczy.network.NeuralNetwork;


public class FeedForward {
    public static double feedForward(NeuralNetwork net, double x, Vector c) {
        for (int i=0; i<net.numLayers-1; i++){
            x= Sigmoid.sigmoid(Vector.dot(c,c));
        }
        return 0;
    }
}
