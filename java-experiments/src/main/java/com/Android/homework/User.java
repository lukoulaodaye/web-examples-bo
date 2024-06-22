package com.Android.homework;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class User {

    private int id;
    private String name;
    private String city;

    public User(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    // 省略其他方法...
    public String getName() {
        return name;
    }

    // getter方法，用于获取用户的city属性
    public String getCity() {
        return city;
    }

    // 静态方法，将用户集合转换为城市到用户列表的映射
    public static Map<String, Set<User>> toMap(Set<User> users) {
        // 创建一个HashMap，用于存储城市到用户集合的映射
        Map<String, Set<User>> cityToUsersMap = new HashMap<>();

        // 遍历用户集合
        for (User user : users) {
            // 获取用户的城市
            String city = user.getCity();

            // 如果该城市在map中不存在，则创建一个新的HashSet来存储用户
            if (!cityToUsersMap.containsKey(city)) {
                cityToUsersMap.put(city, new HashSet<>());
            }

            // 将用户添加到对应城市的用户集合中
            cityToUsersMap.get(city).add(user);
        }

        // 返回最终的映射
        return cityToUsersMap;
    }

    // 主方法或其他测试代码
    public static void main(String[] args) {
        // 示例：使用toMap方法
        Set<User> users = new HashSet<>();
        users.add(new User(1, "Alice", "New York"));
        users.add(new User(2, "Bob", "Los Angeles"));
        users.add(new User(3, "Charlie", "New York"));
        users.add(new User(4, "David", "Chicago"));

        Map<String, Set<User>> cityUsersMap = toMap(users);

        // 打印结果
        for (Map.Entry<String, Set<User>> entry : cityUsersMap.entrySet()) {
            System.out.println("City: " + entry.getKey());
            for (User user : entry.getValue()) {
                System.out.println("User: " + user.getName());
            }
        }
    }
}