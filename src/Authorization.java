public class Authorization {
    private final static String login = "Admin";
    private final static String password = "1234";

    public boolean checkLogin(String input) {
        return input.equals(login);
    }
    public boolean checkPassword(String input) {
        return input.equals(password);
    }
}