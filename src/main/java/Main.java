import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by joy on 6/5/17.
 */
public class Main {
    public static void main(String[] args) {

        //ConnectionJdbc connectionJdbc = new ConnectionJdbc();


        Connection connection = null;
        CrudJdbc crudJdbc = new CrudJdbc(connection);

//        crudJdbc.setJdbcurl("jdbc:mysql://192.168.100.44:20006/hello");
//        crudJdbc.setUsername("root");
//        crudJdbc.getUsername();
//        crudJdbc.setPassword("Qwerty@321");

        crudJdbc.enterConnectionDetails();
        crudJdbc.makeConnection();

        crudJdbc.setCreateTableSQL("CREATE TABLE  Users"+
                "(" +
                "    id INT(11), " +
                "    name VARCHAR(255)," +
                "    age INT(11)," +
                "    email VARCHAR(255)" +
                ")" );
        crudJdbc.getCreateTableSQL();

        crudJdbc.createTable();

        crudJdbc.insertRow(3,"Mike",19,"m@gmail.com");

        crudJdbc.readTable();

        crudJdbc.updateRow(3, 20);

        crudJdbc.readTable();

    }
}