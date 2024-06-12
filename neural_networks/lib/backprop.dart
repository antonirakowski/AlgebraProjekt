import 'package:ml_linalg/matrix.dart';
import 'package:ml_linalg/vector.dart';
import 'package:neural_networks/neural_networks.dart';
import 'package:neural_networks/utils.dart';

(List<Vector>, List<Matrix>) backprop(NeuralNetwork network, Vector input, Vector desiredOutput) {
  List<Vector> resultLayers = [];
  List<Matrix> resultWeights = [];
  List<Vector> networkOutputs = [input];
  Vector lastNetworkOutput = input;
  List<Vector> zs = [];
  // feedforward
  for (int i = 0; i < network.weights.length; i++) {
    Vector z = (network.weights[i] * lastNetworkOutput).toVector() + network.layers[i];
    zs.add(z);
    lastNetworkOutput = vectorizedSigmoid(z);
    networkOutputs.add(lastNetworkOutput);
  }
  // backwards pass
  Vector delta = (networkOutputs.last - desiredOutput) * vectorizedSigmoidPrime(zs.last);
  for (int i = 1; i < network.sizes.length; i++) {
    if (i > 1) {
      Matrix dot = network.weights[network.weights.length - i + 1].transpose() * delta;
      assert(dot.columnCount == 1);
      delta = dot.getColumn(0) * vectorizedSigmoidPrime(zs[zs.length - i]);
    }
    resultLayers.insert(0, delta);
    resultWeights.insert(0, outerProduct(delta, networkOutputs[networkOutputs.length - i - 1]));
  }
  return (resultLayers, resultWeights);
}
