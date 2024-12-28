package ru.vsu.cs.dorofeyeva_s_v.att3;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FlightScheduleService {

    private final FlightScheduleRepository flightScheduleRepository;

    @Transactional
    public FlightSchedule addFlight(String departureCity, String arrivalCity, LocalDateTime departureTime, String status) {
        FlightSchedule flightSchedule = new FlightSchedule();
        flightSchedule.setDepartureCity(departureCity);
        flightSchedule.setArrivalCity(arrivalCity);
        flightSchedule.setDepartureTime(departureTime);
        flightSchedule.setStatus(status);
        return flightScheduleRepository.save(flightSchedule);
    }

    @Transactional
    public void deleteFlightById(Long flightId) {
        Optional<FlightSchedule> flightSchedule = flightScheduleRepository.findById(flightId);
        if (flightSchedule.isPresent()) {
            flightScheduleRepository.delete(flightSchedule.get());
        } else {
            throw new IllegalArgumentException("Flight with id " + flightId + " not found");
        }
    }

    @Transactional
    public FlightSchedule updateFlight(Long flightId, String departureCity, String arrivalCity, LocalDateTime departureTime, String status) {
        Optional<FlightSchedule> existingFlightSchedule = flightScheduleRepository.findById(flightId);
        if (existingFlightSchedule.isPresent()) {
            FlightSchedule flightSchedule = existingFlightSchedule.get();
            flightSchedule.setDepartureCity(departureCity);
            flightSchedule.setArrivalCity(arrivalCity);
            flightSchedule.setDepartureTime(departureTime);
            flightSchedule.setStatus(status);
            return flightScheduleRepository.save(flightSchedule);
        } else {
            throw new IllegalArgumentException("Flight with id " + flightId + " not found");
        }
    }
}