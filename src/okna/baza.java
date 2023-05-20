package okna;

import java.sql.*;

public class baza {
    private static final String URL = "jdbc:mariadb://localhost:3306/bazaprojekt";
    private static final String user = "root";
    private static final String password = "";
    Connection con;
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
    private Object[][] getObj(ResultSet resultSet) throws SQLException {
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

}
