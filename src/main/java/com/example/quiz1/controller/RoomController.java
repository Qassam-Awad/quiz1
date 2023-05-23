package com.example.quiz1.controller;

import com.example.quiz1.dto.PatientDto;
import com.example.quiz1.dto.RoomDto;
import com.example.quiz1.service.imp.PatientServiceImp;
import com.example.quiz1.service.imp.RoomServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Room")
public class RoomController {

    @Autowired
    private RoomServiceImp roomServiceImp;
    @GetMapping("/list")
    public List<RoomDto> listAllRoom() {
        return roomServiceImp.listAllRoom();
    }
    @GetMapping("/{id}")
    public ResponseEntity<RoomDto> getPatientById(@PathVariable("id") int roomId) {
        return new ResponseEntity<>(roomServiceImp.getRoomById(roomId), HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<RoomDto> savePatient(@RequestBody RoomDto roomId) {
        return new ResponseEntity<RoomDto>(roomServiceImp.saveRoom(roomId), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<RoomDto> updateAddressNameById(@PathVariable("id") int roomId, @RequestParam(name="name", required = true) int numberOfBeds) {
        return new ResponseEntity<RoomDto>(roomServiceImp.updateRoomNumberOfBedsById(roomId, numberOfBeds), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRoomById(@PathVariable("id") int roomId) {
        roomServiceImp.deleteRoomById(roomId);
        return new ResponseEntity<String>("room deleted successfully.", HttpStatus.OK);
    }
}
