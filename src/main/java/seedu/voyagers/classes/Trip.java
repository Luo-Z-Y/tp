package seedu.voyagers.classes;

import java.util.ArrayList;
import java.util.Date;

import seedu.voyagers.utils.Currency;
import seedu.voyagers.utils.FormatDate;
import seedu.voyagers.utils.Status;


public class Trip {
    private String name;
    private Date startDate;
    private Date endDate;
    private String location;
    private String description;
    private String tripType;
    private Status status;
    private Review review;
    private Currency currency;

    private int subTripIndex = 0;

    private ArrayList<Trip> subTrips = new ArrayList<>();
    private BillList bills = new BillList(new ArrayList<Bill>());

    public Trip(String name, Date startDate, Date endDate, String location, String description) {

        if (startDate.after(endDate)) {
            throw new IllegalArgumentException("Start date cannot be after end date");
        }

        assert !startDate.after(endDate) : "Start date cannot be after end date";

        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.description = description;
        // if the date is in the future, the trip is ongoing
        // if the date is in the past, the trip is completed
        if (endDate.before(new Date())) {
            setStatus(Status.COMPLETED);
        } else if (startDate.after(new Date())) {
            setStatus(Status.UPCOMING);
        } else {
            setStatus(Status.ONGOING);
        }
        this.review = new Review();
    }

    public Trip(String[] args) throws Exception {
        this.name = args[0];

        this.startDate = FormatDate.dateFormat.parse(args[1]);
        this.endDate = FormatDate.dateFormat.parse(args[2]);
        if (startDate.after(endDate)) {
            throw new IllegalArgumentException("Start date cannot be after end date");
        }
        this.location = args[3];
        this.description = args[4];
        if (endDate.before(new Date())) {
            setStatus(Status.COMPLETED);
        } else if (startDate.after(new Date())) {
            setStatus(Status.UPCOMING);
        } else {
            setStatus(Status.ONGOING);
        }
        this.review = new Review();
    }

    public String getName() {
        return name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public int getSubTripsSize() {
        return subTrips.size();
    }


    public String getTripType() {
        return tripType;
    }

    public void setTripType(String tripType) {
        if (tripType.equalsIgnoreCase("main")) {
            this.tripType = "main";
        } else if (tripType.equalsIgnoreCase("sub")) {
            this.tripType = "sub";
        } else {
            this.tripType = "main";
        }
    }

    /**
     * Returns the duration of the trip in days.
     *
     * @return duration of the trip in days
     */
    public int getDuration() {
        return (int) ((endDate.getTime() - startDate.getTime()) / (1000 * 60 * 60 * 24));
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
        for (Trip subTrip : subTrips) {
            subTrip.setName(name);
        }
    }

    public void setDates(Date startDate, Date endDate) {

        if (startDate.after(endDate)) {
            throw new IllegalArgumentException("Start date cannot be after end date");
        }
        this.startDate = startDate;
        this.endDate = endDate;

        if(endDate.before(new Date())) {
            setStatus(Status.COMPLETED);
        } else if(startDate.after(new Date())) {
            setStatus(Status.UPCOMING);
        } else {
            setStatus(Status.ONGOING);
        }
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Currency getCurrency() {
        return this.currency;
    }

    /**
     * Returns the sub-trips of the current trip.
     *
     * @return the list with sub-trips of the current trip
     */
    public ArrayList<Trip> getSubTrips() {
        return subTrips;
    }

    /**
     * Adds a sub-trip to the current trip.
     *
     * @param subTrip the sub-trip to be added
     */
    public void addSubTrip(Trip subTrip) {
        subTrips.add(subTrip);
        subTrip.subTripIndex = subTrips.size();
    }

    /**
     * Removes the specified sub-trip from the current trip.
     *
     * @param subTrip the sub-trip to be removed
     */
    public void removeSubTrip(Trip subTrip) {
        subTrips.remove(subTrip);
    }

    /**
     * Removes the sub-trip at the specified index.
     *
     * @param i the index of the sub-trip to be removed. Index starts from 0.
     */
    public void removeSubTrip(int i) {
        try {
            subTrips.remove(i);
            for (int j = i; j < subTrips.size(); j++) {
                subTrips.get(j).subTripIndex--;
            }
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }

    public void addBill(Bill bill) {
        bills.add(bill);
    }

    //TODO: implement way to find bills in BillList from index
    public void removeBill(Bill bill) {

    }

    public BillList getBills() {
        return this.bills;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {

        this.status = status;
        if (status == Status.CANCELLED) {
            for (Trip subTrip : subTrips) {
                subTrip.setStatus(Status.CANCELLED);
            }
        }
        else {
            for (Trip subTrip : subTrips) {
                if(subTrip.endDate.before(new Date())) {
                    subTrip.status = Status.COMPLETED;
                } else if(subTrip.startDate.after(new Date())) {
                    subTrip.status = Status.UPCOMING;
                } else {
                    subTrip.status = Status.COMPLETED;
                }
            }
        }
    }

    /**
     * Returns the sub-trip at the specified index.
     *
     * @param i the index of the sub-trip to be returned. Index starts from 0.
     * @return the sub-trip at the specified index
     */
    public Trip getSubTrip(int i) {
        try {
            return subTrips.get(i);
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }

    public Review getReview() {
        return review;
    }

    @Override
    public String toString() {
        String s;
        if (this.tripType == "main") {
            s = "\tTrip Name: " + name;
        } else {
            s = "\t" + name + "-" + subTripIndex;
        }

        s += "\t\tStart Date: " +
                FormatDate.dateFormat.format(startDate) + "\t\tEnd Date: " +
                FormatDate.dateFormat.format(endDate) + "\t\tLocation: " +
                location + "\t\tDescription: " + description
                + "\t\tStatus: " + getStatus();

        if (this.tripType == "main") {
            s += "\n\tSub-trips:";
            for (Trip t : subTrips) {
                s += "\n\t\t" + t.toString();
            }
        }

        return s;

    }
}
