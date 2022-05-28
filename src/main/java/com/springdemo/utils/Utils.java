/**
 * @author Nil Panchal Mex IT May 28, 2022 10:51:52 PM Utils.java com.springdemo.utils SpringDemo
 */
package com.springdemo.utils;


import org.apache.commons.lang3.RandomStringUtils;
import com.springdemo.constant.Constants;


/**
 * @author Nil Panchal Mex IT May 28, 2022 10:51:52 PM
 */
public class Utils {


  public static String getShortId(String initial) {
    return initial + RandomStringUtils.randomAlphanumeric(Constants.SHORT_ID_POSTFIX);
  }
}
