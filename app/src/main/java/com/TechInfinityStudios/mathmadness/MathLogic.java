package com.TechInfinityStudios.mathmadness;

import java.util.Random;

public class MathLogic {

    Random rand = new Random();
    int answer;

    public String getAdditionQuestion() {

        int num1 = rand.nextInt(10);
        int num2 = rand.nextInt(10);

        answer = num1 + num2;
        return num1 + " + " + num2;

    }

    public String getSubtractionQuestion() {

        int num1 = rand.nextInt(10);
        int num2 = rand.nextInt(10);

        answer = num1 - num2;
        return num1 + " - " + num2;

    }

   public String getMultiplicationQuestion() {

        int num1 = rand.nextInt(10);
        int num2 = rand.nextInt(10);

        answer = num1 * num2;
        return num1 + " * " + num2;

   }



   public int getAnswer() {
       return answer;
   }


}
