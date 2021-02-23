package pl.orlowski.sebastian.weather.validation;

public class PasswordStrength {

    public boolean isValid(String password) {
        int size = password.length();
        if (size < 5) {
            return false;
        }

        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";

        return password.matches(regex);
    }
}
