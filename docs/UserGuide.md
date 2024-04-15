# Voyagers

Voyagers is a Java application designed to manage trips efficiently through a command-line interface.

<!---
@@author azamanis
-->

## Table of Contents


1. [Introduction](#introduction)
2. [Features](#features)
    - [Add Main Trip](#adding-a-main-trip)
    - [Delete Main Trip](#deleting-a-main-trip)
    - [Set Trip Details](#setting-trip-details)
    - [Add Sub Trip](#adding-a-sub-trip)
    - [Delete Sub Trip](#deleting-a-sub-trip)
    - [List All Trips](#listing-all-trips)
    - [Listing Trips by Status](#listing-trips-by-status)
    - [Add Bills](#creating-a-bill)
    - [Pay Bills](#paying-a-bill)
    - [Set Bill Currency](#setting-bill-currency)
    - [List Bills](#listing-all-bills)
    - [Settle and Simplify Bills](#simplify-bills)
    - [Add Review](#reviewing-trips)
    - [Read Review](#reading-trip-reviews)
    - [Update Status](#update-status)
    - [Cancel Trip](#canceling-a-trip)
    - [Save Data](#save-data)
    - [Exit Application](#exit-application)
3. [Usage](#usage)
    - [Running the jar file](#how-to-run-jar-file)
    - [Adding a Main Trip](#adding-a-main-trip)
    - [Setting Trip Details](#setting-trip-details)
    - [Change the Name of a Trip](#change-the-name-of-a-trip)
    - [Change the Date of a Trip](#change-the-date-of-a-trip)
    - [Change the Location of a Trip](#Change-the-Location-of-a-Trip)
    - [Change the Description of a Trip](#Change-the-Description-of-a-Trip)
    - [Cancel a Trip](#canceling-a-trip)
    - [Uncancel a Trip](#uncancel-a-trip)
    - [Deleting a Main Trip](#deleting-a-main-trip)
    - [Add Sub Trip](#adding-a-sub-trip)
    - [Delete Sub Trip](#deleting-a-sub-trip)
    - [Listing All Trips](#listing-all-trips)
    - [Listing Trips by Status](#listing-trips-by-status)
    - [Managing Bills](#managing-bills)
      - [Adding Bills](#creating-a-bill)
      - [Paying Bills](#paying-a-bill)
      - [Setting Bill Currency](#setting-bill-currency)
      - [Listing Bills](#listing-all-bills)
      - [Settling and Simplifying Bills](#simplify-bills)
    - [Reviewing Trips](#reviewing-trips)
    - [Reading Trip Reviews](#reading-trip-reviews)
    - [Exit Command](#exit-command)
    - [Currency](#currency)

<!---
@@author azamanis
-->
## Introduction

Voyagers is a Java application designed to simplify trip management. It provides users with a command-line interface to 
manage their trips efficiently, including adding main trips, setting trip details, listing all trips, and more.

## Features

- **Add Main Trip**: Add a new main trip with specified details such as name, dates, location, and description.
- **Delete Main Trip**: Remove an existing main trip from the list.
- **Set Trip Details**: Modify trip details such as name, dates, location, and description for existing trips.
- **List All Trips**: View a comprehensive list of all trips along with their details.
- **Add Bill**: Add a bill to a certain trip, along with who paid, people who owe, and what percentage of the bill 
each person owes.
- **Pay Bill** Mark a bill as paid.
- **Add Review**: Review a trip by providing a score and reflection.
- **Read Review**: Read the review of a specific trip.
- **Update Status**: Update the status of a trip to 'Ongoing', 'Upcoming' or 'Completed'.
- **Cancel Trip**: Cancel a trip and remove it from the list.
- **Save Data**: Save the trip data to a file for future reference.
- **Exit Application**: Exit the application.

## Usage

The core of Voyagers is to allow users to manage their trips efficiently. Especially adding a new main trip by typing a
single line.

### How to run jar file

To run the tp.jar file, open a CLT program such as Windows Powershell (Windows), Terminal (macOS), or Linux Terminal (Linux).

Navigate to the folder you copied the jar file to. This folder should be empty except for the jar file when running it for the first time.

In your CLT, enter the following command to run the jar file:
```bash
java -jar ./tp.jar
```

The jar file will run, greet you with its welcome message, and list any saved trips:
```bash
                ____________________________________________________________
                Hello! I'm Voyagers
                What can I do for you?
                ____________________________________________________________
                You have no trips in your list.
                ____________________________________________________________
                ____________________________________________________________
                Enter your next command:
                ____________________________________________________________
```

### Adding a Main Trip

To add a new main trip, use the `addmaintrip` command followed by the trip details.

```bash
addmaintrip /n <Name> /start <yyyy-MM-dd> /end <yyyy-MM-dd> /location <Location> /d <Description>
```
Example:
```bash
addmaintrip /n EuropeTrip /start 2024-05-01 /end 2024-07-01 /location Europe /d Travelling western europe with the family
```
Example output:
```bash
		____________________________________________________________
		Got it. I've added this trip:
	Trip Name: EuropeTrip		Start Date: 2024-05-01		End Date: 2024-07-01		Location: Europe		Description: Travelling western europe with the family		Status: UPCOMING
	Sub-trips:
Now you have 3 trips in the list.
        ____________________________________________________________
```


### Setting Trip Details

You can also modify the details of an existing trip using the following commands:

- `setname`: Set the name of a trip.
- `setdates`: Set the dates of a trip.
- `setlocation`: Set the location of a trip.
- `setdescription`: Set the description of a trip.

### Change the Name of a Trip (only for main trips)
```bash
setname <current_name> /n <new_name>
```


Example:

```bash
setname EuropeTrip /n EuropeanAdventure
```

Example output:

```bash
		____________________________________________________________
		Noted. I've modified this trip:
	Trip Name: EuropeanAdventure		Start Date: 2024-05-01		End Date: 2024-07-01		Location: Europe		Description: Travelling western europe with the family		Status: UPCOMING
	Sub-trips:
		____________________________________________________________
```

### Change the Date of a Trip

```bash
setdates <current_trip_name> /start <yyyy-MM-dd> /end <yyyy-MM-dde>
```

Example:
```bash
setdates EuropeanAdventure /start 2024-05-01 /end 2024-07-31
```

Example output:
```bash
        ____________________________________________________________
		Noted. I've modified this trip:
	Trip Name: EuropeanAdventure		Start Date: 2024-05-01		End Date: 2024-07-31		Location: Europe		Description: Travelling western europe with the family		Status: UPCOMING
	Sub-trips:
        ____________________________________________________________
```

### Change the Location of a Trip

```bash
setdates <current_trip_name> /location <new_location>
```

Example:
```bash
setdates DateWithSO /location Fancy Restaurant
```

Example output:
```bash
        ____________________________________________________________
		Noted. I've modified this trip:
	Trip Name: DateWithSO		Start Date: 2024-08-27		End Date: 2024-08-27		Location: Fancy Restaurant		Description: Having Italian with beloved		Status: UPCOMING
	Sub-trips:
        ____________________________________________________________
```

### Change the Description of a Trip

```bash
setdates <current_trip_name> /d <new_description>
```

Example:
```bash
setdates DateWithSO /d Double dating with other friends at Italian place
```

Example output:
```bash
        ____________________________________________________________
		Noted. I've modified this trip:
	Trip Name: DateWithSO		Start Date: 2024-08-27		End Date: 2024-08-27		Location: Fancy Restaurant		Description: Double dating with other friends at Italian place		Status: UPCOMING
	Sub-trips:
        ____________________________________________________________
```

### Canceling a Trip

```bash
setstatus <current_name> /status cancel
```

Example:
```bash
setstatus EuropeanAdventure /status cancel
```

Example output:
```bash
		____________________________________________________________
		Noted. I've modified this trip:
	Trip Name: EuropeanAdventure		Start Date: 2024-05-01		End Date: 2024-07-31		Location: Europe		Description: Travelling western europe with the family		Status: CANCELLED
	Sub-trips:
		____________________________________________________________
```

### Uncancel a Trip
```bash
setstatus <trip_name> /status uncancel
```

Example:
```bash
setstatus EuropeanAdventure /status uncancel
```

Example output:
```bash
		____________________________________________________________
		Noted. I've modified this trip:
	Trip Name: EuropeanAdventure		Start Date: 2024-05-01		End Date: 2024-07-31		Location: Europe		Description: Travelling western europe with the family		Status: UPCOMING
	Sub-trips:
		____________________________________________________________
```

### Deleting a Main Trip
To delete an existing main trip, use the `deletemaintrip` command followed by the trip name.

```bash
deletemaintrip /n <main_trip_name>
```

Example:
```bash
deletemaintrip /n EuropeanAdventure
```

Example output:
```
		____________________________________________________________
		Noted. I've removed this trip:
	Trip Name: EuropeanAdventure		Start Date: 2024-05-01		End Date: 2024-07-31		Location: Europe		Description: Travelling western europe with the family		Status: UPCOMING
	Sub-trips:
Now you have 2 trips in the list.
		____________________________________________________________
```

### Adding a Sub Trip
To add sub trips under a main trip, use the addsubtrip command.

```bash
addsubtrip /n <existing_main_trip_name> /start <yyyy-MM-dd> /end <yyyy-MM-dd> /location <location> /d <description>
```

Example:
```bash
addsubtrip /n Korea /start 2024-05-10 /end 2024-05-24 /location Gwanggyo Lake Park /d have a picnic
```

Example output:
```bash
		____________________________________________________________
		Got it. I've added this trip as a subtrip of :Korea
	Korea-1		Start Date: 2024-05-10		End Date: 2024-05-24		Location: Gwanggyo Lake Park		Description: have a picnic		Status: UPCOMING
Now you have 1 subtrips.
		____________________________________________________________
```


### Deleting a Sub Trip
To delete a sub trip, use the deletesubtrip command.

```bash
deletesubtrip /n <Main trip name> /i <index of subtrip>
```

Example:
```bash
deletesubtrip /n Korea /i 1
```

Example output:
```bash
		____________________________________________________________
		Noted. I've removed this subtrip:
	Korea-1		Start Date: 2024-05-10		End Date: 2024-05-24		Location: Gwanggyo Lake Park		Description: have a picnic		Status: UPCOMING
		____________________________________________________________
```

### Listing All Trips
To view a list of all trips along with their details, use the list command.

```bash 
list
```

Example output:
```bash
____________________________________________________________
		Here are the trips in your list:
		____________________________________________________________
		____________________________________________________________
		1. 	Trip Name: Korea		Start Date: 2024-05-01		End Date: 2024-07-31		Location: Suwon		Description: dating		Status: UPCOMING
	Sub-trips:
		____________________________________________________________
```

### Listing Trips by Status
To view a list of trips of only a specific status, add the status after the list command

```bash
list <status>
```

Example 1:
```bash
list upcoming
```

Example output 1:
```bash
		____________________________________________________________
		Here are the upcoming trips in your list:
		____________________________________________________________
		____________________________________________________________
		1. 	Trip Name: Korea		Start Date: 2024-05-01		End Date: 2024-07-31		Location: Suwon		Description: dating		Status: UPCOMING
	Sub-trips:
		____________________________________________________________
```

Example 2:
```bash
list cancelled
```

Example output 2:
```bash
		____________________________________________________________
		You have no cancelled trips in your list.
		____________________________________________________________
```

### Managing bills

You can add bills to a trip. The bills are payed by a person but it can involve multiple people.

### Creating a Bill
To add a bill to a trip, use the `addbill` command followed by the following flags:
 
 `/trip`: name of the trip this bill belongs to  
`/n`: name of this bill  
`/payer`: name of the person who paid the bill  
`/others`: other people involved in the bill, owing the payer for this expense. Each person
 should be separated by a space bar. Do not include names with a spacebar; one
 could instead represent such a name as "John-Paul", for example. The payer should not
be repeated in this section.   
`/amount`: how much this bill costed. Default currency will be the currency of the trip.
`/percentages`: the percentage of the total amount that each person is responsible for
in the bill. Must have the same number of arguments as the number of people in `/payer` and `/others`. 
 Must add up to 100 (+-0.5).
```bash
addbill /trip China /n dinner /payer Alice /others Bob Carol /amount 50 /percentages 33.3 33.3 33.3
```

Note:
- The amount must be positive.
   - The percentage must be between 0 and 100 and the sum of the percentages of all participants must be 100.
- The listed percentages are attributed to the listed users in the order that they appear. For example,
in the below command, Bob is responsible for 50% of the bill, Charles for 45%, and Denise for 5%.  
`addbill /trip China /n breakfast /payer Bob /others Charles Denise /amount 45 /percentages 50 45 5`

### Paying a Bill
To mark a bill as paid, use the `paybill` command followed by the name of the trip and the bill.
```bash
paybill /trip Korea /n dinner
```

### Setting Bill Currency
To set the currency used in the bill, use the `setbillcurrency` command, followed by the name of the trip, bill, and 
3-letter currency code.
```bash
setbillcurrency /trip China /n breakfast /currency SGD
```

- Note: The currency must be a valid currency code. Consult the list of valid currency codes [here](#currency).

### Listing all Bills
To list all bills in Voyagers, use the `listbills` command.
```bash
listbills
```

Note: if the trip is a maintrip, the simplification will be done on all the subtrips of the maintrip.

Note: the simplification will be made using dollars.

#### Currency
(Not implemented)

The app supports multiple currencies:
- EUR: Euro
- USD: US Dollar
- SGD: Singapore Dollar
- JPY: Japanese Yen
- CNY: Chinese Yuan
- KRW: South Korean Won
- GBP: British Pound
- AUD: Australian Dollar
- CAD: Canadian Dollar

### Reviewing Trips

To review a main trip with a scale of 1-10 'score' and your open-ended 'reflection', use the review command.

```bash
review <main_trip_name> /s <1-10> /r <open-ended thoughts>
```

Example:
```bash
review Korea /s 7 /r Great food, great weather, expensive though
```

Example output:
```bash
		____________________________________________________________
		Noted. you reviewed this trip: Korea with a score of 7
		noting: Great food, great weather, expensive though
		____________________________________________________________

```

### Reading Trip Reviews

To read previously reviewed main trip, use the readreview command with the name of the trip.
```bash
readreview <main_trip_name>
```

Example:
```bash
readreview Korea
```

Example output:
```bash
		____________________________________________________________
		Here's what you wrote about Korea
		Score: 7
		Reflection:
		Great food, great weather, expensive though
		____________________________________________________________
```

### Save data
Remember to properly exit to save trip data.

The data will be saved in the same directory as the jar file, with names:
- `local-voyagers.txt` for trips storage.
- `local-bills.txt` for bills storage.
- `local-reviews.txt` for reviews storage.

### Enter "exit" to exit the application.

```bash 
exit
```

Output:
```bash
		____________________________________________________________
		Bye. Hope to see you again soon!
		____________________________________________________________
```

<!---
@@author azamanis
-->

<!---
@@author azamanis
-->

## Upcoming Features

### Simplify bills

In order to settle up all the bills. You can simplify all the bills.
The simplification will reduce the number of transactions needed to settle up all the bills.

````bash
simplifybill
````

## FAQ
1. **Can I have two trips with the same details but different names?**
    - Yes, you can have two trips with the same details but different names.
2. **Can I have two trips with the same name but different details?**
    - No, trip names must be unique.
