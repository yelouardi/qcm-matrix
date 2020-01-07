DROP TABLE IF EXISTS answer;
DROP TABLE IF EXISTS choice;
DROP TABLE IF EXISTS question;


  CREATE TABLE question (
  question_id INT AUTO_INCREMENT PRIMARY KEY,
  question_text VARCHAR(250) NOT NULL
  );

  INSERT INTO question (question_text) VALUES
  ('question 1'),
  ('question 2'),
  ('question 3');

  CREATE TABLE choice (
  choice_id INT AUTO_INCREMENT PRIMARY KEY,
  choice_text VARCHAR(250) NOT NULL,
  percentage INT NOT NULL,
  question_id INT NOT NULL
  );

  INSERT INTO choice (choice_text,percentage, question_id) VALUES
  ('choice 1','100',1),
  ('choice 2', '50',1),
  ('choice 3', '25',1),
  ('choice 4', '0',1),
  ('choice 1','100',2),
  ('choice 2', '50',2),
  ('choice 3', '25',2),
  ('choice 4', '0',2),
  ('choice 1','100',3),
  ('choice 2', '50',3),
  ('choice 3', '25',3);

CREATE TABLE answer (
  answer_id INT AUTO_INCREMENT PRIMARY KEY,
  choice_id INT NOT NULL,
  email_person VARCHAR(250) NOT NULL
);

INSERT INTO answer (choice_id, email_person) VALUES
  (1,'khalil@gmail.com'),
  (2,'khalil@gmail.com');