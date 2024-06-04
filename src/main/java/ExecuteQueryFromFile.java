
import org.apache.ibatis.jdbc.ScriptRunner;

import java.sql.*;

public class ExecuteQueryFromFile {

    public static void runScript(String path,Connection connection) throws Exception {
        ScriptRunner scriptRunner = new ScriptRunner(connection);
        scriptRunner.setSendFullScript(false);
        scriptRunner.setAutoCommit(false);
        scriptRunner.setStopOnError(true);
        scriptRunner.runScript(new java.io.FileReader(path));

    }
}
