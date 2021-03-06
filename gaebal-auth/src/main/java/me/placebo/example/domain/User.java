package me.placebo.example.domain;

/**
 * @author 임형태
 * @since 2015.11.19
 */
public class User {
    private String id;
    private String name;
    private String password;
    private String address;
    private String cellphone;
    private String role;

    public User(String id, String name, String password, String address, String cellphone, String role) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.address = address;
        this.cellphone = cellphone;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
