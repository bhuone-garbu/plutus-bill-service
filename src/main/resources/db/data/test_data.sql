-- dummy testing user
insert into "user" (username, email, mobile_no) values ('testing', 'testing@email.com', '07123456789');
-- TODO: need to store the auto generated id from the user that was inserted

insert into "bill" (description, amount, created_by, paid_by) values ('testing', '23.5', 'fixme', 'fixme');
