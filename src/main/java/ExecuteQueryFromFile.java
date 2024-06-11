
import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.PrintWriter;
import java.sql.*;

public class ExecuteQueryFromFile {

    public static void runScriptWithStatements(String path,Connection connection) throws Exception {
        PrintWriter logWriter = new PrintWriter(System.out);
        ScriptRunner scriptRunner = new ScriptRunner(connection);
        scriptRunner.setSendFullScript(false);
        scriptRunner.setAutoCommit(false);
        scriptRunner.setStopOnError(true);
        scriptRunner.setLogWriter(logWriter);

        scriptRunner.runScript(new java.io.FileReader(path));
    }

    public static void runScriptWithFunctions(String path,Connection connection) throws Exception {
        PrintWriter logWriter = new PrintWriter(System.out);
        ScriptRunner scriptRunner = new ScriptRunner(connection);
        scriptRunner.setSendFullScript(true);
        scriptRunner.setAutoCommit(false);
        scriptRunner.setStopOnError(true);
        scriptRunner.setLogWriter(logWriter);

        scriptRunner.runScript(new java.io.FileReader(path));
    }
}
