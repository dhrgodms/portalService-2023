package kr.ac.jejunu.user;

public class User {
    private Long id;
    private String name;
    private String password;

    public Long getId() {
        return id;
    }

    public static void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public static void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        this.password = password;
    }
}