import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Locale;


public class SettingsFrame extends JFrame implements ActionListener {
    Account user = new Account();
    Container container = getContentPane();
    BankDataBase dataBase;
    JButton viewButton = new JButton("View User Information");
    JButton changeButton = new JButton("Change User Information");
    JButton deleteButton = new JButton("Delete Account");
    ImageIcon img = new ImageIcon(getClass().getClassLoader().getResource("NooBank.png"));
    ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("NooBanr.png"));
    JLabel logoLabel = new JLabel(logo);
    JButton logoutButton=new JButton("Log out");
    JButton cancelButton = new JButton("Back");
    JOptionPane pane = new JOptionPane();
    UIManager um = new UIManager();



    SettingsFrame(BankDataBase db, Account user) {
        this.um.put("OptionPane.background", Color.YELLOW);
        this.um.put("Panel.background", Color.YELLOW);
        this.user = user;
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
        viewButton.setBackground(Color.DARK_GRAY);
        viewButton.setForeground(Color.orange);
        changeButton.setBackground(Color.DARK_GRAY);
        changeButton.setForeground(Color.orange);
        deleteButton.setForeground(Color.ORANGE);
        deleteButton.setBackground(Color.DARK_GRAY);
        cancelButton.setForeground(Color.orange);
        cancelButton.setBackground(Color.DARK_GRAY);
        logoutButton.setForeground(Color.orange);
        logoutButton.setBackground(Color.DARK_GRAY);

    }


    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {

        logoLabel.setBounds(50, 10, 400, 250);
        viewButton.setBounds(150, 250, 200, 40);
        changeButton.setBounds(150, 320, 200, 40);
        deleteButton.setBounds(150, 390, 200, 40);
        logoutButton.setBounds(150,460,200,40);

        cancelButton.setBounds(200, 520, 100, 30);


    }

    public void addComponentsToContainer() {
        container.add(logoutButton);
        container.add(logoLabel);
        container.add(cancelButton);
        container.add(changeButton);
        container.add(viewButton);
        container.add(deleteButton);
    }


    public void addActionEvent() {
        logoutButton.addActionListener(this);
        viewButton.addActionListener(this);
        cancelButton.addActionListener(this);
        changeButton.addActionListener(this);
        deleteButton.addActionListener(this);

    }


    @Override
    public void actionPerformed(ActionEvent e) {


        if (e.getSource() == viewButton) {
            this.dispose();
            ViewFrame viewFrame = new ViewFrame(dataBase,user);

        }
        if (e.getSource() == cancelButton) {
            this.dispose();
            MyMainFrame myMainFrame = new MyMainFrame(dataBase,user);

        }
        if (e.getSource() == changeButton) {
            this.dispose();
            ChangeFrame changeFrame= new ChangeFrame(dataBase,user);


        }
        if (e.getSource() == deleteButton) {
            dataBase.deleteUser(user.getId());
            this.dispose();
            StartUpFrame startUpFrame= new StartUpFrame(dataBase);
            pane.showMessageDialog(this, "Account deleted Successfully");



        }
        if (e.getSource() == logoutButton) {
            this.dispose();
            StartUpFrame startUpFrame = new StartUpFrame(dataBase);


        }
    }
}

