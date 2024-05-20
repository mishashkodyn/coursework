import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String name;
    private List<Account> accounts;

    public Bank(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public void calculateTotalAssets() {
        double totalAssets = 0.0;
        for (Account account : accounts) {
            totalAssets += account.getBalance();
        }
        System.out.println("Загальна сума активів банку: " + totalAssets);
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void printInfo() {
        System.out.println("Назва банку: " + getName());
        System.out.println("Рахунки: ");
        for (Account account : accounts) {
            account.printInfo();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
