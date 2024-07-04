insert into Users (deleted, nickname, password, profile_img, username) values (false, 'tester1', '$2a$10$LIYHjliNEYCu0zGge7b7Keokw4MWGuuZe60bXFthbKZOZ/DCU/Xqy', 'https://media.istockphoto.com/id/1451587807/vector/user-profile-icon-vector-avatar-or-person-icon-profile-picture-portrait-symbol-vector.jpg?s=612x612&w=0&k=20&c=yDJ4ITX1cHMh25Lt1vI1zBn2cAKKAlByHBvPJ8gEiIg=', 'tester1');
insert into Users (deleted, nickname, password, profile_img, username) values (false, 'tester2', '$2a$10$LIYHjliNEYCu0zGge7b7Keokw4MWGuuZe60bXFthbKZOZ/DCU/Xqy', 'https://media.istockphoto.com/id/1451587807/vector/user-profile-icon-vector-avatar-or-person-icon-profile-picture-portrait-symbol-vector.jpg?s=612x612&w=0&k=20&c=yDJ4ITX1cHMh25Lt1vI1zBn2cAKKAlByHBvPJ8gEiIg=', 'tester2');
insert into Users (deleted, nickname, password, profile_img, username) values (false, 'tester3', '$2a$10$LIYHjliNEYCu0zGge7b7Keokw4MWGuuZe60bXFthbKZOZ/DCU/Xqy', 'https://media.istockphoto.com/id/1451587807/vector/user-profile-icon-vector-avatar-or-person-icon-profile-picture-portrait-symbol-vector.jpg?s=612x612&w=0&k=20&c=yDJ4ITX1cHMh25Lt1vI1zBn2cAKKAlByHBvPJ8gEiIg=', 'tester3');

insert into Category (deleted, category_name) values (false, '커플');
insert into Category (deleted, category_name) values (false, '풍경');
insert into Category (deleted, category_name) values (false, '가족');
insert into Category (deleted, category_name) values (false, '반려동물');
insert into Category (deleted, category_name) values (false, '친구');
insert into Category (deleted, category_name) values (false, '단독');

insert into spot
(description, img_url, deleted, latitude, like_num, longitude, title, user_id, visit_num)
values ( '예시 데이터입니다1!!', '', false, 37.5078306, 0, 127.0452337, '테스트!!!!! 이곳 근처!', 1, 0);
insert into spot
(description, img_url, deleted, latitude, like_num, longitude, title, user_id, visit_num)
values ( '예시 데이터입니다2!!', '', false, 37.5078306, 0, 127.0452337, '테스트!!!!! 이곳 근처!!', 1, 0);
insert into spot
(description, img_url, deleted, latitude, like_num, longitude, title, user_id, visit_num)
values ( '예시 데이터입니다3!!', '', false, 37.5078306, 0, 127.0452337, '테스트!!!!! 이곳 근처!!!!', 1, 0);
insert into spot
(description, img_url, deleted, latitude, like_num, longitude, title, user_id, visit_num)
values ( '예시 데이터입니다4!!', '', false, 37.5078306, 0, 127.0452337, '테스트!!!!! 이곳 근처!', 1, 0);
insert into spot
(description, img_url, deleted, latitude, like_num, longitude, title, user_id, visit_num)
values ( '예시 데이터입니다5!!', '', false, 37.5078306, 0, 127.0452337, '테스트!!!!! 이곳 근처!', 1, 0);

insert into CategorySpot (category_id, deleted, spot_id) values (1, false, 1);
insert into CategorySpot (category_id, deleted, spot_id) values (2, false, 1);
insert into CategorySpot (category_id, deleted, spot_id) values (2, false, 2);
insert into CategorySpot (category_id, deleted, spot_id) values (3, false, 2);
insert into CategorySpot (category_id, deleted, spot_id) values (3, false, 3);
insert into CategorySpot (category_id, deleted, spot_id) values (4, false, 3);
insert into CategorySpot (category_id, deleted, spot_id) values (5, false, 3);
insert into CategorySpot (category_id, deleted, spot_id) values (6, false, 3);

insert into UserFolder (folder_name, deleted, user_id) values ('파리', false, 1);
insert into UserFolder (folder_name, deleted, user_id) values ('선정릉', false, 1);
insert into UserFolder (folder_name, deleted, user_id) values ('제주도', false, 1);
insert into UserFolder (folder_name, deleted, user_id) values ('유럽', false, 2);
insert into UserFolder (folder_name, deleted, user_id) values ('미국', false, 2);
insert into UserFolder (folder_name, deleted, user_id) values ('아시아', false, 2);
insert into UserFolder (folder_name, deleted, user_id) values ('서울', false, 3);
insert into UserFolder (folder_name, deleted, user_id) values ('경기도', false, 3);