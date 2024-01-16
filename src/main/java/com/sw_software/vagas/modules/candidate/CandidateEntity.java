package com.sw_software.vagas.modules.candidate;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name = "candidate")
public class CandidateEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  @Column(nullable = false)
  private String name;
  @Pattern(regexp = "^(?!\\s*$).+", message = "O campo [username] não deve conter espaço")
  @Column(nullable = false, unique = true)
  private String username;
  @Email(message = "O campo [email] deve conter um e-mail válido")
  @Column(nullable = false, unique = true)
  private String email;
  @Length(min = 8, max = 16, message = "A senha deve conter entre 8 e 16 caractere")
  @Column(nullable = false)
  private String password;
  private String description;
  private String curriculum;

  @CreationTimestamp
  private LocalDateTime createdAt;

}


