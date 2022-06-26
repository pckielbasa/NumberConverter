package comarch.NumberConverter.controller;

import comarch.NumberConverter.repository.ConverterRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequiredArgsConstructor
public class ConverterController {

    private ConverterRepo converterRepo;

    @Autowired
    public ConverterController(ConverterRepo converterRepo) {
        this.converterRepo = converterRepo;
    }

    @RequestMapping("/home")
    public ModelAndView home()
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping("/hello")
    public String helloWorld(){
        return "Hello world";
    }

    @GetMapping("/convert")
    public String convertNumber(@RequestParam (value = "number") Long number,
                                   @RequestParam (value = "convertTo") String convertTo) {
        return converterRepo.convertNumber(number,convertTo);
    }
}
