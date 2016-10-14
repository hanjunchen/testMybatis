package test2;

import com.hsgene.entity.User;
import com.hsgene.util.MyBatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * Created by lenovo on 2016/6/16.
 */

public class UserTest {

    private Logger logger = Logger.getLogger(UserTest.class);

    @Test
    public void getCount() {
        SqlSession sqlSession = null;
        int count = 0;
        try {
            // 从源文件夹中读取mybatis主配置文件到输入流中
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            // 使用输入流创建SqlSessionFactory对象
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            // 获取与数据库通信的sqlSession会话对象
            sqlSession = sqlSessionFactory.openSession(true);
            // 从sql映射文件中读取sql语句并执行  // 此种放获取的xml文件中命名空间，即接口的目录
            count = sqlSession.selectOne("com.hsgene.dao.UserDao.getCount");
            // 使用log4j打印输出信息到日志文件中，因为sout方式太占资源
            logger.debug("count is " + count);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    @Test
    public void getList() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.getSqlSession();
            // 查询不需要提交事务
            List<User> list = sqlSession.selectList("com.hsgene.dao.UserDao.getList");
            list.forEach(x -> logger.debug(x.getUserName()));
        } catch (Exception e) {
            sqlSession.rollback();
        } finally {
            MyBatisUtils.closeSession(sqlSession);
        }
    }

    @Test
    public void insert() {
        User user = new User("2965", "小明", "1234",new Date().toString());
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.getSqlSession();
            sqlSession.insert("com.hsgene.dao.UserDao.insert", user);
            sqlSession.commit();
            logger.debug("增加用户成功！");
        } catch (Exception e) {
            sqlSession.rollback();
        } finally {
            MyBatisUtils.closeSession(sqlSession);
        }
    }

    @Test
    public void update() {
        User user = new User(11, "2477", "小黑", "3334" ,new Date().toString());
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.getSqlSession();
            sqlSession.update("com.hsgene.dao.UserDao.update", user);
            sqlSession.commit();
            logger.debug("更新用户成功！");
        } catch (Exception e) {
            sqlSession.rollback();
        } finally {
            MyBatisUtils.closeSession(sqlSession);
        }
    }

    @Test
    public void delete() {
        User user = new User(11);
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.getSqlSession();
            sqlSession.delete("com.hsgene.dao.UserDao.delete", user);
            sqlSession.commit();
            logger.debug("删除用户成功！");
        } catch (Exception e) {
            sqlSession.rollback();
        } finally {
            MyBatisUtils.closeSession(sqlSession);
        }
    }

}
