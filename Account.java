import java.util.ArrayList;
import java.util.Random;

public class Account {
    static ArrayList<Double> history = new ArrayList<>() ;
    private int id;
    private String fullName;
    private String pin;
    private String username;
    private double balance;
    private  String email;
    private String number;
    private  String gender;


    public Account() {

    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setHistory(ArrayList<Double> history) {
        this.history=history;
    }


    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setId(int id) {
        this.id=id;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ArrayList<Double> getHistory() {
        return history;
    }

    public double getBalance() {
        return balance;
    }

    public int getId() {
        return id;
    }

    public String getPin() {
        return pin;
    }

    public String getFullName() {
        return fullName;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getNumber() {
        return number;
    }

    public String getGender() {
        return gender;
    }

}
