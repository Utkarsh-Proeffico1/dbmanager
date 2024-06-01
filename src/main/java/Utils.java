public class Utils {
    static String getDriverClass(String dbType) {
        switch (dbType.toLowerCase()) {
            case "mysql":
                return "com.mysql.cj.jdbc.Driver";
            case "oracle":
                return "oracle.jdbc.driver.OracleDriver";
            default:
                return null;
        }
    }

    static String getJdbcUrl(String dbType, String dbUrl) {
        switch (dbType.toLowerCase()) {
            case "mysql":
                return "jdbc:mysql://" + dbUrl;
            case "oracle":
                return "jdbc:oracle:thin:@" + dbUrl;
            default:
                return null;
        }
    }
}
