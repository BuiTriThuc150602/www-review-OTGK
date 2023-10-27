package vn.edu.iuh.fit.backend.services;

import java.util.List;
import vn.edu.iuh.fit.backend.modals.Experience;
import vn.edu.iuh.fit.backend.repositories.ExperienceRepository;

public class ExperienceServices {

  private final ExperienceRepository experienceRepository = new ExperienceRepository();

  public List<Experience> getExpOfCandidate(long can_id) {
    return experienceRepository.getExpOfCandidate(can_id);
  }



}
