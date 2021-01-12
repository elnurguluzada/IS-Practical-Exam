package com.company;

public class MultiLayerPerceptron {


    public float[] inputVector1 = new float[50];

    // Layer 1
    public float[] weightsOfLayer1 = new float[3];
    public float[] biasOfLayer1 = new float[3];
    public float[] VofLayer1 = new float[3];
    public float[] YOfLayer1 = new float[3];
    public float[] localGradientsOfLayer1 = new float[3];

    // Layer 2
    public float[] weightsOfLayer2 = new float[4];
    public float[] biasOfLayer2 = new float[2];
    public float[] VofLayer2 = new float[2];
    public float[] YOfLayer2 = new float[2];
    public float[] localGradientsOfLayer2 = new float[2];



    // Layer 3
    public float[] weightsOfLayer3 = new float[4];
    public float[] biasOfLayer3 = new float[3];
    public float[] VofLayer3 = new float[3];
    public float[] YOfLayer3 = new float[3];
    public float[] localGradientsOfLayer3 = new float[3];


    // Output layer
    public float[] weightsOfOutputLayer = new float[3];
    public float outputOfOutputLayer = 0;
    public float biasOfOutputLayer;

    float desiredOutput ;











    // Initializing Input Vector values
    float[] initializeValuesofInputVector1(){

        System.out.println("***************** Input Vector values ***************");
        for (int i = 0; i< inputVector1.length; i++){

            inputVector1[i] = (float) (Math.random() * (1 - (0)));

            System.out.println("inputVector[" +i+"] = " + inputVector1[i]);
        }


        return inputVector1;
    }




    // Initializing Weights of Layer 1

    float[] initializeWeightsOfLayer1(){

        System.out.println("***************** Layer 1 Weight values ***************");
        for (int i = 0; i < weightsOfLayer1.length; i++) {

            weightsOfLayer1[i] = (float) (Math.random() * (1 - (0)));
            System.out.println(" weightsOfLayer1[" + i +"]  = " +weightsOfLayer1[i]);

        }

        return weightsOfLayer1;
    }


    // Initializing Bias of Layer 1

    float[] initializeBiasofLayer1(){

        System.out.println("***************** Layer 1 Bias values ***************");

        for (int i = 0; i < biasOfLayer1.length; i++) {

            biasOfLayer1[i] = (float) (Math.random() * (1 - (0)));
            System.out.println(" biasOfLayer1[" + i +"]  = " +biasOfLayer1[i]);
        }

        return biasOfLayer1;
    }




    // Initializing Weights of Layer 2

    float[] initializeWeightsOfLayer2(){

        System.out.println("***************** Layer 2 Weight values ***************");

        for (int i = 0; i < weightsOfLayer2.length; i++) {

            weightsOfLayer2[i] = (float) (Math.random() * (1 - (0)));
            System.out.println(" weightsOfLayer2[" + i +"]  = " +weightsOfLayer2[i]);

        }

        return weightsOfLayer2;
    }


    // Initializing Bias of Layer 2

    float[] initializeBiasofLayer2(){


        System.out.println("***************** Layer 2 Bias values ***************");

        for (int i = 0; i < biasOfLayer2.length; i++) {

            biasOfLayer2[i] = (float) (Math.random() * (1 - (0)));
            System.out.println(" biasOfLayer2[" + i +"]  = " +biasOfLayer2[i]);

        }

        return biasOfLayer2;
    }



    // Initializing Weights of Layer 3

    float[] initializeWeightsOfLayer3(){


        System.out.println("***************** Layer 3 Weight values ***************");

        for (int i = 0; i < weightsOfLayer3.length; i++) {

            weightsOfLayer3[i] = (float) (Math.random() * (1 - (0)));
            System.out.println(" weightsOfLayer3[" + i +"]  = " +weightsOfLayer3[i]);

        }

        return weightsOfLayer3;
    }


    // Initializing Bias of Layer 3

    float[] initializeBiasofLayer3(){

        System.out.println("***************** Layer 3 Bias values ***************");

        for (int i = 0; i < biasOfLayer3.length; i++) {

            biasOfLayer3[i] = (float) (Math.random() * (1 - (0)));
            System.out.println(" biasOfLayer3[" + i +"]  = " +biasOfLayer3[i]);

        }

        return biasOfLayer3;
    }


    float[] initializeWeightsOfOutputLayer(){




        for (int i = 0; i < weightsOfOutputLayer.length; i++) {

            weightsOfOutputLayer[i] = (float) (Math.random() * (1 - (0)));


        }

        return weightsOfLayer3;
    }


