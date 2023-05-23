package com.example.quiz1.service.imp;

import com.example.quiz1.dto.AddressDto;
import com.example.quiz1.dto.RoomDto;
import com.example.quiz1.entity.Address;
import com.example.quiz1.entity.Room;
import com.example.quiz1.exeption.ResourceNotFoundException;
import com.example.quiz1.repository.AddressRepository;
import com.example.quiz1.repository.RoomRepository;
import com.example.quiz1.service.RoomService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomServiceImp implements RoomService {
    private final RoomRepository roomRepository;

    public RoomServiceImp(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public RoomDto saveRoom(RoomDto roomDto) {
        // convert DTO to entity
        Room room = mapToEntity(roomDto);
        Room newRoom = roomRepository.save(room);

        // convert entity to DTO
        return mapToDTO(newRoom);

    }

    @Override
    public List<RoomDto> listAllRoom() {

        List<Room> rooms = new ArrayList<>();

        roomRepository.findAll().forEach(rooms::add);
        return rooms.stream().map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RoomDto getRoomById(int roomId) {
        Room room = roomRepository.findById(roomId).orElseThrow(() -> new ResourceNotFoundException("room: ", "id", roomId));
        return mapToDTO(room);

    }

    @Override
    public RoomDto updateRoomNumberOfBedsById(int roomId, int numberOfBeds) {

        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new ResourceNotFoundException("room: ", "Id", roomId));

        room.setNumberOfBeds(numberOfBeds);
        //save updated address to DB
        roomRepository.save(room);
        return mapToDTO(room);
    }

    @Override
    public void deleteRoomById(int roomId) {
        Room room = roomRepository.findById(roomId).orElseThrow(() -> new ResourceNotFoundException("room: ", "id", roomId));
        roomRepository.delete(room);
    }

    private RoomDto mapToDTO(Room room) {
        RoomDto roomDto = new RoomDto();
        roomDto.setRoomId(room.getRoomId());
        roomDto.setDepartmentId(room.getDepartmentId());
        roomDto.setNumberOfBeds(room.getNumberOfBeds());
        return roomDto;
    }

    // convert DTO to entity
    private Room mapToEntity(RoomDto roomDto) {
        Room room = new Room();
        room.setRoomId(roomDto.getRoomId());
        room.setDepartmentId(room.getDepartmentId());
        room.setNumberOfBeds(roomDto.getNumberOfBeds());
        return room;
    }
}
