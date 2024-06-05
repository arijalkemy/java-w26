package org.example.edaddeunapersona.service;

import org.example.edaddeunapersona.models.UserData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService service;

    @Test
    void obtainUserAge()
    {
        // arrange
        String day = "06", month = "04", year = "2001";
        UserData data = new UserData(year, month, day);
        int expectedAge = data.calculateAge();

        //act
        int resultAge = service.obtainUserAge(day, month, year);

        // assertion
        assertThat(expectedAge).isEqualTo(resultAge);
    }
}
