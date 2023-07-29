package com.timeconversionbycountry;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Time_Conversion_By_Country {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking user input for local time zone
        String localZoneIdStr;
        ZoneId localZoneId;
        do {
            System.out.print("Enter your local time zone: ");
            localZoneIdStr = sc.nextLine();
            try {
                localZoneId = ZoneId.of(localZoneIdStr);
            } catch (Exception e) {
                System.out.println("Invalid time zone. Please enter a valid time zone.");
                localZoneId = null;
            }
        } while (localZoneId == null);

        // Define additional country time zones directly
        ZoneId bermudaZoneId = ZoneId.of("Atlantic/Bermuda");
        ZoneId ammanZoneId = ZoneId.of("Asia/Amman");
        ZoneId newYorkZoneId = ZoneId.of("America/New_York");
        ZoneId osloZoneId = ZoneId.of("Europe/Oslo");

        // Convert local time to country time using ZonedDateTime
        ZonedDateTime localDateTime = ZonedDateTime.now(localZoneId);
        ZonedDateTime bermudaDateTime = localDateTime.withZoneSameInstant(bermudaZoneId);
        ZonedDateTime ammanDateTime = localDateTime.withZoneSameInstant(ammanZoneId);
        ZonedDateTime newYorkDateTime = localDateTime.withZoneSameInstant(newYorkZoneId);
        ZonedDateTime osloDateTime = localDateTime.withZoneSameInstant(osloZoneId);

        // Formatting Date and time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String localTime = formatter.format(localDateTime);
        String bermudaTime = formatter.format(bermudaDateTime);
        String ammanTime = formatter.format(ammanDateTime);
        String newYorkTime = formatter.format(newYorkDateTime);
        String osloTime = formatter.format(osloDateTime);

        // Showing output and prompting for user's choice
        int choice;
        do {
            System.out.println("\nSelect a time zone to view:");
            System.out.println("1. Local time (" + localZoneId + ")");
            System.out.println("2. Bermuda time (Atlantic/Bermuda)");
            System.out.println("3. Amman time (Asia/Amman)");
            System.out.println("4. New York time (America/New_York)");
            System.out.println("5. Oslo time (Europe/Oslo)");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Local time (" + localZoneId + "): " + localTime);
                    break;
                case 2:
                    System.out.println("Bermuda time (Atlantic/Bermuda): " + bermudaTime);
                    break;
                case 3:
                    System.out.println("Amman time (Asia/Amman): " + ammanTime);
                    break;
                case 4:
                    System.out.println("New York time (America/New_York): " + newYorkTime);
                    break;
                case 5:
                    System.out.println("Oslo time (Europe/Oslo): " + osloTime);
                    break;
                case 0:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        } while (choice != 0);
    }
}
