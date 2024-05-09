package org.example.fines_api.dto.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.fines_api.dto.validation.OnCreate;
import org.example.fines_api.dto.validation.OnUpdate;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    @NotNull(message = "Id must be not null.", groups = OnUpdate.class)
    private Integer id;

    @Length(max = 100, message = "Name length must be less than 100 symbols.", groups = { OnCreate.class, OnUpdate.class })
    private String name;

    @Length(min = 11, max = 11, message = "Phone number length must be equals 11 symbols.", groups = { OnCreate.class, OnUpdate.class })
    private String phoneNumber;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime birthDate;

    @Length(max = 100, message = "Login length must be less than 100 symbols.", groups = { OnCreate.class, OnUpdate.class })
    private String login;

    @Length(max = 100, message = "Password length must be less than 100 symbols.", groups = { OnCreate.class, OnUpdate.class })
    private String password;

    @Length(min = 10, max = 10, message = "License name length must be equals 10 symbols.", groups = { OnCreate.class, OnUpdate.class })
    private String license;
}
