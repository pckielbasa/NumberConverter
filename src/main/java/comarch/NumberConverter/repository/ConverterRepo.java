package comarch.NumberConverter.repository;

import comarch.NumberConverter.model.Converter;

public interface ConverterRepo {
    String convertNumber(Long number, String convertTo);
}
