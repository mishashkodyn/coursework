import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DepositAccount extends Account {
    private double interestRate;
    private LocalDate openingDate;
    private int depositDurationInMonths;

    public DepositAccount(String number, double balance, Client client, double interestRate, LocalDate openingDate, int depositDurationInMonths) {
        super(number, balance, client);
        this.interestRate = interestRate;
        this.openingDate = openingDate;
        this.depositDurationInMonths = depositDurationInMonths;
    }

    @Override
    public void recharge(double value) {
        setBalance(getBalance() + value);
        accrueInterest();
    }

    @Override
    public void take(double value) {
        if (value <= getBalance()) {
            setBalance(getBalance() - value);
            accrueInterest();
        } else {
            System.out.println("Недостаньо коштів на рахунку");
        }
    }

    @Override
    public void transfer(Account account, double value) {
        if (value <= getBalance()) {
            setBalance(getBalance() - value);
            account.recharge(value);
            accrueInterest();
        } else {
            System.out.println("Недостатньо коштів на рахунку");
        }
    }

    private void accrueInterest() {
        LocalDate currentDate = LocalDate.now(); // Get current date
        long periodInMonths = ChronoUnit.MONTHS.between(openingDate, currentDate); // Calculate months between dates

        // Check if the deposit term has expired
        if (periodInMonths >= depositDurationInMonths) {
            // Calculate interest for the entire deposit term
            double interest = getBalance() * interestRate * depositDurationInMonths / 1200;
            setBalance(getBalance() + interest);
            // Update the account opening date
            openingDate = LocalDate.now();
        } else {
            // Calculate interest for the current period
            double interest = getBalance() * interestRate * periodInMonths / 1200;
            setBalance(getBalance() + interest);
        }
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public LocalDate getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(LocalDate openingDate) {
        this.openingDate = openingDate;
    }

    public int getDepositDurationInMonths() {
        return depositDurationInMonths;
    }

    public void setDepositDurationInMonths(int depositDurationInMonths) {
        this.depositDurationInMonths = depositDurationInMonths;
    }
}
