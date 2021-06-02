package ru.vlapin.experiments.ubrirproject.dao;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.vlapin.experiments.ubrirproject.model.Cat;

//@Repository
public interface CatRepository extends JpaRepository<Cat, UUID> {
}
