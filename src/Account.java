public abstract class Account {
    private String number;
    private double balance;
    private Client client;

    public Account(String number, double balance, Client client) {
        this.number = number;
        this.balance = balance;
        this.client = client;
    }

    public abstract void recharge(double value);
    public abstract void take(double value);
    public abstract void transfer(Account account, double value);

    public void printInfo() {
        System.out.println("Номер рахунку:" + getNumber());
        System.out.println("Баланс: " + getBalance());
        getClient().printInfo();
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
