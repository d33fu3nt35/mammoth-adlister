import java.util.List;

/**
 * Created by daniel on 6/7/17.
 */
public interface Users {
    List<User> all();
    User getUserById(long id);
    User getUserByEmail(String email);
//    User getUserByPassword(String password);
}
