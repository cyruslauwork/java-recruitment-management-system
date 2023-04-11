package rms;
import java.sql.*;
import java.util.*;


public class DatabaseConnector {
	private static final String DATABASE_URL = "jdbc:mysql://localhost/recruitment_db";
	   private static final String DATABASE_USERNAME = "username";
	   private static final String DATABASE_PASSWORD = "password";
	   private static final List<String> tableNames = Arrays.asList("Candidates", "Employers", "JobDescriptions", "Applications");
	   
	   public static Connection getConnection() throws SQLException {
	      return DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
	   }
	   public static void tablechecker() {
		   try (Connection conn = DatabaseConnector.getConnection()) {
			   DatabaseMetaData meta = conn.getMetaData();
	            for (String tableName : tableNames) {
	                ResultSet tables = meta.getTables(null, null, tableName, null);
	                if (tables.next()) {
	                    System.out.println(tableName + " table exists.");
	                } else {
	                    System.out.println(tableName + " table does not exist. Creating it now...");
	                    Statement statement = conn.createStatement();
	                    String sql = null;
	                    switch (tableName) {
	                        case "Candidates":
	                        	sql = "CREATE TABLE Candidates (" +
	                                    "id INT PRIMARY KEY AUTO_INCREMENT," +
	                                    "name VARCHAR(255) NOT NULL," +
	                                    "email VARCHAR(255) NOT NULL," +
	                                    "phone VARCHAR(20)," +
	                                    "address VARCHAR(255)," +
	                                    "education VARCHAR(255)," +
	                                    "work_experience VARCHAR(255)," +
	                                    "skills VARCHAR(255)" +
	                                    ")";
	                            break;
	                        case "Employers":
	                        	sql = "CREATE TABLE Employers (" +
	                                    "id INT PRIMARY KEY AUTO_INCREMENT," +
	                                    "name VARCHAR(255) NOT NULL," +
	                                    "email VARCHAR(255) NOT NULL," +
	                                    "phone VARCHAR(20)," +
	                                    "address VARCHAR(255)," +
	                                    "description VARCHAR(255)," +
	                                    "industry VARCHAR(255)" +
	                                    ")";
	                            break;
	                        case "JobDescriptions":
	                        	sql = "CREATE TABLE JobDescriptions ("
	                        			+ "id INT PRIMARY KEY, "
	                        			+ "job_title VARCHAR(50), "
	                        			+ "job_description TEXT, "
	                        			+ "job_responsibilities TEXT, "
	                        			+ "job_requirements TEXT, "
	                        			+ "salary DECIMAL(10,2),"
	                        			+ "post_date DATE, "
	                        			+ "employer_id INT,"
	                        			+ "FOREIGN KEY (employer_id) REFERENCES Employers(id))";
	                            break;
	                        case "Applications":
	                        	sql = "CREATE TABLE Applications ("
	                        			+ "id INT PRIMARY KEY, "
	                        			+ "apply_date DATE, "
										+ "candidate_id INT, "
	                        			+ "FOREIGN KEY (candidate_id) REFERENCES Candidates(id),"
										+ "job_id INT,"
	                        			+ "FOREIGN KEY (job_id) REFERENCES JobDescriptions(id))";
	                        	break;
	                        default:
	                            System.out.println("Invalid table name.");
	                            break;
	                    }
	                    if (sql != null) {
	                        statement.executeUpdate(sql);
	                        System.out.println(tableName + " table created.");
	                    }
	                }
	            }
	        } catch (SQLException e) {
	            System.out.println("Error checking/creating table: " + e.getMessage());
	        }
	   }
	   
}
