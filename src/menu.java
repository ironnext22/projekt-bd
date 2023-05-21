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
    private JButton klienci;
    private Connection connection = baza.connect();
    private tabele t = new tabele(connection);
    private filmy t3 = new filmy(connection,t);
    private dodaj t2 = new dodaj(connection,t3);
    private wyp t4 = new wyp(connection);
    private zwroty t5 = new zwroty(connection);
    private Klienci t6 = new Klienci(connection,t,t4);
    public Register register = new Register();
    public menu() throws SQLException {
        main.add(t.test,"tabele");
        main.add(t2.okno,"dadaj");
        main.add(t3.filmy,"filmy");
        main.add(t4.wyp,"wyp");
        main.add(t5.zwrot,"zwroty");
        main.add(t6.klientci,"klienci");
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
                try {
                    t.reload();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                CardLayout cardLayout = (CardLayout) main.getLayout();
                cardLayout.show(main,"tabele");
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    CardLayout cardLayout = (CardLayout) main.getLayout();
                    cardLayout.show(main,"dadaj");

            }
        });
        filmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) main.getLayout();
                cardLayout.show(main,"filmy");
            }
        });
        wynajemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) main.getLayout();
                cardLayout.show(main,"wyp");
            }
        });
        zwrotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) main.getLayout();
                cardLayout.show(main,"zwroty");
            }
        });
        klienci.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) main.getLayout();
                cardLayout.show(main,"klienci");
            }
        });
    }
}
