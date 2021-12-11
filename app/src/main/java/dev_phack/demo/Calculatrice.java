package dev_phack.demo;

public class Calculatrice {

    private double result;

    public void delete(){
        this.result = 0;
    }

    public void addition(double a, double b){
        this.result = a+b;
    }

    public void subtraction(double a, double b){
        this.result = a-b;
    }

    public void multiplication(double a, double b){
        this.result = a*b;
    }

    public void division(double a, double b){
        this.result = a/b;
    }
}
