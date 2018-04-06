使用前需启动My SQL数据库
MySQL

default username:root

default password:

1. http://127.0.0.1:8081/

2. http://127.0.0.1:8081/hello

3. http://127.0.0.1:8081/girl

4.http://127.0.0.1:8081/book

5.http://127.0.0.1:8081/api
  http://127.0.0.1:8081/API
  Tips: Get 请求，多映射
7.http://127.0.0.1:8081/api
Tips:Post 请求

8.http://127.0.0.1:8081/url/a/18

9.http://127.0.0.1:8081/url/b?id=18

10.http://127.0.0.1:8081/url/c?id=18

 Tips:组合注解  @GetMapping(value = "/url/c")

11.http://127.0.0.1:8081/girls/

  Tips：Get 获取所有女生列表

12. http://127.0.0.1:8081/girls/

 Tips: Post girlName girlAge 添加一个女生

 13.http://127.0.0.1:8081/girls/two

 Tips:添加两个女生

 14.根据Id 查询女生
  http://127.0.0.1:8081/girls/1

  15.根据年龄查询女生
  http://127.0.0.1:8081/girls/age/16

  16. http://127.0.0.1:8081/girls/1

  Tips：girlName girlAge Post 根据Id修改一个女生

  17.http://127.0.0.1:8081/girls/1

  Tips:Delete 请求根据id删除一个女生

  创建数据库bean时候切记不要导错包名

  import javax.persistence.Entity;
  import javax.persistence.GeneratedValue;
  import javax.persistence.Id;