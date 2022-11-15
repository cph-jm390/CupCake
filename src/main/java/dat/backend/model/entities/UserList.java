package dat.backend.model.entities;

import java.util.ArrayList;
import java.util.List;

public class UserList {

    List<User> userList = new ArrayList<>();

    public void add(User user) {
        userList.add(user);
    }
    public int getNumberOfUsers() {
        return userList.size();
    }

    public List<User> getUserList() {
        return userList;
    }
}
