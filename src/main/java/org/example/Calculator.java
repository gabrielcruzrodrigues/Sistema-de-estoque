package org.example;

public class Calculator {
    private Integer n1;
    private Integer n2;

    public Calculator() {}

    public Calculator(Integer n1, Integer n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    public void Soma() {
        System.out.printf("A soma deu: %d%n", this.n1 + this.n2);
    }

    public Integer getN1() {
        return this.n1;
    }

    public void setN1(Integer valor) {
        this.n1 = valor;
    }

    public Integer getN2() {
        return this.n2;
    }

    public void setN2(Integer valor) {
        this.n2 = valor;
    }

}
