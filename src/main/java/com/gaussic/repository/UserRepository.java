package com.gaussic.repository;

import com.gaussic.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by max183 on 2016/7/20.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Modifying  // 说明该方法是修改操作
    @Transactional  // 说明该方法是事务性操作
    // @Param注解用于提取参数
    @Query("update User user set user.nickname=:nickname, user.firstName=:firstName, user.lastName=:lastName, " +
            "user.password=:password where user.id=:id")
    public void updateUser(@Param("nickname") String nickname, @Param("firstName") String firstName,
                           @Param("lastName") String lastName, @Param("password") String password,
                           @Param("id") int id);
}
