package org.example.edaddeunapersona.service;

import jakarta.validation.Valid;
import org.example.edaddeunapersona.exception.BadRequestException;
import org.example.edaddeunapersona.models.UserData;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    @Override
    public int obtainUserAge(@Valid String day, @Valid String month, @Valid String year) {

        if( isValidDay(day) && isValidMonth(month) && isValidYear(year))
        {
            UserData user = new UserData(year, month, day);
            return user.calculateAge();
        }

        throw new BadRequestException("Input data dates is not valid");
    }

    public static boolean isValidDay(String day) {
        return day.matches("^(0[1-9]|[12][0-9]|3[01])$");
    }

    public static boolean isValidMonth(String month) {
        return month.matches("^(0[1-9]|1[0-2])$");
    }

    public static boolean isValidYear(String year) {
        return year.matches("^[12]\\d{3}$"); // Adjust range as needed
    }

}
