package org.example.fines_api.mapper;

import org.example.fines_api.dto.fine.FineDto;
import org.example.fines_api.entity.Fine;

import java.util.List;
import java.util.stream.Collectors;

public class FineMapper {

    public static FineDto toDto(Fine fine) {
        return new FineDto(
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
    }

    public static List<FineDto> toDto(List<Fine> fines) {
        return fines.stream()
                .map(FineMapper::toDto)
                .collect(Collectors.toList());
    }

    public static Fine toEntity(FineDto dto) {
        return new Fine(
                dto.getId(),
                null,
                dto.getNumber(),
                dto.getVehicleNumber(),
                dto.getStartDate(),
                dto.getEndDate(),
                dto.getStatus(),
                dto.getAmount(),
                dto.getRequisites()
        );
    }
}
