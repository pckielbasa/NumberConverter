package comarch.NumberConverter.repository;

public interface ConvertStrategy {
    String convertNumber(Long number, String convertTo);
}
