package org.example.fines_api.repository.mapper;

import org.example.fines_api.entity.Fine;
import org.example.fines_api.entity.Payment;
import org.example.fines_api.entity.User;
import org.example.fines_api.entity.Vehicle;
import org.example.fines_api.repository.request.AddFineRequest;
import org.example.fines_api.repository.request.AddPaymentRequest;
import org.example.fines_api.repository.request.AddVehicleRequest;
import org.example.fines_api.repository.response.FineResponse;
import org.example.fines_api.repository.response.ModelResponse;
import org.example.fines_api.repository.response.PaymentResponse;
import org.example.fines_api.repository.response.VehicleResponse;

public class ModelMapper {
    public static ModelResponse mapModelToResponse(Object object) {
        if (object instanceof Vehicle vehicle) {
            return new VehicleResponse(
                    vehicle.getId(),
                    vehicle.getUser().getId(),
                    vehicle.getVehicleNumber(),
                    vehicle.getVehicleBrand(),
                    vehicle.getVinNumber()
            );
        } else if (object instanceof Payment payment) {
            return new PaymentResponse(
                    payment.getId(),
                    payment.getUser().getId(),
                    payment.getPaymentNumber(),
                    payment.getPaymentStatus(),
                    payment.getPaymentDate(),
                    payment.getPaymentAmount()
            );
        } else if (object instanceof Fine fine) {
            return new FineResponse(
                    fine.getId(),
                    fine.getUser().getId(),
                    fine.getFineNumber(),
                    fine.getFineVehicleNumber(),
                    fine.getFineStartDate(),
                    fine.getFineEndDate(),
                    fine.getFineStatus(),
                    fine.getFineAmount(),
                    fine.getFineRequisites()
            );
        } else {
            return null;
        }
    }

    public static Object mapAddRequestToResponse(Object object, User user) {
        if (object instanceof AddVehicleRequest vehicleRequest) {
            Vehicle vehicle = new Vehicle();
            vehicle.setVehicleNumber(vehicleRequest.getVehicleNumber());
            vehicle.setVehicleBrand(vehicleRequest.getVehicleBrand());
            vehicle.setVinNumber(vehicleRequest.getVinNumber());
            vehicle.setUser(user);
            return vehicle;
        } else if (object instanceof AddPaymentRequest paymentRequest) {
            Payment payment = new Payment();
            payment.setUser(user);
            payment.setPaymentAmount(paymentRequest.getPaymentAmount());
            payment.setPaymentDate(paymentRequest.getPaymentDate());
            payment.setPaymentStatus(paymentRequest.getPaymentStatus());
            payment.setPaymentNumber(paymentRequest.getPaymentNumber());
            return payment;
        } else if (object instanceof AddFineRequest fineRequest) {
            Fine fine = new Fine();
            fine.setUser(user);
            fine.setFineNumber(fineRequest.getFineNumber());
            fine.setFineVehicleNumber(fineRequest.getFineVehicleNumber());
            fine.setFineStartDate(fineRequest.getFineStartDate());
            fine.setFineEndDate(fineRequest.getFineEndDate());
            fine.setFineStatus(fineRequest.getFineStatus());
            fine.setFineAmount(fineRequest.getFineAmount());
            fine.setFineRequisites(fineRequest.getFineRequisites());
            return fine;
        } else {
            return null;
        }
    }
}
