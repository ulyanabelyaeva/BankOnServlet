package ru.belyaeva.model;

import ru.belyaeva.entity.Role;
import ru.belyaeva.entity.Score;
import ru.belyaeva.entity.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ModelAllUsers {

    private static ModelAllUsers instance = new ModelAllUsers();

    private List<User> users;

    public static ModelAllUsers getInstance() {
        return instance;
    }

    private ModelAllUsers() {
        users = new ArrayList<>();
    }

    public boolean addNewUser(User newUser) {
        users.add(newUser);
        return true;
    }

    public List<User> list(){
        return users;
    }

    public String moveMoney(long id, int money){
        User user = list().stream()
                .filter(u -> u.getScore().getId() == id)
                .findFirst().orElse(null);

        if (user != null){
            if (ModelUser.getInstance().getUser().getScore().getBalance() >= money){
                int newBalance = user.getScore().getBalance() + money;
                user.getScore().setBalance(newBalance);
                int newBalanceSender = ModelUser.getInstance().getUser().getScore().getBalance() - money;
                ModelUser.getInstance().getUser().getScore().setBalance(newBalanceSender);
                return "Перевод успешно выполнен";
            } else return "На Вашем счете недостаточно средств";
        } else
            return "Такого счета нет в системе";
    }

    public void topUp(long id, int money){

        int newBalance = ModelUser.getInstance().getUser().getScore().getBalance() + money;
        ModelUser.getInstance().getUser().getScore().setBalance(newBalance);

    }

    public User search(long id){
        return users.stream()
                .filter(u -> u.getId() == id)
                .findFirst().orElse(null);
    }
}
