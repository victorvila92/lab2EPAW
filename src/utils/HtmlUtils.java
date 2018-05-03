package utils;

public class HtmlUtils {

    public HtmlUtils(){}

    public static String buildHeader(String title){

        return "<!DOCTYPE html>" +
                "<html>" +
                "<title>" + title + "</title>" +
                "<meta charset=UTF-8>";
    }


    public static String buildTable(){
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
                "        <th>Nom</th>\n" +
                "        <th>Descripci&#243</th>\n" +
                "        <th>Id</th>\n" +
                "        <th>Tel&#232fon</th>\n" +
                "    </tr>\n";
    }


    public static String insertRow(String nom, String descripcio, Integer id, Integer telefon){
        return "    <tr>\n" +
                "        <td>"+ nom +"</td>\n" +
                "        <td>" + descripcio + "</td>\n" +
                "        <td> " + id + " </td>\n" +
                "        <td> " + telefon + " </td>\n" +
                "    </tr>\n";
    }

    public static String closeTable(){
        return "</table>\n" +
                "</body>\n" +
                "\n" +
                "</html>";
    }
}
