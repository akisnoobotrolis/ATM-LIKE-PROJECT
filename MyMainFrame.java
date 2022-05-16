import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyMainFrame extends JFrame implements ActionListener {

    Account user;
    Container container = getContentPane();
    BankDataBase dataBase;
    JLabel welcomeLabel;
    JLabel actionLabel = new JLabel("Select an action", SwingConstants.CENTER);
    JTextField userTextField = new JTextField();
    JButton transactionButton = new JButton("Transaction");
    JButton depositButton = new JButton("Deposit");
    JButton withdrawButton = new JButton("Withdraw");
    JButton historyButton = new JButton("View History");
    ImageIcon img = new ImageIcon(getClass().getClassLoader().getResource("NooBank.png"));
    JLabel name;
    JButton settingsButton = new JButton("Settings");


    MyMainFrame(BankDataBase dataBase, Account user) {
        this.dataBase = dataBase;
        this.user = user;
        if (user.getGender().equals("male"))
            welcomeLabel = new JLabel("Welcome Mr", SwingConstants.CENTER);
        else
            welcomeLabel = new JLabel("Welcome Ms", SwingConstants.CENTER);
        name = new JLabel(user.getFullName(), SwingConstants.CENTER);
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
        settingsButton.setForeground(Color.orange);
        settingsButton.setBackground(Color.DARK_GRAY);
        historyButton.setBackground(Color.DARK_GRAY);
        historyButton.setForeground(Color.orange);
        withdrawButton.setForeground(Color.orange);
        withdrawButton.setBackground(Color.DARK_GRAY);
        transactionButton.setBackground(Color.DARK_GRAY);
        transactionButton.setForeground(Color.orange);
        depositButton.setBackground(Color.DARK_GRAY);
        depositButton.setForeground(Color.orange);

    }


    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        settingsButton.setBounds(360, 30, 100, 40);
        welcomeLabel.setBounds(200, 0, 100, 30);
        name.setBounds(150, 30, 200, 30);
        actionLabel.setBounds(150, 70, 200, 30);
        withdrawButton.setBounds(40, 120, 200, 200);
        depositButton.setBounds(260, 120, 200, 200);
        transactionButton.setBounds(40, 330, 200, 200);
        historyButton.setBounds(260, 330, 200, 200);


    }

    public void addComponentsToContainer() {
        container.add(name);
        container.add(settingsButton);
        container.add(welcomeLabel);
        container.add(actionLabel);
        container.add(userTextField);
        container.add(transactionButton);
        container.add(depositButton);
        container.add(withdrawButton);
        container.add(historyButton);
    }

    public void addActionEvent() {
        settingsButton.addActionListener(this);
        transactionButton.addActionListener(this);
        depositButton.addActionListener(this);
        withdrawButton.addActionListener(this);
        historyButton.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == depositButton) {
            this.dispose();
            DepositFrame depositFrame = new DepositFrame(dataBase, user);
        }
        if (e.getSource() == transactionButton) {
            this.dispose();
            TransactionFrame transactionFrame = new TransactionFrame(dataBase, user);
        }
        if (e.getSource() == withdrawButton) {
            this.dispose();
            WithdrawFrame withdrawFrameFrame = new WithdrawFrame(dataBase, user);
        }
        if (e.getSource() == historyButton) {
            this.dispose();
            HistoryFrame historyFrame = new HistoryFrame(dataBase, user);

        }
        if (e.getSource() == settingsButton) {
            this.dispose();
            SettingsFrame settingsFrame = new SettingsFrame(dataBase, user);

        }
    }


}



