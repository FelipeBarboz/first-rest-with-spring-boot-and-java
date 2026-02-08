package br.com.FelipeBarboz.controllers;

import br.com.FelipeBarboz.exception.UnsupportedMathOperationException;
import br.com.FelipeBarboz.services.MathService;
import br.com.FelipeBarboz.utils.NumberUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    @Autowired
    private MathService mathService;

    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(
            @PathVariable String numberOne,
            @PathVariable String numberTwo
    ) {
        validate(numberOne, numberTwo);

        return mathService.sum(
                NumberUtils.convertToDouble(numberOne),
                NumberUtils.convertToDouble(numberTwo)
        );
    }

    @RequestMapping("/sub/{numberOne}/{numberTwo}")
    public Double sub(
            @PathVariable String numberOne,
            @PathVariable String numberTwo
    ) {
        validate(numberOne, numberTwo);

        return mathService.sub(
                NumberUtils.convertToDouble(numberOne),
                NumberUtils.convertToDouble(numberTwo)
        );
    }

    @RequestMapping("/multi/{numberOne}/{numberTwo}")
    public Double multi(
            @PathVariable String numberOne,
            @PathVariable String numberTwo
    ) {
        validate(numberOne, numberTwo);

        return mathService.multi(
                NumberUtils.convertToDouble(numberOne),
                NumberUtils.convertToDouble(numberTwo)
        );
    }

    @RequestMapping("/division/{numberOne}/{numberTwo}")
    public Double division(
            @PathVariable String numberOne,
            @PathVariable String numberTwo
    ) {
        validate(numberOne, numberTwo);

        return mathService.division(
                NumberUtils.convertToDouble(numberOne),
                NumberUtils.convertToDouble(numberTwo)
        );
    }

    @RequestMapping("/avg/{numberOne}/{numberTwo}")
    public Double avg(
            @PathVariable String numberOne,
            @PathVariable String numberTwo
    ) {
        validate(numberOne, numberTwo);

        return mathService.avg(
                NumberUtils.convertToDouble(numberOne),
                NumberUtils.convertToDouble(numberTwo)
        );
    }

    @RequestMapping("/sqrt/{number}")
    public Double sqrt(@PathVariable String number) {

        if (!NumberUtils.isNumeric(number))
            throw new UnsupportedMathOperationException("Please set a numeric value!");

        return mathService.sqrt(
                NumberUtils.convertToDouble(number)
        );
    }

    private void validate(String... values) {
        for (String value : values) {
            if (!NumberUtils.isNumeric(value))
                throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
    }
}
