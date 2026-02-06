package it.tommaso.uniroma2.model.dao.dbconnect;

import it.tommaso.uniroma2.model.Ruolo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
    private static Connection utenteConnection;
    private static Connection libriConnection;

    private ConnectionFactory() {}

    static {
        // stabilisce connessione al database contenente le info degli utenti del sistema
        try (InputStream input = new FileInputStream("src/main/resources/db.properties")) {
            Properties properties = new Properties();
            properties.load(input);

            String connection_url = properties.getProperty("UTENTI_CONNECTION_URL");
            String user = properties.getProperty("LOGIN_USER");
            String pass = properties.getProperty("LOGIN_PASS");

            utenteConnection = DriverManager.getConnection(connection_url, user, pass);
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

        // stabilisce la connessione al database contenente le info dei libri salvati nel
        // database locale
        try (InputStream input = new FileInputStream("src/main/resources/db.properties")){
            Properties properties = new Properties();
            properties.load(input);

            String connection_url = properties.getProperty("LIBRI_CONNECTION_URL");
            String user = properties.getProperty("LETTORE_USER");
            String pass = properties.getProperty("LETTORE_PASS");

            libriConnection = DriverManager.getConnection(connection_url, user, pass);
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

    }

    public static Connection getUtentiConnection() throws SQLException {
        return utenteConnection;
    }

    public static Connection getLibriConnection() throws SQLException{
        return libriConnection;
    }


    public static void changeRole(Ruolo role) throws SQLException {
        utenteConnection.close();

        try (InputStream input = new FileInputStream("src/main/resources/db.properties")) {
            Properties properties = new Properties();
            properties.load(input);



            String connection_url = properties.getProperty("CONNECTION_URL");
            String user = properties.getProperty(role.name() + "_USER");
            String pass = properties.getProperty(role.name() + "_PASS");


            utenteConnection = DriverManager.getConnection(connection_url, user, pass);
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
