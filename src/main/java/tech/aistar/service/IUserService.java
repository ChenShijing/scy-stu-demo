package tech.aistar.service;

import tech.aistar.moudle.pojo.User;

public interface IUserService {
    User loadByEmail(String email);
}
