package Utils;

public class Querys {

    public Querys(){}

    public static String getUserQuery(String username){
        return "SELECT id, description, phoneNumber FROM User WHERE name = '" + username + "';";
    }

    public static String insertUserQuery(String username){
        return "INSERT INTO User VALUES (null, '" + username + "', null, null);";
    }

    public static String insertUserQuery(String username, String description){
        return "INSERT INTO User VALUES (null, '" + username + "', '"+ description +"');";
    }

    public static String insertUserQuery(String username, String description, String phoneNumber){
        return "INSERT INTO User VALUES (null, '" + username + "', '"+ description +"', '" + phoneNumber + "');";
    }
}
