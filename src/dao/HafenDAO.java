package dao;
import entity.Hafen;
import exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sun.rmi.runtime.Log;

import java.sql.*;
import java.util.ArrayList;
import java.util.EnumSet;

/**
 * Created by Momken on 17.12.2015.
 */

public class HafenDAO implements IHafenDAO {

    private static final Logger log= LogManager.getLogger(HafenDAO.class);
    private Connection dbConnection = null;
    private DBConnection db = new DBConnection();

    public enum Flag {
        ID, LAND, NAME, KAPAZITAET, GROESSE, OELHAFEN, WARTUNGSDATUM;
        public static final EnumSet<Flag> OPTS = EnumSet.allOf(Flag.class);
    }


    public HafenDAO() {
        this.dbConnection = db.getConnection();// FIXME: 08.01.2016 do we need the getConnection on this since we need it in the methods too
    }


    @Override
    public void createHafen(Hafen entity) throws DAOException {
        try {-
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
            log.error(e.getMessage());
            log.error("Error at Hafen creating!");
            throw new DAOException("Error during Hafen Creation ...");
        }
    }

    @Override
    public void deleteHafen(Hafen entity) throws DAOException {
        try{
            PreparedStatement ps=dbConnection.prepareStatement("delete from Hafen where id=? ");
            ps.setInt(1, entity.getId());
            ps.executeUpdate();
            log.info("deleting Hafen is successfully!...");


        }catch (SQLException e){
            log.error(e.getMessage());
            log.error("deleting failed");
            throw new DAOException("Error!...");
        }
    }

    @Override
    public void updateHafen(Hafen entity) throws DAOException {
        try {
            PreparedStatement ps= dbConnection.prepareStatement("update Hafen set land=?, name=?, wartungsdatum=?, maxgroesse=?, kapazitaet=?, oelhafen=? where id=?");
            ps.setInt(1, entity.getId());
            ps.setString(2, entity.getLand());
            ps.setString(3, entity.getName());
            ps.setDate(4, entity.getWartungsdatum());
            ps.setDouble(5, entity.getMaxGroesse());
            ps.setInt(6, entity.getKapzitaet());
            ps.setBoolean(7, entity.getOelhafen());
            ps.executeUpdate();
            log.info("updating entity Hafen successfully");

        }catch (Exception e){
            log.error(e.getMessage());
            log.error("Update failed");
            throw new DAOException("Error!...");
        }



    }

    @Override
    public ArrayList<Hafen> searchHafen(Hafen entity) throws DAOException {
        ArrayList<Hafen> result= new ArrayList<Hafen>();
        String query="select * from Hafen where 1=1";



        try{

            if(entity.getId() !=null){
                query = query + " and id=? " ;
                Flag.OPTS.add(Flag.ID);

            }
            if(entity.getLand()!=null){
                query=query + " and land=? ";
                Flag.OPTS.add(Flag.LAND);
            }
            if(entity.getName()!=null){
                query=query + " and name=?";
                Flag.OPTS.add(Flag.NAME);
            }
            if(entity.getKapzitaet()!=null){
                query = query + " and kapazitaet=?";
                Flag.OPTS.add(Flag.KAPAZITAET);
            }
            if(entity.getMaxGroesse()!=null){
                query=query +  " and maxgroesse=?";
                Flag.OPTS.add(Flag.GROESSE);

            }
            if(entity.getOelhafen()!=null){
                query=query +  " and oelhafen=? ";
                Flag.OPTS.add(Flag.OELHAFEN);
            }

            if(entity.getWartungsdatum()!=null){
                query=query +  " and wartungsdatum=? ";
                Flag.OPTS.add(Flag.WARTUNGSDATUM);
            }

            //i=2
            //name nicht null
            //preis nicht null
            //"select * from entity where name = ? and preis = ?"
            PreparedStatement ps =dbConnection.prepareStatement(query);

            /// TODO: 16.01.2016 difference valueof/Flag.ID ?
            if(Flag.OPTS.contains(Flag.ID)){
                ps.setInt(Flag.valueOf("ID").ordinal(), entity.getId());
            }

            if(Flag.OPTS.contains(Flag.LAND)){
                ps.setString(Flag.LAND.ordinal(), entity.getLand());
            }

            if(Flag.OPTS.contains(Flag.KAPAZITAET)){
                ps.setInt(Flag.KAPAZITAET.ordinal(), entity.getKapzitaet());
            }

            if(Flag.OPTS.contains(Flag.GROESSE)){
                ps.setDouble(Flag.GROESSE.ordinal(), entity.getMaxGroesse());
            }

            if(Flag.OPTS.contains(Flag.OELHAFEN)){
                ps.setBoolean(Flag.OELHAFEN.ordinal(), entity.getOelhafen());
            }


            if(entity.getWartungsdatum()!=null){
                ps.setDate(Flag.WARTUNGSDATUM.ordinal(), (Date) entity.getWartungsdatum());
                i--;
            }



/*
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                result.add(new entity(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getDouble(4), rs.getDate(5), rs.getString(6)));
            }
*/
            log.info("Hafen successfully Searched");


        }catch (SQLException e){
            log.error(e.getMessage());
            log.error("Hafen searching failed!...");
            throw new DAOException("Error!...");

        }
        return result;


        return null;
    }
}
