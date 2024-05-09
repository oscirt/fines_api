package org.example.fines_api.controller;

import lombok.RequiredArgsConstructor;
import org.example.fines_api.dto.fine.FineDto;
import org.example.fines_api.dto.payment.PaymentDto;
import org.example.fines_api.dto.user.UserDto;
import org.example.fines_api.dto.validation.OnCreate;
import org.example.fines_api.dto.validation.OnUpdate;
import org.example.fines_api.dto.vehicle.VehicleDto;
import org.example.fines_api.entity.Fine;
import org.example.fines_api.entity.Payment;
import org.example.fines_api.entity.User;
import org.example.fines_api.entity.Vehicle;
import org.example.fines_api.mapper.FineMapper;
import org.example.fines_api.mapper.PaymentMapper;
import org.example.fines_api.mapper.UserMapper;
import org.example.fines_api.mapper.VehicleMapper;
import org.example.fines_api.service.FineService;
import org.example.fines_api.service.PaymentService;
import org.example.fines_api.service.UserService;
import org.example.fines_api.service.VehicleService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
@Validated
public class UserController {

    private final UserService userService;
    private final VehicleService vehicleService;
    private final FineService fineService;
    private final PaymentService paymentService;

    @GetMapping
    public List<UserDto> getAllUsers() {
        return UserMapper.toDto(userService.getAllUsers());
    }

    @GetMapping("/{userId}")
    public UserDto getUserById(@PathVariable Integer userId) {
        return UserMapper.toDto(userService.getUserById(userId));
    }

    @GetMapping("/{userId}/vehicles")
    public List<VehicleDto> getVehiclesByUserId(@PathVariable Integer userId) {
        User user = userService.getUserById(userId);
        return user.getVehicles().stream()
                .map(VehicleMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{userId}/fines")
    public List<FineDto> getFinesByUserId(@PathVariable Integer userId) {
        User user = userService.getUserById(userId);
        return user.getFines().stream()
                .map(FineMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{userId}/payments")
    public List<PaymentDto> getPaymentsByUserId(@PathVariable Integer userId) {
        User user = userService.getUserById(userId);
        return user.getPayments().stream()
                .map(PaymentMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public UserDto addUser(@Validated(OnCreate.class) @RequestBody UserDto user) {
        return UserMapper.toDto(userService.addUser(UserMapper.toEntity(user)));
    }

    @PostMapping("/{userId}/vehicles")
    public VehicleDto addVehicleToUser(
            @Validated(OnCreate.class) @RequestBody VehicleDto vehicleDto,
            @PathVariable Integer userId) {
        User user = userService.getUserById(userId);
        Vehicle vehicle = VehicleMapper.toEntity(vehicleDto);
        vehicle.setUser(user);
        user.getVehicles().add(vehicle);
        return VehicleMapper.toDto(vehicleService.addVehicle(vehicle));
    }

    @PostMapping("/{userId}/fines")
    public FineDto addFineToUser(
            @RequestBody FineDto fineDto,
            @PathVariable Integer userId) {
        User user = userService.getUserById(userId);
        Fine fine = FineMapper.toEntity(fineDto);
        fine.setUser(user);
        user.getFines().add(fine);
        return FineMapper.toDto(fineService.addFine(fine));
    }

    @PostMapping("/{userId}/payments")
    public PaymentDto addPaymentToUser(
            @RequestBody PaymentDto paymentDto,
            @PathVariable Integer userId) {
        User user = userService.getUserById(userId);
        Payment payment = PaymentMapper.toEntity(paymentDto);
        payment.setUser(user);
        user.getPayments().add(payment);
        return PaymentMapper.toDto(paymentService.addPayment(payment));
    }

    @PutMapping
    public UserDto updateUser(@Validated(OnUpdate.class) @RequestBody UserDto user) {
        return UserMapper.toDto(userService.updateUser(UserMapper.toEntity(user)));
    }

    @PutMapping("/{userId}/vehicles")
    public VehicleDto updateVehicle(
            @Validated(OnUpdate.class) @RequestBody VehicleDto vehicleDto,
            @PathVariable Integer userId) {
        Vehicle vehicle = VehicleMapper.toEntity(vehicleDto);
        vehicle.setUser(userService.getUserById(userId));
        return VehicleMapper.toDto(vehicleService.updateVehicle(vehicle));
    }

    @PutMapping("/{userId}/fines")
    public FineDto updateFine(
            @RequestBody FineDto fineDto,
            @PathVariable Integer userId) {
        Fine fine = FineMapper.toEntity(fineDto);
        fine.setUser(userService.getUserById(userId));
        return FineMapper.toDto(fineService.updateFine(fine));
    }

    @PutMapping("/{userId}/payments")
    public PaymentDto updatePayment(
            @RequestBody PaymentDto paymentDto,
            @PathVariable Integer userId) {
        Payment payment = PaymentMapper.toEntity(paymentDto);
        payment.setUser(userService.getUserById(userId));
        return PaymentMapper.toDto(paymentService.updatePayment(payment));
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Integer userId) {
        userService.deleteUserById(userId);
    }
}
