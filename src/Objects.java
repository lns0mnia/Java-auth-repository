public abstract class Objects {
    private String IIN;
    private String Login;
    private String Password;
    public String getIIN(){return IIN;}
    public void setIIN(String IIN){this.IIN = IIN;}
    public String getLogin(){return Login;}
    public void setLogin(String Login){this.Login = Login;}
    public String getPassword(){return Password;}
    public void setPassword(String Password){this.Password = Password;}
    protected boolean checkUser(String input, String IIN, String login){return input.equals(IIN) && input.equals(Login);}
}