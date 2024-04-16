package org.example.fines_api.service;

import org.example.fines_api.entity.Fine;
import org.example.fines_api.entity.Payment;
import org.example.fines_api.entity.User;
import org.example.fines_api.entity.Vehicle;

import java.util.List;

public interface ManageDataService {

    List<User> getAllUsers();

    User getUserById(int id);

    User updateUser(User user);

    User addUser(User user);

    void deleteUser(User user);

    void deleteUserById(int userId);

    List<Fine> getAllFines();

    Fine updateFine(Fine fine);

    Fine addFine(Fine fine);

    void deleteFine(Fine fine);

    void deleteFineById(int fineId);

    List<Payment> getAllPayments();

    Payment updatePayment(Payment payment);

    Payment addPayment(Payment payment);

    void deletePayment(Payment payment);

    void deletePaymentById(int paymentId);

    List<Vehicle> getAllVehicles();

    Vehicle updateVehicle(Vehicle vehicle);

    Vehicle addVehicle(Vehicle vehicle);

    void deleteVehicle(Vehicle vehicle);

    void deleteVehicleById(int vehicleId);
}
