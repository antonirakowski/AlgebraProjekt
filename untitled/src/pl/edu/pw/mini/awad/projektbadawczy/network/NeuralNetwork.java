package pl.edu.pw.mini.awad.projektbadawczy.network;

import pl.edu.pw.mini.awad.projektbadawczy.MichalS.Sigmoid;
import pl.edu.pw.mini.awad.projektbadawczy.algebraicstructures.Matrix;
import pl.edu.pw.mini.awad.projektbadawczy.algebraicstructures.Vector;
import pl.edu.pw.mini.awad.projektbadawczy.dataloader.TrainingItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NeuralNetwork {
    public ArrayList<Layer> layers;
    public ArrayList<Edges> edges;
    public NeuralNetwork (ArrayList<Integer> sizes) {
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

    public NeuralNetwork emptyCopy() {
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
    public String sizes(){
        String sizes = "";
        for (Layer layer : layers) {
            sizes += layer.neurons.size() + " ";
        }
        return sizes;
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
       System.out.println(this.sizes());
        System.out.println(this.edges);
        //feedforward
        Vector activation = item.input;
        List<Vector> activations = new ArrayList<>();
        activations.add(item.input);
        List<Vector> zs = new ArrayList<>();

        for (int i = 0; i < layers.size()-1; i++) {
            //branie biasów i wag
            Vector b = network.layers.get(i+1).getBiasesInVector();
            Matrix w = network.edges.get(i).weights;
            System.out.println(i);
            Matrix activation2 = new Matrix(new ArrayList<>(Arrays.asList(activation)));
            Vector z = Vector.add(Matrix.matrixToVector(Matrix.transpose(Matrix.multiply(Matrix.transpose(w),Matrix.transpose(activation2)))),b);
            zs.add(z);
            activation = Sigmoid.sigmoidVector(z);
            activations.add(activation);
        }

        // backward pass
        Vector delta = Vector.multiplyVector(
                Vector.addScalar((double) item.output,activations.get(activations.size() - 1)), // item.output = y
                sigmoidPrime(zs.get(zs.size() - 1))
        );

        network.layers.get(network.layers.size() - 1).setBiasesFromVector(delta);


        double help = Vector.dot(delta, activations.get(activations.size() - 1));
        ArrayList<Double> help2 = new ArrayList<>(Collections.nCopies(network.edges.size(), help));
        Vector valueToSet = new Vector(help2);

        network.edges.get(network.edges.size() - 1).weights.values.set(network.edges.size() - 1, valueToSet);

        //piece of shit above is wrong
        // might be good now


        //network.edges.get(network.edges.size() - 1).weights.values.get(0).values.set(0, delta.values.get(0) * activations.get(activations.size() - 2).values.get(0));
        for (int l = 2; l < network.layers.size(); l++) {
            Vector z = zs.get(zs.size() - l);
            Vector sp = sigmoidPrime(z);

            delta = Vector.multiply(Vector.dot(edges.get(edges.size() - l+1 /*-1+1*/ ).weights.values.get(edges.size() - l +1), delta), sp);

            network.layers.get(layers.size() - l ).setBiasesFromVector(delta);

            //useless loop?
            //for (Neuron neuron : layers.get(layers.size() - l).neurons) {
            //    biases.add(neuron.bias);
            //}


            //aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaTO 0 ????
            //edges.get(edges.size() - l - 1).weights.values.set(edges.size() - l - 1, Vector.dot(delta , activations.get(activations.size() - l - 2)) );
            //better below :O
            help = Vector.dot(delta, activations.get(activations.size() - l ));
            System.out.println("help: " + help);
            help2 = new ArrayList<>(Collections.nCopies(network.layers.get(layers.size()-l).neurons.size(), help));
            System.out.println("help2: " + help2);
            valueToSet = new Vector(help2);
            network.edges.get(edges.size() - l ).weights.values.set(edges.size() - l, valueToSet);
        }
        System.out.println(network.edges.get(0).weights.values.get(0).values);
        System.out.println(network.sizes());
        return network;
        //return this.emptyCopy();
    }

    private Vector sigmoidPrime(Vector z) {
        return Vector.multiplyVector(Sigmoid.sigmoidDerivativeVector(z),Vector.substractScalarLeft(1.0, Sigmoid.sigmoidVector(z)));
    }

}
