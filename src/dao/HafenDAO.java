package dao;
import entity.Hafen;
import exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sun.rmi.runtime.Log;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by Momken on 17.12.2015.
 */
public class HafenDAO implements IHafenDAO {

    private static final Logger log= LogManager.getLogger(ArtikelDAO.class);
    private Connection dbConnection = null;
    private DBConnection db = new DBConnection();


    public HafenDAO() {
        this.dbConnection = db.getConnection();// FIXME: 08.01.2016 do we need the getConnection on this since we need it in the methods too
    }


    @Override
    public void createHafen(Hafen entity) throws DAOException {
        try {
            //dbConnection = db.getConnection();//// FIXME: 08.01.2016 is this needed ?
            log.info("inserting Hafen with attributes name=" + entity.getName() + " preis =");

            PreparedStatement ps = dbConnection.prepareStatement("insert into Hafen values(null,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);



            ps.setInt(1, entity.getId());
            ps.setString(2, entity.getLand());
            ps.setString(3, entity.getName());
            ps.setDate(4, entity.getWartungsdatum());
            ps.setDouble(5, entity.getMaxGroesse());
            ps.setInt(6, entity.getKapzitaet());
            ps.setBoolean(7, entity.getOelhafen());
            ps.executeUpdate();








        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteHafen(Hafen entity) throws DAOException {

    }

    @Override
    public void updateHafen(Hafen entity) throws DAOException {

    }

    @Override
    public ArrayList<Hafen> searchHafen(Hafen artikel) throws DAOException {
        return null;
    }
}
