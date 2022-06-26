package comarch.NumberConverter.service;

import comarch.NumberConverter.repository.ConvertStrategy;
import org.springframework.stereotype.Service;

@Service
public class ConvertRoma implements ConvertStrategy {
    @Override
    public String convertNumber(Long number, String convertTo) {
        if (number<=0 || number>3999 ){
            return "Podano liczbe ze zlego przedzialu";
        }else {
            StringBuilder response = new StringBuilder();
            String[] roma = {"M", "CM", "D", "CD", "C","XC", "L", "XL", "X", "IX", "V", "IV", "I"};
            Integer[] arabic = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
            for (int i = 0; i<arabic.length; i++){
                while (number >= arabic[i]){
                    response.append(roma[i]);
                    number-=arabic[i];
                }
            }
            return response.toString();
        }
        }

}
