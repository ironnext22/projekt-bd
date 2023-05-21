package okna;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

public class Klienci {
    public JPanel klientci;
    private JFormattedTextField imie;
    private JFormattedTextField nazwisko;
    private JButton dodaj;
    private JFormattedTextField pesel;
    private JFormattedTextField adres;
    private JFormattedTextField kod;
    private JFormattedTextField miejsc;
    private JFormattedTextField nr;
    private JFormattedTextField mail;
    baza pom = new baza();

    public Klienci(Connection baza, tabele tab, wyp wyp)
    {
        pom.con(baza);
        dodaj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==dodaj)
                {
                    if(imie.getText().isEmpty() || nazwisko.getText().isEmpty() || pesel.getText().isEmpty() || adres.getText().isEmpty() || kod.getText().isEmpty() || miejsc.getText().isEmpty() || nr.getText().isEmpty() || mail.getText().isEmpty())
                    {

                    }
                    else
                    {
                        imie.setText("");
                        nazwisko.setText("");
                        pesel.setText("");
                        adres.setText("");
                        kod.setText("");
                        miejsc.setText("");
                        nr.setText("");
                        mail.setText("");
                        try {
                            pom.addklient(imie.getText(),nazwisko.getText(),pesel.getText(),adres.getText(),kod.getText(),miejsc.getText(),nr.getText(),mail.getText());
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                        try {
                            tab.reload();
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                        try {
                            wyp.reload();
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
            }
        });
    }
}
