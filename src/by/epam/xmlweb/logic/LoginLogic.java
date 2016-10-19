package by.epam.xmlweb.logic;

/**
 * Created by Диана и Глеб on 27.06.2016.
 */
public class LoginLogic {
    public static boolean checkUser(String login, String password) {
        return login.equals(password);
    }
}
