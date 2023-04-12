package by.tnavitski.testbeatdev.controller;

import by.tnavitski.testbeatdev.controller.helpers.UserEndpoints;
import by.tnavitski.testbeatdev.dto.UserRequestDto;
import by.tnavitski.testbeatdev.dto.UserResponseDto;
import by.tnavitski.testbeatdev.exception.UserException;
import by.tnavitski.testbeatdev.model.Status;
import by.tnavitski.testbeatdev.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping(UserEndpoints.USER)
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping(UserEndpoints.ADD)
    @Operation(summary = "Save new user",
            description = "Save new user. Email must be unique")
    public ResponseEntity<UserResponseDto> save(@Valid @RequestBody UserRequestDto request) throws UserException, InterruptedException {
        Thread.sleep(5000L);
        return new ResponseEntity<>(service.save(request), HttpStatus.CREATED);
    }

    @GetMapping(UserEndpoints.GET_BY_ID)
    @Operation(summary = "Get user",
            description = "Get user by id")
    public ResponseEntity<UserResponseDto> getById(@PathVariable UUID id) throws UserException, InterruptedException {
        Thread.sleep(6000L);
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @DeleteMapping(UserEndpoints.DELETE_BY_ID)
    @Operation(summary = "Delete user",
            description = "Delete user by id")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable UUID id) throws UserException, InterruptedException {
        Thread.sleep(6500L);
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(UserEndpoints.UPDATE)
    @Operation(summary = "Update user",
            description = "Update user by id")
    public ResponseEntity<UserResponseDto> update(@PathVariable UUID id,
                                                  @Valid @RequestBody UserRequestDto request) throws UserException, InterruptedException {
        Thread.sleep(7000L);
        return new ResponseEntity<>(service.updateById(id, request), HttpStatus.OK);
    }

    @PostMapping(UserEndpoints.SET_STATUS)
    @Operation(summary = "Update user status",
            description = "Update user status by id")
    public ResponseEntity<UserResponseDto> update(@PathVariable UUID id,
                                                  @RequestParam Status status) throws UserException, InterruptedException {
        Thread.sleep(7000L);
        return new ResponseEntity<>(service.updateById(id, status), HttpStatus.OK);
    }

}
