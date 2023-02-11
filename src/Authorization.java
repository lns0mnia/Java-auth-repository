import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
public class Authorization extends Objects {
    private String loginOrIin;
    public void setLoginOrIin(String loginOrIin){this.loginOrIin = loginOrIin;}
    public String getLoginOrIin(){return loginOrIin;}
    public boolean checkLoginOrIin(){
        if(loginOrIin.length() == 12){
            for(int i=0;i<12;i++){
                if(!Character.isDigit(loginOrIin.charAt(i))){
                    return true;
                }
            }
        }else{
            return true;
        }return false;
    }
    @Override
    protected boolean checkUser(String IndividualNumber, String Login, String Password) {
        try {
            Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ferrari", "postgres", "Monza2020");
            Statement stmt = c.createStatement();
            if (checkLoginOrIin()){
                ResultSet checkExistence = stmt.executeQuery("SELECT * FROM users WHERE login = '" + Login + "' AND pass = '" + Password + "';");
                if (checkExistence.next()){
                    return true;
                }else{
                    c.close();
                    return false;
                }
            }else{
                ResultSet checkExistence = stmt.executeQuery("SELECT * FROM users WHERE iin = '" + IndividualNumber + "' AND pass = '" + Password + "';");
                if (checkExistence.next()){
                    return true;
                }else{
                    c.close();
                    return false;
                }
            }
        } catch (SQLException e) {
            System.out.println("Connection with database failed.");
            throw new RuntimeException(e);
        }
    }
    public boolean Author(){
        return checkUser(loginOrIin, loginOrIin, getPassword());
    }
}