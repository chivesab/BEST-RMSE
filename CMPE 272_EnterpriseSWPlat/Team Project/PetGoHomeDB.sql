drop database if exists PetGoHome;
create database PetGoHome;
use PetGoHome;

DROP TABLE IF EXISTS PetGoHome.Users;
DROP TABLE IF EXISTS PetGoHome.Accounts;
DROP TABLE IF EXISTS PetGoHome.Transactions;
DROP TABLE IF EXISTS PetGoHome.SessionKeys;



CREATE TABLE Users (
	userid varchar(36) NOT NULL,   
    username varchar(20) NOT NULL,  # we can use email as username
	hash_password char(160) NOT NULL,
	phone varchar(20),
	Primary Key(userid),
	Unique (username)
);


CREATE TABLE Pets (
  petid varchar(36) NOT NULL,
  ownerid varchar(36), # onwer's id  
  pet_name varchar(9),
  type varchar(25),   # pet's type
  weight varchar(9),
  height varchar(9),
  gender varchar(9),
  breed varchar(26),
  color varchar(9),
  hair_length varchar(9),
  age int,
  phone varchar(12),  # owner's phone
  email varchar(30),  # owner's email
  missing_date timestamp NOT NULL,
  picture VARCHAR(2083),  # url for pet's picture
  description varchar(255),   # any other description
  Primary Key(petid),
  Foreign Key (ownerid) references Users (userid)
  on delete cascade
);

CREATE TABLE Post (
	postid varchar(36) NOT NULL,
	lostpet_id varchar(36), 
	Primary Key (postid),
	Foreign Key (lostpet_id) references Pets (petid)
    on delete cascade
);


CREATE TABLE Comments (
	commentid varchar(36) NOT NULL,
	postid varchar(36), 
	comment varchar(300),   # comment
	Primary Key (commentid),
	Foreign Key (postid) references Post (postid)
    on delete cascade
);

DELIMITER //
CREATE TRIGGER `before_insert_users` 
BEFORE INSERT ON `Users`
	FOR EACH ROW
	BEGIN
		SET new.userid = uuid();
	END; //


CREATE TRIGGER `before_insert_pets` 
BEFORE INSERT ON `Pets`
	FOR EACH ROW
	BEGIN
		SET new.petid = uuid();
	END; //



CREATE TRIGGER `before_insert_post` 
BEFORE INSERT ON `Post`
	FOR EACH ROW
	BEGIN
		SET new.postid = uuid();
	END; //

CREATE TRIGGER `before_insert_comments`
BEFORE INSERT ON `Comments`
	FOR EACH ROW
		BEGIN
			SET new.commentid = uuid();
		END; //
DELIMITER ;




# Use this to drop tables
# DROP TABLE Users;
# DROP TABLE Pets;
# DROP TABLE Post;
# DROP TABLE Comments;