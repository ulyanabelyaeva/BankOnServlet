package ru.belyaeva.model;

import ru.belyaeva.entity.User;

public class ModelUser {

    private static ModelUser instance = new ModelUser();

    private User user;

    public static ModelUser getInstance() {
        return instance;
    }

    public ModelUser() {
    }

    public ModelUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void put (String name, String last_name, String series, String number, String pass){
        for (User u:
                ModelAllUsers.getInstance().list()) {
            if (u.getId() == user.getId()){
                u.setName(name);
                u.setLastName(last_name);
                u.setSeries(series);
                u.setNumber(number);
                u.setPassword(pass);
            }
        }
        user.setName(name);
        user.setLastName(last_name);
        user.setSeries(series);
        user.setNumber(number);
        user.setPassword(pass);
    }
}
