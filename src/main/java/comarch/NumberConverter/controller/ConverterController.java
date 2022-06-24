package comarch.NumberConverter.controller;

import comarch.NumberConverter.model.Converter;
import comarch.NumberConverter.repository.ConverterRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/convert")
@RequiredArgsConstructor
public class ConverterController {

    @Autowired
    private ConverterRepo converterRepo;

    @GetMapping("/to")
    public String convertNumber(@RequestParam (value = "number") Long number,
                                   @RequestParam (value = "convertTo") String convertTo) {
        return converterRepo.convertNumber(number,convertTo);
    }
}
