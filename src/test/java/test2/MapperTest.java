package test2;

import com.hsgene.dao.UserDao;
import com.hsgene.entity.User;
import com.hsgene.util.CollectionUtil;
import com.hsgene.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * Created by lenovo on 2016/6/26.
 */
public class MapperTest {

    private Logger logger = Logger.getLogger(UserTest.class);

    @Test
    public void getCount() {
        SqlSession sqlSession = null;
        try {
            int count = 0;
            sqlSession = MyBatisUtil.getSqlSession();
            // 通过接口映射文件的方式，相当于调用接口实现类的对应方法
            count = sqlSession.getMapper(UserDao.class).getCount();
            logger.debug("count is " + count);
        } catch (Exception e) {
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
            sqlSession = MyBatisUtil.getSqlSession();
            List<User> list = sqlSession.getMapper(UserDao.class).getList();
            if (CollectionUtil.isNotEmpty(list)) {
                // list.forEach(x -> logger.debug(x.getUserName() + "," + new SimpleDateFormat("yyyy-MM-dd").format(x.getBirthday() != null ? x.getBirthday() : new Date())));
                list.forEach(x -> logger.debug(x.getUserName() + "," + x.getBirthday()));
            } else {
                logger.debug("没有查询到相应列表");
            }
        } catch (Exception e) {
            // 查询不需回滚操作
            e.printStackTrace();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
    }

    @Test
    public void insert() {
        User user = new User("2965", "小明", "1234", new Date().toString());
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.getSqlSession();
            int row = sqlSession.getMapper(UserDao.class).insert(user);
            sqlSession.commit();
            logger.debug("增加用户成功！" + row);
        } catch (Exception e) {
            sqlSession.rollback();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
    }

    @Test
    public void update() {
        User user = new User(12, "2477", "小黑", "3334", new Date().toString());// 实体类属性类型与数据库字段类型不一致，就不能插入和更新操作，只能查询（会自动转换类型）
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.getSqlSession();
            sqlSession.getMapper(UserDao.class).update(user);
            sqlSession.commit();
            logger.debug("更新用户成功！");
        } catch (Exception e) {
            sqlSession.rollback();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
    }

    @Test
    public void delete() {
        User user = new User(12);
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.getSqlSession();
            sqlSession.getMapper(UserDao.class).delete(user);
            sqlSession.commit();
            logger.debug("删除用户成功！");
        } catch (Exception e) {
            sqlSession.rollback();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
    }

}
