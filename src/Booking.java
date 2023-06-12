import java.time.LocalDate;
import java.util.*;

    public class Booking {
        // ...
        private Room room;
        private Guest guest1;
        LocalDate datefrom;
        private int numberOfNights;
        private List<Guest> otherGuests;
        private boolean istourist;

        // ...

        public Booking (Guest guest1, Room room, LocalDate datefrom, int numberOfNights, boolean isTourist) {
            this.guest1 = guest1;
            this.room = room;
            this.datefrom = datefrom;
            this.numberOfNights = numberOfNights;
            this.otherGuests = new ArrayList<>();
            this.istourist = isTourist;
            };


        public Room getRoom() {
            return room;
        }

        public void setRoom(Room room) {
            this.room = room;
        }

        public Guest getGuest() {
            return guest1;
        }

        public void setGuest(Guest guest) {
            this.guest1 = guest;
        }

        public LocalDate getDatefrom() {
            return datefrom;
        }

        public void setDatefrom(LocalDate datefrom) {
            this.datefrom = datefrom;
        }

        public int getNumberOfNights() {
            return numberOfNights;
        }

        public void setNumberOfNights(int numberOfNights) {
            this.numberOfNights = numberOfNights;
        }

        public List<Guest> getOtherGuests() {
            return otherGuests;
        }

        public void setOtherGuests(List<Guest> otherGuests) {
            this.otherGuests = otherGuests;
        }

        public Guest getGuest1() {
            return guest1;
        }

        public void setGuest1(Guest guest1) {
            this.guest1 = guest1;
        }

        public boolean isIstourist() {
            return istourist;
        }

        public void setIstourist(boolean istourist) {
            this.istourist = istourist;
        }
    }

