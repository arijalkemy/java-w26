package com.example.introspringnumerosromanos;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConvertidorNumeros {

        @GetMapping("/{number}")
        public String getNumber(@PathVariable int number){

            if (number<= 0 || number > 3999) {
                return "El número debe estar entre 1 y 3999";
            }

            int[] valoresDecimales = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
            String[] simbolosRomanos = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

            StringBuilder resultado = new StringBuilder();
            int indice = 0;

            while (number > 0) {
                if (number - valoresDecimales[indice] >= 0) {
                    resultado.append(simbolosRomanos[indice]);
                    number -= valoresDecimales[indice];
                } else {
                    indice++;
                }
            }


            return resultado.toString();
        }
}

