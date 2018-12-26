package com.atypon.training.project.model.user;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public abstract class BaseUser implements Comparable, Serializable {
    private int userId;
    private String userName;
    private String password;
    private Date timeStamp;

    public BaseUser(int userId, String userName, String password, Date timeStamp) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.timeStamp = timeStamp;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public boolean authenticate(BaseUser user) {
        return password.equals(user.password) && userName.equalsIgnoreCase(user.userName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseUser)) return false;
        BaseUser baseUser = (BaseUser) o;
        return userId == baseUser.userId &&
                userName.equals(baseUser.userName) &&
                password.equals(baseUser.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, password);
    }
}
