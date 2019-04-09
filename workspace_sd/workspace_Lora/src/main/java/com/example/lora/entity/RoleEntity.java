package com.example.lora.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role",schema = "hrms",catalog = "")
public class RoleEntity {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @ManyToMany(mappedBy = "roleEntitySet")
    private Set<UserEntity> userEntitySet;
    @ManyToMany
    @JoinTable(
            name = "role_permission",
            joinColumns = {@JoinColumn(
                    name = "role_id",
                    referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(
                    name = "permission_id",
                    referencedColumnName = "id")})
    private Set<PermissionEntity> permissionEntitySet;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Set<PermissionEntity> getPermissionEntitySet() {
        return permissionEntitySet;
    }

    public Set<UserEntity> getUserEntitySet() {
        return userEntitySet;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPermissionEntitySet(Set<PermissionEntity> permissionEntitySet) {
        this.permissionEntitySet = permissionEntitySet;
    }

    public void setUserEntitySet(Set<UserEntity> userEntitySet) {
        this.userEntitySet = userEntitySet;
    }
}
