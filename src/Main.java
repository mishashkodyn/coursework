import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Створення клієнтів
        Client client1 = new Client("Іван", "Іванов", "1234567890");
        Client client2 = new Client("Петро", "Петров", "0987654321");

        // Створення рахунків
        CurrentAccount currentAccount = new CurrentAccount("123-456-789", 5000.0, client1);
        DepositAccount depositAccount = new DepositAccount("987-654-321", 10000.0, client2, 5.0, LocalDate.now().minusMonths(12), 12);
        LoanAccount loanAccount = new LoanAccount("456-789-123", 0.0, client1, 10000.0, 7.5);

        // Створення банку
        Bank bank = new Bank("Мій Банк");
        bank.addAccount(currentAccount);
        bank.addAccount(depositAccount);
        bank.addAccount(loanAccount);

        // Вивід інформації про банк та рахунки
        bank.printInfo();

        // Показуємо функціональність кредитного рахунку
        loanAccount.borrow(3000);
        loanAccount.repay(500);
        loanAccount.printInfo();

        // Показуємо обчислення заборгованості
        System.out.println("Заборгованість з відсотками: " + loanAccount.calculateDebt());
    }
}