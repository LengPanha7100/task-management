CREATE TABLE project(
    project_id SERIAL PRIMARY KEY ,
    project_name VARCHAR(200) NOT NULL ,
    description VARCHAR(200) NOT NULL
);

CREATE TABLE tasks(
    task_id SERIAL PRIMARY KEY ,
    title VARCHAR(100) NOT NULL ,
    description VARCHAR(200) NOT NULL ,
    due_date TIMESTAMP NOT NULL ,
    priority VARCHAR(50) NOT NULL,
    project_id INT,
    CONSTRAINT fk_project FOREIGN KEY (project_id) REFERENCES project(project_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE tags(
    tag_id SERIAL PRIMARY KEY ,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE task_tag(
    id SERIAL PRIMARY KEY ,
    task_id INT ,
    tag_id INT ,
    CONSTRAINT fk_task FOREIGN KEY (task_id) REFERENCES tasks(task_id) ON DELETE CASCADE ON UPDATE CASCADE ,
    CONSTRAINT fk_tag FOREIGN KEY (tag_id) REFERENCES tags(tag_id) ON DELETE CASCADE ON UPDATE CASCADE
) ;
CREATE TABLE subtasks(
    subtask_id SERIAL PRIMARY KEY ,
    name VARCHAR(200) NOT NULL ,
    status VARCHAR(50) NOT NULL ,
    task_id INT,
    CONSTRAINT fk_task FOREIGN KEY (task_id) REFERENCES tasks(task_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE comments(
    comment_id SERIAL PRIMARY KEY ,
    content VARCHAR(200) NOT NULL ,
    task_id INT,
    CONSTRAINT fk_task FOREIGN KEY (task_id) REFERENCES tasks(task_id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- project
SELECT * FROM project;

SELECT * FROM project WHERE project_id = 1;

INSERT INTO project(project_name, description)
VALUES ('coca12' ,'coca12')
returning *;

UPDATE project
SET project_name = 'koko' , description = 'koko'
WHERE project_id = 1
returning *;

DELETE FROM project WHERE project_id = 1;

-- Task
SELECT * FROM tasks;

SELECT * FROM tasks WHERE task_id = 1;

INSERT INTO tasks(title, description, due_date, priority, project_id)
VALUES ('book' ,'book' , '2024-11-23 10:39:58.000000','MEDIUM',2)
returning *;

UPDATE tasks
SET title = 'koko' , description = 'koko' , due_date = '2024-10-23 10:39:58.000000' , priority = 'MEDIUM' , project_id = 2
WHERE task_id = 2
returning *;

DELETE FROM tasks WHERE task_id = 2;

-- tag

SELECT * FROM tags;

SELECT * FROM tags WHERE tag_id = 1;

INSERT INTO tags(name)
VALUES ('coca')
returning *;

INSERT INTO task_tag(task_id, tag_id) VALUES (4,3);

UPDATE tags
SET name= 'koko' WHERE tag_id = 2 returning *;

DELETE FROM task_tag WHERE tag_id = 3 AND task_id = 4 ;

SELECT t.tag_id,t.name FROM tags t
JOIN task_tag tt on t.tag_id = tt.tag_id
WHERE task_id = 4;




-- comment
SELECT * FROM comments;

SELECT * FROM comments WHERE comment_id = 1;

INSERT INTO comments(content, task_id)
VALUES ('coca', 4)
returning *;

DELETE FROM comments WHERE comment_id = 2;

-- subTask
SELECT * FROM subtasks;

SELECT * FROM subtasks WHERE subtask_id = 1;

INSERT INTO subtasks(name, status, task_id)
VALUES ('kaka', 'PENDING', 7 )
returning *;

UPDATE subtasks
SET name= 'koko' , status = 'PENDING'
WHERE subtask_id = 2
returning *;

DELETE FROM subtasks WHERE subtask_id = 2;