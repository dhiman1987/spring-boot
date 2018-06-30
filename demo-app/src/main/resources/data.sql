INSERT INTO users (id,username,password) VALUES
  (1,'user1', '{noop}password1'),
  (2,'user2', '{noop}password2');
  
  
 INSERT INTO category (id,name) VALUES
  (1,'home'),
  (2,'office');
  
 INSERT INTO todo (id,title,description,category_id,complete,due_date) VALUES
  (1,'todo1','This is a sample todo 1',1,true,'2018-06-12'),
  (2,'todo2','This is a sample todo 2',1,true,'2018-07-11'),
  (3,'todo3','This is a sample todo 3',1,false,'2018-08-12'),
  (4,'todo4','This is a sample todo 4',1,false,'2018-07-25'),
  (5,'todo5','This is a sample todo 5',1,true,'2018-10-02'),
  (6,'todo1','This is a sample todo 1',2,true,'2018-06-12'),
  (7,'todo2','This is a sample todo 2',2,true,'2018-07-11'),
  (8,'todo3','This is a sample todo 3',2,false,'2018-08-12'),
  (9,'todo4','This is a sample todo 4',2,false,'2018-07-25'),
  (10,'todo5','This is a sample todo 5',2,true,'2018-10-02'),
  (11,'todo5','This is a sample todo 5',2,true,sysdate);