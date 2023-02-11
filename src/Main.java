import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        String input;
        Scanner sc = new Scanner(System.in);
        Registration reg = new Registration();
        Authorization auth = new Authorization();
        while(true){
            System.out.println("Choose: reg or auth");
            do { input = sc.nextLine(); }
            while (!input.equals("reg") && !input.equals("auth"));
            if (input.equals("reg")) {
                System.out.print("Enter login: ");
                reg.setLogin(sc.nextLine());
                System.out.print("Enter IIN: ");
                reg.setIIN(sc.nextLine());
                System.out.print("Enter Password: ");
                reg.setPassword(sc.nextLine());
                if(reg.regUser()){
                    System.out.println("Congratz! You complete registration!");
                }else{
                    System.out.println("Remember: IIN:12 digits");
                    System.out.println("Password with uppercase, number and from 6 to 12 symbols");
                    System.out.println("Login from 6 to 20 symbols, with uppercase and number");
                }
                continue;
            } else if (input.equals("auth")) {
                System.out.print("Enter login or IIN: ");
                auth.setLoginOrIin(sc.nextLine());
                System.out.print("Enter password: ");
                auth.setPassword(sc.nextLine());
                if (reg.checkPassword(auth.getPassword())){
                    if (auth.Author()){
                        System.out.println("Authorization completed successfully!");
                    }else{
                        System.out.println("Try again!");
                    }
                }
            }CodeGen code = new CodeGen();
            SendMail mail = new SendMail("Your verification code for authorization: " + code.getCode());
            System.out.print("Enter verification code from your email: ");
            while (!code.checkCode(sc.nextLine())) {
                System.out.print("Wrong code! Try again: ");
            }
            System.out.println("Success!");
            break;
        }
    }
}
