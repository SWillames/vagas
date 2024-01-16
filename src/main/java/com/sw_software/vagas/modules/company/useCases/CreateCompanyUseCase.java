package com.sw_software.vagas.modules.company.useCases;

import com.sw_software.vagas.exceptions.UserFoundException;
import com.sw_software.vagas.modules.company.repositories.CompanyRepository;
import com.sw_software.vagas.modules.company.entities.CompanyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCompanyUseCase {

  @Autowired
  private CompanyRepository companyRepository;
  public CompanyEntity execute(CompanyEntity companyEntity) {
    this.companyRepository
        .findByUsernameOrEmail(companyEntity.getUsername(), companyEntity.getEmail())
        .ifPresent((user) -> {
          throw new UserFoundException();
        });

    return this.companyRepository.save(companyEntity);
  }
}
