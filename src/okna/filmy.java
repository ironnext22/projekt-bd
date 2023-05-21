package okna;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class filmy {
    public JPanel filmy;
    private JFormattedTextField tytul;
    private JComboBox rezyser;
    private JComboBox gatunek;
    private JComboBox wytw;
    private JComboBox grola;
    private JButton dodaj;
    private tabele po;
    private ArrayList<String> rez = new ArrayList<>();
    private HashMap<String,Integer> rezw = new HashMap<>();
    private ArrayList<String> gat = new ArrayList<>();
    private HashMap<String,Integer> gatw = new HashMap<>();
    private ArrayList<String> wyt = new ArrayList<>();
    private HashMap<String,Integer> wytww= new HashMap<>();
    private ArrayList<String> rol = new ArrayList<>();
    private HashMap<String,Integer> rolw= new HashMap<>();
    public baza bazapom = new baza();
    public filmy(Connection baza,tabele p, wyp wyp) throws SQLException {
        this.po = p;
        this.bazapom.con(baza);
        wczytajrez();
        wczytajgatuenk();
        wczytajwytw();
        wczytajrol();
        rezyser.setModel(new DefaultComboBoxModel(rez.toArray()));
        gatunek.setModel(new DefaultComboBoxModel(gat.toArray()));
        wytw.setModel(new DefaultComboBoxModel(wyt.toArray()));
        grola.setModel(new DefaultComboBoxModel(rol.toArray()));
        dodaj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==dodaj)
                {
                    if(tytul.getText().isEmpty())
                    {

                    }
                    else
                    {
                        try {
                            bazapom.addfilm(tytul.getText(),rezw.get(rezyser.getSelectedItem().toString()),gatw.get(gatunek.getSelectedItem().toString()),wytww.get(wytw.getSelectedItem().toString()),rolw.get(grola.getSelectedItem().toString()));
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                        try {
                            po.reload();
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
    private void wczytajrez() throws SQLException {
        String sqlQuery1 = "SELECT * FROM reżyser";
        Statement statement = bazapom.con.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuery1);
        Object[][] pom = bazapom.getObj(resultSet);
        for(Object[] x : pom)
        {
            rez.add(x[1].toString()+" "+x[2].toString());
            rezw.put(x[1].toString()+" "+x[2].toString(),Integer.parseInt(x[0].toString()));
        }
    }
    private void wczytajgatuenk() throws SQLException
    {
        String sqlQuery1 = "SELECT * FROM gatunek";
        Statement statement = bazapom.con.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuery1);
        Object[][] pom = bazapom.getObj(resultSet);
        for(Object[] x : pom)
        {
            gat.add(x[1].toString());
            gatw.put(x[1].toString(),Integer.parseInt(x[0].toString()));
        }
    }
    private void wczytajwytw() throws SQLException
    {
        String sqlQuery1 = "SELECT * FROM wytwórnia";
        Statement statement = bazapom.con.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuery1);
        Object[][] pom = bazapom.getObj(resultSet);
        for(Object[] x : pom)
        {
            wyt.add(x[1].toString());
            wytww.put(x[1].toString(),Integer.parseInt(x[0].toString()));
        }
    }
    private void wczytajrol() throws SQLException {
        String sqlQuery1 = "SELECT * FROM aktor";
        Statement statement = bazapom.con.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuery1);
        Object[][] pom = bazapom.getObj(resultSet);
        for(Object[] x : pom)
        {
            rol.add(x[1].toString()+" "+x[2].toString());
            rolw.put(x[1].toString()+" "+x[2].toString(),Integer.parseInt(x[0].toString()));
        }
    }
    public void reload() throws SQLException {
        wczytajrez();
        wczytajgatuenk();
        wczytajwytw();
        wczytajrol();
        rezyser.setModel(new DefaultComboBoxModel(rez.toArray()));
        gatunek.setModel(new DefaultComboBoxModel(gat.toArray()));
        wytw.setModel(new DefaultComboBoxModel(wyt.toArray()));
        grola.setModel(new DefaultComboBoxModel(rol.toArray()));
    }
}
