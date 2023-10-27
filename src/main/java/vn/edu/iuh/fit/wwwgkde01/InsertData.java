package vn.edu.iuh.fit.wwwgkde01;

import java.util.List;
import vn.edu.iuh.fit.backend.converters.RoleConverter;
import vn.edu.iuh.fit.backend.enums.Roles;
import vn.edu.iuh.fit.backend.modals.Candidate;
import vn.edu.iuh.fit.backend.modals.Experience;
import vn.edu.iuh.fit.backend.repositories.CandidateRepository;
import vn.edu.iuh.fit.backend.repositories.ExperienceRepository;
import java.time.LocalDate;

public class InsertData {

  public static void main(String[] args) {
    CandidateRepository candidateRepository = new CandidateRepository();
    ExperienceRepository experienceRepository = new ExperienceRepository();
//    RoleConverter roleConverter = new RoleConverter();
//    for (int i = 1; i <= 3; i++) {
//      Candidate candidate = new Candidate("Name0" + i, "098765432" + i,
//          "email0" + i + "@gmail.com");
//      candidateRepository.insert(candidate);
//      int role = 1;
//      for (int j = i; j <= i + 2; j++) {
//        LocalDate fromDate = LocalDate.of(2020 + i, i, j);
//        LocalDate toDate = fromDate.plusMonths(3);
//        Experience ex = new Experience(fromDate, toDate, "company-0" + i + j,
//            roleConverter.convertToEntityAttribute(role), candidate);
//        experienceRepository.insert(ex);
//        role++;
//      }
//    }

    Candidate candidate1 = new Candidate("Bùi Trí Thức", "0987654321", "trithucbuittb@gmail.com");
    LocalDate fromDate = LocalDate.of(2020, 2, 19);
    LocalDate toDate = fromDate.plusMonths(3);
    Experience ex1 = new Experience(fromDate, toDate, "T&T Sowftware", Roles.STAFF, candidate1);
    Experience ex2 = new Experience(fromDate, toDate, "A&B Sowftware", Roles.MANAGER, candidate1);
    Experience ex3 = new Experience(fromDate, toDate, "C&B Sowftware", Roles.ADMINISTRATION,
        candidate1);
    candidate1.setExperiences(List.of(ex1, ex2, ex3));
    candidateRepository.insert(candidate1);
    experienceRepository.insert(ex1);
    experienceRepository.insert(ex2);
    experienceRepository.insert(ex3);

    Candidate candidate2 = new Candidate("Nguyễn Văn Tèo", "0872615342", "teovan@student.com");
    LocalDate fromDate2 = LocalDate.of(2022, 5, 15);
    LocalDate toDate2 = fromDate.plusMonths(3);
    Experience ex12 = new Experience(fromDate2, toDate2, "T&T Sowftware", Roles.EXECUTIVE, candidate2);
    Experience ex22 = new Experience(fromDate2, toDate2, "A&B Sowftware", Roles.EXECUTIVE, candidate2);
    Experience ex32 = new Experience(fromDate2, toDate2, "C&B Sowftware", Roles.MANAGER,
        candidate2);
    candidate2.setExperiences(List.of(ex12, ex22, ex32));
    candidateRepository.insert(candidate2);
    experienceRepository.insert(ex12);
    experienceRepository.insert(ex22);
    experienceRepository.insert(ex32);

    Candidate candidate3 = new Candidate("Trần Thị Mén", "0987651122", "Menthi@gmail.com");
    LocalDate fromDate3 = LocalDate.of(2023, 3, 12);
    LocalDate toDate3 = fromDate.plusMonths(3);
    Experience ex13 = new Experience(fromDate3, toDate3, "T&T Sowftware", Roles.STAFF, candidate3);
    Experience ex23 = new Experience(fromDate3, toDate3, "A&B Sowftware", Roles.STAFF, candidate3);
    Experience ex33 = new Experience(fromDate3, toDate3, "C&B Sowftware", Roles.STAFF,
        candidate3);
    candidate3.setExperiences(List.of(ex13, ex23, ex33));
    candidateRepository.insert(candidate3);
    experienceRepository.insert(ex13);
    experienceRepository.insert(ex23);
    experienceRepository.insert(ex33);
  }

}
