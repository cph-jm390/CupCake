package dat.backend.model.entities;

import java.util.ArrayList;
import java.util.List;

public class Admin {

    List<User> userList = new ArrayList<>();

    public Admin(){
    }

    public int getNumberOfUsers() {
        return userList.size();
    }

    public void add(User user){
        userList.add(user);
    }

    public List<User> getUserList() {
        return userList;
    }


}
