package com.atypon.training.project.model.user;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Admin extends BaseUser implements Serializable,Comparable {
    private AdminPrivilege privilege;

    public Admin(int userId, String userName, String password, Date timeStamp, AdminPrivilege privilege) {
        super(userId, userName, password, timeStamp);
        this.privilege = privilege;
    }

    public AdminPrivilege getPrivilege() {
        return privilege;
    }

    public void setPrivilege(AdminPrivilege privilege) {
        this.privilege = privilege;
    }

    @Override
    public int compareTo(Object o) {
        Admin a = (Admin)o;
        return Integer.compare(getUserId(),a.getUserId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Admin admin = (Admin) o;
        return privilege == admin.privilege;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), privilege);
    }
}
