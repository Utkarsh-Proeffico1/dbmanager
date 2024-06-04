import org.apache.commons.cli.*;
import java.sql.*;

public class DbConfig {

    public static void main(String[] args) {

        Options options = CommandLineOptions.getOptions();

        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine cmd;

        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("dbconfig", options);
            System.exit(1);
            return;
        }

        String user = cmd.getOptionValue("username");
        String pass = cmd.getOptionValue("password");
        String dbUrlValue = cmd.getOptionValue("dburl");
        String dbTypeValue = cmd.getOptionValue("dbtype");
        String queryFilePath = cmd.getOptionValue("queryfile");

        String driverClass = Utils.getDriverClass(dbTypeValue);
        String jdbcUrl = Utils.getJdbcUrl(dbTypeValue, dbUrlValue);

        if (driverClass == null || jdbcUrl == null) {
            System.out.println("Unsupported database type: " + dbTypeValue);
            System.exit(1);
            return;
        }

        try {
            Class.forName(driverClass);
            try (Connection connection = DriverManager.getConnection(jdbcUrl, user, pass)) {
                connection.setAutoCommit(false);
                try {
                    ExecuteQueryFromFile.runScript(queryFilePath, connection);
                    connection.commit();
                    System.out.println("Query OK");
                } catch (Exception e) {
                    connection.rollback();
                    System.out.println("Error executing script, all changes have been rolled back: " + e.getMessage());
                }
            } catch (SQLException e) {
                System.out.println("Database connection error: " + e.getMessage());
            }
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found: " + e.getMessage());
        }
    }
}
