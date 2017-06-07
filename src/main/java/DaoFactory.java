/**
 * Created by daniel on 6/7/17.
 */
public class DaoFactory {
    private static Users usersDao;

    public static Users getUsersDao(){

        // To Check if the object of users is Being Created Already!
        if(usersDao == null) {
            usersDao = new ListUsersDao();
        }
     return usersDao;
    }

}
