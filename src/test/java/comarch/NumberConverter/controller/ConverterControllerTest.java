package comarch.NumberConverter.controller;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import comarch.NumberConverter.enums.ConvertType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class ConverterControllerTest {


    @Autowired
    private MockMvc mockMvc;

    private final Long number = 345L;

    @Test
    public void shouldReturnHexNumber() throws Exception{
        this.mockMvc.perform(post("/convert?number="+number+"&convertTo="+ ConvertType.Hex))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().string(containsString("159")));
    }

    @Test
    public void shouldReturnRomaNumber() throws Exception{
        this.mockMvc.perform(post("/convert?number="+number+"&convertTo="+ ConvertType.Roma))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().string(containsString("CCCXLV")));
    }
    
}