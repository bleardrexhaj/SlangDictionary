INSERT INTO authentication values ("bleard", 1, "$2a$10$2wjnYreXH80/08HCdtMDMu/BbnjJt9zSvGjcritdobH6o/a1uUlN6")
INSERT INTO authorities values (1, "USER", "bleard")
INSERT INTO address values(1, "Fairfield", "IA", "1000N",52557)
INSERT INTO user values(1,"bleardd@gmail.com", "Bleard", "Rexhaj", 1, "bleard")


INSERT INTO category (id, name, description) values (1, "College", "Contains simple slang word use around college")
INSERT INTO category (id, name, description) values (2,"Food", "Contains food names around nowadays")
INSERT INTO category (id, name, description) values (3, "Sports", "Contains sport type, equiment and so on")
INSERT INTO category (id, name, description) values (4, "Name", "Contains name of worldwide ")
INSERT INTO category (id, name, description) values (5, "Tech", "Contains tech words ")


INSERT INTO term (id, author, definition, example, thumbs_down, thumbs_up, word, written_on, user_id, category_id) values (15, "Bleard", "Greeting!", "person 1: hello\r\nPerson 2: hi\r\nPerson 1: goodbye\r\nPerson 2: Farewell", 32, 64, "hello", '2020-08-05 00:00:00',1, 1)
INSERT INTO term (id, author, definition, example, thumbs_down, thumbs_up, word, written_on, user_id, category_id) values (16, "Bleard", "To be/look like a gangster", "person 1: He is thugish", 32, 64, "thugish", '2020-08-06 00:00:00',1, 1)
INSERT INTO term (id, author, definition, example, thumbs_down, thumbs_up, word, written_on, user_id, category_id) values (17, "Bleard", "Toronto slag for Government name.", "person 1: He is the guy from guvy", 32, 64, "guvy", '2020-08-06 00:00:00',1, 1)
