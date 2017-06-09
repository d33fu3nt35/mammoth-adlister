import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Driver;

/**
 * Created by daniel on 6/9/17.
 */
public class MySQLAdsDao implements Ads {

    Connection connection = null;

    public MySQLAdsDao() throws SQLException {
        Config config = new Config();
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        DriverManager.registerDriver(new Driver());
        connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUsername(),
                config.getPassword()
        );
    }

    @Override
    public List<Ad> all() throws SQLException {
        // todo: connect to the database (create a connection object)
        List<Ad> ads = selectExample(connection);
        // instead of printing to the console, we could pass this to a jsp
        for (Ad ad : ads) {
        }
        return ads;
    }


    @Override
    public Long insert(Ad ad) throws SQLException {
        String adTitle = ad.getTitle();
        String description = ad.getDescription();

        Statement stmt = connection.createStatement();

        String query = "INSERT INTO ads(title, description, user_id) VALUES";
        query += "('" + adTitle + "', '" + description + "', 1)";
        System.out.println(query);
        stmt.execute(query);

        return null;
    }

    // todo: run the query to get all the ads
    public static List<Ad> selectExample(Connection connection) throws SQLException {
        String query = "SELECT * FROM ads";
        System.out.println(query);

        Statement stmt = connection.createStatement();

        ResultSet rs = stmt.executeQuery(query);

        List<Ad> ads = new ArrayList();

        // move the cursor through the results
        // this while loop will run once for each row in the results
        while (rs.next()) {
            long adId = rs.getLong("id");
            long adUserId = rs.getLong("user_id");
            String adTitle = rs.getString("title");
            String description = rs.getString("description");
            Ad a = new Ad(adId, adUserId, adTitle, description);
            ads.add(a);
        }

        return ads;
    }

}

// todo: use the results of that query to create a list of Ad objects