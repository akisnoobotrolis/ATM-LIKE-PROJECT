import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ViewFrame extends JFrame implements ActionListener {
    Account user = new Account();
    Container container = getContentPane();
    BankDataBase dataBase;
    JLabel emailLabel;
    JLabel em=new JLabel("Email:",SwingConstants.RIGHT);
    JLabel fn=new JLabel("Full Name:",SwingConstants.RIGHT);
    JLabel un=new JLabel("Username:",SwingConstants.RIGHT);
    JLabel psw=new JLabel("Password:",SwingConstants.RIGHT);
    JLabel phone=new JLabel("Phone:",SwingConstants.RIGHT);
    JLabel gender=new JLabel("Gender:",SwingConstants.RIGHT);
    JLabel id=new JLabel("ID:",SwingConstants.RIGHT);
    JLabel balance=new JLabel("Balance:",SwingConstants.RIGHT);
    JLabel fnLabel;
    JLabel unLabel;
    JLabel pswLabel;
    JLabel phoneLabel;
    JLabel genderLabel;
    JLabel idLabel;
    JLabel balanceLabel;
    JButton cancelButton = new JButton("Back");


    ViewFrame(BankDataBase db, Account user) {
        this.user = user;
        dataBase = db;
        setLabels();
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
        unLabel.setBackground(Color.DARK_GRAY);
        unLabel.setForeground(Color.orange);
        fnLabel.setForeground(Color.orange);
        fnLabel.setBackground(Color.DARK_GRAY);
        pswLabel.setBackground(Color.DARK_GRAY);
        pswLabel.setForeground(Color.orange);
        emailLabel.setBackground(Color.DARK_GRAY);
        emailLabel.setForeground(Color.orange);
        genderLabel.setBackground(Color.DARK_GRAY);
        genderLabel.setForeground(Color.orange);
        phoneLabel.setBackground(Color.DARK_GRAY);
        phoneLabel.setForeground(Color.orange);
        balanceLabel.setBackground(Color.DARK_GRAY);
        balanceLabel.setForeground(Color.orange);
        idLabel.setBackground(Color.DARK_GRAY);
        idLabel.setForeground(Color.orange);
        unLabel.setOpaque(true);
        fnLabel.setOpaque(true);
        pswLabel.setOpaque(true);
        emailLabel.setOpaque(true);
        idLabel.setOpaque(true);
        genderLabel.setOpaque(true);
        phoneLabel.setOpaque(true);
        balanceLabel.setOpaque(true);
        cancelButton.setForeground(Color.orange);
        cancelButton.setBackground(Color.DARK_GRAY);
    }


    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {


        fnLabel.setBounds(200, 40, 100, 30);
        fn.setBounds(80,40,100,30);
        unLabel.setBounds(200, 80, 100, 30);
        un.setBounds(80,80,100,30);
        pswLabel.setBounds(200, 120, 100, 30);
        psw.setBounds(80,120,100,30);
        emailLabel.setBounds(200, 160, 100, 30);
        em.setBounds(80,160,100,30);
        phoneLabel.setBounds(200, 200, 100, 30);
        phone.setBounds(80,200,100,30);
        idLabel.setBounds(200, 240, 100, 30);
        id.setBounds(80,240,100,30);
        genderLabel.setBounds(200, 280, 100, 30);
        gender.setBounds(80,280,100,30);
        balanceLabel.setBounds(200, 320, 100, 30);
        balance.setBounds(80,320,100,30);


        cancelButton.setBounds(200, 500, 100, 30);


    }

    public void addComponentsToContainer() {


        container.add(balanceLabel);
        container.add(genderLabel);
        container.add(idLabel);
        container.add(phoneLabel);
        container.add(emailLabel);
        container.add(pswLabel);
        container.add(unLabel);
        container.add(fnLabel);
        container.add(cancelButton);
        container.add(balance);
        container.add(gender);
        container.add(id);
        container.add(phone);
        container.add(em);
        container.add(psw);
        container.add(un);
        container.add(fn);
        container.add(cancelButton);

    }


    public void addActionEvent() {


        cancelButton.addActionListener(this);

    }


    @Override
    public void actionPerformed(ActionEvent e) {


        if (e.getSource() == cancelButton) {
            this.dispose();
            SettingsFrame settingsFrame = new SettingsFrame(dataBase, user);

        }
    }

    public void setLabels() {

        fnLabel=new JLabel(user.getFullName(),SwingConstants.CENTER);
        unLabel=new JLabel(user.getUsername(),SwingConstants.CENTER);
        pswLabel=new JLabel(user.getPin(),SwingConstants.CENTER);
        emailLabel=new JLabel(user.getEmail(),SwingConstants.CENTER);
        genderLabel=new JLabel(user.getGender(),SwingConstants.CENTER);
        idLabel=new JLabel(Integer.toString(user.getId()),SwingConstants.CENTER);
        phoneLabel=new JLabel(user.getNumber(),SwingConstants.CENTER);
        balanceLabel=new JLabel(Double.toString(dataBase.getBalance(user.getUsername())),SwingConstants.CENTER);






    }


}

