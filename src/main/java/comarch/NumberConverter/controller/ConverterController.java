package comarch.NumberConverter.controller;

import comarch.NumberConverter.enums.ConvertType;
import comarch.NumberConverter.interfaces.ConvertStrategy;
import comarch.NumberConverter.service.ConvertHex;
import comarch.NumberConverter.service.ConvertRoma;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ConverterController {

    @Autowired
    public ConverterController(@Qualifier("convertHex") ConvertStrategy convertStrategy) {
    }

    @RequestMapping("/")
    public ModelAndView home()
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping("/convert")
    public ResponseEntity<String> convertNumber(@RequestParam (value = "number") Optional<Long> number,
                                                @RequestParam (value = "convertTo") String convertTo) {
        if (!number.isPresent() ){
            return ResponseEntity.badRequest().body("Podaj liczbe!");
        }

        if (convertTo.equals(ConvertType.Roma.toString())){
            ConvertStrategy convertStrategy = new ConvertRoma();
            return ResponseEntity.ok().body(convertStrategy.convertNumber(number.get(),convertTo));
        }

        if (convertTo.equals(ConvertType.Hex.toString())){
            ConvertStrategy convertStrategy = new ConvertHex();
            return ResponseEntity.ok().body(convertStrategy.convertNumber(number.get(),convertTo));
        }

        return ResponseEntity.badRequest().body("Podaj poprawne dane");

    }

}
