package org.example.fines_api.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.fines_api.entity.Fine;
import org.example.fines_api.entity.Payment;
import org.example.fines_api.entity.User;
import org.example.fines_api.entity.Vehicle;
import org.example.fines_api.repository.FineRepository;
import org.example.fines_api.repository.PaymentRepository;
import org.example.fines_api.repository.UserRepository;
import org.example.fines_api.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManageDataServiceImpl implements ManageDataService {

    Logger logger = LogManager.getLogger();

    private final UserRepository userRepository;
    private final FineRepository fineRepository;
    private final PaymentRepository paymentRepository;
    private final VehicleRepository vehicleRepository;

    public ManageDataServiceImpl(
            UserRepository userRepository,
            FineRepository fineRepository,
            PaymentRepository paymentRepository,
            VehicleRepository vehicleRepository
    ) {
        this.userRepository = userRepository;
        this.fineRepository = fineRepository;
        this.paymentRepository = paymentRepository;
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(int id) {
        return userRepository.getReferenceById(id);
    }

    @Override
    public User updateUser(User user) {
        Optional<User> optionalUser = userRepository.findById(user.getId());
        if (optionalUser.isPresent()) {
            User userFromDb = optionalUser.get();
            userFromDb.setBirthDate(user.getBirthDate());
            userFromDb.setLicense(user.getLicense());
            userFromDb.setLogin(user.getLogin());
            userFromDb.setPassword(user.getPassword());
            userFromDb.setPhoneNumber(user.getPhoneNumber());
            userFromDb.setUsername(user.getUsername());
            return userRepository.save(userFromDb);
        }
        logger.info("User not found in database");
        return null;
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    @Override
    public void deleteUserById(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<Fine> getAllFines() {
        return fineRepository.findAll();
    }

    @Override
    public Fine updateFine(Fine fine) {
        Optional<Fine> optionalFine = fineRepository.findById(fine.getId());
        if (optionalFine.isPresent()) {
            Fine fineFromDb = optionalFine.get();
            fineFromDb.setFineAmount(fine.getFineAmount());
            fineFromDb.setFineNumber(fine.getFineNumber());
            fineFromDb.setFineRequisites(fine.getFineRequisites());
            fineFromDb.setFineStatus(fine.getFineStatus());
            fineFromDb.setFineStartDate(fine.getFineStartDate());
            fineFromDb.setFineEndDate(fine.getFineEndDate());
            fineFromDb.setFineVehicleNumber(fine.getFineVehicleNumber());
            fineFromDb.setUser(fine.getUser());
            return fineRepository.save(fineFromDb);
        }
        logger.info("Fine not found in database");
        return null;
    }

    @Override
    public Fine addFine(Fine fine) {
        return fineRepository.save(fine);
    }

    @Override
    public void deleteFine(Fine fine) {
        fineRepository.delete(fine);
    }

    @Override
    public void deleteFineById(int fineId) {
        fineRepository.deleteById(fineId);
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment updatePayment(Payment payment) {
        Optional<Payment> optionalPayment = paymentRepository.findById(payment.getId());
        if (optionalPayment.isPresent()) {
            Payment paymentFromDb = optionalPayment.get();
            paymentFromDb.setPaymentAmount(payment.getPaymentAmount());
            paymentFromDb.setPaymentDate(payment.getPaymentDate());
            paymentFromDb.setPaymentNumber(payment.getPaymentNumber());
            paymentFromDb.setPaymentStatus(payment.getPaymentStatus());
            paymentFromDb.setUser(payment.getUser());
            return paymentRepository.save(paymentFromDb);
        }
        logger.info("Payment not found in database");
        return null;
    }

    @Override
    public Payment addPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public void deletePayment(Payment payment) {
        paymentRepository.delete(payment);
    }

    @Override
    public void deletePaymentById(int paymentId) {
        paymentRepository.deleteById(paymentId);
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    @Override
    public Vehicle updateVehicle(Vehicle vehicle) {
        Optional<Vehicle> optionalVehicle = vehicleRepository.findById(vehicle.getId());
        if (optionalVehicle.isPresent()) {
            Vehicle vehicleFromDb = optionalVehicle.get();
            vehicleFromDb.setVehicleBrand(vehicle.getVehicleBrand());
            vehicleFromDb.setUser(vehicle.getUser());
            vehicleFromDb.setVehicleNumber(vehicle.getVehicleNumber());
            vehicleFromDb.setVinNumber(vehicle.getVinNumber());
            return vehicleRepository.save(vehicle);
        }
        logger.info("Vehicle not found in database");
        return null;
    }

    @Override
    public Vehicle addVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public void deleteVehicle(Vehicle vehicle) {
        vehicleRepository.delete(vehicle);
    }

    @Override
    public void deleteVehicleById(int vehicleId) {
        vehicleRepository.deleteById(vehicleId);
    }
}
