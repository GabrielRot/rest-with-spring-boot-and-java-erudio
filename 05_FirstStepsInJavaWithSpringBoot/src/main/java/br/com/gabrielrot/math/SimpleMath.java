package br.com.gabrielrot.math;

import br.com.gabrielrot.exception.UnsupportedMathOperationException;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class SimpleMath {

    public Double sum(Double numberOne, Double numberTwo) {
        return numberOne + numberTwo;
    }

    public Double sub(Double numberOne, Double numberTwo) {
        return numberOne - numberTwo;
    }

    public Double multiply(Double numberOne, Double numberTwo) {
        return numberOne * numberTwo;
    }

    public Double div(Double numberOne, Double numberTwo) {
        return numberOne / numberTwo;
    }

    public Double root(Double number) {
        return number * number;
    }

    public Double avg(List<Double> numbers) {
        AtomicReference<Double> result = new AtomicReference<>(0.0);

        numbers.forEach(number -> {
            result.updateAndGet(value -> value + number);
        });

        result.updateAndGet(value -> value / numbers.size());

        return result.get();
    }

}
