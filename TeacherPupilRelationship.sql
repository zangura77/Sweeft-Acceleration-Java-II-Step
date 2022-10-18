--Create tables

--Teachers table
CREATE TABLE Teachers(
	id serial primary key,
    first_name varchar(50),
    last_name varchar(100),
    gender varchar(50),
    subject varchar(50)
);

--Pupils table
CREATE TABLE Pupils(
	id serial primary key,
    first_name varchar(50),
    last_name varchar(100),
    gender varchar(50),
    class tinyint unsigned
);

--School table - join table to create many to many 
--relationship between Pupils and Teachers tables 
CREATE TABLE School(
	pupil_id bigint unsigned,
    teacher_id bigint unsigned,
    foreign key (pupil_id) references Pupils(id),
    foreign key (teacher_id) references Teachers(id)
);

--Query to get only the teachers of pupils named 'გიორგი'
SELECT t.id, t.first_name, t.last_name, t.gender, t.subject
	FROM Teachers t
    JOIN School s
    ON t.id = s.teacher_id
    JOIN Pupils p
    ON s.pupil_id = p.id
    WHERE p.first_name = 'გიორგი';
