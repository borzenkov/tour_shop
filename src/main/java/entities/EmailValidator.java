package entities;

/**
 * Created by imac on 20.11.16.
 */
public class EmailValidator {

    public static boolean isValid(String email) {
        return org.apache.commons.validator.routines.EmailValidator.
                getInstance(false).
                        isValid(email);
    }
}
