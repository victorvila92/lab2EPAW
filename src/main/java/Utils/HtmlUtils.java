package Utils;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HtmlUtils {

    public HtmlUtils(){}

    public static String buildResponseForm(ResultSet result) throws SQLException {
        StringBuilder sb = new StringBuilder();

        sb.append(HtmlUtils.buildHeader("Current Users"));
        sb.append(HtmlUtils.buildTable());

        while (result.next()){
            Integer id = result.getInt("id");
            String name = result.getString("name");
            String description = result.getString("description");
            Integer phoneNumber = result.getInt("phoneNumber");

            sb.append(HtmlUtils.insertRow(id, name, description, phoneNumber));
        }
        sb.append(HtmlUtils.closeTable());
        return sb.toString();
    }

    private static String buildHeader(String title){

        return "<!DOCTYPE html>" +
                "<html>" +
                "<title>" + title + "</title>" +
                "<meta charset=UTF-8>";
    }


    private static String buildTable(){
        return  "    <style>\n" +
                "        table,\n" +
                "        th,\n" +
                "        td {\n" +
                "            border: 1px solid black;\n" +
                "        }\n" +
                "    </style>\n" +
                "\n" +
                "<body>\n" +
                "<table style=\"width:100%\">\n" +
                "    <tr>\n" +
                "        <th>Id</th>\n" +
                "        <th>Name</th>\n" +
                "        <th>Description</th>\n" +
                "        <th>PhoneNumber</th>\n" +
                "    </tr>\n";
    }


    private static String insertRow(Integer id, String name, String description, Integer phoneNumber){
        return "    <tr>\n" +
                "        <td>"+ id +"</td>\n" +
                "        <td>" + name + "</td>\n" +
                "        <td> " + description + " </td>\n" +
                "        <td> " + phoneNumber + " </td>\n" +
                "    </tr>\n";
    }

    private static String closeTable(){
        return "</table>\n" +
                "</body>\n" +
                "\n" +
                "</html>";
    }
}
