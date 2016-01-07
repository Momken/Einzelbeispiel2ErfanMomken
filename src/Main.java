import dao.ArtikelDAO;
import dao.IArtikelDAO;
import entity.Artikel;
import exception.DAOException;

import java.sql.Date;
import java.util.ArrayList;

/**
 * Created by Momken on 17.12.2015.
 */
public class Main {

    public static void main(String args[]) {

        IArtikelDAO aDao = new ArtikelDAO();
        Artikel a = new Artikel(null, "erfan", 10000.0, 10000.0, new Date(86, 11, 20), "erfan.jpg");

        try {
            aDao.createArtikel(a);
            ArrayList<Artikel> result = new ArrayList<Artikel>();
            result = aDao.searchArtikel(a);
            Artikel erfan = result.get(0);
            for(int i = 0; i < result.size(); i++) {
                System.out.println(result.get(i).getId() + " " + result.get(i).getGewicht());
            }

        } catch (DAOException e) {
            e.printStackTrace();
        }


    }

}
