package testaj;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.javalite.activejdbc.Base;

import javax.sql.DataSource;

public class Database {

    private static final Database instance = new Database();

    private static final String HOST = "jdbc:mysql://127.0.0.1:3306/";
    private static final String DATABASE = "testdb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String PARAMETERS = "autoReconnect=true&useSSL=false";
    private static final String URL = HOST + DATABASE + "?" + PARAMETERS;
    private DataSource dataSource;

    public static Database get() {
        return instance;
    }

    public void init() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(URL);
        config.setUsername(USERNAME);
        config.setPassword(PASSWORD);
        this.dataSource = new HikariDataSource(config);
    }

    public void openCon() {
        Base.open(dataSource);
    }

    public void close() {
        Base.close();
    }
}
