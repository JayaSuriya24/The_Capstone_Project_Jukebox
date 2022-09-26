--create the data base
create DATABASE IF NOT EXISTS `jukebox`;

--use the database
USE `jukebox`

--create the table (song)
create TABLE IF NOT EXISTS `jukebox`.`song`(
  `song_id` int not null primary key auto_increment,
  `song_name` varchar(60) not null,
  `duration` varchar(25) not null,
  `artist_name` varchar(50) not null,
  `genre` varchar(20) not null,
  `Song path` varchar(80) not null
);

--values insert into the table
--song_id :-1
insert into `jukebox`.`song` (`song_id`, `song_name`, `duration`, `artist_name`, `genre`, `Song path`)
 VALUES ('1', 'akon', '0:20', 'akon', 'pop', 'src/main/resources/songs/akon.wav');
--song_id :-2
insert into `jukebox`.`song` (`song_id`, `song_name`, `duration`, `artist_name`, `genre`, `Song path`)
 VALUES ('2', 'fastAndFuries', '0:24', 'Badodariya ', 'fusion', 'src/main/resources/songs/Fast and Furious.wav');
--song_id :-3
insert into `jukebox`.`song` (`song_id`, `song_name`, `duration`, `artist_name`, `genre`, `Song path`)
 VALUES ('3', 'harryPotter', '0:06', 'John Williams', 'fusion', 'src/main/resources/songs/Harry Potter.wav');
--song_id :-4
insert into `jukebox`.`song` (`song_id`, `song_name`, `duration`, `artist_name`, `genre`, `Song path`)
 VALUES ('4', 'jackSparrow', '0:30', 'Michael Bolton', 'fusion', 'src/main/resources/songs/Jack Sparrow.wav');
--song_id :-5
insert into `jukebox`.`song` (`song_id`, `song_name`, `duration`, `artist_name`, `genre`, `Song path`)
VALUES ('5', 'smackThat', '0:19', 'akon', 'pop', 'src/main/resources/songs/smack that.wav');


--use the database
USE`jukebox`;

--create new table (playlist)
create TABLE IF NOT EXISTS `playlist`(
  `playlist_id` int not null primary key auto_increment,--(column 1)
  `playlist_name` varchar(50) not null,--(column 2)
  `song_id` varchar(15) not null,--(column 3)
  `song_name` varchar(40) not null--(column 4)
);

--values insert into the table
--playlist_id :-1
insert into `jukebox`.`playlist` (`playlist_id`, `playlist_name`, `song_id`, `song_name`)
 VALUES ('1', 'popPlaylist', '1', 'akon');
--playlist_id :-2
insert into `jukebox`.`playlist` (`playlist_id`, `playlist_name`, `song_id`, `song_name`)
 VALUES ('2', 'popPlaylist', '5', 'smackThat');
--playlist_id :-3
insert into `jukebox`.`playlist` (`playlist_id`, `playlist_name`, `song_id`, `song_name`)
VALUES ('3', 'fusionPlaylist', '2', 'fastAndFuries');
--playlist_id :-4
insert into `jukebox`.`playlist` (`playlist_id`, `playlist_name`, `song_id`, `song_name`)
 VALUES ('4', 'fusionPlaylist', '3', 'harryPotter');
--playlist_id :-5
insert into `jukebox`.`playlist` (`playlist_id`, `playlist_name`, `song_id`, `song_name`)
 VALUES ('5', 'fusionPlaylist', '4', 'jackSparrow');
