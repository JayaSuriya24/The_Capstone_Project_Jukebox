--create database jukebox
create DATABASE IF NOT EXISTS`jukebox`.

--use database to create the table
USE `jukebox`;

--song table is created
create TABLE IF NOT EXISTS`jukebox`.`song`(
--song id column is created
`id` int not null primary key auto_increment,
--song name column is created
`name` varchar(20) not null,
--song genre column is created
`genre` varchar(40) not null,
--artist column is created
`artist` varchar(40) not null
);

--statement to insert the values into the table
--1
insert into `jukebox`.`song` (`name`, `artist_name`, `genre`, `song_path`) VALUES ('band', 'John Williams', 'Disco instrumental', 'src/main/resources/songs/CantinaBand60.wav');
--2
insert into `jukebox`.`song` (`name`, `artist_name`, `genre`, `song_path`) VALUES ('fanfare', ' Kittie Moller', ' soundtrack', 'src/main/resources/songs/Fanfare60.wav');
--3
insert into `jukebox`.`song` (`name`, `artist_name`, `genre`, `song_path`) VALUES ('imperialMarch', 'John Williams', 'Film soundtrack', 'src/main/resources/songs/ImperialMarch60.wav');
--4
insert into `jukebox`.`song` (`name`, `artist_name`, `genre`, `song_path`) VALUES ('pinkPanther', 'Friz Freleng', ' comedy-mystery', 'src/main/resources/songs/PinkPanther30.wav');
--5
insert into `jukebox`.`song` (`name`, `artist_name`, `genre`, `song_path`) VALUES ('starWars', 'Ralph McQuarrie', 'Film soundtrack', 'src/main/resources/songs/StarWars3.wav');



--playlist table is created
create TABLE IF NOT EXISTS`jukebox`.`playlist`(
--playlist id column is created
`playlist_id` int not null primary key auto_increment,
--playlist_name column is created
`playlist_name` varchar(20) not null
--songs_id column is created
`song_ids` varchar(20) not null
);
--
--1
insert into `jukebox`.`playlist` (`playlist_id`, `playlist_name`, `song_ids`) VALUES ('1', 'firstPlaylist', '1,2,3,4,5');
--2
insert into `jukebox`.`playlist` (`playlist_id`, `playlist_name`, `song_ids`) VALUES ('2', 'second', '1,2,3,4,5');










