import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Locale;


public class StartUpFrame extends JFrame implements ActionListener {
    Account user = new Account();
    Container container = getContentPane();
    BankDataBase dataBase;
    JLabel userLabel = new JLabel("Username");
    JLabel passwordLabel = new JLabel("Password");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("LOGIN");
    JButton signupButton = new JButton("SIGN UP");

    JCheckBox showPassword = new JCheckBox("Show Password");
    ImageIcon img = new ImageIcon(getClass().getClassLoader().getResource("NooBank.png"));
    ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("NooBanr.png"));
    JLabel logoLabel = new JLabel(logo);
    JLabel dontHaveAcc = new JLabel("You dont have an Account?");


    StartUpFrame(BankDataBase db) {

        dataBase = db;
        setLayoutManager();
        setLocationAndSize();
        setColors();
        addComponentsToContainer();
        container.setBackground(Color.YELLOW);
        addActionEvent();
        this.setIconImage(img.getImage());
        this.setTitle("Login Form");
        this.setVisible(true);
        this.setBounds(10, 10, 500, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);



    }


    public void setColors() {
        passwordField.setBackground(Color.DARK_GRAY);
        passwordField.setForeground(Color.orange);
        userTextField.setBackground(Color.DARK_GRAY);
        userTextField.setForeground(Color.orange);
        showPassword.setBackground(Color.YELLOW);
        signupButton.setBackground(Color.DARK_GRAY);
        signupButton.setForeground(Color.orange);
        loginButton.setBackground(Color.DARK_GRAY);
        loginButton.setForeground(Color.orange);

    }


    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {

        logoLabel.setBounds(50, 10, 400, 250);
        userLabel.setBounds(100, 250, 100, 30);
        userTextField.setBounds(180, 250, 170, 30);
        passwordLabel.setBounds(100, 320, 100, 30);
        passwordField.setBounds(180, 320, 170, 30);
        showPassword.setBounds(200, 350, 150, 30);
        loginButton.setBounds(200, 400, 100, 30);
        dontHaveAcc.setBounds(180, 450, 200, 30);
        signupButton.setBounds(200, 500, 100, 30);



    }

    public void addComponentsToContainer() {

        container.add(logoLabel);
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(signupButton);
        container.add(dontHaveAcc);

    }


    public void addActionEvent() {

        loginButton.addActionListener(this);
        signupButton.addActionListener(this);
        showPassword.addActionListener(this);
    }





    @Override
    public void actionPerformed(ActionEvent e) {


        if (e.getSource() == loginButton) {
            loginPress();


        }
        if (e.getSource() == signupButton) {
            this.dispose();
            MakeAccFrame myAccFrame = new MakeAccFrame(dataBase);

        }
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }


        }
    }

    public void loginPress() {
        String userText;
        String pwdText;
        userText = userTextField.getText();
        pwdText = String.valueOf(passwordField.getPassword());
        JOptionPane pane = new JOptionPane();
        UIManager um = new UIManager();
        um.put("OptionPane.background", Color.YELLOW);
        um.put("Panel.background", Color.YELLOW);
        if (userText.equals(dataBase.getUsername(userText)) && pwdText.equals(dataBase.getPin(userText, pwdText))) {
            user.setUsername(dataBase.getUsername(userText));
            user.setPin(dataBase.getPin(userText, pwdText));
            user.setUsername(dataBase.getUsername(userText));
            user.setId(dataBase.getid(userText));
            user.setBalance(dataBase.getBalance(userText));
            user.setFullName(dataBase.getFullName(userText, pwdText));
            user.setEmail(dataBase.getEmail(userText));
            user.setGender(dataBase.getGender(userText,pwdText));
            user.setNumber(dataBase.getNumber(userText,pwdText));
            user.setHistory(dataBase.getHistory(user.getId()));


            pane.showMessageDialog(this, "LOGIN SUCCESSFULL");
            this.dispose();
            MyMainFrame myMainFrame = new MyMainFrame(dataBase, user);

        } else {
            pane.showMessageDialog(this, "INVAILD USERNAME OR PASSWORD");
        }
    }
}
