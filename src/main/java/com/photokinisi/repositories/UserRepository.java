package com.photokinisi.repositories;
import com.photokinisi.repositories.entities.Role;
import com.photokinisi.repositories.entities.User;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findUserByUsername(String username);

    @Query("SELECT role.name as role " +
            "FROM role " +
            "    JOIN user_role ON role.id=user_role.role_id " +
            "    JOIN user ON user.id = user_role.user_id " +
            "WHERE user.id=:userId")
    List<String> findUserRoles(int userId);

    @Modifying
    @Query("INSERT INTO user_role (user_id, role_id) VALUES (:userId, :roleId) ")
    void addRoleToUser(int userId, int roleId);

    @Modifying
    default void saveWithRole(User user, Role role) {
        save(user);
        addRoleToUser(user.getId(), role.getId());
    }
}
