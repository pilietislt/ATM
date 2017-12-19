package ATM;

import java.util.ArrayList;
import java.util.List;

public class ATM {

    double balance;
    List<Double> allTransactions;

    ATM() {
        this.balance = 1000;
        allTransactions = new ArrayList<>();

    }


    void withdrow(double amount) throws BalanceExepsion {

        if (this.balance <= 0) {
            throw new BalanceExepsion("ATM is Empty");
        } else if (this.balance < amount) {
            throw new BalanceExepsion("Your withdrow amount is to large");
        }else if(amount < 0){
            throw new BalanceExepsion("Amount can not be negative");

        } else {
            this.balance -= amount;
            commissions(amount);
            //transactions(-amount);
        }
    }


    void deposit(double amount) throws BalanceExepsion {
        if (amount < 0){
            throw new BalanceExepsion("Amount can not be negative");
        }else{
            this.balance += amount;
            commissions(amount);
            // transactions(+amount);
        }

    }

    String balance() {
        return "ATM balance is: " + this.balance;
    }

//    void transactions(double amount) {
//        allTransactions.add(amount);
//    }

    void seeAllTransactions() {
        for (double a : allTransactions) {
            System.out.println(a);
        }
    }


   void commissions(double amount) {
        this.balance -= amount * 0.02d;
    }

}
