package dao;

import entity.Artikel;
import exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;


//123Test
//456Test2
public class ArtikelDAO implements IArtikelDAO {

    private static final Logger log= LogManager.getLogger(ArtikelDAO.class);
    private Connection dbConnection= null;
    private DBConnection db = new DBConnection();

    public ArtikelDAO() {
        //db = DBConnection.getInstance();
        this.dbConnection = db.getConnection();
    }

    @Override
    public void createArtikel(Artikel artikel) throws DAOException {
        try {

            dbConnection = db.getConnection();

            log.info("inserting Artikel with attributes name=" + artikel.getName() + " preis =");

            PreparedStatement ps = dbConnection.prepareStatement("insert into Artikel values(null,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, artikel.getName());
            ps.setDouble(2, artikel.getPreis());
            ps.setDouble(3, artikel.getGewicht());
            ps.setDate(4, artikel.getAblaufdatum());
            ps.setString(5, artikel.getBild());
            ps.executeUpdate();

            //ResultSet rs = ps.getGeneratedKeys();
            //rs.next();
            //int i = rs.getInt(1);
            //artikel.setId(i);

            log.info("Artikel successfully inserted");

        } catch (SQLException e) {
            log.error(e.getMessage());
            log.error("Error at Artikel creating!");
            throw new DAOException("Error during Artikel Creation ...");
        }

        //return artikel;

    }


    @Override
    public ArrayList<Artikel> searchArtikel(Artikel artikel) throws DAOException {

        ArrayList<Artikel> result= new ArrayList<Artikel>();

    /*public Artikel findArtikelById(Integer id) throws DAOException  {

        Artikel result = null;

        try{
            log.info("inserting Artikel with attributes name=" + artikel.getName() + " preis =");

            PreparedStatement ps = dbConnection.prepareStatement("select * from Artikel where id = ?");

            ps.setString(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                result = new Artikel(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getDouble(4), rs.getDate(5), rs.getString(6));
            }

            log.info("Artikel successfully inserted");

        } catch (SQLException e) {
            log.error(e.getMessage());
            log.error("Error at Artikel creating!");
            throw new DAOException("Error during Artikel Creation ...");
        }

        return result;
    }*/






        /*
        vonArtikel a
                id=1
                name = erfan
                preis = 5000

        bisArtikel b
                id= 5;
                preis = 10000

        "select * from artikel
        where 1=1
            and id >= 1
            and id <= 5
            and name = erfan
            and preis >= 5000
            and preis <= 10000"
        */

        String query="select * from Artikel where 1=1";

        int i=0;

        try{

            if(artikel.getId() !=null){
                query = query + " and id=? " ;
                i++;
            }
            if(artikel.getName()!=null){
                query=query + " and name=? ";
                i++;
            }
            if(artikel.getPreis()!=null){
                query=query + " and preis=?";
                i++;
            }
            if(artikel.getGewicht()!=null){
                query = query + " and gewicht=?";
                i++;
            }
            if(artikel.getAblaufdatum()!=null){
                query=query +  " and ablaufdatum=?";
                i++;
            }
            if(artikel.getBild()!=null){
                query=query +  " and bild=? ";
                i++;
            }

            //i=2
            //name nicht null
            //preis nicht null
            //"select * from Artikel where name = ? and preis = ?"
            PreparedStatement ps =dbConnection.prepareStatement(query);

            if(artikel.getBild()!=null) {
                ps.setString(i, artikel.getBild());
                i--;
            }
            if(artikel.getAblaufdatum()!=null){
                ps.setDate(i, (Date) artikel.getAblaufdatum());
                i--;
            }
            if(artikel.getGewicht()!=null){
                ps.setDouble(i, artikel.getGewicht());
                i--;
            }
            if(artikel.getPreis()!=null){
                ps.setDouble(i, artikel.getPreis());
                i--;
            }
            if(artikel.getName()!=null){
                ps.setString(i, artikel.getName());
                i--;
            }
            if(artikel.getId()!=null){
                ps.setInt(i, artikel.getId());
                i--;
            }



            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                result.add(new Artikel(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getDouble(4), rs.getDate(5), rs.getString(6)));
            }

            log.info("Artikel successfully Searched");


        }catch (SQLException e){
            log.error(e.getMessage());
            log.error("Artikel searching failed!...");
            throw new DAOException("Error!...");

        }
        return result;

    }


    @Override
    public void updateArtikel(Artikel artikel) throws DAOException {
        try{
            PreparedStatement ps= dbConnection.prepareStatement("update artikel set name=?, preis=?, gewicht=?, ablaufdatum=?, bild=? where id=?");
            ps.setString(1, artikel.getName());
            ps.setDouble(2, artikel.getPreis());
            ps.setDouble(3, artikel.getGewicht());
            ps.setDate(4, artikel.getAblaufdatum());
            ps.setString(5, artikel.getBild());
            ps.setInt(6, artikel.getId());

            ps.executeUpdate();
            log.info("updating Artikel successfully");


        }catch(Exception e){
            log.error(e.getMessage());
            log.error("updating Artikel failed!...");
            throw new DAOException("Error!...");
        }


    }

    @Override
    public void deleteArtikel(Artikel artikel) throws DAOException {
        try{
            PreparedStatement ps=dbConnection.prepareStatement("delete from artikel where id=? ");
            ps.setInt(1, artikel.getId());
            ps.executeUpdate();
            log.info("deleting Artikel is successfully!...");


        }catch (SQLException e){
            log.error(e.getMessage());
            log.error("deleting failed");
            throw new DAOException("Error!...");
        }

    }

    /*
    public void searchAbsoluteValue()
    */
}
