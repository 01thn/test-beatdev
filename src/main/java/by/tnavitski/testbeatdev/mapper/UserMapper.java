package by.tnavitski.testbeatdev.mapper;

import by.tnavitski.testbeatdev.dto.UserRequestDto;
import by.tnavitski.testbeatdev.dto.UserResponseDto;
import by.tnavitski.testbeatdev.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User requestDtoToEntity(UserRequestDto requestDto);

    UserResponseDto entityToResponseDto(User entity);

    User responseDtoToUser(UserResponseDto responseDto);

    User updateEntityFromRequestDto(@MappingTarget User entity, UserRequestDto requestDto);
}
