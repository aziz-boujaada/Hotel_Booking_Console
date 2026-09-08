package Repositories.impl;

import Models.User;
import Repositories.UserRepository;

import java.sql.Array;
import java.util.*;

public class InMemoryUserRepo implements UserRepository {

    HashMap<String , User> users = new HashMap<>();

    public User save(User user){

        String id = user.generateID();
        users.put(id , user);

        return  user;
    }

    public Optional<User> findByEmail(String email){
         for(User user : users.values()){
             if(user.getEmail().equalsIgnoreCase(email)){
                 return Optional.of(user);
             }
         }
         return Optional.empty();
    }

    public Optional<User> findById(String id){
        for(User user : users.values()){
            if(user.getId().equalsIgnoreCase(id)){
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    public boolean existsByEmail(String email){
        return users.containsKey(email);
    }

      public List<User> findAll(){
          return  new ArrayList<>(users.values());
        }

        public User update(User user){
            String id = user.generateID();
           return users.put(id , user);
        }

}
