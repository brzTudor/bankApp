/*
    Read from a .csv file of names, social security numbers, account type, initial deposit
    deposit() - withdraw() - transfer() - showInfo() methods
    11-digit account number generated as follows:
        - 1 or 2 depending on Savings or Checking
        - last 2 digits of SSN
        - unique 5-digit number
        - random 3 digit number
 */

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Account> accounts = new LinkedList<Account>();


        // read a CSV file and create new accounts based on that
        String file = "E:\\JavaWork\\NewBank\\NewBankAccounts.csv";
        List<String[]> newAccountHolders = CSV.read(file);
        for(String[] accountHolder : newAccountHolders){
            String name = accountHolder[0];
            String SSN = accountHolder[1];
            String accountType = accountHolder[2];
            double initDeposit = Double.parseDouble(accountHolder[3]);
            if(accountType.equals("Savings")){
                accounts.add(new Savings(name, SSN, initDeposit));
            }else if(accountType.equals("Checking")){
                accounts.add(new Checking(name, SSN, initDeposit));
            }else{
                System.out.println("ERROR READING ACCOUNT TYPE.");
            }

        }

        for(Account acc : accounts){
            System.out.println("\n*************************************\n");
            acc.showInfo();
            if(acc.name.equals("Frankie Davidson")){
                acc.deposit(80000);
                System.out.println("\nFrankie deposited 80000 RON");
                acc.printBalance();
            }
        }

        Account z = accounts.get((int)Math.random() * accounts.size());
        if(z.SSN.equals("233479044")){
            accounts.get(9).deposit(8732);
            System.out.println("\n Deposit has been made.");
        }

        // lottery
        accounts.get((int)(Math.random() * accounts.size())).deposit(100000);

    }

}
