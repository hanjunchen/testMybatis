package testlog4j;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by lenovo on 2016/6/16.
 */

public class UserTest {

    private Logger logger = Logger.getLogger(UserTest.class);

    @Test
    public void userTest() {

        SqlSession sqlSession = null;
        int count = 0;
        try {
            // 从源文件夹中读取mybatis主配置文件到输入流中
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            // 使用输入流创建SqlSessionFactory对象
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            // 获取与数据库通信的sqlSession会话对象
            sqlSession = sqlSessionFactory.openSession(true);// 设置事务提交，查询不涉及事务
            // 从sql映射文件中读取sql语句并执行
            count = sqlSession.selectOne("com.hsgene.dao.UserMapper.count");
            // 使用log4j打印输出信息到日志文件中，sout方式太占资源
            logger.debug("count is " + count);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }
}
