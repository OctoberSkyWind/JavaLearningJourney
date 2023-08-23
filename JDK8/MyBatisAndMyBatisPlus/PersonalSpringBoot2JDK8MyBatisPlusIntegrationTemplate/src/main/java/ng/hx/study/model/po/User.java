package ng.hx.study.model.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("user")
public class User {
    @TableId
    private Long id;
    private String name;
    private Integer age;
    private String email;


    @TableField(exist = false)
    private Dog dog = null;
    @TableField(exist = false)
    private static CopyOnWriteArrayList<User> usersList = new CopyOnWriteArrayList<>();
    @TableField(exist = false)
    private static ConcurrentHashMap<Long, User> usersMap = new ConcurrentHashMap<Long, User>();

    static {
        for (int i = 1; i < 100; i++) {
            User user = new User((long) i, "Name " + i, i, "email:" + i + "@QQ.com");
            usersList.add(user);
            usersMap.put(user.getId(), user);
        }
    }

    public static List<User> getUsersList() {
        return usersList;
    }

    public static Map<Long, User> getUsersMap() {
        return usersMap;
    }

    public User(long id, String name, int age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.id = id;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Dog {
        private Long id;
        private String name;
        private Integer age;
        private static CopyOnWriteArrayList<Dog> dogsList = new CopyOnWriteArrayList<>();
        private static ConcurrentHashMap<Long, Dog> dogsMap = new ConcurrentHashMap<Long, Dog>();

        static {
            for (int i = 1; i < 100; i++) {
                Dog dog = new Dog((long) i, "name:" + i, i);
                dogsList.add(dog);
                dogsMap.put(dog.getId(), dog);
            }
        }

        public static List<Dog> getDogsList() {
            return dogsList;
        }

        public static Map<Long, Dog> getDogsMap() {
            return dogsMap;
        }
    }
/*

 # SQL语句
 CREATE DATABASE IF NOT EXISTS HXTest;
 use HXTest;
 DROP TABLE IF EXISTS user;

 CREATE TABLE user
 (
 id BIGINT(20) NOT NULL COMMENT '主键ID',
 name VARCHAR(30) NULL DEFAULT NULL COMMENT '姓名',
 age INT(11) NULL DEFAULT NULL COMMENT '年龄',
 email VARCHAR(50) NULL DEFAULT NULL COMMENT '邮箱',
 PRIMARY KEY (id)
 );

 DELETE FROM user;

 INSERT INTO user (id, name, age, email) VALUES
 (1, 'Jone', 18, 'test1@baomidou.com'),
 (2, 'Jack', 20, 'test2@baomidou.com'),
 (3, 'Tom', 28, 'test3@baomidou.com'),
 (4, 'Sandy', 21, 'test4@baomidou.com'),
 (5, 'Billie', 24, 'test5@baomidou.com');

# SQL连接：
spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://192.168.2.15:3306/HXTest?useSSL=false&useUnicode=true&characterEncoding=utf-8
spring.datasource.username=root
spring.datasource.password=mysql
mybatis-plus.configuration.log-impl=org.apache.ibatis.logging.stdout.StdOutImpl

# mapper
@Mapper
public interface UserMapper extends BaseMapper<User> {

}

*/
}