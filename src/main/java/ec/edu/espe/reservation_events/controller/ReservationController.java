package ec.edu.espe.reservation_events.controller;

import ec.edu.espe.reservation_events.model.ReservationEvent;
import ec.edu.espe.reservation_events.util.ReservationFilters;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;

@RestController
public class ReservationController {

    @GetMapping("/api/reservations/stream")
    public Flux<ReservationEvent> streamReservations() {

        ReservationEvent r1 =
                new ReservationEvent(
                        "R001",
                        "Juan Perez",
                        320.0,
                        List.of("juan@gmail.com"));

        ReservationEvent r2 =
                new ReservationEvent(
                        "R002",
                        "Maria Lopez",
                        0.0,
                        List.of("maria@gmail.com"));

        ReservationEvent r3 =
                new ReservationEvent(
                        "R003",
                        "Carlos Ruiz",
                        500.0,
                        List.of("carlos@gmail.com"));

        ReservationEvent r4 =
                new ReservationEvent(
                        "R004",
                        "Ana Torres",
                        -25.0,
                        List.of());

        ReservationEvent r5 =
                new ReservationEvent(
                        "R005",
                        "Pedro Gómez",
                        800.0,
                        List.of("pedro@gmail.com"));

        ReservationEvent defaultReservation =
                new ReservationEvent(
                        "DEFAULT",
                        "Reserva Genérica",
                        1.0,
                        List.of("default@gmail.com"));

        return Flux.just(
                        r1,
                        r2,
                        r3,
                        r4,
                        r5)
                .delayElements(Duration.ofSeconds(1))
                .filter(ReservationFilters.VALID_RESERVATION)
                .doOnNext(ReservationFilters.PRINT_EVENT)
                .defaultIfEmpty(defaultReservation);
    }
}