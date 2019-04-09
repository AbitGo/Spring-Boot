package com.example.lora.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user",schema = "hrms",catalog = "")
public class UserEntity {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @ManyToMany
    @JoinTable(
            name = "user_role",
            joinColumns = {@JoinColumn(
                            name = "user_id",
                            referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(
                            name = "role_id",
                            referencedColumnName = "id")})
    private Set<RoleEntity> roleEntitySet;

    public String getId() {
        return id;
    }

    public Set<RoleEntity> getRoleEntitySet() {
        return roleEntitySet;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setRoleEntitySet(Set<RoleEntity> roleEntitySet) {
        this.roleEntitySet = roleEntitySet;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
