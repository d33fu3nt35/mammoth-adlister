import java.sql.SQLException;

/**
 * Created by daniel on 6/9/17.
 */
public interface Users {
    Long insertUser(User user) throws SQLException;
}
