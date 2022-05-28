/**
 * @author Nil Panchal Mex IT May 28, 2022 10:57:33 PM Role.java com.springdemo.constant SpringDemo
 */
package com.springdemo.constant;

/**
 * @author Nil Panchal Mex IT May 28, 2022 10:57:33 PM
 */
public enum Role {
  SUPER_ADMIN("User with SUPER_ADMIN role can perform all the operations in the system"), ADMIN(
      "User with SUPER_ADMIN role can perform uthorized operations in admin panel"), USER(
          "User with USER role can perform oprations in user application");

  public final String description;

  private Role(String description) {
    this.description = description;
  }
}