    float initializeBiasofOutputLayer(){

        System.out.println("***************** Output Layer  Bias values ***************");

            biasOfOutputLayer = (float) (Math.random() * (1 - (0)));

        return biasOfOutputLayer;
    }




    // Layer 1 outputs calculation
    float[] calculateOutputsOfLayer_1(float input , float[] weightsOfInputLayer , float[] biasOfLayer1 ){

        System.out.println("***************** Layer 1 outputs ***************");

        for (int i = 0; i < VofLayer1.length; i++){

            VofLayer1[i] = input * weightsOfInputLayer[i]  +  biasOfLayer1[i];
            YOfLayer1[i] = (float) (1 / (1 + Math.exp(-VofLayer1[i])));
            System.out.println(" YOfLayer1[" + i +"]  = " +YOfLayer1[i]);

        }
        return YOfLayer1;
    }


    // Layer 2 outputs calculation
    float[] calculateOutputsOfLayer_2(float[] YOfLayer1 , float[] weightsOfLayer1 , float[] biasOfLayer2 ){

        System.out.println("***************** Layer 2 outputs ***************");


        for (int i = 0; i < VofLayer2.length; i++) {

            VofLayer2[i] = YOfLayer1[i] * weightsOfLayer1[i] + YOfLayer1[i + 1] * weightsOfLayer1[i + 1] + biasOfLayer2[i];
            YOfLayer2[i] = VofLayer2[i];
            System.out.println(" YOfLayer2[" + i + "]  = " + YOfLayer2[i]);
        }


        return YOfLayer1;
    }


    // Layer 3 outputs calculation
    float[] calculateOutputsOfLayer_3(float[] YOfLayer2 , float[] weightsOfLayer2 , float[] biasOfLayer3 ){

        System.out.println("***************** Layer 3 outputs ***************");


        for (int i = 0; i < VofLayer3.length; i++) {

            if( i == 0){
                VofLayer3[i] = YOfLayer2[i] * weightsOfLayer2[i] + biasOfLayer3[i];
                YOfLayer3[i] = (float) (1 / (1 + Math.exp(-VofLayer3[i])));
            } else if(i == 1){

                VofLayer3[i] = YOfLayer2[i-1] * weightsOfLayer2[i-1] + YOfLayer2[i] * weightsOfLayer2[i] + biasOfLayer3[i] ;
                YOfLayer3[i] = (float) (1 / (1 + Math.exp(-VofLayer3[i])));
            } else if(i == 2){
                VofLayer3[i] = YOfLayer2[i-1] * weightsOfLayer2[i-1] + biasOfLayer3[i];
                YOfLayer3[i] = (float) (1 / (1 + Math.exp(-VofLayer3[i])));
            }

        }


        return YOfLayer1;
    }

    // Desired output calculation
    float calculateDesiredOutput(float input){

        float desiredOutput = (float) ((1 + 0.6 * Math.sin(2* Math.PI * input / 7)) + (0.3 * Math.sin(2 * Math.PI * input) / 2 ));

        return desiredOutput;
    }


    float calculateOutput(float[] YOfLayer3 , float[] weightsOfLayer3, float   biasOfOutputLayer){

        for (int i = 0; i < YOfLayer3.length; i++) {
            outputOfOutputLayer += YOfLayer3[i] * weightsOfLayer3[i] ;
        }
        outputOfOutputLayer  = outputOfOutputLayer + biasOfOutputLayer;

        return outputOfOutputLayer;

    }



    float[] updateWeightsOfOutputLayer(float error, float learningRate){

        for (int i = 0; i < weightsOfOutputLayer.length; i++){

            weightsOfOutputLayer[i] = weightsOfOutputLayer[i] + learningRate * error * YOfLayer3[i];

            System.out.println("Updated weightsOfHiddenLayer[" +i+ "] = " + weightsOfOutputLayer[i]);
        }
        return weightsOfOutputLayer;
    }


    float updateBiasOfOutputLayer(float error, float learningRate){

        biasOfOutputLayer  =  biasOfOutputLayer + learningRate * error;

        return biasOfOutputLayer;
    }






    float[] calculateLocalGradientsOfLayer3(float error , float[] updatedWeightsOfOutputLayer, float[] YOfLayer3){


        for (int i = 0; i < localGradientsOfLayer3.length; i++){

            localGradientsOfLayer3[i]  = YOfLayer3[i]*(1-YOfLayer3[i])*error*updatedWeightsOfOutputLayer[i];

        }

        return localGradientsOfLayer3;
    }


