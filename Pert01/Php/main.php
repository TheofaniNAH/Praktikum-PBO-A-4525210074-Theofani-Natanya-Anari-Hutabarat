<?php
// main.php
require_once 'BankAccount.php';

// 1. Buat objek valid & tampilkan
$acc = new BankAccount("1234567890", 500000);
echo "Objek dibuat: Acc " . $acc->getAccountNumber() . " | Saldo: Rp" . $acc->getBalance() . "\n";

// 2. Satu perubahan sah
$acc->deposit(200000);
echo "Setelah deposit sah Rp200.000 | Saldo: Rp" . $acc->getBalance() . "\n";

// 3. Operasi tidak sah 1
try {
    echo "\n[Uji Coba 1 Invalid] Membuat akun dengan nomor rekening '123'...\n";
    $invalidAcc = new BankAccount("123", 100000);
} catch (InvalidArgumentException $e) {
    echo "Ditolak: " . $e->getMessage() . "\n";
}

// 4. Operasi tidak sah 2
try {
    echo "\n[Uji Coba 2 Invalid] Menarik Rp1.000.000 dari saldo Rp700.000...\n";
    $acc->withdraw(1000000);
} catch (InvalidArgumentException $e) {
    echo "Ditolak: " . $e->getMessage() . "\n";
}
?>