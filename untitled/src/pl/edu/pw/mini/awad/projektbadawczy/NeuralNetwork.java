
package pl.edu.pw.mini.awad.projektbadawczy;
import java.util.*;

public class NeuralNetwork {

    private int numLayers;
    private ArrayList<Integer> sizes;
    private ArrayList<ArrayList<Double>> biases;
    private ArrayList<ArrayList<Double>> weights;

    NeuralNetwork (ArrayList<Integer> sizes) {
        numLayers = sizes.size();
        this.sizes = sizes;
        ArrayList<ArrayList<Double>> biases = new ArrayList<ArrayList<Double>>();
        Random random = new Random();
        for (int i = 1; i < sizes.size(); i++) {
            ArrayList<Double> bias = new ArrayList<Double>();
            for (int j = 0; j < sizes.get(i); j++ ) {
                bias.add(random.nextDouble());
            }
            biases.add(bias);
        }
        ArrayList<ArrayList<Weights>>
    }

    private Double sigmoid(Vector v){
        return
    }

}
