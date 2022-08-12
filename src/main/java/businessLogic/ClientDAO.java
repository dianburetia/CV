package businessLogic;
import dataAccess.Connection1;
import model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Client;
import java.util.logging.Logger;
public class ClientDAO extends AbstractDAO<Client>{};
/*
public class ClientDAO {
    protected static final Logger LOGGER = Logger.getLogger(ClientDAO.class.getName());
    private static final String insertStatementString = "INSERT INTO client (idc,numec,address)"
            + " VALUES (?,?,?)";
    private static final String updateStatementString = "UPDATE client"
            + " set idc=?,numec=?,address=?"+"where idc=?";
    private static final String deleteStatementString = "DELETE FROM client"
            + " WHERE idc=?";
    private final static String findStatementString = "SELECT * FROM student where idc = ?";

    public static Client findById(int studentId) {
        Client toReturn = null;

        Connection dbConnection = Connection1.getConnection();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        try {
            findStatement = dbConnection.prepareStatement(findStatementString);
            findStatement.setLong(1, studentId);
            rs = findStatement.executeQuery();
            rs.next();

           int idc = rs.getInt("idc");
            String numec = rs.getString("numec");
            String adresa=rs.getString("address");
            toReturn = new Client(idc, numec,adresa);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING,"StudentDAO:findById " + e.getMessage());
        } finally {
            Connection1.close(rs);
            Connection1.close(findStatement);
            Connection1.close(dbConnection);
        }
        return toReturn;
    }

    public static int insert(Client client) {
        Connection dbConnection = Connection1.getConnection();

        PreparedStatement insertStatement = null;
        int insertedId = -1;
        try {
            insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
            insertStatement.setInt(1, client.getId());
             insertStatement.setString(2, client.getNume()); System.out.println(client.getNume());
            insertStatement.setString(3, client.getAdresa());System.out.println("aaaa");
            insertStatement.executeUpdate();//aici e baiul

           ResultSet rs = insertStatement.getGeneratedKeys();
            if (rs.next()) {
                insertedId = rs.getInt(1);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ClientDAO:insert " + e.getMessage());
        } finally {
            Connection1.close(insertStatement);
            Connection1.close(dbConnection);
        }
        return insertedId;
    }
    public static int update(Client client) {
        Connection dbConnection = Connection1.getConnection();

        PreparedStatement updateStatement = null;
        int insertedId = -1;
        try {
            updateStatement = dbConnection.prepareStatement(updateStatementString, Statement.RETURN_GENERATED_KEYS);
            updateStatement.setInt(1, client.getId());
            updateStatement.setString(2, client.getNume()); System.out.println(client.getNume());
            updateStatement.setString(3, client.getAdresa());updateStatement.setInt(4, client.getId());
            updateStatement.executeUpdate();//aici e baiul
            ResultSet rs = updateStatement.getGeneratedKeys();
            if (rs.next()) {
                insertedId = rs.getInt(1);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ClientDAO:update " + e.getMessage());
        } finally {
            Connection1.close(updateStatement);
            Connection1.close(dbConnection);
        }
        return insertedId;
    }
    public static int delete(Client client) {
        Connection dbConnection = Connection1.getConnection();

        PreparedStatement deleteStatement = null;
        int insertedId = -1;
        try {
            deleteStatement = dbConnection.prepareStatement(deleteStatementString, Statement.RETURN_GENERATED_KEYS);
            deleteStatement.setInt(1, client.getId());
            if(deleteStatement.executeUpdate() >0){
                System.out.println("am sters un rand");
            }

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ClientDAO:delete " + e.getMessage());
        } finally {
            Connection1.close(deleteStatement);
            Connection1.close(dbConnection);
        }
        return insertedId;
    }
}*/
