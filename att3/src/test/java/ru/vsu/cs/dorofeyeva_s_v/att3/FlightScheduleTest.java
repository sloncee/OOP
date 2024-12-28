package ru.vsu.cs.dorofeyeva_s_v.att3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@Transactional
class FlightScheduleTest {

    @Autowired
    private FlightScheduleService flightScheduleService;

    @Autowired
    private FlightScheduleRepository flightScheduleRepository;

    @BeforeEach
    public void setUp() {
        flightScheduleRepository.deleteAll();
    }

    @Test
    public void testAddFlight() {
        String departureCity = "New York";
        String arrivalCity = "Los Angeles";
        LocalDateTime departureTime = LocalDateTime.of(2024, 12, 10, 15, 0);
        String status = "On Time";
        FlightSchedule addedFlight = flightScheduleService.addFlight(departureCity, arrivalCity, departureTime, status);
        assertThat(addedFlight).isNotNull();
        assertThat(addedFlight.getFlightId()).isNotNull();
        assertThat(addedFlight.getDepartureCity()).isEqualTo(departureCity);
        assertThat(addedFlight.getArrivalCity()).isEqualTo(arrivalCity);
        assertThat(addedFlight.getDepartureTime()).isEqualTo(departureTime);
        assertThat(addedFlight.getStatus()).isEqualTo(status);
    }

    @Test
    public void testUpdateFlight() {
        FlightSchedule addedFlight = flightScheduleService.addFlight(
                "New York", "Los Angeles", LocalDateTime.of(2024, 12, 10, 15, 0), "On Time"
        );
        String newDepartureCity = "Chicago";
        String newArrivalCity = "San Francisco";
        LocalDateTime newDepartureTime = LocalDateTime.of(2024, 12, 15, 10, 30);
        String newStatus = "Delayed";
        FlightSchedule updatedFlight = flightScheduleService.updateFlight(
                addedFlight.getFlightId(), newDepartureCity, newArrivalCity, newDepartureTime, newStatus
        );
        assertThat(updatedFlight).isNotNull();
        assertThat(updatedFlight.getFlightId()).isEqualTo(addedFlight.getFlightId());
        assertThat(updatedFlight.getDepartureCity()).isEqualTo(newDepartureCity);
        assertThat(updatedFlight.getArrivalCity()).isEqualTo(newArrivalCity);
        assertThat(updatedFlight.getDepartureTime()).isEqualTo(newDepartureTime);
        assertThat(updatedFlight.getStatus()).isEqualTo(newStatus);
    }

    @Test
    public void testDeleteFlightById() {
        FlightSchedule addedFlight = flightScheduleService.addFlight(
                "New York", "Los Angeles", LocalDateTime.of(2024, 12, 10, 15, 0), "On Time"
        );
        flightScheduleService.deleteFlightById(addedFlight.getFlightId());
        assertThat(flightScheduleRepository.findById(addedFlight.getFlightId())).isEmpty();
    }

    @Test
    public void testDeleteFlightById_NotFound() {
        Long invalidId = 999L;
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> flightScheduleService.deleteFlightById(invalidId)
        );

        assertThat(exception.getMessage()).isEqualTo("Flight with id " + invalidId + " not found");
    }

    @Test
    public void testUpdateFlight_NotFound() {
        Long invalidId = 999L;
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> flightScheduleService.updateFlight(
                        invalidId, "Chicago", "San Francisco", LocalDateTime.of(2024, 12, 15, 10, 30), "Delayed"
                )
        );
        assertThat(exception.getMessage()).isEqualTo("Flight with id " + invalidId + " not found");
    }
}
