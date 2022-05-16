import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class HistoryFrame extends JFrame implements ActionListener {
    Account user = new Account();
    Container container = getContentPane();
    BankDataBase dataBase;
    JLabel transLabel1;
    JLabel transLabel2;
    JLabel transLabel3;
    JLabel transLabel4;
    JLabel transLabel5;
    JLabel transLabel6;
    JLabel transLabel7;
    JLabel transLabel8;
    JLabel transLabel9;
    JLabel transLabel10;

    JButton cancelButton = new JButton("Back");


    HistoryFrame(BankDataBase db, Account user) {
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

        transLabel1.setBackground(Color.DARK_GRAY);

        transLabel1.setForeground(Color.orange);
        transLabel2.setBackground(Color.DARK_GRAY);
        transLabel2.setForeground(Color.orange);
        transLabel3.setBackground(Color.DARK_GRAY);
        transLabel3.setForeground(Color.orange);
        transLabel4.setBackground(Color.DARK_GRAY);
        transLabel4.setForeground(Color.orange);
        transLabel5.setBackground(Color.DARK_GRAY);
        transLabel5.setForeground(Color.orange);
        transLabel6.setBackground(Color.DARK_GRAY);
        transLabel6.setForeground(Color.orange);
        transLabel7.setBackground(Color.DARK_GRAY);
        transLabel7.setForeground(Color.orange);
        transLabel8.setBackground(Color.DARK_GRAY);
        transLabel8.setForeground(Color.orange);
        transLabel9.setBackground(Color.DARK_GRAY);
        transLabel9.setForeground(Color.orange);
        transLabel10.setBackground(Color.DARK_GRAY);
        transLabel10.setForeground(Color.orange);
        cancelButton.setBackground(Color.DARK_GRAY);
        transLabel2.setOpaque(true);
        transLabel3.setOpaque(true);
        transLabel1.setOpaque(true);
        transLabel4.setOpaque(true);
        transLabel5.setOpaque(true);
        transLabel6.setOpaque(true);
        transLabel7.setOpaque(true);
        transLabel8.setOpaque(true);
        transLabel9.setOpaque(true);
        transLabel10.setOpaque(true);
        cancelButton.setForeground(Color.orange);

    }


    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {


        transLabel1.setBounds(200, 40, 100, 30);
        transLabel2.setBounds(200, 80, 100, 30);
        transLabel3.setBounds(200, 120, 100, 30);
        transLabel4.setBounds(200, 160, 100, 30);
        transLabel5.setBounds(200, 200, 100, 30);
        transLabel6.setBounds(200, 240, 100, 30);
        transLabel7.setBounds(200, 280, 100, 30);
        transLabel8.setBounds(200, 320, 100, 30);
        transLabel9.setBounds(200, 360, 100, 30);
        transLabel10.setBounds(200, 400, 100, 30);

        cancelButton.setBounds(200, 500, 100, 30);


    }

    public void addComponentsToContainer() {


        container.add(transLabel1);
        container.add(transLabel2);
        container.add(transLabel3);
        container.add(transLabel4);
        container.add(transLabel5);
        container.add(transLabel6);
        container.add(transLabel7);
        container.add(transLabel8);
        container.add(transLabel9);
        container.add(transLabel10);

        container.add(cancelButton);

    }


    public void addActionEvent() {


        cancelButton.addActionListener(this);

    }


    @Override
    public void actionPerformed(ActionEvent e) {


        if (e.getSource() == cancelButton) {
            this.dispose();
            MyMainFrame myMainFrame = new MyMainFrame(dataBase, user);

        }
    }

    public void setLabels() {
        transLabel1 = new JLabel(Double.toString(dataBase.getHistory(user.getId()).get(0)), SwingConstants.CENTER);
        transLabel2 = new JLabel(Double.toString(dataBase.getHistory(user.getId()).get(1)), SwingConstants.CENTER);
        transLabel3 = new JLabel(Double.toString(dataBase.getHistory(user.getId()).get(2)), SwingConstants.CENTER);
        transLabel4 = new JLabel(Double.toString(dataBase.getHistory(user.getId()).get(3)), SwingConstants.CENTER);
        transLabel5 = new JLabel(Double.toString(dataBase.getHistory(user.getId()).get(4)), SwingConstants.CENTER);
        transLabel6 = new JLabel(Double.toString(dataBase.getHistory(user.getId()).get(5)), SwingConstants.CENTER);
        transLabel7 = new JLabel(Double.toString(dataBase.getHistory(user.getId()).get(6)), SwingConstants.CENTER);
        transLabel8 = new JLabel(Double.toString(dataBase.getHistory(user.getId()).get(7)), SwingConstants.CENTER);
        transLabel9 = new JLabel(Double.toString(dataBase.getHistory(user.getId()).get(8)), SwingConstants.CENTER);
        transLabel10 = new JLabel(Double.toString(dataBase.getHistory(user.getId()).get(9)), SwingConstants.CENTER);


    }


}

