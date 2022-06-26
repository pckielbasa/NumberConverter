package comarch.NumberConverter.service;

import comarch.NumberConverter.interfaces.ConvertStrategy;
import org.springframework.stereotype.Service;

@Service
public class ConvertHex implements ConvertStrategy {
    @Override
    public String convertNumber(Long number, String convertTo) {
        if (number<0 || number >= Long.MAX_VALUE){
            return "Podano liczbe ze zlego przedzialu!";
        }else {
//            StringBuilder response = new StringBuilder();
//            String[] hex = {"0","1", "2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
//            while (number>0){
//                response.append(hex[Math.toIntExact(number % 16)]);
//                number = number/16;
//            }
//            response.reverse();
//            return response.toString();
            return Long.toHexString(number).toUpperCase();
            }
        }

}
