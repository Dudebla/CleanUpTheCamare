package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import domain.User;

@Repository
public class userDao {
    private JdbcTemplate jdbcTemplate;
    private final static String MATCH_COUNT_SQL = "SELECT count(*) FROM users WHERE username=?";
    private final static String FIND_USER_BY_NAME = "SELECT * FROM users WHERE username=?";
    private final static String INSERT_USER = "INSERT INTO users(id,username,password,phone,email,flag) VALUES (?,?,?,?,?,?)";

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public int getMatchCount(String username){
        return jdbcTemplate.queryForObject(MATCH_COUNT_SQL, new Object[] {username}, Integer.class);
    }

    public User findUserByName(final String username){
        final User user = new User();
        jdbcTemplate.query(FIND_USER_BY_NAME, new Object[] {username}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                user.setUserName(username);
                user.setPassWord(resultSet.getString("password"));
                user.setId(resultSet.getString("id"));
                user.setPhone(resultSet.getString("phone"));
                user.setEmail(resultSet.getString("email"));
                user.setFlag(resultSet.getInt("flag"));
            }
        });
        return user;
    }

    public boolean insertUser(final User user){
        Object args[] = {user.getId(),user.getUserName(),user.getPassWord(),user.getPhone(),user.getEmail(),user.getFlag()};
        int success = jdbcTemplate.update(INSERT_USER, args);
        return success>0;
    }
}
