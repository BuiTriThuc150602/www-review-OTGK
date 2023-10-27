package vn.edu.iuh.fit.backend.repositories;

import vn.edu.iuh.fit.backend.modals.Experience;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExperienceRepository {

  private final EntityManager entityManager;
  private final EntityTransaction transaction;
  private final Logger logger = LoggerFactory.getLogger(ExperienceRepository.class);

  public ExperienceRepository() {
    entityManager = Connection.getInstance().getEntityManager();
    transaction = entityManager.getTransaction();
  }

  public List<Experience> getAll() {
    return entityManager.createNamedQuery("findAllExperience", Experience.class).getResultList();
  }

  public List<Experience> getExpOfCandidate(long can_id) {
    return entityManager.createNamedQuery("getExpOfCandidate", Experience.class)
        .setParameter("can_id", can_id).getResultList();
  }


  public Optional<Experience> findById(long id) {
    Experience experience = entityManager.find(Experience.class, id);
    return experience == null ? Optional.empty() : Optional.of(experience);
  }

  public void insert(Experience experience) {
    try {
      transaction.begin();
      entityManager.persist(experience);
      transaction.commit();
    } catch (Exception ex) {
      transaction.rollback();
      logger.error(ex.getMessage());
    }
  }

  public void update(Experience experience) {
    try {
      transaction.begin();
      entityManager.merge(experience);
      transaction.commit();
    } catch (Exception e) {
      transaction.rollback();
      logger.error(e.getMessage());
    }
  }

  public void delete(Experience experience) {
    try {
      transaction.begin();
      entityManager.remove(experience);
      transaction.commit();
    } catch (Exception e) {
      transaction.rollback();
      logger.error(e.getMessage());
    }
  }


}
