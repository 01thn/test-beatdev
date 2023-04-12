package by.tnavitski.testbeatdev.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "app_user")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "ID", unique = true, nullable = false)
    @Type(type = "uuid-char")
    private UUID id;

    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @Column(name = "EMAIL", nullable = false, unique = true)
    @Pattern(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
            + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$",
            message = "Invalid email")
    private String email;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "DATE_OF_BIRTH", nullable = false)
    private LocalDate dateOfBirth;

    /**
     * В дальнейшем, следует определиться с хостингом для изображений и, возможно, добавить проверку URI
     */
    @Column(name = "IMAGE_URI")
    private String imageUri;

    @Column(name = "DATE_CREATED", nullable = false)
    @CreationTimestamp
    private LocalDate dateCreated;

    @Column(name = "DATE_LAST_UPDATED")
    @UpdateTimestamp
    private LocalDate dateLastUpdated;

    @Column(name = "STATUS", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;
}
