package com.demo.login.dao;


import com.demo.login.domain.User;
import com.demo.login.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 通过查询数据库返回user对象，如果查询到了返回详细的user对象，如果没查询到返回null
 */
public class UserDao {
    /**
     * @param loginUser 只有用户名和密码的User对象
     * @return 更加详细的user对象
     */
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    public User login(User loginUser) {
        try {
            User detailedUser = jdbcTemplate.queryForObject("select * from user where userName=? and userPassword=?", new BeanPropertyRowMapper<>(User.class), loginUser.getUserName(), loginUser.getUserPassword());   // 数据库表头名必须和JavaBeans对象名称一致否则返回null
            System.out.println(loginUser.getUserName()+" "+loginUser.getUserPassword());
            return detailedUser;
        } catch (DataAccessException e) {
            e.printStackTrace();
            System.out.println("can' access");
            return null;
        }
    }
}
