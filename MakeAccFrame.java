import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MakeAccFrame extends JFrame implements ActionListener {


    Account user = new Account();
    Container container = getContentPane();
    BankDataBase dataBase;
    JLabel userLabel = new JLabel("Enter Username");
    JLabel passwordLabel = new JLabel(" Enter Password");
    JLabel passwordLabel2 = new JLabel("Re-enter Password");
    JLabel fnLabel = new JLabel("Enter Full Name");
    JTextField fnTextField = new JTextField();
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JPasswordField passwordField2 = new JPasswordField();
    JButton okButton = new JButton("Create Account");
    JCheckBox showPassword = new JCheckBox("Show Both");
    JCheckBox male = new JCheckBox("Male");
    JCheckBox female = new JCheckBox("Female");
    JLabel gender = new JLabel("Choose Gender");
    JLabel emailLabel = new JLabel("Enter email");
    JTextField email = new JTextField();
    JLabel mobileLabel = new JLabel("Enter your phone Number");
    JTextField mobile = new JTextField();
    ImageIcon img = new ImageIcon(getClass().getClassLoader().getResource("NooBank.png"));
    ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("NooBanr.png"));
    JLabel logoLabel = new JLabel(logo);


    MakeAccFrame(BankDataBase dataBase) {
        this.dataBase = dataBase;
        setLayoutManager();
        setLocationAndSize();
        setColors();
        addComponentsToContainer();
        container.setBackground(Color.YELLOW);
        addActionEvent();
        this.setIconImage(img.getImage());
        this.setVisible(true);
        this.setBounds(10, 10, 500, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);


    }


    public void setColors() {
        fnTextField.setBackground(Color.DARK_GRAY);
        fnTextField.setForeground(Color.orange);
        passwordField.setBackground(Color.DARK_GRAY);
        male.setBackground(Color.YELLOW);
        female.setBackground(Color.YELLOW);
        passwordField.setForeground(Color.orange);
        passwordField2.setBackground(Color.DARK_GRAY);
        passwordField2.setForeground(Color.orange);
        userTextField.setBackground(Color.DARK_GRAY);
        userTextField.setForeground(Color.orange);
        showPassword.setBackground(Color.YELLOW);
        okButton.setBackground(Color.DARK_GRAY);
        okButton.setForeground(Color.orange);
        email.setForeground(Color.orange);
        email.setBackground(Color.DARK_GRAY);
        mobile.setForeground(Color.orange);
        mobile.setBackground(Color.DARK_GRAY);
    }


    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {


        logoLabel.setBounds(50, 20, 400, 250);
        userLabel.setBounds(105, 225, 100, 30);
        userTextField.setBounds(205, 225, 170, 30);
        passwordLabel.setBounds(105, 265, 100, 30);
        passwordField.setBounds(205, 265, 170, 30);
        passwordLabel2.setBounds(90, 305, 170, 30);
        passwordField2.setBounds(205, 305, 170, 30);
        showPassword.setBounds(205, 335, 170, 30);
        gender.setBounds(105, 365, 100, 30);
        male.setBounds(205, 365, 70, 30);
        female.setBounds(285, 365, 90, 30);
        emailLabel.setBounds(130, 395, 100, 30);
        email.setBounds(205, 395, 170, 30);
        mobileLabel.setBounds(50, 435, 170, 30);
        mobile.setBounds(205, 435, 170, 30);
        fnLabel.setBounds(90, 475, 170, 30);
        fnTextField.setBounds(205, 475, 170, 30);
        okButton.setBounds(160, 515, 180, 30);


    }

    public void addComponentsToContainer() {
        container.add(fnLabel);
        container.add(fnTextField);
        container.add(male);
        container.add(female);
        container.add(gender);
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(okButton);
        container.add(passwordField2);
        container.add(passwordLabel2);
        container.add(emailLabel);
        container.add(email);
        container.add(mobile);
        container.add(mobileLabel);
        container.add(logoLabel);


    }


    public void addActionEvent() {
        male.addActionListener(this);
        female.addActionListener(this);
        okButton.addActionListener(this);
        showPassword.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == male) {
            if (male.isSelected()) {
                female.setSelected(false);
            }


        }

        if (e.getSource() == female) {
            if (female.isSelected()) {
                male.setSelected(false);
            }


        }


        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
                passwordField2.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
                passwordField2.setEchoChar('*');
            }
        }
        if (e.getSource() == okButton) {

            String userText;
            String pwdText;
            String pwdText2;
            String emText;
            String mobText;
            String fullText;
            List<Boolean> list = new ArrayList<Boolean>();
            List<String> slist = new ArrayList<String>();
            Collections.fill(list, Boolean.TRUE);
            fullText = fnTextField.getText();
            userText = userTextField.getText();
            pwdText = String.valueOf(passwordField.getPassword());
            pwdText2 = String.valueOf(passwordField2.getPassword());
            boolean passMatch = false;
            if (pwdText.equals(pwdText2) && !pwdText.equals(""))
                passMatch = true;
            emText = email.getText();
            mobText = mobile.getText();
            list.add(passMatch);
            JOptionPane pane = new JOptionPane();
            UIManager um = new UIManager();
            um.put("OptionPane.background", Color.YELLOW);
            um.put("Panel.background", Color.YELLOW);
            boolean emailValid = emailVal(emText);
            boolean nameValid = isValidMobile(mobText);
            list.add(emailValid);
            list.add(nameValid);
            boolean gndr;
            gndr = false;
            String gender = " ";
            if (male.isSelected())
                gender = "Male";
            if (female.isSelected())
                gender = "Female";
            if (!gender.equals(" "))
                gndr = true;
            list.add(gndr);
            boolean nameNotData = false;
            if (!userText.equals(dataBase.getUsername(userText)) && !userText.equals(""))
                nameNotData = true;
            list.add(nameNotData);
            boolean emailNotData = false;
            if (!emText.equals(dataBase.getEmail(userText)) && !emText.equals(""))
                emailNotData = true;
            list.add(emailNotData);
            boolean fn= false;
            if (!fullText.equals(""))
                fn=true;
            list.add(fn);


            boolean nall = true;
            for (int i = 0; i < list.size(); i++) {
                if (!list.get(i)) {
                    nall = false;
                    if (i == 0 && pwdText.equals("") && pwdText2.equals(""))
                        slist.add("Enter Password in both fields\n");
                    else if (i == 0 && !pwdText.equals(" ") && !pwdText2.equals(" "))
                        slist.add("Passwords dont Match\n");
                    else if (i == 0 && pwdText.equals("") && !pwdText2.equals(""))
                        slist.add("Enter Password in first field\n");
                    else if (i == 0 && !pwdText.equals("") && pwdText2.equals(""))
                        slist.add("Enter Password in second field\n");
                    if (i == 1 && !emText.equals(""))
                        slist.add("Email not Valid\n");
                    else if (i == 1 && emText.equals(""))
                        slist.add("Enter an Email \n");
                    if (i == 2 && !mobText.equals(""))
                        slist.add("Phone number not Valid\n");
                    else if (i == 2 && mobText.equals(""))
                        slist.add("Enter Phone Number\n");
                    if (i == 3)
                        slist.add("Please choose a gender\n");
                    if (i == 4 && !userText.equals(""))
                        slist.add("Username already taken \n");
                    else if (i == 4 && userText.equals(""))
                        slist.add("Enter a Username \n");
                    if (i == 5 && !emText.equals(""))
                        slist.add("Email already taken \n");
                    if (i == 5 && emText.equals(""))
                        slist.add("");
                    if (i == 6  )
                        slist.add("Enter your Full Name\n");

                }
                if (list.get(i)) {
                    if (i == 0)
                        slist.add("");
                    if (i == 1)
                        slist.add("");
                    if (i == 2)
                        slist.add("");
                    if (i == 3)
                        slist.add("");
                    if (i == 4)
                        slist.add("");
                    if (i == 5)
                        slist.add("");
                    if (i == 6)
                        slist.add("");
                }

            }


            if (nall == true) {
                pane.showMessageDialog(this, "Account created Successfully");
                dataBase.addUser(fullText, pwdText, userText, emText, mobText, gender);
                this.dispose();
                StartUpFrame startUpFrame = new StartUpFrame(dataBase);
            } else
                pane.showMessageDialog(this, slist.get(0) + slist.get(1) + slist.get(2) + slist.get(3) + slist.get(4) + slist.get(5)+ slist.get(6));
        }
    }


    public boolean emailVal(String email) {
        String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        Pattern emailPat = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = emailPat.matcher(email);
        return matcher.find();


    }

    public static boolean isValidMobile(String str) {
        Pattern p = Pattern.compile("^\\d{10}$");


        Matcher m = p.matcher(str);

        // Returning boolean value
        return (m.matches());
    }
}









