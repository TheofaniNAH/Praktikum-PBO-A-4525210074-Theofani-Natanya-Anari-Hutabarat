// BankAccount.java
public class BankAccount {
    private final String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double initialDeposit) {
        // Validasi Invarian 2: Nomor rekening harus 10 digit angka
        if (accountNumber == null || !accountNumber.matches("\\d{10}")) {
            throw new IllegalArgumentException("Nomor rekening harus terdiri dari 10 digit angka.");
        }
        // Validasi Invarian 1: Saldo tidak boleh negatif
        if (initialDeposit < 0) {
            throw new IllegalArgumentException("Setoran awal tidak boleh negatif.");
        }
        this.accountNumber = accountNumber;
        this.balance = initialDeposit;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Jumlah deposit harus lebih dari 0.");
        }
        this.balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Jumlah penarikan harus lebih dari 0.");
        }
        // Menjaga Invarian 1
        if (this.balance - amount < 0) {
            throw new IllegalArgumentException("Penarikan ditolak: Saldo tidak mencukupi (Saldo tidak boleh negatif).");
        }
        this.balance -= amount;
    }

    public double getBalance() { return balance; }
    public String getAccountNumber() { return accountNumber; }
}