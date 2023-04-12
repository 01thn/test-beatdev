package by.tnavitski.testbeatdev.service;

import by.tnavitski.testbeatdev.dto.UserRequestDto;
import by.tnavitski.testbeatdev.dto.UserResponseDto;
import by.tnavitski.testbeatdev.exception.UserException;
import by.tnavitski.testbeatdev.model.Status;

import java.util.UUID;

public interface UserService {

    UserResponseDto save(UserRequestDto request) throws UserException;

    UserResponseDto findById(UUID id) throws UserException;

    void deleteById(UUID id) throws UserException;

    UserResponseDto updateById(UUID id, UserRequestDto request) throws UserException;

    UserResponseDto updateById(UUID id, Status status) throws UserException;

    Boolean isUnique(UserRequestDto request);

}
