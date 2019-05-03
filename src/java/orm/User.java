package orm;

public class User {

    public static final String TYPE_CUSTOMER = "customer";
    public static final String TYPE_MANAGER = "manager";
    public static final String TYPE_DELIVERY = "delivery";
    private int UserId;
    private String Firstname;
    private String LastName;
    private String Fullname;
    private String PhoneNumber;
    private String Email;
    private String Password;
    private String address;
    private String tybe;
    private String gender;
    

    public User(int UserId, String Firstname, String LastName, String PhoneNumber, String Email, String Password, String address, String tybe,String gender) {
        this.UserId = UserId;
        this.Firstname = Firstname;
        this.LastName = LastName;
       
        this.PhoneNumber = PhoneNumber;
        this.Email = Email;
        this.Password = Password;
        this.address = address;
        this.tybe = tybe;
        this.gender=gender;
    }

    public User() {
        }

   

  

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String Firstname) {
        this.Firstname = Firstname;
    }

    public String getSecondname() {
        return LastName;
    }

    public void setSecondname(String Secondname) {
        this.LastName = Secondname;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getTybe() {
        return tybe;
    }

    public void setTybe(String tybe) {
        this.tybe = tybe;
    }

}
