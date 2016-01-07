package dao;

import entity.Artikel;
import exception.DAOException;

import java.util.ArrayList;

public interface IArtikelDAO {

    public void createArtikel(Artikel artikel) throws DAOException;
    public void deleteArtikel(Artikel artikel) throws DAOException;
    public void updateArtikel(Artikel artikel) throws DAOException;
    public ArrayList<Artikel> searchArtikel(Artikel artikel) throws DAOException;



}