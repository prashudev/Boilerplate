package com.stackroute.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService{
    @Override
    public int addNumbers(int varA, int varB) {
        return varA+varB;
    }

    @Override
    public int subtractNumbers(int varA, int varB) {
        return varA-varB;
    }
}
