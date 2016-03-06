package com.dal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import com.model.Queriesdto;
import com.dal.Database_Controller;
public class Queriesdao {
	

	        private Database_Controller databaseController = Database_Controller.getDatabase_Controller();

	        public int create() {
	            Connection conn = null;
	            PreparedStatement stmt = null;

	            try {
	                conn = databaseController.getConnection();
	                stmt = conn.prepareStatement("insert into queries(queriesid,text,date) values (?, ?, ?)");
	                final int result = stmt.executeUpdate();
	                return result;

	            } catch (final Exception e) {
	                e.printStackTrace();
	                return 0;
	            } finally {
	                databaseController.close(stmt, conn);
	            }
	        }

	        public int update() {
	            Connection conn = null;
	            PreparedStatement stmt = null;

	            try {
	                conn = databaseController.getConnection();
	                stmt = conn.prepareStatement("update queries set text=?, date=? "+" where queriesid=?");
	                final int result = stmt.executeUpdate();
	                return result;

	            } catch (final Exception e) {
	                e.printStackTrace();
	                return 0;
	            } finally {
	                databaseController.close(stmt, conn);
	            }
	        }

	        public int delete() {
	            Connection conn = null;
	            PreparedStatement stmt = null;

	            try {
	                conn = databaseController.getConnection();
	                stmt = conn.prepareStatement("delete from queries where queriesid=?");
	                final int result = stmt.executeUpdate();
	                return result;

	            } catch (final Exception e) {
	                e.printStackTrace();
	                return 0;
	            } finally {
	                databaseController.close(stmt, conn);
	            }
	        }

	        public Queriesdto retrieve() {
	            final Queriesdto query = new Queriesdto();
	            Connection conn = null;
	            PreparedStatement stmt = null;
	            ResultSet result = null;
	            try {
	                conn = databaseController.getConnection();
	                stmt = conn.prepareStatement("select * from queries where queriesid=?");
	                result = stmt.executeQuery();
	                while (result.next()) {

	                    query.setQueriesid(result.getInt("queriesid"));
	                    query.setText(result.getString("text"));
	                    query.setDate(result.getDate("date"));
	                    
	                }
	                return query;
	            } catch (final Exception e) {
	                e.printStackTrace();
	                return query;
	            } finally {
	                databaseController.close(result, stmt, conn);
	            }
	        }

	    }

