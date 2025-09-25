package Model;

public abstract class Person {
    private String identifiableIdNumber;
    private String name;
    private String address;
    private int age;
    private String birthday;
    private String gender;
    private String nationality;

    public Person() {
    }

    public Person(String identifiableIdNumber, String name, String address, int age, String birthday, String gender, String nationality) {
        this.identifiableIdNumber = identifiableIdNumber;
        this.name = name;
        this.address = address;
        this.age = age;
        this.birthday = birthday;
        this.gender = gender;
        this.nationality = nationality;
    }

    public String getIdentifiableIdNumber() {
        return identifiableIdNumber;
    }

    public void setIdentifiableIdNumber(String identifiableIdNumber) {
        this.identifiableIdNumber = identifiableIdNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public abstract String showInfor();


    public String personInfor(){
        return String.format(
                "| ID: %s | Name: %s | Age: %d | Gender: %s | Nationality: %s | Address: %s | Birthday: %s",
                this.identifiableIdNumber,
                this.name,
                this.age,
                this.gender,
                this.nationality,
                this.address,
                this.birthday
        );
    }
}
