# 项目说明
html输入用户名和密码进行登录

登录成功转到成功页面，失败转到失败页面

UserDao执行数据库的查询

# 数据库创建

```mysql
CREATE DATABASE demologin;
USE demologin;
DROP TABLE USER;
CREATE TABLE USER(
	userId INT PRIMARY KEY AUTO_INCREMENT,
	userName VARCHAR(32) UNIQUE NOT NULL,
	userPassword VARCHAR(32) NOT NULL);

INSERT INTO USER(userId,userName,userPassword) VALUES
	(1001,'Jack','1001Jack'),
	(1002,'Jackie','1002Jackie');
	
SELECT * FROM USER;
```

# 注意事项

1. JavaBean的User类中成员变量与数据库表头名称一致（大小写敏感），getter和setter自动生成。

2. BeanUtils.populate()中properties属性名称也要与User类中的属性名称一致（注意是属性） 

**简言之：数据库表头名，User类的成员变量，BeanUtils.populate()中传入的属性名称三者要一致**


