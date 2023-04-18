public class Savings extends Account {
    // list properties specific to a savings account
    private int safetyDepositBoxID;
    private int safetyDepositBoxKey;

    // constructor to initialize settings for savings accounts
    public Savings(String name, String SSN, double initDeposit){
        super(name, SSN, initDeposit);
        accountNumber = "1" + accountNumber;
        setSafetyDepositBox();
    }

    @Override
    public void setRate() {
        rate = getBaseRate() - .25;
    }

    private void setSafetyDepositBox(){
        safetyDepositBoxID = (int)(Math.random() * Math.pow(10,3));
        safetyDepositBoxKey = (int)(Math.random() * Math.pow(10,4));

    }

    // list any methods specific to a savings account
    @Override
    public void showInfo(){
        super.showInfo();
        System.out.println("Your savings account features: " +
                "\n - Safety Deposit Box ID: " + safetyDepositBoxID +
                "\n - Safety Deposit Box Key: " + safetyDepositBoxKey);
    }
}
