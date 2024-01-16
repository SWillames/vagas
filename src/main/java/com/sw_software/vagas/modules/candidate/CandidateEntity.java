package com.sw_software.vagas.modules.candidate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

@Data
public class CandidateEntity {

  private UUID id;
  private String name;
  @Pattern(regexp = "^(?!\\s*$).+", message = "O campo [username] não deve conter espaço")
  private String username;
  @Email(message = "O campo [email] deve conter um e-mail válido")
  private String email;
  @Length(min = 8, max = 16, message = "A senha deve conter entre 8 e 16 caractere")
  private String password;
  private String description;
  private String curriculum;

}


