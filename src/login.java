import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class login {
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
        menu.register.loginmain.add(login,"login");
        CardLayout cardLayout = (CardLayout) menu.register.loginmain.getLayout();
        cardLayout.show(menu.register.loginmain,"login");
        error.setVisible(false);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                CardLayout cardLayout = (CardLayout) menu.register.loginmain.getLayout();
                if(e.getSource() == loginButton)
                {
                    if(menu.register.konta.find(formattedTextField1.getText(),new String(passwordField1.getPassword())) == 1)
                    {
                        formattedTextField1.setValue("");
                        passwordField1.setText("");
                        cardLayout.show(menu.register.loginmain, "menu");
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
                CardLayout cardLayout = (CardLayout) menu.register.loginmain.getLayout();
                if(e.getSource()==Register)
                {
                    cardLayout.show(menu.register.loginmain,"rej");
                    error.setVisible(false);
                }
            }
        });
    }

}
