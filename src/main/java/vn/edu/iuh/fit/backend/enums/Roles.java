package vn.edu.iuh.fit.backend.enums;

public enum Roles {
  STAFF(0),
  EXECUTIVE(1),
  MANAGER(2),
  ADMINISTRATION(3);
  private final int value;

  Roles(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }
}
