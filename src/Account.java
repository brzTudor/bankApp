public abstract class Account implements IBaseRate {
    protected String name;
    protected String SSN;
    private double balance;

    static int index = 10000;
    protected String accountNumber;
    protected double rate;

    // constructor to set base properties
    public Account(String name, String SSN, double initDeposit) {
        index++;
        this.name = name;
        this.SSN = SSN;
        this.balance = initDeposit;
        this.accountNumber = setAccountNumber();
        setRate();
    }

    public abstract void setRate();

    // list common methods
    private String setAccountNumber(){
        String lastTwo = SSN.substring(SSN.length()-2, SSN.length());
        int uniqueID = index;
        int randomNum = (int)(Math.random() * Math.pow(10, 3));
        return lastTwo + uniqueID + randomNum;
    }

    public void compound(){
        double interest = balance * (rate/100);
        balance = balance + interest;
        System.out.println("Interest: " + interest + " RON");
        printBalance();
    }

    // transactions
    public void deposit(double amount){
        balance = balance + amount;
        System.out.println("Depositing " + amount + " RON");
        printBalance();
    }
    public void withdraw(double amount){
        balance = balance - amount;
        System.out.println("Withdrawing " + amount + " RON");
        printBalance();
    }
    public void transfer(String toWhere, double amount){
        balance = balance - amount;
        System.out.println("Transfering " + amount + " RON to " + toWhere);
        printBalance();
    }
    public void printBalance(){
        System.out.println(" - " + name + ": - Your balance is now: " + balance + " RON");
    }

    public void showInfo(){
        System.out.println(" NAME: " + name +
                "\n ACCOUNT NUMBER: " + accountNumber +
                "\n BALANCE: " + balance +
                "\n RATE: " + rate + "%"
        );
    }
}
