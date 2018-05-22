package utility;

import initialization.Config;

import java.sql.*;

/**
 * Created by eduard.climov on 6/20/2017.
 */
public class DBConnection {

    private Connection connection;

    public DBConnection(String project, String dbName) throws SQLException {
        String dbusername;
        String connectionUrl;
        String dbpassword;
        if(project.equalsIgnoreCase("autotest")){
            dbusername = Config.getAutotestDbusername();
            dbpassword = Config.getAutotestDbpassword();
            connectionUrl = "jdbc:sqlserver://" + Config.getAutotestDbUrl() + ";DatabaseName=" + dbName;
        } else{
            dbusername = Config.getDbUsername();
            dbpassword = Config.getDbPassword();
            connectionUrl = "jdbc:sqlserver://" + Config.getDbUrl() + ";DatabaseName=" + dbName;
        }

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        connection = DriverManager.getConnection(connectionUrl, dbusername, dbpassword);

        if (connection != null) {
            System.out.println("\nConnected to the database: " + connectionUrl);
        } else {
            System.out.println("Failed to connect to '"+project+"' " + dbName + " database");
        }
    }

    public ResultSet executeSQL(String query) {
        //System.out.println("Try to execute: "+query);
        ResultSet result = null;
        try {
            Statement stmt = connection.createStatement();
            boolean gotResults = stmt.execute(query, Statement.RETURN_GENERATED_KEYS);
            if(gotResults) {
                result = stmt.getResultSet();
            }
        } catch (SQLException sqlEx) {
            System.out.println("SQL Exception:" + sqlEx.getStackTrace() + "\n Message: " + sqlEx.getMessage()+"\n Query: "+query);
        }
        return result;
    }

    //Returns inserted value id
    public int executeInsert(String query){
        int resultKey = -1;
        try {
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            resultKey = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultKey;
    }

    public void closeConnection() {
        try {
            if (connection != null) {
                this.connection.close();
                System.out.println("DB connection closed");
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception:" + e.getStackTrace() + "\n" + e.getMessage());
        }
    }
}