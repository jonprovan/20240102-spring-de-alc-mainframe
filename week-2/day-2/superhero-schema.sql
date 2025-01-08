# comments
-- more comments

CREATE SCHEMA `superheroes` ;

CREATE TABLE `superheroes`.`origin` (
  `origin_id` INT NOT NULL AUTO_INCREMENT,
  `origin_story` VARCHAR(256) NOT NULL,
  PRIMARY KEY (`origin_id`));
  
CREATE TABLE `superheroes`.`universe` (
  `universe_id` INT NOT NULL AUTO_INCREMENT,
  `universe_name` VARCHAR(32) NOT NULL,
  `universe_founded` INT NOT NULL,
  PRIMARY KEY (`universe_id`),
  UNIQUE INDEX `universe_name_UNIQUE` (`universe_name` ASC) VISIBLE);
  
CREATE TABLE `superheroes`.`team` (
  `team_id` INT NOT NULL AUTO_INCREMENT,
  `team_name` VARCHAR(64) NOT NULL,
  `team_established` VARCHAR(128) NOT NULL,
  PRIMARY KEY (`team_id`),
  UNIQUE INDEX `team_name_UNIQUE` (`team_name` ASC) VISIBLE);
  
CREATE TABLE `superheroes`.`villain` (
  `villain_id` INT NOT NULL AUTO_INCREMENT,
  `villain_stage_name` VARCHAR(64) NOT NULL,
  `villain_real_name` VARCHAR(64) NULL,
  `villain_age` INT NOT NULL,
  `origin_id` INT NULL,
  `team_id` INT NULL,
  `universe_id` INT NOT NULL,
  PRIMARY KEY (`villain_id`),
  UNIQUE INDEX `villain_name_UNIQUE` (`villain_stage_name` ASC) VISIBLE,
  INDEX `villain_origin_id_idx` (`origin_id` ASC) VISIBLE,
  INDEX `villain_team_id_idx` (`team_id` ASC) VISIBLE,
  INDEX `villain_universe_id_idx` (`universe_id` ASC) VISIBLE,
  CONSTRAINT `villain_origin_id`
    FOREIGN KEY (`origin_id`)
    REFERENCES `superheroes`.`origin` (`origin_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `villain_team_id`
    FOREIGN KEY (`team_id`)
    REFERENCES `superheroes`.`team` (`team_id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
  CONSTRAINT `villain_universe_id`
    FOREIGN KEY (`universe_id`)
    REFERENCES `superheroes`.`universe` (`universe_id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE);
    
CREATE TABLE `superheroes`.`hero` (
  `hero_id` INT NOT NULL AUTO_INCREMENT,
  `hero_stage_name` VARCHAR(64) NOT NULL,
  `hero_real_name` VARCHAR(64) NULL,
  `hero_age` INT NOT NULL,
  `archrival` INT NULL,
  `origin_id` INT NULL,
  `team_id` INT NULL,
  `universe_id` INT NOT NULL,
  PRIMARY KEY (`hero_id`),
  UNIQUE INDEX `hero_stage_name_UNIQUE` (`hero_stage_name` ASC) VISIBLE,
  INDEX `hero_origin_id_idx` (`origin_id` ASC) VISIBLE,
  INDEX `hero_team_id_idx` (`team_id` ASC) VISIBLE,
  INDEX `hero_universe_id_idx` (`universe_id` ASC) VISIBLE,
  INDEX `hero_archrival_id_idx` (`archrival` ASC) VISIBLE,
  CONSTRAINT `hero_origin_id`
    FOREIGN KEY (`origin_id`)
    REFERENCES `superheroes`.`origin` (`origin_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `hero_team_id`
    FOREIGN KEY (`team_id`)
    REFERENCES `superheroes`.`team` (`team_id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
  CONSTRAINT `hero_universe_id`
    FOREIGN KEY (`universe_id`)
    REFERENCES `superheroes`.`universe` (`universe_id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `hero_archrival_id`
    FOREIGN KEY (`archrival`)
    REFERENCES `superheroes`.`villain` (`villain_id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE);
    
CREATE TABLE `superheroes`.`power` (
  `power_id` INT NOT NULL AUTO_INCREMENT,
  `power_name` VARCHAR(32) NOT NULL,
  PRIMARY KEY (`power_id`));
  
CREATE TABLE `superheroes`.`hero_power` (
  `hero_id` INT NOT NULL,
  `power_id` INT NOT NULL,
  PRIMARY KEY (`hero_id`, `power_id`),
  INDEX `hero_power_id_idx` (`power_id` ASC) VISIBLE,
  CONSTRAINT `hero_id`
    FOREIGN KEY (`hero_id`)
    REFERENCES `superheroes`.`hero` (`hero_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `hero_power_id`
    FOREIGN KEY (`power_id`)
    REFERENCES `superheroes`.`power` (`power_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE `superheroes`.`villain_power` (
  `villain_id` INT NOT NULL,
  `power_id` INT NOT NULL,
  PRIMARY KEY (`villain_id`, `power_id`),
  INDEX `villain_power_id_idx` (`power_id` ASC) VISIBLE,
  CONSTRAINT `villain_id`
    FOREIGN KEY (`villain_id`)
    REFERENCES `superheroes`.`villain` (`villain_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `villain_power_id`
    FOREIGN KEY (`power_id`)
    REFERENCES `superheroes`.`power` (`power_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

INSERT INTO universe(universe_name, universe_founded) VALUES('Marvel', 1939), 
															('DC', 1934), 
                                                            ('Image', 1992);
INSERT INTO team(team_name, team_established) VALUES('Avengers', 'The Avengers #1, September 1963'), 
													('Justice League', 'The Brave and the Bold #28, January 1960'), 
                                                    ('Sinister Six', 'The Amazing Spider-Man Annual #1, January 1964');
INSERT INTO origin(origin_story) VALUES('Got stuck in cave. Made armor. Got out of cave.'), 
									   ('Kidnapped and forced into assassinhood.'), 
									   ('Exposed to extensive gamma radiation.'), 
									   ('Planet destroyed. Escape pod sent him to Earth as a baby.'), 
									   ('Parents killed. Vowed revenge on criminal underworld.'), 
									   ('Amazonian goddess. Sculpted from clay by her mother.'), 
									   ('Died and went to Hell. Made a deal with Malebolgia.'), 
									   ('Mechanical arms took on a life of their own and controlled his mind.'), 
									   ('Struck by lightning while working on a power line.'), 
									   ('Fooled around and found out at a nuclear testing site.'), 
									   ('From abuse and poverty, developed severe megalomania.'), 
									   ('No one really knows...just flat-out insane.');
INSERT INTO villain(villain_stage_name, villain_real_name, villain_age, origin_id, team_id, universe_id)
	VALUES('Doctor Octopus', 'Otto Octavius', 50, 8, 3, 1),
		  ('Electro', 'Max Dillon', 31, 9, 3, 1),
		  ('Sandman', 'Flint Marko', 39, 10, 3, 1),
		  ('Lex Luthor', 'Lex Luthor', 55, 11, NULL, 2),
		  ('The Joker', NULL, 41, 12, NULL, 3);
INSERT INTO hero(hero_stage_name, hero_real_name, hero_age, archrival, origin_id, team_id, universe_id)
	VALUES('Iron Man', 'Tony Stark', 42, NULL, 1, 1, 1),
		  ('Black Widow', 'Natasha Romanova', 35, NULL, 2, 1, 1),
		  ('The Incredible Hulk', 'Bruce Banner', 45, NULL, 3, 1, 1),
		  ('Superman', 'Clark Kent', 30, 4, 4, 2, 2),
		  ('Batman', 'Bruce Wayne', 40, 5, 5, 2, 2),
		  ('Wonder Woman', 'Diana Prince', 100, NULL, 6, 2, 2),
		  ('Spawn', 'Al Simmons', 32, NULL, 7, NULL, 3);
INSERT INTO power(power_name) VALUES('Flight'), 
									('Wealth'), 
									('Strength'), 
									('Genius'), 
									('Indestructibility'), 
									('Immortality'), 
									('Electricity'), 
									('Shape-Shifting'), 
									('Insanity'), 
									('Robotic Arms');
INSERT INTO villain_power(villain_id, power_id) VALUES(1, 4),
													  (1, 10),
													  (2, 7),
													  (3, 3),
													  (3, 8),
													  (4, 2),
													  (4, 4),
													  (5, 4),
													  (5, 9);
INSERT INTO hero_power(hero_id, power_id) VALUES(1, 1),
												(1, 2),
												(1, 4),
												(2, 4),
												(3, 3),
												(3, 4),
												(3, 5),
												(4, 1),
												(4, 3),
												(4, 5),
												(5, 2),
												(5, 4),
												(6, 3),
												(6, 5),
												(6, 6),
												(7, 3),
												(7, 5),
												(7, 6);
                                                
SELECT * FROM hero;
SELECT * FROM hero_power;
SELECT * FROM origin;
SELECT * FROM power;
SELECT * FROM team;
SELECT * FROM universe;
SELECT * FROM villain;
SELECT * FROM villain_power;
                                                
SELECT hero_stage_name, power_name FROM hero JOIN hero_power ON hero.hero_id = hero_power.hero_id
											 JOIN power ON hero_power.power_id = power.power_id;
SELECT villain_stage_name, power_name FROM villain JOIN villain_power ON villain.villain_id = villain_power.villain_id
												   JOIN power ON villain_power.power_id = power.power_id;