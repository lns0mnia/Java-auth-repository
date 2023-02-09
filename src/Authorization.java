import java.util.regex.Pattern;
public class Authorization extends Registration {
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,12}$");

    public boolean checkLogin(String input, String login, String IIN) {
        return (input.equals(login) || input.equals(IIN));
    }



    public boolean checkPasswordPattern(String input) {
        if (!PASSWORD_PATTERN.matcher(input).matches()) {
            System.out.println("Password must contain at least one capital letter, lowercase letter and digit!");
            return false;
        }
        else return true;
    }

}