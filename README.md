- Create MySQL DB locally

```bash
mysql -u root -h localhost
create database recruitment_db;
create user 'username' identified by 'password';
grant all privileges on recruitment_db.* to 'username';
FLUSH PRIVILEGES;
system mysql -u username -p;
```

- Insert Employer Data

```bash
insert into Employers values ('PwC', 'recruit@pwc.com', 30003000, 'Hong Kong', 'PwC Limited', 'Acc');
insert into Employers values ('Deloitte', 'recruit@deloitte.com', 30003000, 'Hong Kong', 'Deloitte Limited', 'Acc');
insert into Employers values ('KMPG', 'recruit@kmpg.com', 30003000, 'Hong Kong', 'KMPG Limited', 'Acc');
```
