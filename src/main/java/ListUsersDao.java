import java.util.ArrayList;
import java.util.List;

/**
 * Created by daniel on 6/7/17.
 */
public class ListUsersDao implements Users{

    List<User> users;

    @Override
    public List<User> all() {
        if(users == null){
            users = generateDummyUsers();
        }
        return users;
    }

    @Override
    public User getUserById(long id) {
        return null;
    }

    @Override
    public User getUserByEmail(String email) {
        return null;
    }

    public List<User> generateDummyUsers() {

        List <User> list = new ArrayList<>();

        User daniel = new User();
        daniel.setId(1);
        daniel.setUsername("daniel");
        daniel.setEmail("daniel@mail.com");
        daniel.setPassword("123");

        list.add(daniel);
        list.add(new User(1, "elijah", "elijah@mail.com", "password"));

        return list;
    }
}
