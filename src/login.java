import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class login {
    public konta konta = new konta();
    public JPanel login;
    private JTextField loginTextField;
    private JFormattedTextField formattedTextField1;
    private JTextField hasłoTextField;
    private JPasswordField passwordField1;
    private JButton loginButton;
    private JButton Register;
    private JTextArea error;
    public menu menu = new menu();

    public login()
    {
        hasłoTextField.setBorder(null);
        loginTextField.setBorder(null);
        loginButton.setBorder(null);
        loginButton.setFocusPainted(false);
        Register.setBorder(null);
        Register.setFocusPainted(false);
        menu.loginmain.add(login,"login");
        menu.loginmain.add(menu.menu,"menu");
        CardLayout cardLayout = (CardLayout) menu.loginmain.getLayout();
        cardLayout.show(menu.loginmain,"login");
        error.setVisible(false);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                CardLayout cardLayout = (CardLayout) menu.loginmain.getLayout();
                if(e.getSource() == loginButton)
                {
                    if(konta.find(formattedTextField1.getText(),new String(passwordField1.getPassword())) == 1)
                    {
                        formattedTextField1.setValue("");
                        passwordField1.setText("");
                        cardLayout.show(menu.loginmain, "menu");
                        error.setVisible(false);
                    }
                    else
                    {
                        error.setVisible(true);
                    }
                }
            }
        });

        Register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(e.getSource()==Register)
                {

                }
            }
        });
    }

}
