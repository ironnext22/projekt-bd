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

public class zwroty {
    public JPanel zwrot;
    private JComboBox wypożyczenie;
    private JFormattedTextField data;
    private JButton Dodaj;
    baza pom = new baza();
    private ArrayList<String> wyph = new ArrayList<>();
    private HashMap<String,String> wypd = new HashMap<>();
    LocalDate currentDate = LocalDate.now();

    public zwroty(Connection baza, wyp wyp, tabele tab) throws SQLException {
        pom.con(baza);
        wczytwyp();
        wypożyczenie.setModel(new DefaultComboBoxModel(wyph.toArray()));
        data.setText(currentDate.toString());
        Dodaj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(data.getText().isEmpty())
                {

                }
                else
                {
                    try {
                        dodajzwrot(wypd.get(wypożyczenie.getSelectedItem().toString()),data.getText().toString());
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    try {
                        wyp.reload();
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
    public void wczytwyp() throws SQLException {
        String sqlQuery1 = "CALL wypożyczenia2()";
        Statement statement = pom.con.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuery1);
        Object[][] po = pom.getObj(resultSet);
        for(Object[] x : po)
        {
            wyph.add(x[1].toString()+" , "+x[2].toString());
            wypd.put(x[1].toString()+" , "+x[2].toString(),x[0].toString());
        }
    }
    public void dodajzwrot(String wyp, String data) throws SQLException {
        String sqlQuery1 = "INSERT INTO zwroty VALUES(null,"+wyp+",'"+data+"')";
        Statement statement = pom.con.createStatement();
        statement.executeQuery(sqlQuery1);
    }
}
