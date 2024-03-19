package seedu.voyagers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.voyagers.classes.Trip;
import seedu.voyagers.classes.TripList;
import seedu.voyagers.utils.Ui;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserTest {

    private static final String DEFAULT_START = "01 January 1900";
    private static final String DEFAULT_END = "01 January 2500";
    private final SimpleDateFormat printDateFormat = new SimpleDateFormat("dd MMMM yyyy", new Locale("en"));
    private TripList tripsList;
    private Ui ui;
    private Parser parser;

    @BeforeEach
    public void setUp() {
        tripsList = new TripList(new ArrayList<>());
        ui = new Ui();
    }

    @Test
    public void testAddMainTrip() {
        String input = "addmaintrip /n Trip1 with long name /start 2024-03-15 /end 2024-03-20 " +
                "/location Location1 /d This is the description";
        Parser.parseInput(input).execute(tripsList, ui, null);

        assertEquals(1, tripsList.size());
        Trip addedTrip = tripsList.getTrip("Trip1 with long name");
        assertEquals("Trip1 with long name", addedTrip.getName());
        assertEquals("15 March 2024", printDateFormat.format(addedTrip.getStartDate()));
        assertEquals("20 March 2024", printDateFormat.format(addedTrip.getEndDate()));
        assertEquals("Location1", addedTrip.getLocation());
        assertEquals("This is the description", addedTrip.getDescription());
    }

    @Test
    public void testAddMainTripMissingDatesLocation() {
        String input = "addmaintrip /n Trip1 /d Dates missing, location missing";

        // Set up a new input stream to simulate user input
        InputStream in = new ByteArrayInputStream("y\n".getBytes());
        System.setIn(in);

        // Execute the parser with the prepared input
        Parser.parseInput(input).execute(tripsList, ui, null);

        assertEquals(1, tripsList.size());
        Trip addedTrip = tripsList.getTrip("Trip1");
        assertEquals("Trip1", addedTrip.getName());
        assertEquals(DEFAULT_START, printDateFormat.format(addedTrip.getStartDate())); // Check start date
        assertEquals(DEFAULT_END, printDateFormat.format(addedTrip.getEndDate())); // Check end date
        assertEquals("-", addedTrip.getLocation());
        assertEquals("Dates missing, location missing", addedTrip.getDescription());
    }


    @Test
    public void testSetName() {
        String input = "addmaintrip /n Trip1 with long name " +
                "/start 2024-03-15 /end 2024-03-20 /location Location1 /d This is the description";
        Parser.parseInput(input).execute(tripsList, ui, null);

        assertEquals(1, tripsList.size());
        Trip addedTrip = tripsList.getTrip("Trip1 with long name");
        assertEquals("Trip1 with long name", addedTrip.getName());
        input = "setname /old Trip1 with long name /new This is the new name";
        Parser.parseInput(input).execute(tripsList, ui, null);
        assertEquals("This is the new name", addedTrip.getName());
    }

    @Test
    public void testSetLocation() {
        String input = "addmaintrip /n Trip1 with long name " +
                "/start 2024-03-15 /end 2024-03-20 /location Location1 /d This is the description";
        Parser.parseInput(input).execute(tripsList, ui, null);

        assertEquals(1, tripsList.size());
        Trip addedTrip = tripsList.getTrip("Trip1 with long name");
        assertEquals("Location1", addedTrip.getLocation());
        input = "setlocation /n Trip1 with long name    /location the new hangout";
        Parser.parseInput(input).execute(tripsList, ui, null);
        assertEquals("the new hangout", addedTrip.getLocation());
    }
}