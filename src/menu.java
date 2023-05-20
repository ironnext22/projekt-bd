import okna.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

public class menu {
    public JButton back;
    public JPanel menu;
    private JPanel main;
    private JPanel manu;
    private JButton button2;
    private JButton button1;
    private JButton filmButton;
    private JButton wynajemButton;
    private JButton zwrotButton;
    private Connection connection = baza.connect();
    private tabele t = new tabele(connection);
    private dodaj t2 = new dodaj(connection);
    public Register register = new Register();
    public menu() throws SQLException {
        main.add(t.test,"okno1");
        main.add(t2.okno,"okno2");
        register.loginmain.add(menu,"menu");
        register.loginmain.add(register.rejestracja,"rej");
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                    CardLayout cardLayout = (CardLayout) register.loginmain.getLayout();
                    cardLayout.show(register.loginmain,"login");
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    CardLayout cardLayout = (CardLayout) main.getLayout();
                    cardLayout.show(main,"okno1");
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    CardLayout cardLayout = (CardLayout) main.getLayout();
                    cardLayout.show(main,"okno2");

            }
        });
    }
}
