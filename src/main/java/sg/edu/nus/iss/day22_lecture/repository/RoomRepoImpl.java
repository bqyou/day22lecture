package sg.edu.nus.iss.day22_lecture.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.day22_lecture.model.Room;

@Repository
public class RoomRepoImpl implements RoomRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;

    String countSQL = "select count(*) from room";

    String selectSQL = "select * from room";

    String selectByIdSQL = "select * from room where id = ?";

    String insertSQL = "insert into room (room_type, price) values (?, ?)";

    String updateSQL = "update room set room_type = ?, price = ? where id = ?";

    String deleteSQL = "delete from room where id = ?";

    @Override
    public int count() {
        Integer result = 0;
        result = jdbcTemplate.queryForObject(countSQL, Integer.class);
        return result;
    }

    @Override
    public Boolean save(Room room) {
        Boolean saved;
        saved = jdbcTemplate.execute(insertSQL, new PreparedStatementCallback<Boolean>() {

            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                ps.setString(1, room.getRoomType());
                ps.setInt(2, room.getPrice());
                Boolean rslt = ps.execute();
                return rslt;
            }

        });
        return saved;
    }

    @Override
    public List<Room> findAll() {
        List<Room> rsltList = new ArrayList<Room>();
        rsltList = jdbcTemplate.query(selectSQL, BeanPropertyRowMapper.newInstance(Room.class));
        return rsltList;
    }

    @Override
    public Room findById(Integer id) {
        Room room = jdbcTemplate.queryForObject(selectByIdSQL, BeanPropertyRowMapper.newInstance(Room.class), id);
        return room;
    }

    @Override
    public Integer update(Room room) {
        Integer updated = 0;
        updated = jdbcTemplate.update(updateSQL, new PreparedStatementSetter() {

            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, room.getRoomType());
                ps.setInt(2, room.getPrice());
                ps.setInt(3, room.getId());
            }
        });
        return updated;
    }

    @Override
    public Integer deleteById(Integer id) {
        Integer deleted = 0;

        PreparedStatementSetter pss = new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setInt(1, id);
            }
        };
        deleted = jdbcTemplate.update(deleteSQL, pss);
        return deleted;
    }

}
