import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
public class Registration extends Objects {
    public boolean checkIIN(String IIN) {
        boolean isDigit = true;
        if(IIN.length() == 12){
            for(int i=0;i<12; i++){
                if(!Character.isDigit(IIN.charAt(i))){
                    isDigit = false;
                    break;
                }
            }
        }else{
            return false;
        }return isDigit;
    }
    public boolean checkPassword(String Password) {
        boolean checkUpper = false;
        boolean checkSymbol = false;
        if(Password.length() > 5){
            for(int i = 0;i<Password.length();i++){
                if(Character.isUpperCase(Password.charAt(i))){
                    checkUpper = true;
                }
                if(Character.isLetterOrDigit(Password.charAt(i))){
                    checkSymbol = true;
                }
            }
        }else{
            return false;
        }return checkSymbol && checkUpper;
    }
    @Override
    protected boolean checkUser(String IndividualNumber, String Login, String Password) {
        try {
            Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ferrari", "postgres", "Monza2020");
            Statement stmt = c.createStatement();
            ResultSet checkLogin = stmt.executeQuery("SELECT * FROM users WHERE iin = '" + IndividualNumber + "' AND pass = '" + Password + "';");
            if(checkLogin.next()){
                return false;
            }
            else{
                c.close();
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Connection to database failed.");
            throw new RuntimeException(e);
        }
    }
    public boolean regUser(){
        if(checkUser(getIIN(), getLogin(), getPassword()) && checkIIN(getIIN()) && checkPassword(getPassword())){
            try{
                Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ferrari", "postgres", "Monza2020");
                String sql = "INSERT INTO users(iin, login, pass)"
                        + "VALUES ('" + getIIN() + "', '" +getLogin() +
                        "', '" + getPassword() + "');";
                Statement stmt = c.createStatement();
                int rows = stmt.executeUpdate(sql);
                if(rows > 0){
                    return true;
                }
            }catch (SQLException e){
                System.out.println("Connection to database failed.");
                throw new RuntimeException(e);
            }
        } return false;
    }
}