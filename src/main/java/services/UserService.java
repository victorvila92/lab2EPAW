package services;

import Utils.Querys;
import models.DAO;

import java.sql.ResultSet;

public class UserService {

    public static ResultSet getUser(String name) throws Exception {
        DAO dao = new DAO();
        return dao.executeSQL(Querys.getUserQuery(name));
    }

    public static void insertUser(String username) throws Exception {
        DAO dao = new DAO();
        dao.execute(Querys.insertUserQuery(username));
    }

}
