package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import domain.Merchant;

@Repository
public class merchantDao {
    private JdbcTemplate jdbcTemplate;
    private final static String GET_INFO_BY_ID = "SELECT * FROM merchantInfo WHERE id=?";
    private final static String UPDATE_INFO_BY_ID = "UPDATE merchantInfo SET name=?, address=?, status=?, intro=?, score=? WHERE id=?";

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Merchant getInfoByID(final String id)
    {
        final Merchant merchant = new Merchant();
        jdbcTemplate.query(GET_INFO_BY_ID, new Object[]{id}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                merchant.setID(id);
                merchant.setName(resultSet.getString("name"));
                merchant.setAddress(resultSet.getString("address"));
                merchant.setIntroduction(resultSet.getString("intro"));
                merchant.setScore(resultSet.getDouble("score"));
                merchant.setStatus(resultSet.getString("status"));
            }
        });
        return merchant;
    }

    public boolean updateInfoByID(final Merchant merchant)
    {
        int temp;
        temp = jdbcTemplate.update(UPDATE_INFO_BY_ID, new Object[]{merchant.getName(), merchant.getAddress(),
                merchant.getStatus(), merchant.getIntroduction(), merchant.getScore(), merchant.getID()});
        return temp > 0;
    }
}
