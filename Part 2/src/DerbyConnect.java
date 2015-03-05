/**
 *
 * @author Nathan Bingham
 * @date March 4, 2015
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class DerbyConnect
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        try
        {
            Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/TeamMembers","student","student");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Members");
            
            while (resultSet.next())
            {
                System.out.println(resultSet.getInt("ID")+": "+resultSet.getString("firstName")+" "+resultSet.getString("lastName")+" - "+resultSet.getString("jobTitle"));
            }
        }
        catch (SQLException sqle)
        {
            System.err.println(sqle.getMessage());
        }
    }
    
}
