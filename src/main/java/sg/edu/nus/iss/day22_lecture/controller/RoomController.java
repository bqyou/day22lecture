package sg.edu.nus.iss.day22_lecture.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.nus.iss.day22_lecture.model.Room;
import sg.edu.nus.iss.day22_lecture.service.RoomService;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    @Autowired
    RoomService roomService;

    @GetMapping("/count")
    public Integer getRoomCount() {

        Integer roomCount = roomService.count();

        return roomCount;
    }

    @GetMapping("/")
    public ResponseEntity<List<Room>> retrieveAllRooms() {
        List<Room> rooms = new ArrayList<Room>();
        rooms = roomService.findAll();

        if (rooms.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Room> retrieveRoomById(@PathVariable("id") Integer id) {
        Room room = roomService.findById(id);
        return new ResponseEntity<>(room, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Boolean> createRoom(@RequestBody Room room) {
        Boolean result = roomService.save(room);
        if (!result) {
            return new ResponseEntity<Boolean>(!result, HttpStatus.OK);
        } else {
            return new ResponseEntity<Boolean>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/")
    public ResponseEntity<Integer> updateRoom(@RequestBody Room room) {
        Integer updated = roomService.update(room);
        if (updated == 1) {
            return new ResponseEntity<Integer>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<Integer>(updated, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deleteRoom(@PathVariable("id") Integer id) {
        Integer result = 0;
        result = roomService.deleteById(id);
        if (result == 0) {
            return new ResponseEntity<Integer>(0, HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity<Integer>(1, HttpStatus.OK);
        }
    }

}
