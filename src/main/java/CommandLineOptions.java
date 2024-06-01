import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class CommandLineOptions {
     static Options getOptions() {
        Options options = new Options();

        Option username = new Option("u", "username", true, "DB username");
        username.setRequired(true);
        options.addOption(username);

        Option password = new Option("p", "password", true, "DB password");
        password.setRequired(true);
        options.addOption(password);

        Option dbUrl = new Option("d", "dburl", true, "DB URL (host:port/db_name)");
        dbUrl.setRequired(true);
        options.addOption(dbUrl);

        Option dbType = new Option("dbtype", "dbtype", true, "DB type (mysql or oracle)");
        dbType.setRequired(true);
        options.addOption(dbType);

        Option queryFile = new Option("q", "queryfile", true, "SQL file path");
        queryFile.setRequired(true);
        options.addOption(queryFile);


        return options;
    }
}
