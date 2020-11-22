package com.wdc.demo.dao;

import com.wdc.demo.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 这里关键的地方在于方法的名字。
 * 由于使用了 JPA，无需手动构建 SQL 语句，
 * 而只需要按照规范提供方法的名字即可实现对数据库的增删改查。
*/
public interface UserDAO extends JpaRepository<User,Integer> {
    //findByUsername，就是通过 username 字段查询到对应的行，并返回给 User 类
    User findByUsername(String username);

    User getByUsernameAndPassword(String username,String password);
}