package com.company;

public class Main {

    public static void main(String[] args) {


        MultiLayerPerceptron multilayerPerceptron = new MultiLayerPerceptron();

        float[] inputVector = new float[50];


        // Layer 1
        float[] weightsOfLayer1 = new float[3];
        float[] biasOfLayer1 = new float[3];
        float[] YOfLayer1 = new float[3];
        float[] updatedLocalGradientsOfLayer1 = new float[3];

        // Layer 2
        float[] weightsOfLayer2 = new float[4];
        float[] biasOfLayer2 = new float[2];
        float[] YOfLayer2 = new float[2];
        float[] updatedLocalGradientsOfLayer2 = new float[3];


        // Layer 3
        float[] weightsOfLayer3 = new float[3];
        float[] biasOfLayer3 = new float[3];
        float[] YOfLayer3 = new float[3];
        float[] updatedLocalGradientsOfLayer3 = new float[3];

        // Output layer
        float[] weightsOfOutputLayer = new float[3];
        float[] receivedOutput  = new float[50];
        float biasofOutputLayer;
        float[] desiredOutput = new  float[50];

        float learningRate = 0.2F;
        float error;

        // Getting Input vector
        inputVector = multilayerPerceptron.initializeValuesofInputVector1();
        // Getting Input Weights


        // Getting Layer 1 weights
        weightsOfLayer1 = multilayerPerceptron.initializeWeightsOfLayer1();
        // Getting Layer 1 Bias
        biasOfLayer1 = multilayerPerceptron.initializeBiasofLayer1();


        // Getting Layer 2 weights
        weightsOfLayer2 = multilayerPerceptron.initializeWeightsOfLayer2();
        // Getting Layer 2 Bias
        biasOfLayer2 = multilayerPerceptron.initializeBiasofLayer2();


        // Getting Layer 3 weights
        weightsOfLayer3 = multilayerPerceptron.initializeWeightsOfLayer3();
        // Getting Layer 3 Bias
        biasOfLayer3 = multilayerPerceptron.initializeBiasofLayer3();



        weightsOfOutputLayer = multilayerPerceptron.initializeWeightsOfOutputLayer();
        biasofOutputLayer = multilayerPerceptron.initializeBiasofOutputLayer();





        // Update Part

        for(int j =0; j < 1000; j++) {


            for (int i = 0; i < inputVector.length; i++) {

                desiredOutput[i] = multilayerPerceptron.calculateDesiredOutput(inputVector[i]);

                YOfLayer1 = multilayerPerceptron.calculateOutputsOfLayer_1(inputVector[i] , weightsOfLayer1, biasOfLayer1);
                YOfLayer2 = multilayerPerceptron.calculateOutputsOfLayer_2(YOfLayer1, weightsOfLayer2, biasOfLayer2);
                YOfLayer3 = multilayerPerceptron.calculateOutputsOfLayer_3(YOfLayer2, weightsOfLayer3, biasOfLayer3);
                receivedOutput[i] = multilayerPerceptron.calculateOutput(YOfLayer3, weightsOfOutputLayer , biasofOutputLayer);

                error =desiredOutput[i] - receivedOutput[i];


                weightsOfOutputLayer= multilayerPerceptron.updateWeightsOfOutputLayer(error, learningRate);
                biasofOutputLayer = multilayerPerceptron.updateBiasOfOutputLayer(error, learningRate);
                updatedLocalGradientsOfLayer3 = multilayerPerceptron.calculateLocalGradientsOfLayer3(error, weightsOfOutputLayer, YOfLayer3);
                weightsOfLayer3 = multilayerPerceptron.updateWeightsOfLayer3(YOfLayer2, weightsOfLayer3, updatedLocalGradientsOfLayer3, learningRate);
                biasOfLayer3 = multilayerPerceptron.updateBiasOfLayer3(error, updatedLocalGradientsOfLayer3);

                updatedLocalGradientsOfLayer2 = multilayerPerceptron.calculateLocalGradientsOfLayer2(weightsOfLayer2, updatedLocalGradientsOfLayer3, YOfLayer2);
                weightsOfLayer2 = multilayerPerceptron.updateWeightsOfLayer2(YOfLayer1, weightsOfLayer2, updatedLocalGradientsOfLayer2, learningRate);
                biasOfLayer2 = multilayerPerceptron.updateBiasOfLayer2(learningRate, updatedLocalGradientsOfLayer2);

                updatedLocalGradientsOfLayer1 = multilayerPerceptron.calculateLocalGradientsOfLayer1(weightsOfLayer2, updatedLocalGradientsOfLayer2, YOfLayer1);
                weightsOfLayer1 = multilayerPerceptron.updateWeightsOfLayer1(inputVector[i] , learningRate, weightsOfLayer1, updatedLocalGradientsOfLayer1);


                YOfLayer1 = multilayerPerceptron.calculateOutputsOfLayer_1(inputVector[i] , weightsOfLayer1, biasOfLayer1);
                YOfLayer2 = multilayerPerceptron.calculateOutputsOfLayer_2(YOfLayer1, weightsOfLayer2, biasOfLayer2);
                YOfLayer3 = multilayerPerceptron.calculateOutputsOfLayer_3(YOfLayer2, weightsOfLayer3, biasOfLayer3);
                receivedOutput[i] = multilayerPerceptron.calculateOutput(YOfLayer3, weightsOfOutputLayer , biasofOutputLayer);




            }

        }








    }
}
