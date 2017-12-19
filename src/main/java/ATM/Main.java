package ATM;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws BalanceExepsion, PinExepsion {

        boolean okay = true;
        int count = 0;

        while (okay) {
            System.out.println("___Enter PIN___");
            Scanner scanner = new Scanner(System.in);
            String pin = scanner.next();
            try {
                pin(pin);
            } catch (PinExepsion p) {
                System.out.println(p.getMessage());
                count += 1;
            }
            if (count == 3) {
                okay = false;
                System.out.println("ATM is BLOCKED");
            }
        }

    }


    public static void menu() {
        System.out.println("___ ATM ___");
        System.out.println("1. Withdrow Money");
        System.out.println("2. Deposit Money");
        System.out.println("3. Balance");
        System.out.println("4. Exit");
        System.out.print("Your choice: ");
    }

    public static void withdrowMenu(ATM atm) throws BalanceExepsion {
        Scanner scanner = new Scanner(System.in);
        System.out.println("__Withdrow Money__");
        atm.withdrow(0);
        System.out.println("Enter withdrow amount: ");
        try {
            double amount = scanner.nextDouble();
            atm.withdrow(amount);
        } catch (InputMismatchException ex) {
            System.out.println("Input not corect");
        }
    }

    private static void depositMenu(ATM atm) throws BalanceExepsion {
        Scanner scanner = new Scanner(System.in);
        System.out.println("__Deposit Money__");
        System.out.println("Enter withdrow amount: ");
        try {
            double amount = scanner.nextDouble();
            atm.deposit(amount);
        }catch (InputMismatchException ex){
            System.out.println("Input not corect");


        }

    }

    public static void pin(String pin) throws PinExepsion, BalanceExepsion {
        final String myPin = "1234";
        if (pin.equalsIgnoreCase(myPin)) {
            atm();
        } else {
            throw new PinExepsion("Wrong PIN");
        }

    }

    private static void atm() throws BalanceExepsion {
        ATM atm = new ATM();
        Scanner scanner = new Scanner(System.in);
        boolean choice = true;


        while (choice) {
            menu();
            String input = scanner.next();
            switch (input) {
                case "1":
                    try {
                        withdrowMenu(atm);
                    } catch (BalanceExepsion b) {
                        System.out.println(b.getMessage());
                    }

                    break;
                case "2":
                    try {
                        depositMenu(atm);
                    }catch (BalanceExepsion b) {
                        System.out.println(b.getMessage());
                    }
                    break;
                case "3":
                    System.out.println(atm.balance());
                    break;
                case "4":
                    choice = false;
                    break;
                case "5":
                    atm.seeAllTransactions();
                    break;

            }
        }
    }
}
