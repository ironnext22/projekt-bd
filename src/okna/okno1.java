package okna;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

public class okno1 {
    public JPanel test;
    private JTable tabela;
    private JComboBox zniana_tabel;
    baza baza = new baza();

    String[] kary = new String[] {"tytul","klient","pesel","data_wypożyczenia","data zwrotu","dni wypożyczenia","po terminie","kara"};
    String[] filmy = new String[] {"tytul","gatynek","reżyser","wytwórnia","rola główna"};
    String[] klienci = new String[] {"klient","adres","kod pocztowy","miejscowość","nr. telefonu","mail"};

    Object [][] kary_data;
    Object [][] filmy_data;
    Object [][] klienci_data;
    public okno1(Connection baza) throws SQLException {
        this.baza.con(baza);
        zniana_tabel.setModel(new DefaultComboBoxModel(new String[] {"Kary","filmy","klienci"}));
        kary_data = this.baza.getkara();
        filmy_data = this.baza.getfilmy();
        klienci_data = this.baza.getklienci();
        createTable();
        zniana_tabel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedOption = (String) zniana_tabel.getSelectedItem();
                if(selectedOption == "Kary")
                {
                    setTable(kary,kary_data);
                }
                else if(selectedOption == "filmy")
                {
                    setTable(filmy,filmy_data);
                }
                else if(selectedOption == "klienci")
                {
                    setTable(klienci,klienci_data);
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
}
