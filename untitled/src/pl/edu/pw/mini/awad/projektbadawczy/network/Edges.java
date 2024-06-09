package pl.edu.pw.mini.awad.projektbadawczy.network;

import pl.edu.pw.mini.awad.projektbadawczy.algebraicstructures.Matrix;
import pl.edu.pw.mini.awad.projektbadawczy.algebraicstructures.Vector;

import java.util.ArrayList;
import java.util.Random;

public class Edges {
    final Layer layer1;
    final Layer layer2;
    public final Matrix weights;

    public Edges(Layer layer1, Layer layer2) {
        this.layer1 = layer1;
        this.layer2 = layer2;
        Random random = new Random();
        ArrayList<Vector> weights = new ArrayList<Vector>();
        for (int i = 0; i < layer1.neurons.size(); i++) {
            ArrayList<Double> weightsFromLayer1ToLayer2 = new ArrayList<>();
            for (int j = 0; j < layer2.neurons.size(); j++) {
                weightsFromLayer1ToLayer2.add(random.nextDouble());
            }
            weights.add(new Vector(weightsFromLayer1ToLayer2));
        }
        this.weights = new Matrix(weights);
    }
}
