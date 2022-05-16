import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TransactionFrame extends JFrame implements ActionListener {
    Account user = new Account();
    Container container = getContentPane();
    BankDataBase dataBase;
    JLabel amountLabel = new JLabel("Enter Amount");
    JLabel userIdLabel = new JLabel("<html>Enter Username you<br>want to send money</html>");
    JTextField useridField = new JTextField();
    JTextField amountField = new JTextField();
    ImageIcon img = new ImageIcon(getClass().getClassLoader().getResource("NooBank.png"));
    ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("NooBanr.png"));
    JLabel logoLabel = new JLabel(logo);
    JButton okButton = new JButton("Enter");
    JButton cancelButton = new JButton("Cancel");


    TransactionFrame(BankDataBase db, Account user) {
        this.user = user;
        dataBase = db;
        setLayoutManager();
        setLocationAndSize();
        setColors();
        addComponentsToContainer();
        container.setBackground(Color.ORANGE);
        addActionEvent();
        this.setIconImage(img.getImage());
        this.setTitle("Withdraw");
        this.setVisible(true);
        this.setBounds(10, 10, 500, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);


    }


    public void setColors() {
        useridField.setBackground(Color.DARK_GRAY);
        useridField.setForeground(Color.orange);
        amountField.setBackground(Color.DARK_GRAY);
        amountField.setForeground(Color.orange);
        okButton.setBackground(Color.DARK_GRAY);
        okButton.setForeground(Color.orange);
        cancelButton.setBackground(Color.DARK_GRAY);
        cancelButton.setForeground(Color.orange);

    }


    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {

        logoLabel.setBounds(50, 10, 400, 250);
        userIdLabel.setBounds(60, 240, 200, 50);
        useridField.setBounds(180, 250, 170, 30);
        amountLabel.setBounds(100, 320, 100, 30);
        amountField.setBounds(180, 320, 170, 30);
        okButton.setBounds(200, 400, 100, 30);
        cancelButton.setBounds(200, 500, 100, 30);


    }

    public void addComponentsToContainer() {

        container.add(logoLabel);
        container.add(userIdLabel);
        container.add(useridField);
        container.add(amountField);
        container.add(amountLabel);
        container.add(okButton);
        container.add(cancelButton);

    }


    public void addActionEvent() {

        okButton.addActionListener(this);
        cancelButton.addActionListener(this);

    }


    @Override
    public void actionPerformed(ActionEvent e) {


        if (e.getSource() == okButton) {
            okPress();


        }
        if (e.getSource() == cancelButton) {
            this.dispose();
            MyMainFrame myMainFrame = new MyMainFrame(dataBase, user);

        }
    }


    public void okPress() {
        String userText;
        Double amntText;
        userText = useridField.getText();
        amntText = Double.valueOf(amountField.getText());
        System.out.println(amntText);
        JOptionPane pane = new JOptionPane();
        UIManager um = new UIManager();
        um.put("OptionPane.background", Color.ORANGE);
        um.put("Panel.background", Color.ORANGE);
        if (userText.equals(dataBase.getUsername(userText))) {
            if (!userText.equals(user.getUsername())) {
                int i = dataBase.transaction(amntText, user.getUsername(), userText, user.getPin());

                if (i == 1) {
                    pane.showMessageDialog(this, "Transaction Successful\nAmount: "+Math.abs(amntText)+"\nBalance: "+dataBase.getBalance(user.getUsername()));
                    this.dispose();
                    MyMainFrame myMainFrame = new MyMainFrame(dataBase, user);
                } else if (i==0)
                    pane.showMessageDialog(this, "Transaction Unsuccessful");
                else
                    pane.showMessageDialog(this, "Transaction Unsuccessful. Not enough money");

            } else {
                pane.showMessageDialog(this, "Do not enter your Username");
            }
        } else pane.showMessageDialog(this, "Invalid Username");
    }
}

