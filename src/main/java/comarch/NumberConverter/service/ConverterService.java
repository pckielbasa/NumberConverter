package comarch.NumberConverter.service;

import comarch.NumberConverter.repository.ConverterRepo;
import org.springframework.stereotype.Service;

@Service
public class ConverterService implements ConverterRepo {

    @Override
    public String convertNumber(Long number, String convertTo) {
        StringBuilder response = new StringBuilder();
           if(number<1){
               return "Zła liczba! Podaj liczbe większą od zera.";
           }else if (convertTo.equals("Roma") &&  number <= 3999){
               String[] roma = {"M", "CM", "D", "CD", "C","XC", "L", "XL", "X", "IX", "V", "IV", "I"};
               Integer[] arabic = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
               for (int i = 0; i<arabic.length; i++){
                   while (number >= arabic[i]){
                       response.append(roma[i]);
                       number-=arabic[i];
                   }
               }
           } else if (convertTo.equals("Hex") && number.toString().length() <= 18){
               String[] hex = {"0","1", "2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
               while (number>0){
                   response.append(hex[Math.toIntExact(number % 16)]);
                   number = number/16;
               }
               response.reverse();
           } else {
             return "Złe dane";
           }
        return response.toString();

    }
}
