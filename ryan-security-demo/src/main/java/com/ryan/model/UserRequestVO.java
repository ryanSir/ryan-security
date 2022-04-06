package com.ryan.model;

/**
 * @author ryan
 * @version Id: UserRequestVO, v 0.1 2022/3/31 4:14 PM ryan Exp $
 */
public class UserRequestVO {

    private String username;

    private String age;

    /**
     * Getter method for property <tt>username</tt>.
     *
     * @return property value of username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Setter method for property <tt>username</tt>.
     *
     * @param username value to be assigned to property username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Getter method for property <tt>age</tt>.
     *
     * @return property value of age
     */
    public String getAge() {
        return age;
    }

    /**
     * Setter method for property <tt>age</tt>.
     *
     * @param age value to be assigned to property age
     */
    public void setAge(String age) {
        this.age = age;
    }
}
