package entities;

import java.io.BufferedReader;
import java.io.FileReader;

public class PasswordChecker {

    public static boolean isPasswordCorrect(String email, String password) {
        try {
            BufferedReader bufferedReader = new BufferedReader(
                    new FileReader("/Users/imac/IdeaProjects/tour_shop/src/main/resources/db.txt"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(" ");
                String _email = data[0];
                String _password = data[1];
                if (_email.equals(email)) {
                    if(_password.equals(password)) {
                        return true;
                    } else return false;
                }
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
