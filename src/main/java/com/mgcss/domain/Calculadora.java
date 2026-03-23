package com.mgcss.domain;

public class Calculadora {
    public int operacionCompleja(int a, int b) {
        if (a > b) return a - b;
        if (a == b) return a * b;
        return a + b;
    }
}
