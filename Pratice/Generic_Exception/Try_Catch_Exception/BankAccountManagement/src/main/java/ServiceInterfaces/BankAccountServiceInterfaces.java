package ServiceInterfaces;

import Model.BankAccount;

import java.util.List;

public interface BankAccountServiceInterfaces {
    public List<BankAccount> getAllBankAccount() throws Exception;

    public BankAccount findBankAccountByAccountNumber(String bankAccountNumber) throws Exception;

    public boolean addBankAccount(String bankAccountNumber, String bankAccountHolderName, String bankAccountType, String password, String address) throws Exception;

    public boolean updatePasswordBankAccountByAccountNumber(String bankAccountNumber, String password) throws Exception;

    public boolean deleteBankAccountByAccountNumber(String bankAccountNumber) throws Exception;
}
