import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try {
            Class.forName("org.postgresql.Driver");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


        String input;
        Scanner sc = new Scanner(System.in);
        Registration reg = new Registration();
        Authorization auth = new Authorization();

        while(true) {

            //  Choose auth or reg
            System.out.println("Choose: reg or auth");
            do { input = sc.nextLine(); }
            while (!input.equals("reg") && !input.equals("auth"));

            //  Registration
            if (input.equals("reg")) {

                System.out.print("Enter login: ");
                reg.setLogin(sc.nextLine());
                while (true) {
                    System.out.print("Enter password: ");
                    input = sc.nextLine();
                    if (auth.checkPasswordPattern(input)) {
                        reg.setPassword(input);
                        break;
                    }
                }
                System.out.print("Enter IIN: ");
                reg.setIIN(sc.nextLine());
                System.out.println("Registration completed successfully!");
                continue;

            //  Authorization
            } else if (input.equals("auth")) {

                System.out.print("Enter login or IIN: ");
                input = sc.nextLine();
                while (!auth.checkLogin(input, reg.getLogin(), reg.getIIN())) {
                    System.out.print("Wrong login (or IIN)! Try again: ");
                    input = sc.nextLine();
                }

                System.out.print("Success!\nEnter password: ");
                input = sc.nextLine();
                while (!(auth.checkPasswordPattern(input) && reg.checkPassword(input))) {
                    System.out.print(auth.checkPasswordPattern(input));
                    System.out.print(reg.checkPassword(input));
                    System.out.print("Wrong password! Try again: ");
                    input = sc.nextLine();
                }
                System.out.println("Authorization completed successfully!");

            }

            //  Email code sending
            CodeGen code = new CodeGen();
            SendMail mail = new SendMail("Your verification code for authorization: " + code.getCode());

            //  Code checking
            System.out.print("Enter verification code from your email: ");
            while (!code.checkCode(sc.nextLine())) {
                System.out.print("Wrong code! Try again: ");
            }
            //

            System.out.println("Success!");
            break;
        }
    }
}