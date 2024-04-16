package seedu.voyagers.paser;

public class ParserDefinitions {

    public static final String[] ADDMAINTRIP = {"/n", "/start", "/end", "/location", "/d"};

    public static final String[] DELETEMAINTRIP = {"/n"};

    public static final String[] DELETESUBTRIP = {"/n", "/i"};

    public static final String[] ADDSUBTRIP = {"/n", "/start", "/end", "/location", "/d"};

    public static final String[] ADDBILL = {"/trip", "/n", "/payer", "/others", "/amount", "/percentages"};

    public static final String[] PAYBILL = {"/trip", "/n"};

    public static final String[] SETBILLCURRENCY = {"/trip", "/n", "/currency"};

    public static final String[] SETNAME = {"/n"};

    public static final String[] SETDATES = {"/start", "/end"};

    public static final String[] SETLOCATION = {"/location"};

    public static final String[] SETDESCRIPTION = {"/d"};

    public static final String[] REVIEW = {"/s", "/r"};

    public static final String[] SETSTATUS = {"/status"};

    public static final String[] FIND = {"/n"};

    public static final String[] SIMPLIFYBILL = {"/n"};
}
