package dao;

import entity.Hafen;
import exception.DAOException;

import java.util.ArrayList;

/**
 * Created by Momken on 07.01.2016.
 */
public interface IHafenDAO {

    public void createHafen(Hafen entity) throws DAOException;

    public void deleteHafen(Hafen entity) throws DAOException;

    public void updateHafen(Hafen entity) throws DAOException;

    public ArrayList<Hafen> searchHafen(Hafen artikel) throws DAOException;

}
