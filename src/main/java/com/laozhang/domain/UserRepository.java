package com.laozhang.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by zhangchengfu on 2018/2/2.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String userName);

    User findByUserNameOrEmail(String userName, String email);
}
