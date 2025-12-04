package auth.server.hw.service;



import auth.server.hw.dto.user.CreateUser;
import auth.server.hw.dto.user.UpdateUser;
import auth.server.hw.dto.user.UserResponse;

import java.util.List;

public interface UserService {

    List<UserResponse> getAll();

    UserResponse getById(String id);

    void createUser(CreateUser create);

    void updateUserById(UpdateUser updateUser, String id);

    void deleteUserById(String id);
}
