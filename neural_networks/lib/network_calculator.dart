import 'package:ml_linalg/vector.dart';
import 'package:neural_networks/neural_networks.dart';

Vector calculateNetworkOutput(NeuralNetwork network, Vector input) {
  Vector result = Vector.fromList(input.toList());
  for (int i = 0; i < network.weights.length; i++) {
    result = (network.weights[i] * result).toVector() + network.layers[i];
  }
  return result;
}
