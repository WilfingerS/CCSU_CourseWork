package com.example.pizzaapplication;
import java.lang.Math;
public class PizzaObject {
    private final double[] sizeCost = new double[] {10.29,12.59,14.89};
    private final double[] toppingCost = new double[] {1.39,2.29,2.99};
    public int size,type,numOfToppings; // id of the image


    public PizzaObject(int type){
        this.type = type;
        this.size = -1;
        this.numOfToppings = 0;
    }

    private double roundTwoDec(double value){
        return Math.round(value*100.0)/100.0;
    }

    public void reset(int type){
        this.type = type;
        this.size = -1;
        this.numOfToppings = 0;
    }
    public double getTotalCost(){
        if (size < 0 || size > 2) // Check if within range
            return 0.00;
        double cost = sizeCost[size] + (toppingCost[size] * numOfToppings);
        return roundTwoDec(cost);
    }
    public void setSize(int size){
        this.size = size;
    }
    public void setType(int type){
        this.type = type;
    }
    public void setNumOfToppings(int newNum){
        if (newNum < 0)
            newNum = 0;
        else if(newNum > 6)
            newNum = 6;

        this.numOfToppings = newNum;
    }

}
