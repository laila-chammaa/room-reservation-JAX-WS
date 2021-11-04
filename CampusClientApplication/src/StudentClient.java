import client.com.CampusID;
import client.com.CampusServerService;
import client.com.ServerInterface;
import client.com.Timeslot;

import javax.xml.ws.WebServiceRef;
import java.util.logging.Logger;

public class StudentClient {

    private String studentID;
    private CampusID campusID;
    private Logger logger;
    private ServerInterface server;

    static final int USER_TYPE_POS = 3;

    public StudentClient(String userID) throws Exception {
        validateStudent(userID);

        try {
            this.logger = ClientLogUtil.initiateLogger(campusID, userID);
        } catch (Exception e) {
            throw new Exception("Login Error: Invalid ID.");
        }

        CampusServerService service = new CampusServerService();
        switch (campusID) {
            case WST:
                server = service.getWSTCampusServerPort();
                break;
            case DVL:
                server = service.getDVLCampusServerPort();
                break;
            case KKL:
                server = service.getKKLCampusServerPort();
                break;
        }

        System.out.println("Login Succeeded. | Student ID: " +
                this.studentID + " | Campus ID: " + this.campusID.toString());
    }

    private void validateStudent(String userID) throws Exception {
        char userType = userID.charAt(USER_TYPE_POS);
        String campusName = userID.substring(0, USER_TYPE_POS);

        if (userType != 'S') {
            throw new Exception("Login Error: This client is for students only.");
        }
        this.studentID = userID;

        try {
            this.campusID = CampusID.valueOf(campusName);
        } catch (Exception e) {
            throw new Exception("Login Error: Invalid ID.");
        }
    }

    public synchronized String bookRoom(CampusID campusID, int roomNumber, String date,
                                      Timeslot timeSlot) {

        this.logger.info(String.format("Client Log | Request: bookRoom | Campus: %s | StudentID: %s | " +
                "Room number: %d | Date: %s | Timeslot: %s", campusID.toString(), studentID, roomNumber, date,
                timeSlot.toString()));
        String result = server.bookRoom(studentID, campusID, roomNumber, date, timeSlot);
        this.logger.info(result);
        if (result.contains("BookingID: ")) {
            return result.substring(result.indexOf("ID: ") + 4);
        }
        return null;
    }

    public synchronized String getAvailableTimeSlot(String date) {
        this.logger.info(String.format("Client Log | Request: getAvailableTimeSlot | Date: %s", date));
        return server.getAvailableTimeSlot(date);
    }

    public synchronized void cancelBooking(String bookingID) {
        this.logger.info(String.format("Client Log | Request: cancelBooking | StudentID: %s | " +
                "BookingID: %s", studentID, bookingID));

        this.logger.info(server.cancelBooking(studentID, bookingID));
    }

    public synchronized void changeReservation(String bookingID, CampusID newCampusName, short newRoomNo,
                                               Timeslot newTimeSlot) {
        this.logger.info(String.format("Client Log | Request: changeReservation | StudentID: %s | " +
                        "BookingID: %s | New CampusID: %s | New room: %d | New Timeslot: %s", studentID, bookingID,
                newCampusName.name(), newRoomNo, newTimeSlot.toString()));
        this.logger.info(server.changeReservation(studentID, bookingID, newCampusName, newRoomNo, newTimeSlot));
    }

}
