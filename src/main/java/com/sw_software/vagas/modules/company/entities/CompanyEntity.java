package com.sw_software.vagas.modules.company.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "Company")
@Data
public class CompanyEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Pattern(regexp = "^(?!\\s*$).+", message = "O campo [username] não deve conter espaço")
  private String username;

  @Email(message = "O campo email deve conter um email válido")
  private String email;

  @Length(min = 8, max = 16, message = "A senha deve conter entre 8 e 16 caractere")

  private String password;

  @Column(nullable = false)
  private String website;

  @Column(nullable = false)
  private String name;
  private String description;

  @CreationTimestamp
  private LocalDateTime createdAt;

}
