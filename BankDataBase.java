import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.sql.*;

public class BankDataBase {
    private Connection connection;
    private Statement stmt;

    BankDataBase() {
        {
            try {
                this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdatabase", "root", "");
                stmt = connection.createStatement();
            } catch (SQLException e) {


            }
        }


    }

    public void addUser(String fn, String pin, String un, String email, String number, String gender) {
        try {


            // Inserting data in database
            Random rand = new Random();
            int upperbound = 100001;
            int id;
            int hiid;
            double balance = 0.0;
            int y;
            int x;
            do {
                hiid = rand.nextInt(upperbound);
                id = rand.nextInt(upperbound);
                String q1 = "insert into account values ('" + id + "', '" + fn + "', '" + pin + "', '" + un + "', '" + balance + "','" + email + "','" + number + "','" + gender + "')";
                String q2 = "insert into history values (" + hiid + "," + 0.0 + ", " + 0.0 + ", " + 0.0 + ", " + 0.0 + "," + 0.0 + "," + 0.0 + "," + 0.0 + "," + 0.0 + "," + 0.0 + "," + 0.0 + "," + id + ")";
                x = stmt.executeUpdate(q1);
                y = stmt.executeUpdate(q2);
            } while (x <= 0 && y <= 0);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(int id) {

        try {
            String q1;

            q1 = "DELETE from history WHERE id = " + id;
            stmt.executeUpdate(q1);
            q1 = "DELETE from Account WHERE id = " + id;
            stmt.executeUpdate(q1);


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public int deposit(double amount, String un) {
        amount = Math.abs(amount);

        try {
            String q1 = "UPDATE Account set balance =" + (getBalance(un) + amount) +
                    " WHERE username = '" + un + "'";
            int x = stmt.executeUpdate(q1);

            if (x > 0) {
                System.out.println("Transaction Updated");
                return 1;
            } else
                System.out.println("Deposit Unsuccessful");

        } catch (Exception e) {
            System.out.println(e);
        }

        return 0;
    }

    public int withdraw(double amount, String un) {
        amount = Math.abs(amount);

        try {
            String q1 = "UPDATE Account set balance =" + (getBalance(un) - amount) +
                    " WHERE username = '" + un + "' And balance >" + amount;
            int x = stmt.executeUpdate(q1);

            if (x > 0) {
                System.out.println("Withdraw Successfull");
                return 1;
            } else
                System.out.println("Not enough money...");

        } catch (Exception e) {

            System.out.println(e);
        }

        return 0;
    }

    public int transaction(double amount, String un, String un2, String pin) {
        amount = Math.abs(amount);
        int i = withdraw(amount, un);
        int j = 0;
        if (i == 1)
            j = deposit(amount, un2);


        if (i == j && i == 1) {
            setHistory(-amount, getid(un));
            setHistory(amount, getid(un2));
            return 1;
        } else if (i == 0)
            return -1;
        return 0;
    }


    public String getUsername(String username) {
        try {

            String q1 = "select * from Account WHERE username = '" + username + "'";
            ResultSet rs = stmt.executeQuery(q1);
            if (rs.next())

                return rs.getString(4);


        } catch (Exception e) {
            System.out.println("exc on getun");
        }

        return "  ";
    }


    public int getid(String un) {

        try {
            String q1 = "select * from Account where username = '" + un + "'";
            ResultSet rs = stmt.executeQuery(q1);
            if (rs.next())

                return rs.getInt(1);


        } catch (Exception e) {
            System.out.println("exc on getid");
        }

        return -1;
    }

    public double getBalance(String username) {
        try {
            String q1 = "select * from Account where username ='" + username + "'";
            ResultSet rs = stmt.executeQuery(q1);
            if (rs.next()) {
                return rs.getDouble(5);
            }


        } catch (Exception e) {
            System.out.println("exc on get balance");
        }

        return -1;
    }

    public String getPin(String username, String pin) {
        try {
            String q1 = "select * from Account WHERE username = '" + username +
                    "' AND pin = '" + pin + "'";
            ResultSet rs = stmt.executeQuery(q1);
            if (rs.next())

                return rs.getString(3);


        } catch (Exception e) {
            System.out.println("exc on getpin");
        }
        return "    ";
    }


    public String getFullName(String username, String pin) {
        try {
            String q1 = "select * from Account WHERE username = '" + username +
                    "' AND pin = '" + pin + "'";
            ResultSet rs = stmt.executeQuery(q1);
            if (rs.next())

                return rs.getString(2);


        } catch (Exception e) {
            System.out.println("exc on getfn");
        }
        return "    ";
    }

    public String getEmail(String username) {
        try {
            String q1 = "select * from Account WHERE username = '" + username + "'";
            ResultSet rs = stmt.executeQuery(q1);
            if (rs.next())

                return rs.getString(6);


        } catch (Exception e) {
            System.out.println("exc on getem");
        }
        return "    ";
    }

    public String verEmail(String email) {
        try {
            String q1 = "select * from Account WHERE email = '" + email + "'";
            ResultSet rs = stmt.executeQuery(q1);
            if (rs.next())

                return rs.getString(6);


        } catch (Exception e) {
            System.out.println("exc on getem");
        }
        return "    ";
    }

    public String getNumber(String username, String pin) {
        try {
            String q1 = "select * from Account WHERE username = '" + username +
                    "' AND pin = '" + pin + "'";
            ResultSet rs = stmt.executeQuery(q1);
            if (rs.next())

                return rs.getString(7);


        } catch (Exception e) {
            System.out.println("exc on getnum");
        }
        return "    ";
    }

    public String getGender(String username, String pin) {
        try {
            String q1 = "select * from Account WHERE username = '" + username +
                    "' AND pin = '" + pin + "'";
            ResultSet rs = stmt.executeQuery(q1);
            if (rs.next())

                return rs.getString(8);


        } catch (Exception e) {
            System.out.println("exc on get gender");
        }
        return "    ";
    }

    public ArrayList<Double> getHistory(int id) {
        try {
            ResultSet rs = null;
            ArrayList<Double> history = new ArrayList<>();
            String q1 = "select *   from history WHERE id = " + id + "";
            rs = stmt.executeQuery(q1);
            double x;
            if (rs.next()) {
                for (int i = 2; i < 12; i++) {
                    x = rs.getDouble(i);
                    history.add(x);

                }
            }
            return history;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("still exc ongethis");
        }
        return null;
    }


    public void setHistory(Double amount, int id) {

        try {

            String q1;
            for (int i = 1; i < 10; i++) {
                System.out.println(i);
                q1 = "update history set trans" + (i - 1) + " =trans" + i + " WHERE id =" + id;
                stmt.executeUpdate(q1);


            }
            q1 = "update history set trans9 =" + amount + " WHERE id = " + id;
            stmt.executeUpdate(q1);


        } catch (Exception e) {

            System.out.println(e);
        }


    }

    public void setEmail(String em, int id) {

        try {
            String q1 = "update Account set email ='" + em + "' WHERE id=" + id;
            int x = stmt.executeUpdate(q1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setFullName(String fn, int id) {
        try {
            String q1 = "update Account set fullName ='" + fn + "' where id= " + id;
            int x = stmt.executeUpdate(q1);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void setNum(String num, int id) {
        try {
            String q1 = "update Account set number ='" + num + "' where id=" + id;
            int x = stmt.executeUpdate(q1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setPin(String pin, int id) {
        try {
            String q1 = "update Account set pin ='" + pin + "' where id=" + id;
            int x = stmt.executeUpdate(q1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}




