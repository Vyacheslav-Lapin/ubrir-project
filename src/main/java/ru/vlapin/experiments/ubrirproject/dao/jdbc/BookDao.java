package ru.vlapin.experiments.ubrirproject.dao.jdbc;

import static ru.vlapin.experiments.ubrirproject.model.Book.Fields.author;
import static ru.vlapin.experiments.ubrirproject.model.Book.Fields.comment;
import static ru.vlapin.experiments.ubrirproject.model.Book.Fields.id;
import static ru.vlapin.experiments.ubrirproject.model.Book.Fields.releaseDate;
import static ru.vlapin.experiments.ubrirproject.model.Book.Fields.title;

import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;
import org.jetbrains.annotations.NotNull;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.vlapin.experiments.ubrirproject.common.jdbc.CrudDao;
import ru.vlapin.experiments.ubrirproject.common.jdbc.NamedParameterJdbcDaoSupport;
import ru.vlapin.experiments.ubrirproject.model.Book;

@Repository
public class BookDao extends NamedParameterJdbcDaoSupport implements CrudDao<Book, UUID> {

  private static final RowMapper<Book> ROW_MAPPER =
      (rs, rowNum) ->
          Book.builder()
              .id(rs.getObject(id, UUID.class))
              .comment(rs.getString(comment))
              .releaseDate(rs.getObject(releaseDate, LocalDate.class))
              .title(rs.getString(title))
              .author(rs.getString(author))
              .build();

  @Override
  public @NotNull Stream<Book> all() {
    return getJdbcTemplate()
        .queryForStream("""
            select id, title, comment, releaseDate, author
            from book""", ROW_MAPPER);
  }

  @Override
  public @NotNull Optional<Book> get(@NotNull UUID id) {
    try {
      return Optional.ofNullable(
          getNamedParameterJdbcTemplate().queryForObject("""
                  select id, title, comment, releaseDate, author
                  from book
                  where id = :id""",
              Map.of(Book.Fields.id, id),
              ROW_MAPPER)
      );
    } catch (EmptyResultDataAccessException e) {
      return Optional.empty();
    }
  }

  @Override
  public void add(@NotNull Book book) {

    if (book.id() != null)
      throw new RuntimeException("UUID is not empty");

    book.id(UUID.randomUUID());

    getNamedParameterJdbcTemplate().update("""
            insert into book (id, title, comment, releaseDate, author)
            values (:id, :title, :comment, :releaseDate, :author)""",
        Map.of(
            id, book.id(),
            title, book.title(),
            comment, book.comment(),
            releaseDate, book.releaseDate(),
            author, book.author()));
  }

  @Override
  public void merge(@NotNull Book book) {

  }

  @Override
  public void delete(@NotNull Book book) {

  }
}
