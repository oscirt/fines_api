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
    public User getUserById(Integer userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        }
        logger.error(String.format("User with userId %s not found", userId));
        return null;
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
        logger.error("User not found in database");
        return null;
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUserById(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<Fine> getAllFines() {
        return fineRepository.findAll();
    }

    @Override
    public Fine getFineById(Integer fineId) {
        Optional<Fine> optionalFine = fineRepository.findById(fineId);
        if (optionalFine.isPresent()) {
            return optionalFine.get();
        }
        logger.error(String.format("Fine with id %s not found", fineId));
        return null;
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
        logger.error("Fine not found in database");
        return null;
    }

    @Override
    public Fine addFine(Fine fine) {
        return fineRepository.save(fine);
    }

    @Override
    public void deleteFineById(Integer fineId) {
        fineRepository.deleteById(fineId);
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment getPaymentById(Integer paymentId) {
        Optional<Payment> optionalPayment = paymentRepository.findById(paymentId);
        if (optionalPayment.isPresent()) {
            return optionalPayment.get();
        }
        logger.error(String.format("Payment with id %s not found", paymentId));
        return null;
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
        logger.error("Payment not found in database");
        return null;
    }

    @Override
    public Payment addPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public void deletePaymentById(Integer paymentId) {
        paymentRepository.deleteById(paymentId);
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    @Override
    public Vehicle getVehicleById(Integer vehicleId) {
        Optional<Vehicle> optionalVehicle = vehicleRepository.findById(vehicleId);
        if (optionalVehicle.isPresent()) {
            return optionalVehicle.get();
        }
        logger.error(String.format("Vehicle with id %s not found", vehicleId));
        return null;
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
        logger.error("Vehicle not found in database");
        return null;
    }

    @Override
    public Vehicle addVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public void deleteVehicleById(Integer vehicleId) {
        vehicleRepository.deleteById(vehicleId);
    }
}
