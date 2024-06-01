import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;

public class ExecuteQueryFromFile {

    static void executeQueriesFromFile(Connection connection, String filePath) {
        try {
            String queries = new String(Files.readAllBytes(Paths.get(filePath)));
            String[] queryArray = queries.split(";\\s*");
            for (String query : queryArray) {
                if (query.trim().isEmpty()) continue;
                try (Statement statement = connection.createStatement()) {
                    boolean isResultSet = statement.execute(query);
                    if (isResultSet) {
                        try (ResultSet rs = statement.getResultSet()) {
                            ResultSetMetaData rsmd = rs.getMetaData();
                            int columnsNumber = rsmd.getColumnCount();
                            while (rs.next()) {
                                for (int i = 1; i <= columnsNumber; i++) {
                                    if (i > 1) System.out.print(", ");
                                    String columnValue = rs.getString(i);
                                    System.out.print(rsmd.getColumnName(i) + ": " + columnValue);
                                }
                                System.out.println();
                            }
                        }
                    } else {
                        int updateCount = statement.getUpdateCount();
                        System.out.println("Query OK, " + updateCount + " rows affected.");
                    }
                } catch (SQLException e) {
                    System.out.println("Query execution error: " + query.trim());
                    System.out.println("Something went wrong ->: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("SQL file reading error: " + e.getMessage());
        }
    }
}
