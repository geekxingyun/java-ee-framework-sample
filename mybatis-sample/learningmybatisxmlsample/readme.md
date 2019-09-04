# MyBatis 学习案例
官方地址: [http://www.mybatis.org/mybatis-3/zh/](http://www.mybatis.org/mybatis-3/zh/)
## 1.1 什么是MyBatis?
>MyBatis 是一款优秀的持久层框架，它支持定制化 SQL、存储过程以及高级映射。MyBatis 避免了几乎所有的 JDBC 代码和手动设置参数以及获取结果集。MyBatis 可以使用简单的 XML 或注解来配置和映射原生类型、接口和 Java 的 POJO（Plain Old Java Objects，普通老式 Java 对象）为数据库中的记录。
## 1.2 入门
### 1.2.1 安装
在pom.xml中添加如下依赖:
```xml
<dependency>
  <groupId>org.mybatis</groupId>
  <artifactId>mybatis</artifactId>
  <version>3.5.2</version>
</dependency>
```
[点击查看最新版本](https://github.com/mybatis/mybatis-3/releases)
### 1.2.2 从XML中构建SqlSessionFactory
> - 每个基于 MyBatis 的应用都是以一个 SqlSessionFactory 的实例为核心的。SqlSessionFactory 的实例可以通过 SqlSessionFactoryBuilder 获得。而 SqlSessionFactoryBuilder 则可以从 XML 配置文件或一个预先定制的 Configuration 的实例构建出 SqlSessionFactory 的实例。

> - 从 XML 文件中构建 SqlSessionFactory 的实例非常简单，建议使用类路径下的资源文件进行配置。 但是也可以使用任意的输入流（InputStream）实例，包括字符串形式的文件路径或者 file:// 的 URL 形式的文件路径来配置。MyBatis 包含一个名叫 Resources 的工具类，它包含一些实用方法，可使从 classpath 或其他位置加载资源文件更加容易。
```java
import com.xingyun.dao.mapper.UserInfoMapper;
import com.xingyun.model.UserInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 功能: 从 XML 中构建 SqlSessionFactory
 * 作者: 星云
 * 时间: 2019/9/2 9:41
 */
public class MainTest {

    private static final String resource = "config/mybatis-config.xml";
    private static InputStream inputStream = null;
    private static SqlSessionFactory sqlSessionFactory=null;
    private static SqlSession sqlSession=null;
    private static int effectRowLine=0;

    public static void main(String[] args) {

        try {
            //从classpath根路径开始加载配置文件
            inputStream = Resources.getResourceAsStream(resource);
            //每个基于 MyBatis 的应用都是以一个 SqlSessionFactory 的实例为核心的
            //通过 SqlSessionFactoryBuilder创建SqlSessionFactory
            //而 SqlSessionFactoryBuilder 则可以从 XML 配置文件或一个预先定制的 Configuration 的实例构建出 SqlSessionFactory 的实例
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            //打开Session
            //SqlSession 完全包含了面向数据库执行 SQL 命令所需的所有方法
            sqlSession=sqlSessionFactory.openSession();

            //制造一些假数据
            UserInfo toAddUserInfo=makeUserInfo();

            //方式一 调用插入方法
            effectRowLine=sqlSession.insert("com.xingyun.dao.mapper.UserInfoMapper.insertUserInfo",toAddUserInfo);
            System.out.println("执行影响行数:"+effectRowLine);

            //方式二 推荐这种 这种方法有很多优势
            // 首先它不依赖于字符串字面值，会更安全一点；
            // 其次，如果你的 IDE 有代码补全功能，那么代码补全可以帮你快速选择已映射的 SQL 语句。
            UserInfoMapper userInfoMapper=sqlSession.getMapper(UserInfoMapper.class);
            //执行插入方法
            effectRowLine=userInfoMapper.insertUserInfo(toAddUserInfo);
            System.out.println("执行影响行数:"+effectRowLine);

            //执行查询方法
            List<UserInfo> userInfoList=userInfoMapper.selectAllUserInfo();
            System.out.println("当前数据总条数:\r\n"+userInfoList.size());
            System.out.println("当前所有数据结果:\r\n"+userInfoList.toString());

        } catch (IOException e) {
            System.err.println(e);
        }finally {
            if(null!=sqlSession){
                sqlSession.close();
                if(null!=inputStream){
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        System.err.println("InputStream关闭出错"+e);
                    }
                }
            }
        }
    }

    /**
     * 创建一些假数据
     */
    private static UserInfo makeUserInfo(){
        //封装要插入的数据
        UserInfo userInfo=new UserInfo();
        userInfo.setUserInfoId(1L);
        userInfo.setUserInfoAge(27);
        userInfo.setUserInfoName("xingyun");
        userInfo.setUserInfoMobile("183****5684");
        userInfo.setUserInfoSex(false);
        return userInfo;
    }
}
```
### ~~1.2.3 不使用 XML 构建 SqlSessionFactory~~
>由于 Java 注解的一些限制以及某些 MyBatis 映射的复杂性，要使用大多数高级映射（比如：嵌套联合映射），仍然需要使用 XML 配置

因此不推荐使用这种方式.
### 1.2.4 作用域和生命周期
- SqlSessionFactoryBuilder
>这个类可以被实例化、使用和丢弃，一旦创建了 SqlSessionFactory，就不再需要它了。 因此 SqlSessionFactoryBuilder 实例的最佳作用域是方法作用域（也就是局部方法变量）。 你可以重用 SqlSessionFactoryBuilder 来创建多个 SqlSessionFactory 实例，但是最好还是不要让其一直存在，以保证所有的 XML 解析资源可以被释放给更重要的事情。

- SqlSessionFactory
>SqlSessionFactory 一旦被创建就应该在应用的运行期间一直存在，没有任何理由丢弃它或重新创建另一个实例。 使用 SqlSessionFactory 的最佳实践是在应用运行期间不要重复创建多次，多次重建 SqlSessionFactory 被视为一种代码“坏味道（bad smell）”。因此 SqlSessionFactory 的最佳作用域是应用作用域。 有很多方法可以做到，最简单的就是使用单例模式或者静态单例模式。

- SqlSession
>每个线程都应该有它自己的 SqlSession 实例。SqlSession 的实例不是线程安全的，因此是不能被共享的，所以它的最佳的作用域是请求或方法作用域。 绝对不能将 SqlSession 实例的引用放在一个类的静态域，甚至一个类的实例变量也不行。 也绝不能将 SqlSession 实例的引用放在任何类型的托管作用域中，比如 Servlet 框架中的 HttpSession。 如果你现在正在使用一种 Web 框架，要考虑 SqlSession 放在一个和 HTTP 请求对象相似的作用域中。 换句话说，每次收到的 HTTP 请求，就可以打开一个 SqlSession，返回一个响应，就关闭它。 这个关闭操作是很重要的，你应该把这个关闭操作放到 finally 块中以确保每次都能执行关闭。 下面的示例就是一个确保 SqlSession 关闭的标准模式：
>```
>try (SqlSession session = sqlSessionFactory.openSession()) {
>  // 你的应用逻辑代码
>}
>```
>在你的所有的代码中一致地使用这种模式来保证所有数据库资源都能被正确地关闭。
- 映射器实例
>映射器是一些由你创建的、绑定你映射的语句的接口。映射器接口的实例是从 SqlSession 中获得的。因此从技术层面讲，任何映射器实例的最大作用域是和请求它们的 SqlSession 相同的。尽管如此，映射器实例的最佳作用域是方法作用域。 也就是说，映射器实例应该在调用它们的方法中被请求，用过之后即可丢弃。 并不需要显式地关闭映射器实例，尽管在整个请求作用域保持映射器实例也不会有什么问题，但是你很快会发现，像 SqlSession 一样，在这个作用域上管理太多的资源的话会难于控制。 为了避免这种复杂性，最好把映射器放在方法作用域内。下面的示例就展示了这个实践：
>
>```
>try (SqlSession session = sqlSessionFactory.openSession()) {
>  BlogMapper mapper = session.getMapper(BlogMapper.class);
>  // 你的应用逻辑代码
>}
>```
