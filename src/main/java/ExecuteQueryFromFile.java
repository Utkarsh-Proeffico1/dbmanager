
import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.PrintWriter;
import java.sql.*;

public class ExecuteQueryFromFile {

    public static void runScript(String path,Connection connection) throws Exception {
        PrintWriter logWriter = new PrintWriter(System.out);
        ScriptRunner scriptRunner = new ScriptRunner(connection);
        scriptRunner.setSendFullScript(true);
        scriptRunner.setAutoCommit(false);
        scriptRunner.setStopOnError(true);
        scriptRunner.runScript(new java.io.FileReader(path));
        scriptRunner.setLogWriter(logWriter);
    }
}
