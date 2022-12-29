import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Authorization auth = new Authorization();

        //  Basic authorization
        System.out.print("Enter login: ");
        while(!auth.checkLogin(sc.nextLine())) {
            System.out.print("Wrong login! Try again: ");
        }
        System.out.print("Success! Enter password: ");
        while(!auth.checkPassword(sc.nextLine())) {
            System.out.print("Wrong password! Try again: ");
        }
        System.out.println("Success!");

        //  Email code check
        //  ...
    }
}