public class LoanAccount extends Account {
    private double creditLimit;
    private double interestRate;

    public LoanAccount(String number, double balance, Client client, double creditLimit, double interestRate) {
        super(number, balance, client);
        this.creditLimit = creditLimit;
        this.interestRate = interestRate;
    }

    @Override
    public void recharge(double value) {
        setBalance(getBalance() - value);
    }

    @Override
    public void take(double value) {
        if (value <= getAvailableCredit()) {
            setBalance(getBalance() + value);
        } else {
            System.out.println("Перевищено кредитний ліміт");
        }
    }

    @Override
    public void transfer(Account account, double value) {
        if (value <= getAvailableCredit()) {
            setBalance(getBalance() + value);
            account.recharge(value);
        } else {
            System.out.println("Перевищено кредитний ліміт");
        }
    }

    public void borrow(double value) {
        take(value);
    }

    public void repay(double value) {
        recharge(value);
    }

    public double calculateDebt() {
        return getBalance() * (1 + interestRate / 100);
    }

    public double getAvailableCredit() {
        return creditLimit - getBalance();
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
}