import 'dart:math';

import 'package:ml_linalg/matrix.dart';
import 'package:ml_linalg/vector.dart';
import 'package:neural_networks/utils.dart';

class NeuralNetwork {
  final List<Vector> layers = [];
  final List<Matrix> weights = [];
  final List<int> sizes;
  final Random rand;

  NeuralNetwork(this.sizes, this.rand) {
    for (int i = 0; i < sizes.length - 1; i++) {
      List<List<double>> matrix = []; // matrix of size sizes[i] x sizes[i + 1]
      double stdDev = sqrt(2 / (sizes[i] + sizes[i + 1]));
      for (int j = 0; j < sizes[i + 1]; j++) {
        matrix.add(rand.nextGaussians(sizes[i], stdDev: stdDev));
      }
      weights.add(Matrix.fromList(matrix));
      layers.add(Vector.fromList(rand.nextGaussians(sizes[i + 1], stdDev: stdDev)));
    }
  }

  static (List<Vector> layers, List<Matrix> weights) generateEmptyNetwork(List<int> sizes) {
    List<Vector> layers = [];
    List<Matrix> weights = [];
    for (int i = 0; i < sizes.length - 1; i++) {
      List<List<double>> matrix = []; // matrix of size sizes[i] x sizes[i + 1]
      for (int j = 0; j < sizes[i + 1]; j++) {
        matrix.add(List.filled(sizes[i], 0));
      }
      weights.add(Matrix.fromList(matrix));
      layers.add(Vector.fromList(List.filled(sizes[i + 1], 0)));
    }
    return (layers, weights);
  }
}

class TrainingInput {
  final Vector input;
  final Vector output;

  TrainingInput({required this.input, required this.output});
}
