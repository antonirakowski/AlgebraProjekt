import 'dart:math';

import 'package:neural_networks/dataset_loader.dart';
import 'package:neural_networks/network_calculator.dart';
import 'package:neural_networks/neural_networks.dart';
import 'package:neural_networks/mini_batch_delta.dart';

void main(List<String> arguments) async {
  var data = await DatasetLoader.loadData(
      'data/train-labels-idx1-ubyte', 'data/train-images-idx3-ubyte');
  Random rand = Random(888);
  data.shuffle(rand);
  var network = NeuralNetwork([784, 128, 64, 10], rand);
  var epochs = 700;
  var miniBatchSize = 10;
  var eta = 3.0;
  trainNetwork(network, data, epochs, miniBatchSize, eta);
  var testData = await DatasetLoader.loadData(
      'data/t10k-labels-idx1-ubyte', 'data/t10k-images-idx3-ubyte');
  var sum = 0;
  for (int i = 0; i < 10000; i++) {
    var result = calculateNetworkOutput(network, testData[i].input).toList();
    int maxK = 0;
    double maxArg = result[0];
    for (int k = 0; k < 10; k++) {
      if (result[k] > maxArg) {
        maxArg = result[k];
        maxK = k;
      }
    }
    if (testData[i].output.toList()[maxK] == 1) {
      sum += 1;
    }
  }
  print("Network accuracy: ${sum * 100 / 10000}%");
}

void trainNetwork(NeuralNetwork network, List<TrainingInput> data, int epochs,
    int miniBatchSize, double eta) {
  for (int i = 0; i < epochs; i++) {
    if (i % 10 == 0) {
      print("$i of $epochs");
    }

    var (layers, weights) = calculateDeltaFromMiniBatch(
        network, data.sublist(i * miniBatchSize, (i + 1) * miniBatchSize), eta);
    for (int j = 0; j < network.weights.length; j++) {
      network.weights[j] = network.weights[j] + weights[j];
    }
    for (int k = 0; k < network.layers.length; k++) {
      network.layers[k] = network.layers[k] + layers[k];
    }
  }
}
