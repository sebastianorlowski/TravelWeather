package pl.orlowski.sebastian.weather.validation.user;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class UserInfoChecker {

    protected boolean isValidPassword(String password) {
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,30}$";

        return password.matches(regex);
    }

    protected boolean isValidEmail(String email) {
        String regex = "^[-!#$%&'*+/0-9=?A-Z^_a-z{|}~](\\.?[-!#$%&'*+/0-9=?A-Z^_a-z{|}~])*\n" +
                "@[a-zA-Z](-?[a-zA-Z0-9])*(\\.[a-zA-Z](-?[a-zA-Z0-9])*)+$";

        return email.matches(regex);
    }

    protected boolean isValidUsername(String username) {
        String regex = "^[A-Za-z0-9]{5,15}$";

        return username.matches(regex);
    }
}
