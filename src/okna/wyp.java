package okna;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class wyp {
    public JPanel wyp;
    private JComboBox film;
    private JFormattedTextField data;
    private JComboBox klient;
    private JFormattedTextField długość;
    private JFormattedTextField cena;
    private JButton dodajButton;
    private ArrayList<String> filmh = new ArrayList<>();
    private HashMap<String,String> filmd = new HashMap<>();
    private ArrayList<String> klienth = new ArrayList<>();
    private HashMap<String,String> klientd = new HashMap<>();
    LocalDate currentDate = LocalDate.now();
    baza pom = new baza();
    public wyp(Connection baza, tabele tab) throws SQLException {
        pom.con(baza);
        wczytajfilm();
        wczytajklienta();
        film.setModel(new DefaultComboBoxModel(filmh.toArray()));
        klient.setModel(new DefaultComboBoxModel(klienth.toArray()));
        data.setText(currentDate.toString());
        dodajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(data.getText().isEmpty() || długość.getText().isEmpty() || cena.getText().isEmpty())
                {

                }
                else
                {
                    try {
                        wypozycz(filmd.get(film.getSelectedItem().toString()),klientd.get(klient.getSelectedItem().toString()),data.getText().toString(),długość.getText().toString(),cena.getText().toString());
                        data.setText(currentDate.toString());
                        długość.setText("");
                        cena.setText("");
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    try {
                        tab.reload();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
    }
    private void wczytajfilm() throws SQLException {
        String sqlQuery1 = "CALL filmy2()";
        String sqlQuery2 = "SELECT * FROM filmy2";
        Statement statement = pom.con.createStatement();
        statement.executeQuery(sqlQuery1);
        ResultSet resultSet = statement.executeQuery(sqlQuery2);
        Object[][] po = pom.getObj(resultSet);
        for(Object[] x : po)
        {
         filmh.add(x[1].toString());
         filmd.put(x[1].toString(),x[0].toString());
        }
    }
    private void wczytajklienta() throws SQLException {
        String sqlQuery1 = "CALL klienci2()";
        Statement statement = pom.con.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuery1);
        Object[][] po = pom.getObj(resultSet);
        for(Object[] x : po)
        {
            klienth.add(x[1].toString()+" "+x[2].toString());
            klientd.put(x[1].toString()+" "+x[2].toString(),x[0].toString());
        }
    }
    private void wypozycz(String film,String klient, String data, String dlugosc, String cena) throws SQLException {
        String sqlQuery1 = "INSERT INTO wypożyczenia VALUES(null,"+film+","+klient+",'"+data+"',"+dlugosc+","+cena+")";
        Statement statement = pom.con.createStatement();
        statement.executeQuery(sqlQuery1);
    }
    public void reload() throws SQLException {
        wczytajfilm();
        wczytajklienta();
        film.setModel(new DefaultComboBoxModel(filmh.toArray()));
        klient.setModel(new DefaultComboBoxModel(klienth.toArray()));
    }
}
