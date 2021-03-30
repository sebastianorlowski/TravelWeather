package pl.orlowski.sebastian.weather.validation.user;

import org.springframework.stereotype.Component;

@Component
public class UserInfoChecker {

    protected boolean isValidPassword(String password) {
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,32}$";

            return password.matches(regex);
    }

    protected boolean isValidEmail(String email) {
        String regex = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$";

        return email.matches(regex);
    }

    protected boolean isValidUsername(String username) {
        String regex = "^[A-Za-z0-9]{5,15}$";

        return username.matches(regex);
    }
}
