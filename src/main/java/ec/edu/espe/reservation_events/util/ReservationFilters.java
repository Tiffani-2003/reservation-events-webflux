package ec.edu.espe.reservation_events.util;

import ec.edu.espe.reservation_events.model.ReservationEvent;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class ReservationFilters {

    public static final Predicate<ReservationEvent> VALID_RESERVATION =
            reservation ->
                    reservation.getPrice() > 0 &&
                            !reservation.getEmails().isEmpty();

    public static final Consumer<ReservationEvent> PRINT_EVENT =
            reservation ->
                    System.out.println("Evento procesado -> " + reservation.getId()
                            + " | Pasajero: "
                            + reservation.getPassengerName()
                            + " | Precio: "
                            + reservation.getPrice());

}