package Utils;

public class Querys {

    public Querys(){}

    public static String getUserQuery(String username){
        return "SELECT id, description, phoneNumber FROM User WHERE name = '" + username + "';";
    }

    public static String insertUserQuery(String username){
        return "INSERT INTO User VALUES ('" + username + "');";
    }
}
