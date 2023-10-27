package vn.edu.iuh.fit.backend.modals;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "candidate")
@NamedQueries({

    @NamedQuery(name = "findAllCandidate", query = "select c from Candidate c"),
    @NamedQuery(name = "getCandidateByRole",query = "select c from Candidate c inner JOIN Experience e on c.id = e.candidate.id where e.role = :role"),
    @NamedQuery(name = "getCandidateUseGmail",query = "select c from Candidate c where email like '%gmail%'")
}
)
public class Candidate {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "can_id")
  private long id;

  @Column(name = "full_name")
  private String fullName;
  @Column(name = "phone", length = 15)

  private String phone;
  @Column(name = "email")

  private String email;
  @OneToMany(mappedBy = "candidate", fetch = FetchType.LAZY)

  private List<Experience> experiences;


  public Candidate() {
  }

  public Candidate(long id, String fullName, String phone, String email,
      List<Experience> experiences) {
    this.id = id;
    this.fullName = fullName;
    this.phone = phone;
    this.email = email;
    this.experiences = experiences;
  }

  public Candidate(String fullName, String phone, String email, List<Experience> experiences) {
    this.fullName = fullName;
    this.phone = phone;
    this.email = email;
    this.experiences = experiences;
  }

  public Candidate(String fullName, String phone, String email) {
    this.fullName = fullName;
    this.phone = phone;
    this.email = email;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public List<Experience> getExperiences() {
    return experiences;
  }

  public void setExperiences(List<Experience> experiences) {
    this.experiences = experiences;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Candidate)) {
      return false;
    }
    Candidate candidate = (Candidate) o;
    return getId() == candidate.getId();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId());
  }

  @Override
  public String toString() {
    return "Candidate{" +
        "id=" + id +
        ", fullName='" + fullName + '\'' +
        ", phone='" + phone + '\'' +
        ", email='" + email + '\'' +
        ", experiences=" + experiences +
        '}';
  }
}
