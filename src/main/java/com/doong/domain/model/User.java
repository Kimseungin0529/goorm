package com.doong.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter @Setter
@NoArgsConstructor
public class User {
    // private Long id;
    private String name;
    private String email;
    private String password;
    private int age;

    public User(String email, String password) {
        this.name = "승진";
        this.email = email;
        this.password = password;
        this.age = 25;
    }
    public static User isValidUser(User user){
        User defaultUser = new User("email@xxxx.com", "1234");
        if(user.equals(defaultUser)){
            return defaultUser;
        }
        return null;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(password, user.password) && Objects.equals(email, user.email);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, email);
    }
}
