/**
 * @author Nil Panchal Mex IT May 28, 2022 10:50:20 PM User.java com.springdemo.model SpringDemo
 */
package com.springdemo.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.hibernate.annotations.Type;
import com.springdemo.constant.Constants;
import com.springdemo.constant.Role;
import com.springdemo.utils.Utils;

/**
 * @author Nil Panchal Mex IT May 28, 2022 10:50:20 PM
 */
@Entity(name = "user")
@Table(name = "user", uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})

public class User extends BaseEntity implements Serializable {

  private static final long serialVersionUID = 7761438259607140956L;

  @Type(type = "text")
  @Column(name = "token")
  private String token;

  @Enumerated(EnumType.STRING)
  @Column(name = "role")
  private Role role;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @NotBlank
  @Email
  @Size(max = 40)
  @Column(name = "email", nullable = false)
  private String email;

  @Column(name = "password")
  private String password;

  @Override
  public String generatShortId() {
    return Utils.getShortId(Constants.USER_INTIAL);
  }

  /**
   * @author Nil Panchal May 28, 2022 11:09:13 PM
   * @param token
   * @param role
   * @param firstName
   * @param lastName
   * @param email
   * @param password
   */
  public User(String token, Role role, String firstName, String lastName, String email,
      String password) {
    this.token = token;
    this.role = role;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
  }

  /**
   * @author Nil Panchal May 28, 2022 11:09:15 PM
   */
  public User() {
    super();
  }

  public String getToken() {
    return token;
  }

  public Role getRole() {
    return role;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public void setRole(Role role) {
    this.role = role;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setPassword(String password) {
    this.password = password;
  }

}
