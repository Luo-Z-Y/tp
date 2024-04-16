package seedu.voyagers.commands;

import seedu.voyagers.classes.Bill;
import seedu.voyagers.classes.BillList;
//import seedu.voyagers.classes.Profile;
import seedu.voyagers.classes.TripList;
import seedu.voyagers.classes.billsettler.BillSettler;
import seedu.voyagers.utils.TripStorage;
import seedu.voyagers.utils.Ui;

import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Objects;

//import static javax.swing.UIManager.put;

public class SimplifyBillCommand extends Command {
    public void execute(TripList trips, Ui ui, TripStorage tripStorage) {
        BillList billList = new BillList();
        ArrayList<Bill> bills = billList.getBills();
        if (bills.isEmpty()) {
            ui.echo("You have no bills in your list.");
            return;
        } else {
            /*for (int j = 0; j < Objects.requireNonNull(billList).size(); j++) {
                Bill billtemp = billList.get(j);
                Bill bill = new Bill(billtemp.getName(), billtemp.getPayer(), billtemp.getAmount(),
                        billtemp.getCurrency(), new HashMap<Profile, Double>() {{
                    for (int k = 0; k < billtemp.getParticipants().size(); k++) {
                        put(billtemp.getParticipants(k), billtemp.getAmount() * billtemp.getPercentages().get(k));
                    }
                }});
            }*/
            BillSettler.createGraphForDebts(bills);
        }
    }
}
