import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class ConnectionJdbc {

    private String userName;
    private String password;
    private String jdbcUrl;

    public Connection connection;

    public ConnectionJdbc() {
        this.connection = connection;
    }

    public String getUsername() {
        return userName;
    }

    public void setUsername(String username) {
        this.userName = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJdbcurl() {
        return jdbcUrl;
    }

    public void setJdbcurl(String jdbcurl) {
        this.jdbcUrl = jdbcurl;
    }

    public void enterConnectionDetails(){
        System.out.println("Enter jdbc url : ");
        Scanner url = new Scanner(System.in);
        jdbcUrl = url.next();

        System.out.println("Enter username : ");
        Scanner name = new Scanner(System.in);
        userName = name.next();

        System.out.println("Enter password : ");
        Scanner passwd = new Scanner(System.in);
        password = passwd.next();
    }

    public void makeConnection(){
        try {
            connection = DriverManager.getConnection(jdbcUrl, userName, password);
            System.out.println("Successfully connected");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}