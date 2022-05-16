import javax.swing.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ChangeFrame extends JFrame implements ActionListener {
    Account user = new Account();
    Container container = getContentPane();
    BankDataBase dataBase;
    JLabel em=new JLabel("Email:",SwingConstants.RIGHT);
    JLabel fn=new JLabel("Full Name:",SwingConstants.RIGHT);
    JLabel un=new JLabel("Username:",SwingConstants.RIGHT);
    JLabel psw=new JLabel("Password:",SwingConstants.RIGHT);
    JLabel phone=new JLabel("Phone:",SwingConstants.RIGHT);
    JLabel id=new JLabel("ID:",SwingConstants.RIGHT);
    JOptionPane pane = new JOptionPane();
    UIManager um = new UIManager();



    JTextField emT=new JTextField();
    JTextField fnT= new JTextField();
    JTextField unT= new JTextField();
    JTextField pswT= new JTextField();
    JTextField phoneT= new JTextField();
    JTextField idT= new JTextField();


    JButton emok=new JButton("Ok");
    JButton fnok=new JButton("Ok");
    JButton unok=new JButton("Ok");
    JButton numok=new JButton("Ok");
    JButton pinok=new JButton("Ok");
    JButton cancelButton = new JButton("Back");


    ChangeFrame(BankDataBase db, Account user) {
        this.user = user;
        dataBase = db;
        this.um.put("OptionPane.background", Color.YELLOW);
        this.um.put("Panel.background", Color.YELLOW);
        setLayoutManager();
        setLocationAndSize();
        setColors();
        addComponentsToContainer();
        container.setBackground(Color.YELLOW);
        addActionEvent();
        this.setTitle("History");
        this.setVisible(true);
        this.setBounds(10, 10, 500, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

    }


    public void setColors() {


        unT.setBackground(Color.DARK_GRAY);
        unT.setForeground(Color.orange);
        fnT.setBackground(Color.DARK_GRAY);
        fnT.setForeground(Color.orange);
        emT.setBackground(Color.DARK_GRAY);
        emT.setForeground(Color.orange);
        pswT.setBackground(Color.DARK_GRAY);
        pswT.setForeground(Color.orange);
        phoneT.setBackground(Color.DARK_GRAY);
        phoneT.setForeground(Color.orange);
        cancelButton.setForeground(Color.orange);
        cancelButton.setBackground(Color.DARK_GRAY);
        unok.setBackground(Color.DARK_GRAY);
        unok.setForeground(Color.orange);
        fnok.setBackground(Color.DARK_GRAY);
        fnok.setForeground(Color.orange);
        emok.setBackground(Color.DARK_GRAY);
        emok.setForeground(Color.orange);
        numok.setBackground(Color.DARK_GRAY);
        numok.setForeground(Color.orange);
        pinok.setBackground(Color.DARK_GRAY);
        pinok.setForeground(Color.orange);
        cancelButton.setForeground(Color.orange);
        cancelButton.setBackground(Color.DARK_GRAY);
    }


    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {


        fnT.setBounds(160, 40, 170, 30);
        fn.setBounds(40,40,100,30);
        fnok.setBounds(360,40,50,30);
        unT.setBounds(160, 80, 170, 30);
        un.setBounds(40,80,100,30);
        unok.setBounds(360,80,50,30);
        pswT.setBounds(160, 120, 170, 30);
        psw.setBounds(40,120,100,30);
        pinok.setBounds(360,120,50,30);
        emT.setBounds(160,160,170,30);
        em.setBounds(40,160,100,30);
        emok.setBounds(360,160,50,30);
        phoneT.setBounds(160, 200, 170, 30);
        phone.setBounds(40,200,100,30);
        numok.setBounds(360,200,50,30);




        cancelButton.setBounds(200, 500, 100, 30);


    }

    public void addComponentsToContainer() {

        container.add(psw);
        container.add(pswT);
        container.add(fn);
        container.add(phone);
        container.add(phoneT);
        container.add(fnT);
        container.add(id);
        container.add(idT);
        container.add(em);
        container.add(emT);
        container.add(un);
        container.add(unT);
        container.add(cancelButton);
        container.add(emok);
        container.add(fnok);
        container.add(unok);
        container.add(pinok);
        container.add(numok);

        container.add(cancelButton);

    }


    public void addActionEvent() {


        cancelButton.addActionListener(this);
        emok.addActionListener(this);
        fnok.addActionListener(this);
        unok.addActionListener(this);
        numok.addActionListener(this);
        pinok.addActionListener(this);

    }


    @Override
    public void actionPerformed(ActionEvent e) {


        if (e.getSource() == cancelButton) {
            this.dispose();
            MyMainFrame myMainFrame = new MyMainFrame(dataBase, user);

        }
        if (e.getSource() == emok) {

            String emText= emT.getText();
            boolean x=emailVal(emText);
            if (emText.equals(""))
                pane.showMessageDialog(this, "Enter an Email");
            else if (emText.equals(user.getEmail()))
                pane.showMessageDialog(this, "You already use this email");
            else if (emText.equals(dataBase.verEmail(emText)))
                pane.showMessageDialog(this, "Email already in use");
            else if (!x)
                pane.showMessageDialog(this, "Email not Valid");
            else {
                dataBase.setEmail(emText, user.getId());
                pane.showMessageDialog(this, "Email changed Successfully");
                user.setEmail(emText);
            }



        }
        if (e.getSource() == fnok) {
            String fnText=fnT.getText();
            if (fnText.equals(""))
                pane.showMessageDialog(this, "Enter a Full Name");
            else if (fnText.equals(user.getFullName()))
                pane.showMessageDialog(this, "You already use this email");
            else {
                dataBase.setFullName(fnText, user.getId());
                pane.showMessageDialog(this, "Full Name changed Successfully");
                user.setFullName(fnText);
            }


        }
        if (e.getSource() == unok) {
            String unText=unT.getText();
            if (unText.equals(""))
                pane.showMessageDialog(this, "Enter a Username");
            else if (unText.equals(user.getUsername()))
                pane.showMessageDialog(this, "You already use this Username");
            else if (unText.equals(dataBase.getUsername(unText)))
                pane.showMessageDialog(this, "Username already in use");
             else  {
                 dataBase.setFullName(unText, user.getId());
                pane.showMessageDialog(this, "Username changed Successfully");
                user.setUsername(unText);

            }


        }
        if (e.getSource() == numok) {
            String numText=phoneT.getText();
            boolean x=isValidMobile(numText);
            if (numText.equals(""))
                pane.showMessageDialog(this, "Enter a Phone number");
            else if (numText.equals(user.getNumber()))
                pane.showMessageDialog(this, "You already use this Phone number");
            else if (!x)
                pane.showMessageDialog(this, "Not a Valid Phone number");
            else {
                dataBase.setNum(numText, user.getId());
                pane.showMessageDialog(this, "Phone number changed Successfully");
                user.setNumber(numText);
            }
        }
        if (e.getSource() == pinok) {
            String pinText=pswT.getText();
            if (pinText.equals(""))
                pane.showMessageDialog(this, "Enter a Password");
            else if (pinText.equals(user.getPin()))
                pane.showMessageDialog(this, "You already use this Password");
            else {
                dataBase.setPin(pinText, user.getId());
                pane.showMessageDialog(this, "Password changed Successfully");
                user.setPin(pinText);
            }

        }



    }


    public static boolean isValidMobile(String str) {
        Pattern p = Pattern.compile("^\\d{10}$");


        Matcher m = p.matcher(str);

        // Returning boolean value
        return (m.matches());
    }
    public boolean emailVal(String email) {
        String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        Pattern emailPat = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = emailPat.matcher(email);
        return matcher.find();


    }
}





