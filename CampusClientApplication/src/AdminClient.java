import client.com.CampusID;
import client.com.CampusServerService;
import client.com.ServerInterface;
import client.com.Timeslot;

import javax.xml.ws.WebServiceRef;
import java.util.ArrayList;
import java.util.logging.Logger;


public class AdminClient {

    private String adminID;
    private CampusID campusID;
    private Logger logger;
    private ServerInterface server;

    private static final int USER_TYPE_POS = 3;
    private static final int CAMPUS_NAME_POS = 3;

    public AdminClient(String userID) throws Exception {
        validateAdmin(userID);
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

        System.out.println("Login Succeeded. | Admin ID: " +
                this.adminID + " | Campus ID: " + this.campusID.toString());
    }

    private void validateAdmin(String userID) throws Exception {
        char userType = userID.charAt(USER_TYPE_POS);
        String campusName = userID.substring(0, CAMPUS_NAME_POS);

        if (userType != 'A') {
            throw new Exception("Login Error: This client is for admins only.");
        }
        this.adminID = userID;

        try {
            this.campusID = CampusID.valueOf(campusName);
        } catch (Exception e) {
            throw new Exception("Login Error: Invalid ID.");
        }
    }

    public synchronized void createRoom(int roomNumber, String date, Timeslot[] listOfTimeSlots) {
        this.logger.info(String.format("Client Log | Request: createRoom | AdminID: %s | Room number: %d | Date: %s",
                adminID, roomNumber, date));
        this.logger.info(server.createRoom(adminID, roomNumber, date, listOfTimeSlots));
    }

    public synchronized void deleteRoom(int roomNumber, String date, Timeslot[] listOfTimeSlots) {
        this.logger.info(String.format("Client Log | Request: deleteRoom | AdminID: %s | Room number: %d | Date: %s",
                adminID, roomNumber, date));
        this.logger.info(server.deleteRoom(adminID, roomNumber, date, listOfTimeSlots));
    }
}
