import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register {
    public konta konta = new konta();
    private JTextField imieTextField;
    private JFormattedTextField formattedTextField1;
    private JTextField nazwiskoTextField;
    private JFormattedTextField formattedTextField2;
    private JTextField loginTextField;
    private JFormattedTextField formattedTextField3;
    private JTextField hasłoTextField;
    private JFormattedTextField formattedTextField4;
    private JButton button1;
    private JButton backButton;
    public JPanel rejestracja;
    public JPanel loginmain = new JPanel(new CardLayout());
    public Register()
    {
        imieTextField.setBorder(null);
        nazwiskoTextField.setBorder(null);
        loginTextField.setBorder(null);
        hasłoTextField.setBorder(null);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) loginmain.getLayout();
                if(e.getSource()==backButton)
                {
                    cardLayout.show(loginmain,"login");

                }
            }
        });
    }
}
