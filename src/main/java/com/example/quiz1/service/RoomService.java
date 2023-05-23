package com.example.quiz1.service;

import com.example.quiz1.dto.RoomDto;

import java.util.List;

public interface RoomService {
    RoomDto saveRoom(RoomDto roomDto);

    List<RoomDto> listAllRoom();

    RoomDto getRoomById(int roomId);

    RoomDto updateRoomNumberOfBedsById(int roomId, int numberOfBeds);

    void deleteRoomById(int roomId);
}
