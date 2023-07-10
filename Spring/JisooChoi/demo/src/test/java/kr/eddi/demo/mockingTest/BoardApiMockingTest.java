package kr.eddi.demo.mockingTest;

import kr.eddi.demo.lectureClass.jpa.board.service.JpaBoardService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;

@SpringBootTest
public class BoardApiMockingTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private JpaBoardService boardService;

    
}
