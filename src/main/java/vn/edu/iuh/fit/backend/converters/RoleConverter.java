package vn.edu.iuh.fit.backend.converters;

import vn.edu.iuh.fit.backend.enums.Roles;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class RoleConverter implements AttributeConverter<Roles, Integer> {


  @Override
  public Integer convertToDatabaseColumn(Roles attribute) {
    return attribute == null ? null : attribute.getValue();
  }

  @Override
  public Roles convertToEntityAttribute(Integer dbData) {
    return dbData == null ? null
        : Stream.of(Roles.values()).filter(roles -> roles.getValue() == dbData).findFirst()
            .orElseThrow(IllegalArgumentException::new);
  }
}
