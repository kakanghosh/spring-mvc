package com.helloworld.springmvcdemo.dao;

import com.helloworld.springmvcdemo.models.User;
import com.helloworld.springmvcdemo.repo.SimpleCrud;
import com.helloworld.springmvcdemo.repo.SimplePagination;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDao implements SimpleCrud<User>, SimplePagination<User>, RowMapper<User> {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int save(User object) {
        final String SQL_QUERY = "insert into users(id, first_name, last_name, gender) " +
                "values(null,'"+object.getFirstName()+"','"+object.getLastName()+"', '"+object.getGender()+"');";
        return jdbcTemplate.update(SQL_QUERY);
    }

    @Override
    public int update(User object) {
        final String SQL_QUERY = "UPDATE users SET first_name='"+object.getFirstName()
                +"', last_name='"+object.getLastName()
                +"', gender='"+object.getGender()
                +"' WHERE id ="+object.getId()+";";
        return jdbcTemplate.update(SQL_QUERY);
    }

    @Override
    public int delete(Long id) {
        final String SQL_QUERY = "DELETE FROM users WHERE id ="+id+";";
        return jdbcTemplate.update(SQL_QUERY);
    }

    @Override
    public User find(Long id) {
        final String SQL_QUERY = "SELECT * FROM users where id = '"+id+"'";
        return jdbcTemplate.queryForObject(SQL_QUERY, this);
    }

    @Override
    public List<User> findAll() {
        final String SQL_QUERY = "SELECT * FROM users";
        return jdbcTemplate.query(SQL_QUERY, this);
    }

    private User getUserFromResultSet(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getLong(1));
        user.setFirstName(resultSet.getString(2));
        user.setLastName(resultSet.getString(3));
        user.setGender(resultSet.getString(4));
        return user;
    }

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return getUserFromResultSet(rs);
    }

    @Override
    public List<User> findAllByPagination(int page, int itemPerPage) {
        final String SQL_QUERY = "SELECT * FROM users LIMIT "+page+", "+itemPerPage+";";
        return jdbcTemplate.query(SQL_QUERY, this);
    }

    @Override
    public int findTotalPages(int itemPerPage) {
        final String SQL_QUERY = "SELECT COUNT(*) FROM users;";
        final int totalRow = jdbcTemplate.query(SQL_QUERY, (resultSet, i) -> resultSet.getInt(1)).get(0);
        final int totalPages = (totalRow / itemPerPage);
        return (totalRow % itemPerPage) > 0 ? totalPages + 1 : totalPages;
    }
}
