package org.example.g14.service;

import org.example.g14.model.User;

public interface IUserServiceInternal {
    User searchUserIfExists(int id);
}
