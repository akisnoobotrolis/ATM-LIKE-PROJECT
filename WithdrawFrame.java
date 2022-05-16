import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class WithdrawFrame extends JFrame implements ActionListener {
    Account user = new Account();
    Container container = getContentPane();
    BankDataBase dataBase;
    JLabel amountLabel = new JLabel("Enter Amount");
    JTextField amountField = new JTextField();
    ImageIcon img = new ImageIcon(getClass().getClassLoader().getResource("NooBank.png"));
    ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("NooBanr.png"));
    JLabel logoLabel = new JLabel(logo);
    JButton okButton = new JButton("Enter");
    JButton cancelButton = new JButton("Cancel");


    WithdrawFrame(BankDataBase db, Account user) {
        this.user = user;
        dataBase = db;
        setLayoutManager();
        setLocationAndSize();
        setColors();
        addComponentsToContainer();
        container.setBackground(Color.YELLOW);
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

        logoLabel.setBounds(50, 40, 400, 250);
        amountLabel.setBounds(100, 285, 100, 30);
        amountField.setBounds(180, 285, 170, 30);
        okButton.setBounds(200, 400, 100, 30);
        cancelButton.setBounds(200, 500, 100, 30);


    }

    public void addComponentsToContainer() {

        container.add(logoLabel);
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

        Double amntText;
        amntText = Double.valueOf(amountField.getText());
        amntText = Math.abs(amntText);
        System.out.println(amntText);
        JOptionPane pane = new JOptionPane();
        UIManager um = new UIManager();
        um.put("OptionPane.background", Color.YELLOW);
        um.put("Panel.background", Color.YELLOW);


        int i = dataBase.withdraw(amntText, user.getUsername());

        if (i == 1) {
            dataBase.setHistory(-amntText, dataBase.getid(user.getUsername()));
            pane.showMessageDialog(this, "Withdraw Successful\n Amount: "+ amntText+"\n Balance: "+dataBase.getBalance(user.getUsername()));
            this.dispose();
            MyMainFrame myMainFrame = new MyMainFrame(dataBase, user);
        } else if (i == 0) {
            pane.showMessageDialog(this, "Withdraw Unsuccessful\n Your balance is: "+ dataBase.getBalance(user.getUsername()));

        }
    }
}

