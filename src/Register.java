import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register {
    public konta konta = new konta();
    private JTextField imieTextField;
    private JFormattedTextField formattedimie;
    private JTextField nazwiskoTextField;
    private JFormattedTextField formattednazwisko;
    private JTextField loginTextField;
    private JFormattedTextField formattedlogin;
    private JTextField hasłoTextField;
    private JFormattedTextField formattedhaslo;
    private JButton button1;
    private JButton backButton;
    public JPanel rejestracja;
    private JTextArea error;
    public JPanel loginmain = new JPanel(new CardLayout());
    public Register()
    {
        error.setVisible(false);
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
                    error.setVisible(false);
                    error.setText("Wprowadzono błędne dane");
                }
            }
        });

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) loginmain.getLayout();
                if(e.getSource()==button1)
                {
                    String imie = formattedimie.getText();
                    String nazwisko = formattednazwisko.getText();
                    String login = formattedlogin.getText();
                    String haslo = formattedhaslo.getText();
                    if(imie.isEmpty() || nazwisko.isEmpty() || login.isEmpty() || haslo.isEmpty())
                    {
                        error.setVisible(true);
                    }
                    else
                    {
                        if(konta.find2(login)>0)
                        {
                            error.setText("Podany login już istnieje");
                            error.setVisible(true);
                        }
                        else
                        {
                            konta.add(login,haslo,imie,nazwisko);
                            cardLayout.show(loginmain,"login");
                            error.setVisible(false);
                            error.setText("Wprowadzono błędne dane");
                            konta.clear();
                            konta = new konta();

                        }
                    }
                }
            }
        });
    }
}
