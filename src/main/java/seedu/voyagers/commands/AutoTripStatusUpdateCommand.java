package seedu.voyagers.commands;

import seedu.voyagers.classes.Trip;
import seedu.voyagers.classes.TripList;
import seedu.voyagers.utils.Status;
import seedu.voyagers.utils.Storage;
import seedu.voyagers.utils.Ui;
import java.util.Date;

public class AutoTripStatusUpdateCommand {
    public void execute(TripList trips, Ui ui, Storage storage) {
        Date currentDate = new Date();

        for (int i = 0; i < trips.size(); i++) {
            Trip trip = trips.get(i);
            if (trip.getEndDate().before(currentDate) && (trip.getStatus() == Status.ONGOING
                    || trip.getStatus() == Status.UPCOMING)){
                trip.setStatus(Status.COMPLETED);
                ui.echo("Trip " + trip.getName() + " has ended. It is now marked as completed.");
            }
            else if (trip.getStartDate().after(currentDate) && trip.getStatus() == Status.UPCOMING){
                trip.setStatus(Status.ONGOING);
                ui.echo("Trip " + trip.getName() + " has started. It is now marked as ongoing.");
            }
        }
    }
}
