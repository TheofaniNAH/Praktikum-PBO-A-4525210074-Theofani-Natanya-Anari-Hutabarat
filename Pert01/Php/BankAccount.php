<?php
// BankAccount.php
class BankAccount {
    private string $accountNumber;
    private float $balance;

    public function __construct(string $accountNumber, float $initialDeposit) {
        // Validasi Invarian 2
        if (!preg_match('/^\d{10}$/', $accountNumber)) {
            throw new InvalidArgumentException("Nomor rekening harus terdiri dari 10 digit angka.");
        }
        // Validasi Invarian 1
        if ($initialDeposit < 0) {
            throw new InvalidArgumentException("Setoran awal tidak boleh negatif.");
        }
        $this->accountNumber = $accountNumber;
        $this->balance = $initialDeposit;
    }

    public function deposit(float $amount): void {
        if ($amount <= 0) {
            throw new InvalidArgumentException("Jumlah deposit harus lebih dari 0.");
        }
        $this->balance += $amount;
    }

    public function withdraw(float $amount): void {
        if ($amount <= 0) {
            throw new InvalidArgumentException("Jumlah penarikan harus lebih dari 0.");
        }
        // Menjaga Invarian 1
        if ($this->balance - $amount < 0) {
            throw new InvalidArgumentException("Penarikan ditolak: Saldo tidak mencukupi (Saldo tidak boleh negatif).");
        }
        $this->balance -= $amount;
    }

    public function getBalance(): float { return $this->balance; }
    public function getAccountNumber(): string { return $this->accountNumber; }
}
?>