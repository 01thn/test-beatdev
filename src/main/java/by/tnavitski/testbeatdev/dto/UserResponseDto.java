package by.tnavitski.testbeatdev.dto;

import by.tnavitski.testbeatdev.model.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {

    private UUID id;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private LocalDate dateOfBirth;

    private String imageUri;

    private LocalDate dateCreated;

    private LocalDate dateLastUpdated;

    private Status status;
}
