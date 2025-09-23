package Model;

public class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private String accountType;
    private double balance;
    private String password;
    private String address;
    private boolean status;

    public BankAccount(){

    }

    public BankAccount(String accountNumber, String accountHolderName, String accountType, double balance, String password, String address, boolean status) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.accountType = accountType;
        this.balance = balance;
        this.password = password;
        this.address = address;
        this.status = status;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    //Two this function use check and uncheck exception, use throw and throws to another class execute..
    public boolean deposit (double amount) throws Exception{
        if(amount <= 0){
            throw new IllegalArgumentException("So tien phai nap phai lon hon 0 (>0)");
        }
        this.balance += amount;
        return true;
    }

    public boolean withdraw(double amount) throws Exception{
        if(amount <= 0){
            throw new IllegalArgumentException("So tien rut ra phai lon hon 0 (>0)");
        }
        if(amount > this.balance){
            throw new IllegalArgumentException("So du khong du de cho phep thuc hien giao dich nay!!!" +"\nSo tien rut: " + amount +"\nTien trong tai khoan: " + this.balance);
        }
        if(this.balance - amount <= 50){
            throw new IllegalArgumentException("Giao dich nay khong the thuc hien" + "\n\"Số dư phải còn lại ít nhất 50 sau khi rút tiền." +
                    "\nSo tien muon rut: " + amount + "\nSo tien trong tai khoan: " + this.balance);
        }
        this.balance -= amount;
        return true;
    }

    public String showAccountDetail(){
        String status = "Khong Hoat Dong";
        if(this.status) {
            status = "Hoat Dong";
        }
        return "Account Details:\n" +
                "--------------------\n" +
                "Account Number: " + accountNumber + "\n" +
                "Account Holder: " + accountHolderName + "\n" +
                "Account Type: " + accountType + "\n" +
                "Balance: " + balance + "\n"
                +"Account Password: " + this.password
                +"\nAccount address: " + this.address
                +"\nStatus: " + this.status;
    }



    public String showOverall(){
        return "Bank Account Number: " + this.accountNumber + " - " + "Bank Account Holder Name: " + this.accountHolderName;
    }
}
