package comarch.NumberConverter.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Converter {
    private Long number;
    private String convertTo;
}
