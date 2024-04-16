package seedu.voyagers.commands;

import seedu.voyagers.classes.*;
import seedu.voyagers.utils.Currency;
import seedu.voyagers.utils.TripStorage;
import seedu.voyagers.utils.Ui;

import java.util.ArrayList;

import static seedu.voyagers.utils.BillStorage.readBillFile;
import static seedu.voyagers.utils.BillStorage.writeBillFile;

public class AddBillCommand extends Command {
    public AddBillCommand(String[] args){
        super(args);
    }

    //TODO: also need currency

    public void execute(TripList trips, Ui ui, TripStorage tripStorage){

        try{
            Profile payer = new Profile(args[2]);
            double amount = Double.parseDouble(args[4]);
            ArrayList<Profile> people = new ArrayList<>();
            ArrayList<Double> percentages = new ArrayList<>();
            String[] peopleNames = args[3].split(" ");
            String[] percentagesString = args[5].split(" ");
            for (int i = 0; i < percentagesString.length; i++) {
                percentages.add(Double.parseDouble(percentagesString[i]));
            }
            for (int i = 0; i < peopleNames.length; i++) {
                people.add(new Profile(peopleNames[i]));
            }
            for (int i = 0; i < trips.size(); i++){
                if (trips.get(i).getName().equals(args[0])){
                    Bill bill = new Bill(args[0], args[1], payer, amount, null, people, percentages);
                    for (int j = 0; j < trips.size(); j++){
                        if (trips.get(j).getName().equals(args[0])){
                            bill.setTrip(trips.get(j));
                            break;
                        }
                    }
                    bill.getTrip().addBill(bill);
                    BillList bills = bill.getTrip().getBills();
                    //new AutoBillStatusUpdateCommand().execute(bills, ui, null);
                    ui.echo("Got it. I've added this bill:\n" + bill
                            + "\nNow you have " + bills.size() +
                            " bill(s) in the list.");
                    String currentDir = System.getProperty("user.dir");
                    String billsFileName = "local-bills.txt";
                    writeBillFile(bills, bills.size(), currentDir, billsFileName);
                    return;
                }
            }
            throw new Exception("Trip not found.");
        } catch (Exception e){
            ui.echo(e.getMessage());
        }
    }

}
