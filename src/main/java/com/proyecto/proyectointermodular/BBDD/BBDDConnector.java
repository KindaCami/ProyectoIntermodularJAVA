package com.proyecto.proyectointermodular.BBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *  Este archivo es una plantilla para la conexión a base de datos.
 * Sustituye los valores de USER, PASSWORD y URL por los tuyos.
 * Para no subir mis credenciales a GitHub.
 */

public class BBDDConnector {
    private static BBDDConnector instance = null;
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/proyectointermodular?autoReconnect=true&useSSL=false";
    private Connection connection;

    private final Properties props;


    // Constructor privado
    private BBDDConnector() {
        props = new Properties();
        props.setProperty("user", "");
        props.setProperty("password", "");

        conectar();
    }

    // Metodo que conecta
    private void conectar() {
        try {
            connection = DriverManager.getConnection(JDBC_URL, props);
            System.out.println("✅ Conexión exitosa a la base de datos.");
        } catch (SQLException e) {
            System.out.println(" Error al conectar con la base de datos:");
            e.printStackTrace();
        }
    }

    // Singleton
    public static BBDDConnector getInstance() {
        if (instance == null) {
            instance = new BBDDConnector();
        }
        return instance;
    }

    // Metodo que reintenta conexion en caso de cerrarse
    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                System.out.println("🔄 La conexión estaba cerrada. Reconectando...");
                conectar();
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al verificar la conexión:");
            e.printStackTrace();
        }
        return connection;
    }
}


