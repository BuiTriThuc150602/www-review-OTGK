package vn.edu.iuh.fit.backend.modals;

import jakarta.persistence.NamedQueries;
import vn.edu.iuh.fit.backend.enums.Roles;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "experience")
@NamedQueries({

    @NamedQuery(name = "findAllExperience", query = "select e from Experience e"),
    @NamedQuery(name = "getExpOfCandidate", query = "select e from Experience e where e.candidate.id = :can_id")}
)
public class Experience {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "exp_id")
  private long id;
  @Column(name = "form_date")
  private LocalDate formDate;
  @Column(name = "to_date")
  private LocalDate toDate;
  @Column(name = "company")
  private String companyName;
  @Column(name = "role", length = 4)
  private Roles role;
  @ManyToOne
  @JoinColumn(name = "can_id")
  private Candidate candidate;

  public Experience() {
  }

  public Experience(LocalDate formDate, LocalDate toDate, String companyName, Roles role,
      Candidate candidate) {
    this.formDate = formDate;
    this.toDate = toDate;
    this.companyName = companyName;
    this.role = role;
    this.candidate = candidate;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public LocalDate getFormDate() {
    return formDate;
  }

  public void setFormDate(LocalDate formDate) {
    this.formDate = formDate;
  }

  public LocalDate getToDate() {
    return toDate;
  }

  public void setToDate(LocalDate toDate) {
    this.toDate = toDate;
  }

  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  public Roles getRole() {
    return role;
  }

  public void setRole(Roles role) {
    this.role = role;
  }

  public Candidate getCandidate() {
    return candidate;
  }

  public void setCandidate(Candidate candidate) {
    this.candidate = candidate;
  }

  @Override
  public String toString() {
    return "Experience{" +
        "id=" + id +
        ", formDate=" + formDate +
        ", toDate=" + toDate +
        ", companyName='" + companyName + '\'' +
        ", role=" + role +
        '}';
  }
}
