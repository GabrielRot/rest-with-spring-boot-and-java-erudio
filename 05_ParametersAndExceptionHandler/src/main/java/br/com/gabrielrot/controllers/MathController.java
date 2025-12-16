package br.com.gabrielrot.controllers;

import br.com.gabrielrot.exception.UnsupportedMathOperationException;
import br.com.gabrielrot.math.SimpleMath;
import br.com.gabrielrot.request.converters.NumberConverter;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@RestController
@RequestMapping("/math")
public class MathController {

    private SimpleMath math = new SimpleMath();

    // http://localhost:8080/math/sum/1/1
    @GetMapping("sum/{numberOne}/{numberTwo}")
    public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws IllegalArgumentException {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Invalid numeric value");

        return math.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    // http://localhost:8080/math/sub/1/1
    @GetMapping("sub/{numberOne}/{numberTwo}")
    public Double sub(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws IllegalArgumentException {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Invalid numeric value");

        return math.sub(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    // http://localhost:8080/math/multiply/1/1
    @GetMapping("multiply/{numberOne}/{numberTwo}")
    public Double multiply(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws IllegalArgumentException {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Invalid numeric value");

        return math.multiply(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    // http://localhost:8080/math/div/1/1
    @GetMapping("div/{numberOne}/{numberTwo}")
    public Double div(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws IllegalArgumentException {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Invalid numeric value");

        return math.div(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    // http://localhost:8080/math/root/1
    @GetMapping("root/{number}")
    public Double root(@PathVariable("number") String number) throws IllegalArgumentException {
        if (!NumberConverter.isNumeric(number)) throw new UnsupportedMathOperationException("Invalid numeric value");

        return math.root(NumberConverter.convertToDouble(number));
    }

    // http://localhost:8080/root/avg/
    @PostMapping("/avg")
    public Double avg(@RequestBody List<String> numbers) throws IllegalArgumentException {
        List<Double> parameters = new ArrayList<>();

        for (int i = 1; i < numbers.size(); i++) {
            if (!NumberConverter.isNumeric(numbers.get(i))) throw new UnsupportedMathOperationException("Invalid numeric value");

            parameters.add(NumberConverter.convertToDouble(numbers.get(i)));
        }

        return math.avg(parameters);
    }

}
