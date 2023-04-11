- Create MySQL DB locally

For Win:

```bash
mysql -u root -h localhost
create database recruitment_db;
create user 'username' identified by 'password';
grant all privileges on recruitment_db.* to 'username';
FLUSH PRIVILEGES;
system mysql -u username -p;
```

For MacOS:

```bash
/./Applications/XAMPP/xamppfiles/bin/mysql -u root -h localhost
create database recruitment_db;
create user 'username' identified by 'password';
grant all privileges on recruitment_db.* to 'username';
FLUSH PRIVILEGES;
system /./Applications/XAMPP/xamppfiles/bin/mysql -u username -p;
```

- Insert Employer Data

```bash
use recruitment_db;
insert into Employers values (1, 'PwC', 'recruit@pwc.com', 30003000, 'Hong Kong', 'PwC Limited', 'Accounting');
insert into Employers values (2, 'Deloitte', 'recruit@deloitte.com', 30003000, 'Hong Kong', 'Deloitte Limited', 'Accounting');
insert into Employers values (3, 'KMPG', 'recruit@kmpg.com', 30003000, 'Hong Kong', 'KMPG Limited', 'Accounting');
insert into Employers values (4, 'Oracle', 'recruit@oracle.com', 30003000, 'USA', 'Oracle Corporation', 'JavaScript');
insert into Employers values (5, 'Python Software Foundation', 'recruit@python.com', 30003000, 'Hong Kong', 'Python Software Foundation', 'Python');
```
