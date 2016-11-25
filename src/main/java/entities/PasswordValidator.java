package entities;

/**
 * Created by imac on 20.11.16.
 */
public class PasswordValidator {

    public static boolean validatePassword(String password) {
        if (password.length() >= 3)
            return true;
        return false;
    }
}