    float[] updateWeightsOfLayer3(float[] YOfLayer2 , float[] weightsOfLayer3 , float[] localGradientsOfLayer3, float learningRate ){


                //firs neuron
                weightsOfLayer3[0] = weightsOfLayer3[0] + learningRate * localGradientsOfLayer3[0] * YOfLayer2[0];

                //second neuron
                weightsOfLayer3[1] = weightsOfLayer3[1] + learningRate * localGradientsOfLayer3[1] * YOfLayer2[0];
                weightsOfLayer3[2] = weightsOfLayer3[2] + learningRate * localGradientsOfLayer3[1] * YOfLayer2[1];
                // third neuron
                weightsOfLayer3[3] = weightsOfLayer3[3] + learningRate * localGradientsOfLayer3[2] * YOfLayer2[1];

        return weightsOfLayer3;
    }


    float[] updateBiasOfLayer3(float learningRate , float[] localGradientsOfLayer3 ){


        for (int i =0; i<biasOfLayer3.length; i++){
            biasOfLayer3[i] = biasOfLayer3[i] + learningRate*localGradientsOfLayer3[i];
        }

        return biasOfLayer3;
    }


    float[] calculateLocalGradientsOfLayer2(float[] updatedWeightsOfLayer3, float[] localGradientsOfLayer3 ,float[] YOfLayer2){



            localGradientsOfLayer2[0]  = YOfLayer2[0]*(1-YOfLayer2[0])*(localGradientsOfLayer3[0]*updatedWeightsOfLayer3[0] + localGradientsOfLayer3[1]*updatedWeightsOfLayer3[1]);
            localGradientsOfLayer2[1]  = YOfLayer2[1]*(1-YOfLayer2[1])*(localGradientsOfLayer3[1]*updatedWeightsOfLayer3[2] + localGradientsOfLayer3[2]*updatedWeightsOfLayer3[3]);




        return localGradientsOfLayer2;
    }

    float[] updateWeightsOfLayer2(float[] YOfLayer1 , float[] weightsOfLayer2 ,float[] localGradientsOfLayer2, float learningRate ){


        weightsOfLayer2[0] = weightsOfLayer2[0] + learningRate * localGradientsOfLayer2[0] * YOfLayer1[0];
        weightsOfLayer2[1] = weightsOfLayer2[1] + learningRate * localGradientsOfLayer2[0] * YOfLayer1[1];
        weightsOfLayer2[2] = weightsOfLayer2[2] + learningRate * localGradientsOfLayer2[1] * YOfLayer1[1];
        weightsOfLayer2[3] = weightsOfLayer2[3] + learningRate * localGradientsOfLayer2[1] * YOfLayer1[2];




        return weightsOfLayer2;
    }


    float[] updateBiasOfLayer2(float learningRate , float[] localGradientsOfLayer2 ){


        for (int i =0; i<biasOfLayer2.length; i++){
            biasOfLayer2[i] = biasOfLayer2[i] + learningRate*localGradientsOfLayer2[i];
        }

        return biasOfLayer2;
    }

    float[] calculateLocalGradientsOfLayer1(float[] updatedWeightsOfLayer2, float[] localGradientsOfLayer2 ,float[] YOfLayer1){


            localGradientsOfLayer1[0]  = YOfLayer1[0]*(1-YOfLayer1[0])*(localGradientsOfLayer2[0]*updatedWeightsOfLayer2[0]);
            localGradientsOfLayer1[1]  = YOfLayer1[1]*(1-YOfLayer1[1])*(localGradientsOfLayer2[0]*updatedWeightsOfLayer2[1] + localGradientsOfLayer2[1]*updatedWeightsOfLayer2[2]);
            localGradientsOfLayer1[2]  = YOfLayer1[2]*(1-YOfLayer1[2])*(localGradientsOfLayer2[1]*updatedWeightsOfLayer2[3]);


        return localGradientsOfLayer2;
    }



    float[] updateWeightsOfLayer1(float input, float learningRate,  float[] weightsOfLayer1 , float[] localGradientsOfLayer1){

        for (int i =0; i<weightsOfLayer1.length; i++){
            weightsOfLayer1[i] = weightsOfLayer1[i] + learningRate*localGradientsOfLayer1[i]*input;
        }

        return weightsOfLayer1;
    }

    float[] updateBiasOfLayer1(float learningRate , float[] localGradientsOfLayer1 ){


        for (int i =0; i<biasOfLayer1.length; i++){
            biasOfLayer1[i] = biasOfLayer1[i] + learningRate*localGradientsOfLayer1[i];
        }

        return biasOfLayer1;
    }

}
