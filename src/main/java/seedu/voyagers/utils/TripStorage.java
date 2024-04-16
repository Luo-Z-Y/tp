package seedu.voyagers.utils;

import seedu.voyagers.classes.Trip;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TripStorage {

    private static final Logger LOGGER = Logger.getLogger("Storage");


    /**
     * Reads the trip file and adds the trips to the list of trips.
     *
     * @param trips      The list of trips to add the trips to.
     * @param currentDir The current directory of the file.
     * @param fileName   The name of the file to read from.
     */
    public static void readTripFile(ArrayList<Trip> trips, String currentDir, String fileName) {

        Logger logger = Logger.getLogger("Storage");
        //local path of data file
        File f = new File(currentDir + "/" + fileName);

        try {
            Scanner s = new Scanner(f);
            /*if (s.hasNext()) {
                System.out.println("Here are the trips in your list:");
            }*/
            while (s.hasNext()) {
                String[] inputs = s.nextLine().split("\\|", 7);
                assert inputs.length == 7 : "Invalid input format";
                java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");
                Date startDate = format.parse(inputs[2]);
                Date endDate = format.parse(inputs[3]);
                Trip trip = new Trip(inputs[1], startDate, endDate, inputs[4], inputs[5]);
                trip.setTripType(inputs[0]);
                trip.setStatus(Status.valueOf(inputs[6]));
                if (inputs[0].equalsIgnoreCase("main")) {
                    trips.add(trip);
                } else {
                    for (Trip t : trips) {
                        if (t.getTripType().equalsIgnoreCase("main") &&
                                t.getName().equalsIgnoreCase(inputs[1])) {
                            t.addSubTrip(trip);
                        }
                    }
                }
            }
            s.close();
        } catch (FileNotFoundException e) {

            System.out.println("Trip file not found.\nCreating new trip file...\nTrip file created.");
            try {
                assert f.createNewFile() : "Trip file creation failed";
                f.createNewFile();
                logger.log(Level.INFO, "Trip file created.");
            } catch (java.io.IOException ex) {
                System.out.println("An error occurred.");
                logger.log(Level.SEVERE, "An error occurred when creating the trip file.");
            }
        } catch (ParseException e) {
            System.out.println("An error occurred.");
        }
    }

    /**
     * Writes the trips to the trip file.
     *
     * @param trips      The list of trips to write to the file.
     * @param tripsCount The number of trips in the list.
     * @param currentDir The current directory of the file.
     */
    public static void writeTripFileMain(ArrayList<Trip> trips, int tripsCount, String currentDir, String fileName) {
        //local path of data file
        File f = new File(currentDir + "/" + fileName);

        try (java.io.FileWriter writer = new java.io.FileWriter(f)) {
            for (int i = 0; i < tripsCount; i++) {
                Trip trip = trips.get(i);
                if (trip.getTripType() == "main") {
                    parseToFile(writer, trip);
                    writeTripFileSub(trip.getSubTrips(), trip.getSubTripsSize(), writer);
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    private static void parseToFile(FileWriter writer, Trip trip) throws IOException {
        writer.write(trip.getTripType() + "|" + trip.getName() + "|" +
                FormatDate.dateFormat.format(trip.getStartDate()) + "|" +
                FormatDate.dateFormat.format(trip.getEndDate()) + "|"
                + trip.getLocation() + "|" + trip.getDescription()
                + "|" + trip.getStatus().toString() + "\n");
    }

    public static void writeTripFileSub(ArrayList<Trip> trips, int tripsCount, java.io.FileWriter writer)
            throws IOException {

        for (int i = 0; i < tripsCount; i++) {
            Trip trip = trips.get(i);
            parseToFile(writer, trip);
        }
    }
}
