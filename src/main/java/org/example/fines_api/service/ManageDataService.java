package org.example.fines_api.service;

import org.example.fines_api.entity.Fine;
import org.example.fines_api.entity.Payment;
import org.example.fines_api.entity.User;
import org.example.fines_api.entity.Vehicle;

import java.util.List;

public interface ManageDataService {

    List<User> getAllUsers();

    User getUserById(Integer userId);

    User updateUser(User user);

    User addUser(User user);

    void deleteUserById(Integer userId);

    List<Fine> getAllFines();

    Fine getFineById(Integer fineId);

    Fine updateFine(Fine fine);

    Fine addFine(Fine fine);

    void deleteFineById(Integer fineId);

    List<Payment> getAllPayments();

    Payment getPaymentById(Integer paymentId);

    Payment updatePayment(Payment payment);

    Payment addPayment(Payment payment);

    void deletePaymentById(Integer paymentId);

    List<Vehicle> getAllVehicles();

    Vehicle getVehicleById(Integer vehicleId);

    Vehicle updateVehicle(Vehicle vehicle);

    Vehicle addVehicle(Vehicle vehicle);

    void deleteVehicleById(Integer vehicleId);
}
