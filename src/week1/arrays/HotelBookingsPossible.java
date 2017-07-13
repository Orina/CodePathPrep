package week1.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A hotel manager has to process N advance bookings of rooms for the next season. His hotel has K rooms. Bookings contain an arrival date and a departure date. He wants to find out whether there are enough rooms in the hotel to satisfy the demand. Write a program that solves this problem in time O(N log N) .
 *
 * Input:
 *
 *
 * First list for arrival time of booking.
 * Second list for departure time of booking.
 * Third is K which denotes count of rooms.
 *
 * Output:
 *
 * A boolean which tells whether its possible to make a booking.
 * Return 0/1 for C programs.
 * O -> No there are not enough rooms for N booking.
 * 1 -> Yes there are enough rooms for N booking.
 * Example :
 *
 * Input :
 * Arrivals :   [1 3 5]
 * Departures : [2 6 8]
 * K : 1
 *
 * Return : False / 0
 *
 * At day = 5, there are 2 guests in the hotel. But I have only one room.
 *
 * Created by Elmira Andreeva on 7/12/17.
 */
public class HotelBookingsPossible {

    public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
        List<Booking> bookings = new ArrayList<Booking>();
        int N = arrive.size();

        for (int i = 0; i < N; i++) {
            bookings.add(new Booking(arrive.get(i), true));
            bookings.add(new Booking(depart.get(i), false));
        }

        Collections.sort(bookings);

        int overlapped = 0;
        for (Booking b : bookings) {
            if (b.isStart) overlapped++;
            else overlapped--;

            if (overlapped > K) return false;
        }
        return true;
    }

    class Booking implements Comparable<Booking> {
        int time;
        boolean isStart;

        public Booking(int time, boolean isStart) {
            this.time = time;
            this.isStart = isStart;
        }

        public int compareTo(Booking a) {
            if (this == a) return 0;
            if (time < a.time) return -1;
            else if (time > a.time) return 1;
            else if (isStart && !a.isStart) return 1;
            else if (!isStart && a.isStart) return -1;
            else return 0;
        }
    }
}
