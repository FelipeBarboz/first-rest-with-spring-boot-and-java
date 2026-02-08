package br.com.FelipeBarboz.services;

import org.springframework.stereotype.Service;

@Service
public class MathService {

    public Double sum(Double a, Double b) {
        return a + b;
    }

    public Double sub(Double a, Double b) {
        return a - b;
    }

    public Double multi(Double a, Double b) {
        return a * b;
    }

    public Double division(Double a, Double b) {
        return a / b;
    }

    public Double avg(Double a, Double b) {
        return (a + b) / 2;
    }

    public Double sqrt(Double a) {
        return Math.sqrt(a);
    }
}
