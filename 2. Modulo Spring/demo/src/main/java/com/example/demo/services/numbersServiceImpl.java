package com.example.demo.services;

import org.springframework.stereotype.Service;

@Service
public class numbersServiceImpl implements INumbersService {
    
    @Override
    public String convertToRoman(int decimalNumber){
        return "Decimal number is : " + decimalNumber + ", and converted into roman numbers is: " ;
    }
}
