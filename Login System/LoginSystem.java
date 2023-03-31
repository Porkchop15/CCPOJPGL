import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginSystem extends JFrame implements ActionListener {
     JLabel userLabel, passLabel;
     JTextField userField;
     JPasswordField passField;
     JButton loginButton, regButton;
     JPanel loginPanel;
     JCheckBox showPassword = new JCheckBox("Show Password");
     String[][] userArray = new String[100][2];
     int userCount = 0;
    
    public LoginSystem() {
        setTitle("Login System");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        showPassword.addActionListener(this);

        
        userLabel = new JLabel("Username:");
        passLabel = new JLabel("Password:");
        userField = new JTextField(15);
        passField = new JPasswordField(15);
        loginButton = new JButton("Login");
        regButton = new JButton("Register");
        loginPanel = new JPanel(new GridLayout(4, 1));
        showPassword.setBounds(150, 250, 150, 30);
        
        

        loginPanel.add(userLabel);
        loginPanel.add(userField);
        loginPanel.add(passLabel);
        loginPanel.add(passField);
        loginPanel.add(loginButton);
        loginPanel.add(regButton);
        loginPanel.add(showPassword);
        add(loginPanel);
        setVisible(true);
        
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean userExists = false;
                for (int i = 0; i < userCount; i++) {
                    if (userArray[i][0].equals(userField.getText()) && userArray[i][1].equals(new String(passField.getPassword()))) {
                        userExists = true;
                        break;
                    }
                }
                if (userExists) {
                    JOptionPane.showMessageDialog(null, "Login successful!");
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect username or password.");
                }
            }
        });
        
        regButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String newUser = JOptionPane.showInputDialog(null, "Enter new username:");
                String newPass = JOptionPane.showInputDialog(null, "Enter new password:");
                userArray[userCount][0] = newUser;
                userArray[userCount][1] = newPass;
                userCount++;
            }
        });
    }
    
 
 
    @Override
    public void actionPerformed(ActionEvent e) {
        //Coding Part of RESET button
        if (e.getSource() == regButton) {
            userField.setText("");
            passField.setText("");
        }
       //Coding Part of showPassword JCheckBox
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passField.setEchoChar((char) 0);
            } else {
                passField.setEchoChar('*');
            }
 
 
        }
    }

    
    public static void main(String[] args) {
        LoginSystem login = new LoginSystem();
    }

 
 
}
