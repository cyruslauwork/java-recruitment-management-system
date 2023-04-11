- Create MySQL DB locally

```bash
mysql -u root -h localhost
create database recruitment_db;
create user 'username' identified by 'password';
grant all privileges on recruitment_db.* to 'username';
FLUSH PRIVILEGES;
system mysql -u username -p;
```
