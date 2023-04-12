package by.tnavitski.testbeatdev.service.impl;

import by.tnavitski.testbeatdev.dto.UserRequestDto;
import by.tnavitski.testbeatdev.dto.UserResponseDto;
import by.tnavitski.testbeatdev.exception.NoSuchUserException;
import by.tnavitski.testbeatdev.exception.UserAlreadyExistsException;
import by.tnavitski.testbeatdev.exception.UserException;
import by.tnavitski.testbeatdev.mapper.UserMapper;
import by.tnavitski.testbeatdev.model.Status;
import by.tnavitski.testbeatdev.model.User;
import by.tnavitski.testbeatdev.repository.UserRepository;
import by.tnavitski.testbeatdev.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    private final UserMapper mapper;

    public UserServiceImpl(UserRepository repository, UserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public UserResponseDto save(UserRequestDto request) throws UserException {
        if (isUnique(request))
            return mapper.entityToResponseDto(
                    repository.save(
                            mapper.requestDtoToEntity(request)
                    )
            );
        else {
            logger.error("User with id {} weren't saved because of email collision", request.getEmail());
            throw new UserAlreadyExistsException("User with such email already exists");
        }
    }

    @Override
    public UserResponseDto findById(UUID id) throws UserException {
        return repository.findById(id)
                .map(mapper::entityToResponseDto)
                .orElseThrow(() -> {
                    logger.warn("User with id {} not found", id);
                    return new NoSuchUserException("User with such id not found");
                });
    }

    @Override
    public void deleteById(UUID id) throws UserException {
        Optional.ofNullable(findById(id))
                .ifPresent(user -> repository.deleteById(user.getId()));
    }

    @Override
    public UserResponseDto updateById(UUID id, UserRequestDto request) throws UserException {
        return mapper.entityToResponseDto(
                repository.save(
                        mapper.updateEntityFromRequestDto(
                                mapper.responseDtoToUser(findById(id)),
                                request)
                )
        );
    }

    @Override
    public UserResponseDto updateById(UUID id, Status status) throws UserException {
        User user = mapper.responseDtoToUser(findById(id));
        user.setStatus(status);
        return mapper.entityToResponseDto(repository.save(user));
    }

    @Override
    public Boolean isUnique(UserRequestDto request) {
        return !repository.findByEmail(request.getEmail()).isPresent();
    }
}
