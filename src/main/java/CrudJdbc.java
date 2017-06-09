import java.sql.*;

public class CrudJdbc extends ConnectionJdbc {

    private String createTableSQL;

    private Statement statement;


    public CrudJdbc(Connection connection){
        this.connection = connection;
    }

    public String getCreateTableSQL() {
        return createTableSQL;
    }

    public void setCreateTableSQL(String createTableSQL) {
        this.createTableSQL = createTableSQL;
    }

    // Create table method
    //executeUpdate: returns the rows affected by the execution of the SQL statement
    public void createTable() {
        try {
            statement = connection.createStatement();
            statement.executeUpdate(createTableSQL);

            System.out.println("Table Created Successfully");
        }
        catch (SQLException e) {
            System.out.println("Table Already exist");
        }
    }

    //Read Table
    //executeQuery method to get a result set
    public void readTable() {
        try {
            System.out.println("Reading Table Data");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from Users");

            while (resultSet.next()) {

                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int age = resultSet.getInt(3);
                String email = resultSet.getString(4);

                System.out.println("Id = " + String.valueOf(id) + " name = " + name + " age = " + String.valueOf(age) + " email = " + email);
            }
        }
        catch (SQLException | NullPointerException e) {
            e.printStackTrace();
        }
    }

    //Insert a row

    public void insertRow(int id,String name,int age,String email){

        try {
            PreparedStatement insertStatement = connection.prepareStatement("insert into Users "+" values(?,?,?,?)");

            insertStatement.setInt(1,id);
            insertStatement.setString(2,name);
            insertStatement.setInt(3, age);
            insertStatement.setString(4,email);

            insertStatement.executeUpdate();

            System.out.println("Rows inserted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Delete a table
    public void deleteRow(int id) {
        try {
            Statement statement = connection.createStatement();

            String sql = "DELETE FROM Users" + " " + "WHERE id = " + String.valueOf(id);

            int result = statement.executeUpdate(sql);

            System.out.println("Rows deleted = " + result);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Update a row
    public void updateRow(int id, int updatedAge) {
        try {
            Statement statement = connection.createStatement();

            int rows = statement.executeUpdate("Update Users" + " set age=" + updatedAge + " where id=" + id);

            System.out.println("Rows updated = " + rows);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

