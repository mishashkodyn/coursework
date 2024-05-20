public class CurrentAccount extends Account {
    public CurrentAccount(String number, double balance, Client client) {
        super(number, balance, client);
    }

    @Override
    public void recharge(double value) {
        setBalance(getBalance() + value);
    }

    @Override
    public void take(double value) {
        if (value <= getBalance()) {
            setBalance(getBalance() - value);
        } else {
            System.out.println("Недостатньо коштів на рахунку");
        }
    }

    @Override
    public void transfer(Account account, double value) {
        if (value <= getBalance()) {
            setBalance(getBalance() - value);
            account.recharge(value);
        } else {
            System.out.println("Недостаньо коштів на рахунку");
        }
    }
}
