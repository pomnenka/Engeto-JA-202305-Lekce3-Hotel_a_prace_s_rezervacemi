import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class Main {
    public static void main(String[] args) {

        List<Guest> guests = new ArrayList<>();
        List<Room> rooms = new ArrayList<>();
        List<Booking> bookings = new ArrayList<>();

// vytvoření hostů
        guests.add(new Guest("Adéla Malíková", LocalDate.of(1993,3,13)));
        guests.add(new Guest("Jan Dvořáček", LocalDate.of(1995,5,5)));

//  výpis hostů
        System.out.println("\nSeznam hostů:");
        for (Guest guest : guests) {
            System.out.println("Jméno hosta: " + guest.getName() + " (" + guest.getBirthDate() + ")"); }

//  vytvoření pokojů
        rooms.add(new Room( 1, 1, TRUE, TRUE, 1000));
        rooms.add(new Room( 2, 1, TRUE, TRUE, 1000));
        rooms.add(new Room( 3, 3, FALSE, TRUE, 2400));

//  výpis pokojů
        System.out.println("\nSeznam pokojů:");
        for (Room room : rooms) {
            System.out.println("Číslo pokoje: " + room.roomNumber + ", počet postelí: " + room.numberOfBeds + ", cena: " + room.pricePerNight); }

//  vytvoření rezervací
        bookings.add(new Booking(guests.get(0), rooms.get(0), LocalDate.of(2021, 7, 19), 7 , TRUE));
        bookings.add(new Booking(guests.get(0), rooms.get(2), LocalDate.of(2021, 9, 1), 13 , FALSE));
        bookings.get(1).getOtherGuests().add(guests.get(1)); // dodatečný host k předchozí rezervaci

//  výpis rezervací
        System.out.println("\nSeznam rezervací:");
        for (Booking booking : bookings) { // rezervace pokoje a hlavního hosta
            System.out.println("Číslo pokoje: " + booking.getRoom().roomNumber + ", jméno hosta: " + booking.getGuest().name + ", datum: " + booking.getDatefrom() + ", počet nocí: " + booking.getNumberOfNights() + ", cena: " + booking.getRoom().pricePerNight + "Kč");
        for (Guest guest : booking.getOtherGuests()) // výpis dalších hostí (pokud jsou)
            System.out.println("    Jméno dalšího hosta: " + guest.getName() ); }
    }
}
