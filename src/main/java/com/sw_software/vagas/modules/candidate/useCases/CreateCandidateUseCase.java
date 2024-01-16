package com.sw_software.vagas.modules.candidate.useCases;

import com.sw_software.vagas.exceptions.UserFoundException;
import com.sw_software.vagas.modules.candidate.CandidateEntity;
import com.sw_software.vagas.modules.candidate.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCandidateUseCase {

  @Autowired
  private CandidateRepository candidateRepository;
  public CandidateEntity execute(CandidateEntity candidateEntity) {
    this.candidateRepository
        .findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
        .ifPresent((user) -> {
          throw new UserFoundException();
        });
    return this.candidateRepository.save(candidateEntity);
  }
}
