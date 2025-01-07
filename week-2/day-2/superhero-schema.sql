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

