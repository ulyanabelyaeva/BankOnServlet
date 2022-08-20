package ru.belyaeva.model;

import ru.belyaeva.entity.User;

import java.util.ArrayList;
import java.util.List;

public class ModelAllAdmins {
    private static ModelAllAdmins instance = new ModelAllAdmins();

    private List<User> admins;

    public static ModelAllAdmins getInstance() {
        return instance;
    }

    private ModelAllAdmins() {
        admins = new ArrayList<>();
    }

    public boolean addNewAdmin(User newAdmin) {
        admins.add(newAdmin);
        return true;
    }

    public List<User> list(){
        return admins;
    }

}
