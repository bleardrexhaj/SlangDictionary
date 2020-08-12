INSERT INTO authentication values ("Bleard", 1, "$2a$10$2wjnYreXH80/08HCdtMDMu/BbnjJt9zSvGjcritdobH6o/a1uUlN6")
INSERT INTO authorities values(1, "USER", "bleard", "Bleard")
INSERT INTO USER values(1,"bleardd@gmail.com", "Bleard", "Rexhaj", "Bleard")

INSERT INTO authentication values ("Enkhjargal", 1, "$2a$10$2wjnYreXH80/08HCdtMDMu/BbnjJt9zSvGjcritdobH6o/a1uUlN6")
INSERT INTO authorities values(2, "USER", "Enkhjargal", "Enkhjargal")
INSERT INTO USER values(2,"enkhjargal@gmail.com", "Enkhjargal", "Gansukh", "Enkhjargal")


INSERT INTO category (id, name, description) values (1, "College", "Contains simple slang word use around college")
INSERT INTO category (id, name, description) values (2,"Food", "Contains food names around nowadays")
INSERT INTO category (id, name, description) values (3, "Sports", "Contains sport type, equiment and so on")
INSERT INTO category (id, name, description) values (4, "Name", "Contains name of worldwide ")

INSERT INTO term (id, author, definition, example, thumbs_down, thumbs_up, word, written_on, user_id, category_id) values (15, "Bleard", "The only word on this site that has nothing to do with sex or drugs!", "person 1: hello\r\nPerson 2: hi\r\nPerson 1: goodbye\r\nPerson 2: Farewell", 32, 64, "hello", '2020-08-05 00:00:00',1, 1)
