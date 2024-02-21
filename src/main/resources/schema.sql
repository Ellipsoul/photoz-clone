CREATE TABLE IF NOT EXISTS photoz (
  id identity primary key,
  file_name varchar(255),
  content_type varchar(255),
  data binary
);