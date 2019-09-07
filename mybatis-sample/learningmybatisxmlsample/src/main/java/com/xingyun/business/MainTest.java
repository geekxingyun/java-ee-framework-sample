package com.xingyun.business;

import com.xingyun.dao.mapper.UserInfoMapper;
import com.xingyun.model.UserInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

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
