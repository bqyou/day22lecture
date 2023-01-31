package sg.edu.nus.iss.day22_lecture.repository;

import java.util.List;

import sg.edu.nus.iss.day22_lecture.model.Room;

public interface RoomRepo {
    int count();

    // create
    Boolean save(Room room);

    // read all
    List<Room> findAll();

    // read
    Room findById(Integer id);

    // update
    Integer update(Room room);

    // delete
    Integer deleteById(Integer id);

}
