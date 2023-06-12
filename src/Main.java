import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class Main {
    public static void main(String[] args) {

        List<Guest> guests = new ArrayList<>();
        List<Room> rooms = new ArrayList<>();
//        List<Booking> bookings = new ArrayList<>();
        BookingManager bookings = new BookingManager();

// vytvoření hostů
        guests.add(new Guest("Adéla Malíková", LocalDate.of(1993, 3, 13)));
        guests.add(new Guest("Jan Dvořáček", LocalDate.of(1995, 5, 5)));
        guests.add(new Guest("Karel Dvořák", LocalDate.of(1990, 5, 15)));
        guests.add(new Guest("Karel Dvořák", LocalDate.of(1979, 1, 3)));
        guests.add(new Guest("ABC Relax", LocalDate.of(1979, 1, 3)));
        guests.add(new Guest("Alena Krásová", LocalDate.of(1956, 11, 30)));

//  výpis hostů
        System.out.println("\nSeznam hostů:");
        for (Guest guest : guests) {
            System.out.println("Jméno hosta: " + guest.getName() + " (" + guest.getBirthDate() + ")");
        }

//  vytvoření pokojů
        rooms.add(new Room(1, 1, TRUE, TRUE, 1000));
        rooms.add(new Room(2, 1, TRUE, TRUE, 1000));
        rooms.add(new Room(3, 3, FALSE, TRUE, 2400));

//  výpis pokojů
        System.out.println("\nSeznam pokojů:");
        for (Room room : rooms) {
            System.out.println("Číslo pokoje: " + room.roomNumber + ", počet postelí: " + room.numberOfBeds + ", cena: " + room.pricePerNight);
        }

//  vytvoření rezervací
        bookings.add(new Booking(guests.get(0), rooms.get(0), LocalDate.of(2021, 7, 19), 7, TRUE));
        bookings.add(new Booking(guests.get(0), rooms.get(2), LocalDate.of(2021, 9, 1), 13, FALSE));
        bookings.get(1).getOtherGuests().add(guests.get(1)); // dodatečný host k předchozí rezervaci
        bookings.add(new Booking(guests.get(2), rooms.get(2), LocalDate.of(2023, 6, 1), 6, FALSE));
        bookings.add(new Booking(guests.get(3), rooms.get(1), LocalDate.of(2023, 8, 18), 3, TRUE));
        for (int i = 1; i < 31; i++)
            bookings.add(new Booking(guests.get(4), rooms.get(1), LocalDate.of(2023, 6, i), 1, TRUE));
        for (int i = 0; i < 7; i++)
            bookings.add(new Booking(guests.get(5), rooms.get(0), LocalDate.of(2023, 6 + i, 1), 5, FALSE));
        for (int i = 0; i < 4; i++)
            bookings.add(new Booking(guests.get(4), rooms.get(1), LocalDate.of(2023, 8, 1 + (i * 7)), 3, TRUE));

//  výpis rezervací
        System.out.println("\nSeznam rezervací:");
        for (Booking booking : bookings.getBookings()) { // rezervace pokoje a hlavního hosta
            System.out.println("Číslo pokoje: " + booking.getRoom().roomNumber + ", jméno hosta: " + booking.getGuest().name + ", datum od: " + booking.getDatefrom() + ", datum do: " + booking.getDatefrom().plusDays(booking.getNumberOfNights()) + ", počet nocí: " + booking.getNumberOfNights() + ", výheld na moře: " + (booking.getRoom().isSeaView ? "Ano" : "Ne") + ", cena: " + (booking.getRoom().pricePerNight * booking.getNumberOfNights()) + "Kč");
            for (Guest guest : booking.getOtherGuests())
                System.out.println("    Jméno dalšího hosta: " + guest.getName()); // výpis dalších hostí (pokud jsou)
        }

        System.out.println("Počet rezervací: " + bookings.getNumberOfBookings());
        System.out.println("Počet pracovních rezervací: " + bookings.getNumberOfWorkingBookings());

//        průměrná počet osob na rezervaci
        int personCounter = 0;
        for (Booking booking : bookings.getBookings()) {  // hlavní host tam je vždy
            personCounter++;
            for (Guest guest : booking.getOtherGuests()) { // výpis dalších hostí (pokud jsou)
                personCounter++;
            }
        }
        System.out.println("Průměrný počet osob na rezervaci: " + (double) personCounter / (double) bookings.getNumberOfBookings());

        System.out.println("\nSeznam prvých osmi rekreačních rezervací:");
        int i = 0;
        for (Booking booking : bookings.getBookings()) { // rezervace pokoje a hlavního hosta
            if (booking.isIstourist()) {
                System.out.println("Číslo pokoje: " + booking.getRoom().roomNumber + ", jméno hosta: " + booking.getGuest().name + ", datum od: " + booking.getDatefrom() + ", datum do: " + booking.getDatefrom().plusDays(booking.getNumberOfNights()) + ", počet nocí: " + booking.getNumberOfNights() + ", výheld na moře: " + (booking.getRoom().isSeaView ? "Ano" : "Ne") + ", cena: " + (booking.getRoom().pricePerNight * booking.getNumberOfNights()) + "Kč");
                i++;
                if (i == 8) break;
            }

        }

        int jednodennich = 0;
        int dvoudennich = 0;
        int vicedennich = 0;
        for (Booking booking : bookings.getBookings()) { // rezervace pokoje a hlavního hosta
            switch (booking.getNumberOfNights()) {
                case 1:
                    jednodennich++;
                    break;
                case 2:
                    dvoudennich++;
                    break;
                default:
                    vicedennich++;
            }
        }
        System.out.println("Počet jednodenních rezervací: " + jednodennich);
        System.out.println("Počet dvoudenních rezervací: " + dvoudennich);
        System.out.println("Počet vídedenních rezervací: " + vicedennich);
    }
}


