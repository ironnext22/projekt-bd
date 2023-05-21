package okna;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

public class tabele {
    public JPanel test;
    private JTable tabela;
    private JComboBox zniana_tabel;
    private JLabel text;
    baza baza = new baza();

    String[] kary = new String[] {"tytul","klient","pesel","data_wypożyczenia","data zwrotu","dni wypożyczenia","po terminie","kara"};
    String[] filmy = new String[] {"tytul","gatynek","reżyser","wytwórnia","rola główna"};
    String[] klienci = new String[] {"klient","adres","kod pocztowy","miejscowość","nr. telefonu","mail"};
    String[] wyp = new String[] {"tytuł","klient","data wypożyczenia","długość","cena"};

    Object [][] kary_data;
    Object [][] filmy_data;
    Object [][] klienci_data;
    Object [][] wyp_data;
    public tabele(Connection baza) throws SQLException {
        this.baza.con(baza);
        zniana_tabel.setModel(new DefaultComboBoxModel(new String[] {"Kary","Filmy","Klienci","Wypożyczenia"}));
        kary_data = this.baza.getkara();
        filmy_data = this.baza.getfilmy();
        klienci_data = this.baza.getklienci();
        wyp_data = this.baza.getwypo();
        createTable();
        zniana_tabel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedOption = (String) zniana_tabel.getSelectedItem();
                if(selectedOption == "Kary")
                {
                    setTable(kary,kary_data);
                }
                else if(selectedOption == "Filmy")
                {
                    setTable(filmy,filmy_data);
                }
                else if(selectedOption == "Klienci")
                {
                    setTable(klienci,klienci_data);
                }
                else if(selectedOption == "Wypożyczenia")
                {
                    setTable(wyp,wyp_data);
                }
            }
        });
    }
    private void createTable() throws SQLException {
        setTable(kary,kary_data);
    }
    private void setTable(String[] tytul, Object [][] data)
    {
        tabela.setModel(new DefaultTableModel(data,tytul));
    }
    public void reload() throws SQLException {
        kary_data = this.baza.getkara();
        filmy_data = this.baza.getfilmy();
        klienci_data = this.baza.getklienci();
        wyp_data = this.baza.getwypo();
        String selectedOption = (String) zniana_tabel.getSelectedItem();
        if(selectedOption == "Kary")
        {
            setTable(kary,kary_data);
        }
        else if(selectedOption == "Filmy")
        {
            setTable(filmy,filmy_data);
        }
        else if(selectedOption == "Klienci")
        {
            setTable(klienci,klienci_data);
        }
        else if(selectedOption == "Wypożyczenia")
        {
            setTable(wyp,wyp_data);
        }
    }
}
