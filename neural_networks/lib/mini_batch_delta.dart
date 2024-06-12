import 'package:ml_linalg/matrix.dart';
import 'package:ml_linalg/vector.dart';
import 'package:neural_networks/neural_networks.dart';
import 'package:neural_networks/backprop.dart';

(List<Vector>, List<Matrix>) calculateDeltaFromMiniBatch(
    NeuralNetwork network, List<TrainingInput> miniBatch, double eta) {
  var (List<Vector> resultLayers, List<Matrix> resultWeights) =
      NeuralNetwork.generateEmptyNetwork(network.sizes);
  for (var batch in miniBatch) {
    var (biases, weights) = backprop(network, batch.input, batch.output);
    for (int i = 0; i < resultLayers.length; i++) {
      resultLayers[i] = biases[i] + resultLayers[i];
    }
    for (int i = 0; i < resultWeights.length; i++) {
      resultWeights[i] = weights[i] + resultWeights[i];
    }
  }

  for (int i = 0; i < resultWeights.length; i++) {
    resultWeights[i] =
        resultWeights[i] * Matrix.scalar(-eta / (miniBatch.length), resultWeights[i].columnCount);
  }

  for (int i = 0; i < resultLayers.length; i++) {
    resultLayers[i] = resultLayers[i] * -eta / (miniBatch.length);
  }

  return (resultLayers, resultWeights);
}
