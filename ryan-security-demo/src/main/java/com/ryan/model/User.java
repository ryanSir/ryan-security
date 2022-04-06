package com.ryan.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.ryan.validate.MyConstraint;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Past;
import java.util.Date;

/**
 * @author ryan
 * @version Id: User, v 0.1 2022/3/31 3:51 PM ryan Exp $
 */
public class User {

    public interface UserSimpleView {
    }

    public interface UserDetailView extends UserSimpleView{
    }

    @MyConstraint(message = "自定义校验注解测试")
    private String username;

    // 更多参数见Hibernate Validator 文档
    @NotBlank(message = "密码不能为空")
    private String password;

    private String id;

    // 前端传时间戳，可以自动解析为Date类型
    @Past(message = "日期为过去时间")
    private Date birthDay;

    /**
     * Getter method for property <tt>id</tt>.
     *
     * @return property value of id
     */
    @JsonView(UserSimpleView.class)
    public String getId() {
        return id;
    }

    /**
     * Setter method for property <tt>id</tt>.
     *
     * @param id value to be assigned to property id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Getter method for property <tt>birthDay</tt>.
     *
     * @return property value of birthDay
     */
    @JsonView(UserSimpleView.class)
    public Date getBirthDay() {
        return birthDay;
    }

    /**
     * Setter method for property <tt>birthDay</tt>.
     *
     * @param birthDay value to be assigned to property birthDay
     */
    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    /**
     * Getter method for property <tt>username</tt>.
     *
     * @return property value of username
     */
    @JsonView(UserSimpleView.class)
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
     * Getter method for property <tt>password</tt>.
     *
     * @return property value of password
     */
    @JsonView(UserDetailView.class)
    public String getPassword() {
        return password;
    }

    /**
     * Setter method for property <tt>password</tt>.
     *
     * @param password value to be assigned to property password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
