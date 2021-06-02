drop table if exists book;
create table book
(
  id          uuid primary key,
  title       varchar(100) not null,
  comment     varchar,
  releaseDate timestamp    not null,
  author    varchar(255)
--     author_id uuid,
--     foreign key(author_id) references author(id)
);
