package com.Metricas_cores.Repository;

import com.Metricas_cores.Model.User;

public interface IKvsRepository {
    public void createUser(User user);
    public User readUser(String id);
    public void updateUser(User user);
    public void deleteUser(String id);
}
