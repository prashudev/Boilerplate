package com.stackroute.calculator.controller;

import com.stackroute.calculator.service.CalculatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/calci")
public class CalculatorController {
    private CalculatorService calculatorService;

    @Autowired
    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService=calculatorService;
    }

    private static Logger logger = LoggerFactory.getLogger(CalculatorController.class);
    @GetMapping("/add/{varA}/{varB}")
    public ResponseEntity<?> addTwoNumbers(@PathVariable int varA, @PathVariable int varB) {
        try{
            return new ResponseEntity<>(calculatorService.addNumbers(varA, varB), HttpStatus.OK);
        } catch (Exception exc) {
            logger.error("Exception caused while adding 2 numbers:"+exc.getMessage());
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/subtract/{varA}/{varB}")
    public ResponseEntity<?> subtractTwoNumbers(@PathVariable int varA, @PathVariable int varB) {
        try{
            return new ResponseEntity<>(calculatorService.subtractNumbers(varA, varB), HttpStatus.OK);
        } catch (Exception exc) {
            logger.error("Exception caused while subtracting 2 numbers:"+exc.getMessage());
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }
    }
}
