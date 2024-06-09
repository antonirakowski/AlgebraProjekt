package pl.edu.pw.mini.awad.projektbadawczy.network;

import pl.edu.pw.mini.awad.projektbadawczy.MichalS.Sigmoid;
import pl.edu.pw.mini.awad.projektbadawczy.algebraicstructures.Vector;
import pl.edu.pw.mini.awad.projektbadawczy.dataloader.TrainingItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NeuralNetwork {
    public ArrayList<Layer> layers;
    public ArrayList<Edges> edges;

    NeuralNetwork (ArrayList<Integer> sizes) {
        ArrayList<Layer> layers = new ArrayList<>();
        for (int i = 0; i < sizes.size(); i++) {
            layers.add(new Layer(sizes.get(i)));
        }
        this.layers = layers;
        ArrayList<Edges> edges = new ArrayList<>();
        for (int i = 0; i < sizes.size() - 1; i++) {
            edges.add(new Edges(layers.get(i), layers.get(i + 1)));
        }
        this.edges = edges;
    }

    NeuralNetwork (ArrayList<Layer> layers, ArrayList<Edges> edges) {
        this.layers = layers;
        this.edges = edges;
    }

    NeuralNetwork emptyCopy() {
        ArrayList<Layer> layers = new ArrayList<>();
        for (int i = 0; i < this.layers.size(); i++) {
            layers.add(new Layer(this.layers.get(i).neurons.size(), 0));
        }
        ArrayList<Edges> edgesSet = new ArrayList<>();
        for (int i = 0; i < layers.size() - 1; i++) {
            Edges edges = new Edges(layers.get(i), layers.get(i + 1), 0);
            edgesSet.add(edges);
        }
        return new NeuralNetwork(layers, edgesSet);
    }

    public NeuralNetwork add(NeuralNetwork other) {
        ArrayList<Layer> layers = new ArrayList<>();
        for (int i = 0; i < this.layers.size(); i++) {
            layers.add(this.layers.get(i).add(other.layers.get(i)));
        }
        ArrayList<Edges> edgesSet = new ArrayList<>();
        for (int i = 0; i < layers.size() - 1; i++) {
            edgesSet.add(this.edges.get(i).add(other.edges.get(i)));
        }
        return new NeuralNetwork(layers, edgesSet);
    }


    public NeuralNetwork multiplyByScalar(double scalar) {
        ArrayList<Layer> layers = new ArrayList<>();
        for (Layer layer : this.layers) {
            layers.add(layer.multiplyByScalar(scalar));
        }
        ArrayList<Edges> edgesSet = new ArrayList<>();
        for (int i = 0; i < layers.size() - 1; i++) {
            edgesSet.add(this.edges.get(i).multiplyByScalar(scalar));
        }
        return new NeuralNetwork(layers, edgesSet);
    }

    public void updateMiniBatch(ArrayList<TrainingItem> trainingItems, double eta) {
        NeuralNetwork result = this.emptyCopy();
        for (TrainingItem trainingItem : trainingItems) {
            result = result.add(backprop(trainingItem));
        }
        result = result.multiplyByScalar(-eta/trainingItems.size());
        result = this.add(result);
        this.edges = result.edges;
        this.layers = result.layers;
    }

    public NeuralNetwork backprop(TrainingItem item) {
        NeuralNetwork network = this.emptyCopy(); //kopiuje szkielet

        //feedforward
        Vector activation = item.input;
        List<Vector> activations = new ArrayList<>();
        activations.add(item.input);
        List<Vector> zs = new ArrayList<>();

        for (int i = 0; i < layers.size(); i++) {
            Vector b = network.layers.get(i).getBiasesInVector();

            Vector w = network.edges.get(i).weights.values.get(i);
            Vector z = Vector.addScalar(Vector.dot(w, activation), b);
            zs.add(z);
            activation = Sigmoid.sigmoidDerivativeVector(z);
            activations.add(activation);
        }

        // backward pass
        Vector delta = Vector.multiplyVector(
                Vector.subtract( activations.get(activations.size() - 1), item.output), // item.output = y
                sigmoidPrime(zs.get(zs.size() - 1))
        );

        network.layers.get(network.layers.size() - 1).setBiasesFromVector(delta);
        network.edges.get(network.edges.size() - 1).weights.values.set(network.edges.size() - 1, Vector.multiplyVector(delta, activations.get(activations.size() - 2)));

        //network.edges.get(network.edges.size() - 1).weights.values.get(0).values.set(0, delta.values.get(0) * activations.get(activations.size() - 2).values.get(0));
        for (int l = 2; l < network.layers.size(); l++) {
            Vector z = zs.get(zs.size() - l);
            Vector sp = sigmoidPrime(z);
            delta = Vector.multiply(Vector.dot(edges.get(edges.size() - l).weights.values.get(edges.size() - l + 1), delta), sp);
            layers.get(layers.size() - l).setBiasesFromVector(delta);
            //for (Neuron neuron : layers.get(layers.size() - l).neurons) {
            //    biases.add(neuron.bias);
            //} //useless?

            edges.get(edges.size() - l - 1).weights.values.set(0, Vector.multiplyVector(delta , activations.get(activations.size() - l - 2)) );
        }

        //return network;
        return this.emptyCopy();
    }

    private Vector sigmoidPrime(Vector z) {
        return Vector.multiplyVector(Sigmoid.sigmoidDerivativeVector(z),Vector.substractScalarLeft(1.0, Sigmoid.sigmoidVector(z)));
    }

}
