package vn.edu.iuh.fit.backend.services;

import java.util.List;
import java.util.Optional;
import vn.edu.iuh.fit.backend.modals.Candidate;
import vn.edu.iuh.fit.backend.repositories.CandidateRepository;

public class CandidateServices {
  private final CandidateRepository candidateRepository = new CandidateRepository();
  public List<Candidate> getAllCandidate(){
    return candidateRepository.getAll();
  }
  public Optional<Candidate> findById(long id){
    return candidateRepository.findById(id);
  }
  public List<Candidate> getCandidateByRole(String  value){return candidateRepository.getCandidateByRole(value);}
  public List<Candidate> getCandidateUseGmail(){return candidateRepository.getCandidateUseGmail();}
}
