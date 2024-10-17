package db;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConexionBBDD {
	
	private final Connection connection;
	
	public ConexionBBDD() throws SQLException {
		 Properties connConfig = new Properties();
         connConfig.setProperty("user", "root");
         connConfig.setProperty("password", "mypass");
         connection = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:33066/personas?serverTimezone=Europe/Madrid", connConfig);
         connection.setAutoCommit(true);
         DatabaseMetaData databaseMetaData = connection.getMetaData();
       //debug
         /*
         System.out.println();
         System.out.println("--- Datos de conexión ------------------------------------------");
         System.out.printf("Base de datos: %s%n", databaseMetaData.getDatabaseProductName());
         System.out.printf("  Versión: %s%n", databaseMetaData.getDatabaseProductVersion());
         System.out.printf("Driver: %s%n", databaseMetaData.getDriverName());
         System.out.printf("  Versión: %s%n", databaseMetaData.getDriverVersion());
         System.out.println("----------------------------------------------------------------");
         System.out.println();
         */
         connection.setAutoCommit(true);
	}
	
	public Connection getConnection() {
		return connection;
	}
	
	public Connection CloseConexion() throws SQLException{
		connection.close();
        return connection;
    }
}
