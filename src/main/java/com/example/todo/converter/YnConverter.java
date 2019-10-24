package com.example.todo.converter;

import javax.persistence.AttributeConverter;

public class YnConverter implements AttributeConverter<Boolean, String> {

  @Override
  public String convertToDatabaseColumn(Boolean attribute) {
    return attribute == true ? "y" : "n";
  }

  @Override
  public Boolean convertToEntityAttribute(String dbData) {
    return "y".equals(dbData);
  }
}
