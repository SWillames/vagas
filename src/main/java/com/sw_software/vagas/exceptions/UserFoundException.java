package com.sw_software.vagas.exceptions;

public class UserFoundException extends RuntimeException{
  public UserFoundException() {
    super("Usuario já existe");
  }
}
