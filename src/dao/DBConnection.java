package dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static Connection connection = null;
    private static String dbConnectionString = ("jdbc:h2:tcp://localhost/~/Einzelbeispiel2");
    private static String user = ("sa");
    private static String password = null;
    private DBConnection instance = null;

    private static final Logger log = LogManager.getLogger(DBConnection.class);

    public DBConnection() {

    }

    //Öffnet die Verbindung zur Datenbank
    public void openConnection() {

        log.info("Opening DB Connection ...");

        try {
            //Wenn die Connection null ist eine neue Connection aufmachen
            if (connection == null) {
                try {
                    Class.forName("org.h2.Driver");
                } catch (ClassNotFoundException e) {

                }
                connection = DriverManager.getConnection(dbConnectionString,
                        user, password);
            }

            log.info("DB Connection successfully opened ...");

            //Falls dabei ein Fehler auftritt
        } catch (SQLException f) {
            log.info("Opening Connection to the DB failed ...");
            log.info(f.getMessage());
        }

    }

    //Gibt die Connection zur DB zurück
    public Connection getConnection() {

        log.info("Returning the Connection to the DB ...");

        //Wenn die Connection null ist, eine neue Connection aufmachen
        //andernfalls die bestehende zurück geben
        if (connection != null) {
            return connection;
        } else {
            openConnection();
            return connection;
        }
    }

    //Gibt die Instanz der Klasse DBConnection zurück
    public DBConnection getInstance() {

        log.info("Returning the Instance of the DB Connection ...");

        //Wenn die Connection null ist dann eine neue Instanz erstellen
        //und diese zurück geben
        if (connection == null) {
            instance = new DBConnection();
            return instance;
        } else {

            return null;
        }

    }

    public void closeConnection() {

        log.info("Closing the DB Connection ...");

        try {

            if (connection != null) {

                connection.close();

                log.info("Closing of the DB Conncetion successful ...");

            }
        } catch (SQLException e) {
            log.info("Closing of the Connection to the DB failed ...");
            log.info(e.getMessage());
        }

    }

}
