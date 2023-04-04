package com.example.demo.exception;

/**
 * @author cuongnk
 * @created_date 15/03/2023
 */
public class BadRequestException extends Exception {

  public BadRequestException(String message) {
    super(message);
  }
}
