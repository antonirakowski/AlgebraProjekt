import 'dart:io';
import 'dart:typed_data';

import 'package:ml_linalg/vector.dart';
import 'package:neural_networks/neural_networks.dart';

class DatasetLoader {
  static Future<List<TrainingInput>> loadData(String labelsPath, String imagesPath) async {
    List<TrainingInput> trainingData = [];
    final labels = await File(labelsPath).readAsBytes();
    ByteData data = ByteData.view(labels.buffer.asUint8List().buffer);
    // final int magicNumber = data.getInt32(0);
    final int n = data.getInt32(4);
    final List<int> labelsResult = [];
    for (int i = 0; i < n; i++) {
      labelsResult.add(data.getUint8(8 + i));
    }
    final images = await File(imagesPath).readAsBytes();
    data = ByteData.view(images.buffer.asUint8List().buffer);

    var offset = 12;
    for (int j = 0; j < n; j++) {
      List<double> pixels = [];
      for (int i = 0; i < 784; i++) {
        pixels.add(data.getUint8(offset + i) / 255);
      }
      Vector output = Vector.filled(10, 0);
      trainingData.add(
          TrainingInput(input: Vector.fromList(pixels), output: output.set(labelsResult[j], 1)));
      offset += 784;
    }
    return trainingData;
  }
}
