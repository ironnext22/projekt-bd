package okna;

import java.sql.*;

public class baza {
    private static final String URL = "jdbc:mariadb://localhost:3306/bazaprojekt";
    private static final String user = "root";
    private static final String password = "";
    public Connection con;
    public void con(Connection connection)
    {
        con=connection;
    }

    public static Connection connect()
    {
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(URL, user, password);
            System.out.println("Connected to database!");
        } catch (SQLException e) {
            System.err.println("Error connecting to database: " + e.getMessage());
        }
        return connection;
    }
    public Object[][] getkara() throws SQLException {
        String sqlQuery1 = "CALL kary()";
        String sqlQuery2 = "SELECT * FROM kara";
        Statement statement = con.createStatement();
        statement.executeQuery(sqlQuery1);
        ResultSet resultSet = statement.executeQuery(sqlQuery2);

        return getObj(resultSet);
    }
    public Object[][] getfilmy() throws SQLException {
        String sqlQuery1 = "CALL filmy()";
        String sqlQuery2 = "SELECT * FROM filmyl";
        Statement statement = con.createStatement();
        statement.executeQuery(sqlQuery1);
        ResultSet resultSet = statement.executeQuery(sqlQuery2);
        return getObj(resultSet);
    }
    public Object[][] getklienci() throws SQLException
    {
        String sqlQuery1 = "CALL klienci()";
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuery1);
        return getObj(resultSet);
    }
    public Object[][] getwypo() throws SQLException
    {
        String sqlQuery1 = "CALL wypożyczenia()";
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuery1);
        return getObj(resultSet);
    }
    public Object[][] getObj(ResultSet resultSet) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        resultSet.last();
        int rowCount = resultSet.getRow();
        resultSet.beforeFirst();


        Object[][] kara = new Object[rowCount][columnCount];
        int row = 0;
        while(resultSet.next())
        {
            for (int col = 1; col <= columnCount; col++) {
                kara[row][col - 1] = resultSet.getObject(col);
            }
            row++;
        }
        return kara;
    }
    public void addGatunek(String gatunek) throws SQLException
    {
        String sqlQuery1 = "INSERT INTO gatunek VALUES(null,'"+gatunek+"')";
        Statement statement = con.createStatement();
        statement.executeQuery(sqlQuery1);
    }
    public void addRez(String imie, String nazwisko) throws SQLException
    {
        String sqlQuery1 = "INSERT INTO reżyser VALUES(null,'"+imie+"','"+nazwisko+"')";
        Statement statement = con.createStatement();
        statement.executeQuery(sqlQuery1);
    }
    public void addAktor(String imie, String nazwisko,String narodowość) throws SQLException
    {
        String sqlQuery1 = "INSERT INTO aktor VALUES(null,'"+imie+"','"+nazwisko+"','"+narodowość+"')";
        Statement statement = con.createStatement();
        statement.executeQuery(sqlQuery1);
    }
    public void addwytw(String wytw) throws SQLException
    {
        String sqlQuery1 = "INSERT INTO wytwórnia VALUES(null,'"+wytw+"')";
        Statement statement = con.createStatement();
        statement.executeQuery(sqlQuery1);
    }
    public void addfilm(String tytul,Integer rez,Integer gat, Integer wytw, Integer RG) throws SQLException
    {
        String rezs = Integer.toString(rez);
        String gats = Integer.toString(gat);
        String wytws = Integer.toString(wytw);
        String RGS = Integer.toString(RG);
        String sqlQuery1 = "INSERT INTO filmy VALUES(null,'"+tytul+"',"+rezs+","+gats+","+wytws+","+RGS+")";
        Statement statement = con.createStatement();
        statement.executeQuery(sqlQuery1);
    }
    public void addklient(String imie,String nazwisko, String pesel, String adres, String kod, String miejscowość, String nr, String mail) throws SQLException {
        String sqlQuery1 = "INSERT INTO klienci VALUES(null,'"+imie+"','"+nazwisko+"',"+pesel+",'"+adres+"','"+kod+"','"+miejscowość+"',"+nr+",'"+mail+"')";
        Statement statement = con.createStatement();
        statement.executeQuery(sqlQuery1);
    }
}
