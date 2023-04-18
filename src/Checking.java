public class Checking extends Account {
    // list properties specific to a checking account
    private int debitCardNumber;
    private int debitCardPin;

    // constructor to initialize checking account prop.
    public Checking(String name, String SSN, double initDeposit){
        super(name, SSN, initDeposit);
        accountNumber = "2" + accountNumber;
    }

    @Override
    public void setRate(){
        rate = getBaseRate() * .15;
    }

    private void setDebitCard(){
        debitCardNumber = (int)(Math.random() * Math.pow(10,12));
        debitCardPin= (int)(Math.random() * Math.pow(10,4));
    }

    // list any methods specific to a checking account
    @Override
    public void showInfo(){
        super.showInfo();
        System.out.println("Your Checking Account Features: " +
                "\n - Debit Card Number: " + debitCardNumber +
                "\n - Debit Card Pin: " + debitCardPin);
    }
}
