package ServiceInterfaces;

import Model.BankAccount;

import java.util.List;

public interface BankAccountServiceInterfaces {
    public List<BankAccount> getAllBankAccount();

    public BankAccount findBankAccountByAccountNumber(String bankAccountNumber);

    public boolean addBankAccount(BankAccount bankAccount);

    public boolean updatePasswordBankAccountByAccountNumber(String bankAccountNumber, String password);

    public boolean deleteBankAccountByAccountNumber(String bankAccountNumber);
}
