// Main.java
public class Main {
    public static void main(String[] args) {
        // 1. Buat objek valid & tampilkan
        BankAccount acc = new BankAccount("1234567890", 500000);
        System.out.println("Objek dibuat: Acc " + acc.getAccountNumber() + " | Saldo: Rp" + acc.getBalance());

        // 2. Satu perubahan sah
        acc.deposit(200000);
        System.out.println("Setelah deposit sah Rp200.000 | Saldo: Rp" + acc.getBalance());

        // 3. Operasi tidak sah 1: Membuat akun dengan format nomor rekening salah
        try {
            System.out.println("\n[Uji Coba 1 Invalid] Membuat akun dengan nomor rekening '123'...");
            BankAccount invalidAcc = new BankAccount("123", 100000);
        } catch (IllegalArgumentException e) {
            System.out.println("Ditolak: " + e.getMessage());
        }

        // 4. Operasi tidak sah 2: Penarikan melebihi saldo (melanggar invarian balance >= 0)
        try {
            System.out.println("\n[Uji Coba 2 Invalid] Menarik Rp1.000.000 dari saldo Rp700.000...");
            acc.withdraw(1000000);
        } catch (IllegalArgumentException e) {
            System.out.println("Ditolak: " + e.getMessage());
        }
    }
}