package ru.vlapin.experiments.ubrirproject.dao.data.jdbc;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.vlapin.experiments.ubrirproject.model.Customer;

@Repository
public interface CustomerRepository
    extends CrudRepository<Customer, Long> {
}

