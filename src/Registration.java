public class Registration {
    private String login;
    private String IIN;
    private String password;

    public String getLogin() {
        return login;
    }

    public String getIIN() {
        return IIN;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setIIN(String IIN) {
        this.IIN = IIN;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean checkPassword(String input) {
        return input.equals(password);
    }
}
