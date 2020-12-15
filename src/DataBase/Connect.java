package DataBase;

import java.io.File;
import java.sql.*;

/**
 *
 * @author menyv
 */
public class Connect
{

    Connection cn = null;

    public Connection connect()
    {

        try
        {
            cn = DriverManager.getConnection("jdbc:ucanaccess://ApsystantDB.accdb", "", "");
        }
        catch (SQLException e)
        {
        }
        return cn;
    }

    public Connection getConnection()
    {
        return cn;
    }
}
