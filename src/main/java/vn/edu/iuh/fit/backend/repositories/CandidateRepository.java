package vn.edu.iuh.fit.backend.repositories;

import vn.edu.iuh.fit.backend.enums.Roles;
import vn.edu.iuh.fit.backend.modals.Candidate;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CandidateRepository {

  private final EntityManager entityManager;
  private final EntityTransaction transaction;
  private final Logger logger = LoggerFactory.getLogger(CandidateRepository.class);

  public CandidateRepository() {
    entityManager = Connection.getInstance().getEntityManager();
    transaction = entityManager.getTransaction();
  }

  public List<Candidate> getAll() {
    return entityManager.createNamedQuery("findAllCandidate", Candidate.class).getResultList();
  }

  public List<Candidate> getCandidateByRole(String role) {
    return entityManager.createNamedQuery("getCandidateByRole", Candidate.class)
        .setParameter("role", Roles.valueOf(role)).getResultList();
  }

  public List<Candidate> getCandidateUseGmail() {
    return entityManager.createNamedQuery("getCandidateUseGmail", Candidate.class).getResultList();
  }

  public Optional<Candidate> findById(long id) {
    Candidate candidate = entityManager.find(Candidate.class, id);
    return candidate == null ? Optional.empty() : Optional.of(candidate);
  }

  public void insert(Candidate candidate) {
    try {
      transaction.begin();
      entityManager.persist(candidate);
      transaction.commit();
    } catch (Exception ex) {
      transaction.rollback();
      logger.error(ex.getMessage());
    }
  }

  public void update(Candidate candidate) {
    try {
      transaction.begin();
      entityManager.merge(candidate);
      transaction.commit();
    } catch (Exception e) {
      transaction.rollback();
      logger.error(e.getMessage());
    }
  }

  public void delete(Candidate candidate) {
    try {
      transaction.begin();
      entityManager.remove(candidate);
      transaction.commit();
    } catch (Exception e) {
      transaction.rollback();
      logger.error(e.getMessage());
    }
  }


}
