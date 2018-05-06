package models;

import java.sql.*;

public class DAO {

    private Connection connection;
    private Statement statement;

    public DAO() throws Exception{

        String user = "root";
        String password = "1020";

        Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost/ts1?" +
                        "user=" + user + "&password="+ password);

        statement = connection.createStatement();
    }

    public ResultSet executeSQL(String query) throws Exception{
        return statement.executeQuery(query);
    }

    public void execute(String query) throws Exception{
        statement.executeUpdate(query);
    }

    public void disconnectDb() throws Exception{
        statement.close();
        connection.close();
    }
}
