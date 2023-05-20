package okna;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

public class dodaj {
    public JPanel okno;
    private JFormattedTextField gatunek;
    private JButton dodajgatunek;
    private JFormattedTextField Rnazwisko;
    private JFormattedTextField Rimie;
    private JButton Rdodaj;
    private JFormattedTextField Aimie;
    private JButton Adodaj;
    private JFormattedTextField Anazwisko;
    private JFormattedTextField Anarodowosc;
    private JTextArea error1;
    private JTextArea error2;
    private JPanel error3;
    private JFormattedTextField Wytwórnia;
    private JTextArea error4;
    private JButton Wdodaj;
    baza pom = new baza();
    public dodaj(Connection baza)
    {
        error1.setVisible(false);
        error2.setVisible(false);
        error3.setVisible(false);
        error4.setVisible(false);
        this.pom.con(baza);
        dodajgatunek.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == dodajgatunek)
                {
                    if(gatunek.getText().isEmpty())
                    {
                        error1.setVisible(true);
                    }
                    else {
                        try {
                            error1.setVisible(false);
                            pom.addGatunek(gatunek.getText());
                            gatunek.setText("");
                        } catch (SQLException ex) {
                            error1.setVisible(true);
                            throw new RuntimeException(ex);
                        }
                    }
                }
            }
        });
        Rdodaj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==Rdodaj)
                {
                    if(Rimie.getText().isEmpty() || Rnazwisko.getText().isEmpty())
                    {
                        error2.setVisible(true);
                    }
                    else
                    {
                        try {
                            error2.setVisible(false);
                            pom.addRez(Rimie.getText(),Rnazwisko.getText());
                            Rimie.setText("");
                            Rnazwisko.setText("");
                        } catch (SQLException ex) {
                            error2.setVisible(true);
                            throw new RuntimeException(ex);
                        }
                    }
                }
            }
        });
        Adodaj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==Adodaj)
                {
                    if(Aimie.getText().isEmpty() || Anazwisko.getText().isEmpty() || Anarodowosc.getText().isEmpty())
                    {
                        error3.setVisible(true);
                    }
                    else
                    {
                        try {
                            error3.setVisible(false);
                            pom.addAktor(Aimie.getText(),Anazwisko.getText(),Anarodowosc.getText());
                            Aimie.setText("");
                            Anazwisko.setText("");
                            Anarodowosc.setText("");
                        } catch (SQLException ex) {
                            error3.setVisible(true);
                            throw new RuntimeException(ex);
                        }
                    }
                }
            }
        });
        Wdodaj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==Wdodaj)
                {
                    if(Wytwórnia.getText().isEmpty())
                    {
                        error4.setVisible(true);
                    }
                    else
                    {
                        try {
                            error4.setVisible(false);
                            pom.addwytw(Wytwórnia.getText());
                            Wytwórnia.setText("");
                        } catch (SQLException ex) {
                            error4.setVisible(true);
                            throw new RuntimeException(ex);
                        }
                    }
                }
            }
        });
    }
}
