package pl.edu.pw.mini.awad.projektbadawczy.network;

import pl.edu.pw.mini.awad.projektbadawczy.algebraicstructures.Matrix;
import pl.edu.pw.mini.awad.projektbadawczy.algebraicstructures.Vector;

import java.util.ArrayList;
import java.util.Random;

public class Edges {
    public final Matrix weights;

    public Edges(Layer layer1, Layer layer2) {
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

    public Edges(Layer layer1, Layer layer2, double value) {
        ArrayList<Vector> weights = new ArrayList<Vector>();
        for (int i = 0; i < layer1.neurons.size(); i++) {
            ArrayList<Double> weightsFromLayer1ToLayer2 = new ArrayList<>();
            for (int j = 0; j < layer2.neurons.size(); j++) {
                weightsFromLayer1ToLayer2.add(value);
            }
            weights.add(new Vector(weightsFromLayer1ToLayer2));
        }
        this.weights = new Matrix(weights);
    }

    public Edges(Matrix weights) {
        this.weights = weights;
    }

    public Edges add(Edges edges) {
        return new Edges(Matrix.add(weights, edges.weights));
    }

    public Edges multiplyByScalar(double scalar) {
        return new Edges(Matrix.dot(scalar, weights));
    }
}
