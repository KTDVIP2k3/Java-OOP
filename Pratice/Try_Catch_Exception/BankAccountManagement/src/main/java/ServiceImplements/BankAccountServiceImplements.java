package ServiceImplements;

import Model.BankAccount;
import ServiceInterfaces.BankAccountServiceInterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BankAccountServiceImplements implements BankAccountServiceInterfaces {
    private static final List<BankAccount> bankAccountList = new ArrayList<>();
    //This static final variable show for that all object of this BankAccountServiceImplements class will share 1 bankAccountList
    //This variable use keyword to notify that it just created 1 times.
    private final Pattern p = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&.])[A-Za-z\\d@$!%*?&.]{8,}$");

    public BankAccountServiceImplements(){
    }

    @Override
    public List<BankAccount> getAllBankAccount() throws Exception {
        if(bankAccountList.isEmpty()){
            throw new IllegalArgumentException("Bank Account List is empty!!!");
        }
        if(bankAccountList == null){
            throw new NullPointerException("Bank Account List should not be null");
        }
        return bankAccountList;
    }

    @Override
    public BankAccount findBankAccountByAccountNumber(String bankAccountNumber) throws Exception {
        for(BankAccount bankAccount : bankAccountList){
            if(bankAccount.getAccountNumber().equalsIgnoreCase(bankAccountNumber)){
                return bankAccount;
            }
        }
        throw new IllegalArgumentException("Bank account number does not exist");
    }

    @Override
    public boolean addBankAccount(String bankAccountNumber, String bankAccountHolderName, String bankAccountType, String password, String address) throws Exception {
        for(BankAccount bankAccount1 : bankAccountList){
            if(bankAccount1.getAccountNumber().equalsIgnoreCase(bankAccountNumber)){
                throw new IllegalArgumentException("Bank account number exist" + "\nPlease input another bank account number");
            }
        }

        if(bankAccountNumber.isBlank()){
            throw new IllegalArgumentException("Bank account number should not be blank\n" + "Please input another bank account number");
        }

        if(bankAccountNumber == null){
            throw new IllegalArgumentException("Bank account number should not be null\n" + "Please input bank account number again");
        }


        if(bankAccountHolderName.isBlank()){
            throw new IllegalArgumentException("Bank account holder name should not be blank\n" + "Please input bank account holder name again!!!");
        }

        if(bankAccountHolderName == null){
            throw new IllegalArgumentException("Bank account holder name should not be null\n" + "Please input bank account holder name again!!!");
        }

        if(bankAccountType == null){
            throw new IllegalArgumentException("Bank account type should not be null\n" + "Please input bank account type again");
        }
        if(bankAccountType.isBlank()){
            throw new IllegalArgumentException("Bank account type should not be blank\n" + "please input bank account type again");
        }
        Matcher m = p.matcher(password);
        if(!m.matches()){
            throw  new IllegalArgumentException("For security, your password must meet the following criteria:\n"
            +"At least one uppercase letter (A-Z).\n" + "At least one lowercase letter (a-z).\n"
            + "At least one number (0-9).\n" + "At least one special character (e.g., !@#$%).\n"
            +"Please input password again");
        }

        if(password == null){
            throw new IllegalArgumentException("Password should not be null\n" + "Please input password again!!!");
        }
        if(password.isBlank()){
            throw new IllegalArgumentException("Password should not be bank\n" + "Please input password again!!!");
        }
        if(address == null){
            throw new IllegalArgumentException("Address should not be null\n" + "Please input address again!!!");
        }
        if(address.isBlank()){
            throw new IllegalArgumentException("Address should not be bank\n" + "Please input address again!!!");
        }
        BankAccount bankAccount = new BankAccount(bankAccountNumber, bankAccountHolderName, bankAccountType, 0, password, address, true);
        bankAccountList.add(bankAccount);
        return true;
    }

    @Override
    public boolean updatePasswordBankAccountByAccountNumber(String bankAccountNumber, String password) throws Exception {
        for(BankAccount bankAccount : bankAccountList){
            if(bankAccount.getAccountNumber().equalsIgnoreCase(bankAccountNumber)){
                Matcher m = p.matcher(password);
                if(!m.matches()){
                    throw  new IllegalArgumentException("For security, your password must meet the following criteria:\n"
                            +"At least one uppercase letter (A-Z).\n" + "At least one lowercase letter (a-z).\n"
                            + "At least one number (0-9).\n" + "At least one special character (e.g., !@#$%).\n"
                            +"Please input password again");
                }

                if(password == null){
                    throw new IllegalArgumentException("Password should not be null\n" + "Please input password again!!!");
                }
                if(password.isBlank()){
                    throw new IllegalArgumentException("Password should not be bank\n" + "Please input password again!!!");
                }
                bankAccount.setPassword(password);
            }
        }
        throw new IllegalArgumentException("Bank account number does not exist");
    }

    @Override
    public boolean deleteBankAccountByAccountNumber(String bankAccountNumber) throws Exception {
        for(BankAccount bankAccount : bankAccountList){
            if(bankAccount.getAccountNumber().equalsIgnoreCase(bankAccountNumber)){
                bankAccountList.remove(bankAccount);
                return true;
            }
        }
        throw new IllegalArgumentException("Bank account number does not exist");
    }

    private static void findBankAccountExistByAccountNumber(BankAccount bankAccount){
        for(BankAccount bankAccount1 : bankAccountList){
            if(bankAccount.getAccountNumber().equalsIgnoreCase(bankAccount1.getAccountNumber())){
                System.out.println("This account number exist!!");
                return;
            }
        }
    }
}
