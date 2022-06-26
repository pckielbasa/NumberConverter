package comarch.NumberConverter.controller;

import comarch.NumberConverter.repository.ConvertStrategy;
import comarch.NumberConverter.service.ConvertHex;
import comarch.NumberConverter.service.ConvertRoma;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequiredArgsConstructor
public class ConverterController {

    private ConvertStrategy convertStrategy;

    @Autowired
    public ConverterController(@Qualifier("convertHex") ConvertStrategy convertStrategy) {
        this.convertStrategy = convertStrategy;
    }

    @RequestMapping("/")
    public ModelAndView home()
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }


    @GetMapping("/convert")
    public String convertNumber(@RequestParam (value = "number") Long number,
                                   @RequestParam (value = "convertTo") String convertTo) {
        if (convertTo.equals("Roma")){
            ConvertStrategy convertStrategy = new ConvertRoma();
            convertStrategy.convertNumber(number, convertTo);
            return convertStrategy.convertNumber(number,convertTo);
        }
        convertStrategy.convertNumber(number, convertTo);
        return convertStrategy.convertNumber(number,convertTo);
    }
}
