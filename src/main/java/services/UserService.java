package services;

import Utils.Querys;
import models.DAO;

import java.sql.ResultSet;

public class UserService {

    public static ResultSet getUser(String name){
        try {
            DAO dao = new DAO();
            return dao.executeSQL(Querys.getUserQuery(name));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Boolean insertUser(String username){
        try {
            DAO dao = new DAO();
            return dao.execute(Querys.insertUserQuery(username));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
