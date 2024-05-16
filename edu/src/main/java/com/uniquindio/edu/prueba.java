package com.uniquindio.edu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@SpringBootApplication
public class prueba implements CommandLineRunner {

    @Autowired
    private Environment env;

    public static void main(String[] args) {
        SpringApplication.run(prueba.class, args);
    }

    @Override
    public void run(String... args) {
        // Lee las propiedades de conexión desde application.properties
        String jdbcUrl = env.getProperty("spring.datasource.url");
        String username = env.getProperty("spring.datasource.username");
        String password = env.getProperty("spring.datasource.password");

        // Declara los objetos Connection y Statement
        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
             Statement statement = connection.createStatement()) {

            // Ejecuta la consulta SQL para mostrar las tablas
            String sql = "SELECT table_name FROM user_tables";
            try (ResultSet resultSet = statement.executeQuery(sql)) {
                // Itera sobre los resultados y muestra los nombres de las tablas
                while (resultSet.next()) {
                    String tableName = resultSet.getString("table_name");
                    System.out.println("Tabla: " + tableName);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
