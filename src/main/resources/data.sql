INSERT INTO User(name, email, password) VALUES('Aluno', 'aluno@email.com', '$2a$10$3SII/BhqnIPzukXTU3/hNOy2SCRtCqXox6Yr/Px8OgrPNkwktP7F2');

INSERT INTO COURSE(name, category) VALUES('Spring Boot', 'Programação');
INSERT INTO Course(name, category) VALUES('HTML 5', 'Front-end');

INSERT INTO Topic(title, message, created_at, status, user_id, course_id) VALUES('Dúvida', 'Erro ao criar o projeto', '2019-05-05T18:00:00', 'NOT_ANSWERED', 1, 1);
INSERT INTO Topic(title, message, created_at, status, user_id, course_id) VALUES('Dúvida 2', 'Projeto não compila', '2019-05-05T19:00:00', 'NOT_ANSWERED', 1, 1);
INSERT INTO Topic(title, message, created_at, status, user_id, course_id) VALUES('Dúvida 3', 'Tag HTML', '2019-05-05T20:00:00', 'NOT_ANSWERED', 1, 2);
