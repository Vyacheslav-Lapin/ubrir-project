package ru.vlapin.experiments.ubrirproject.model;

import static lombok.AccessLevel.PRIVATE;

import java.util.Objects;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

@Getter
@Entity
@ToString //@ToString, @Getter
@Setter(PRIVATE)
@NoArgsConstructor
@RequiredArgsConstructor
public class Cat {

  @Id
  @Include
  @GeneratedValue
  @Column(updatable = false, nullable = false)
  UUID id;

  @Version
  int version;

  @NonNull
  String name;

  @Override
  public boolean equals(Object o) {
    return this == o || o != null
                            && Hibernate.getClass(this) == Hibernate.getClass(o)
                            && o instanceof Cat cat
                            && Objects.equals(id, cat.id);
  }

  @Override
  public int hashCode() {
    return 2_134_426_647;
  }
}
