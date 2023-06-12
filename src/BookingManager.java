import java.util.ArrayList;
import java.util.List;

public class BookingManager {
    private List<Booking> bookings = new ArrayList<>();

    public void add(Booking newBooking) {
        this.bookings.add(newBooking);
    }

    public List<Booking> getBookings() {
        List<Booking> result = new ArrayList<>(bookings) ;
        return result;
    }
    public Booking get(int i) {
        return bookings.get(i);
    }

    public int getNumberOfBookings() {
        return bookings.size();
    }
    
    public int getNumberOfWorkingBookings() {
        int numberOfWorkingBookings = 0;
        for (Booking item: bookings) {
            if (! item.isIstourist()) numberOfWorkingBookings++;
        }
        return numberOfWorkingBookings;
    }
}

