import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import static generated.Tables.*;


/**
 * 3 examples of SQL requests (2 SELECT, 1 UPDATE) with the internal DSL JOOQ
 * @author Robin Hacault - M2 GL
 */
public class Queries {

	public static void main(String[] args) {
		Connection conn = null;

		String userName = "root";
		String password = "";
		String url = "jdbc:mysql://localhost:3307/idmdatabase";

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url, userName, password);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				// Select all of the users which are in the table
				selectAllUsers(conn);
				// Select the users which age >=20 and <=50
				selectUsersFrom20To50Years(conn);
				// Increment the age of users which have a firstname starting by "D"
				incAgeUsersStartsWith_D_FirstName(conn);
				// Select all of the users which are in the table
				selectAllUsers(conn);
				try {
					conn.close();
				} catch (SQLException ignore) {
				}
			}
		}
	}
	
	/**
	 * Select all of the users from the database and print the result
	 * @param conn The connection to the database
	 */
	private static void selectAllUsers(Connection conn) {
		DSLContext create = DSL.using(conn, SQLDialect.MYSQL);
		Result<Record> result = create.select()
									  .from(USERS)
									  .fetch();		
		printUsersResults(result, "Sélection de tous les utilisateurs");		
	}
	
	/**
	 * Select the users with age >= 20 and <=50
	 * @param conn The connection to the database
	 */
	private static void selectUsersFrom20To50Years(Connection conn) {
		DSLContext create = DSL.using(conn, SQLDialect.MYSQL);
		Result<Record> result = create.select()
									  .from(USERS)
									  .where(USERS.AGE.between(20, 50))
									  .fetch();		
		printUsersResults(result, "Sélection des utilisateurs entre 20 et 50 ans");
		
	}
	
	/**
	 * Increment of 1 the age of the users which have a firstname starting with "D"
	 * @param conn The connection to the database
	 */
	private static void incAgeUsersStartsWith_D_FirstName(Connection conn) {
		DSLContext create = DSL.using(conn, SQLDialect.MYSQL);
		create.update(USERS)
		      .set(USERS.AGE, USERS.AGE.add(1))
		      .where(USERS.FIRST_NAME.startsWith("D"))
		      .execute();
		System.out.println("----- Age of users with firstname starting by 'D' is now incremented -----\n");
	}
	
	/**
	 * Print to the console the results of a select query on all fields
	 */
	private static void printUsersResults(Result<Record> result, String msg) {
		StringBuilder sb = new StringBuilder("");
		sb.append("---------- ").append(msg).append(" ---------- \n");
		for (Record record : result) {
			sb.append(record.getValue(USERS.ID)).append("\t-->\t")
			  .append(record.getValue(USERS.FIRST_NAME)).append("\t-->\t")
			  .append(record.getValue(USERS.LAST_NAME)).append("\t-->\t")
			  .append(record.getValue(USERS.AGE)).append("\n");
		}
		System.out.println(sb.toString());
	}

}
