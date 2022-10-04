import exception.WrongLoginException;
import exception.WrongPasswordException;

public class Main {
    public static void main(String[] args) {
        String login = "kolgan";
        String pass = "123456";
        String confirmPass = "123456";
        System.out.println(acceptThreeParameters(login, pass, confirmPass));
    }

    public static boolean acceptThreeParameters(String login, String password, String confirmPassword) {
        boolean checkLogin;
        boolean checkPassword;
        boolean checkLengthPass;
        boolean checkLengthLogin;
        boolean checkPasswordMatching;
        try {
            checkLogin = checkValidationCharacter(login);
            checkPassword = checkValidationCharacter(password);
            checkLengthLogin = checkLengthLogin(login);
            checkLengthPass = checkLengthPassword(password);
            checkPasswordMatching = checkPasswordMatching(password, confirmPassword);
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return checkLogin && checkPassword && checkLengthPass && checkLengthLogin && checkPasswordMatching;
    }

    public static boolean checkValidationCharacter(String checkWord) {
        if (checkWord == null) {
            System.out.println("Пустое поле");
            return false;
        }
        if (checkWord.matches("\\w+")) {
            return true;
        }
        System.out.printf("Недопустимые символы в слове! - %s\n", checkWord);
        return false;
    }

    public static boolean checkLengthLogin(String login) throws WrongLoginException {
        if (login.length() > 20) {
            throw new WrongLoginException("Слишком длинный логин");
        }
        return true;
    }

    public static boolean checkLengthPassword(String pass) {
        if (pass.length() > 19) {
            System.out.println("Слишком длинный пароль");
            return false;
        }
        return true;
    }

    public static boolean checkPasswordMatching(String password, String confirmPassword) throws WrongPasswordException{
        if (password.equals(confirmPassword)) return true;
        throw new WrongPasswordException("Пароли не совпадают");
    }

}