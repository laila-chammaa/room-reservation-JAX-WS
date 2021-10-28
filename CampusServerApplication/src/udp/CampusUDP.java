package udp;

import model.CampusID;
import model.Timeslot;
import server.ServerInterface;

public class CampusUDP implements CampusUDPInterface {
    private static final long serialVersionUID = 1L;


    private String studentID;
    private String bookingID;
    private int newRoomNo;
    private Timeslot newTimeSlot;
    private CampusID newCampusID;

    private String operationType;
    private boolean transferStatus = false;
    private int availableTimeSlot;

    //Constructor for inter-campus booking change
    public CampusUDP(String studentID, String bookingId, CampusID newCampusName, int newRoomNo,
                     Timeslot newTimeSlot) {
        this.studentID = studentID;
        this.bookingID = bookingId;
        this.newCampusID = newCampusName;
        this.newRoomNo = newRoomNo;
        this.newTimeSlot = newTimeSlot;

        this.operationType = "bookingChange";
    }

    //Constructor for get total available time slots.
    public CampusUDP() {
        this.operationType = "getAvailableTimeSlots";
    }

    public boolean isTransferStatus() {
        return transferStatus;
    }

    public int getLocalAvailableTimeSlot() {
        return availableTimeSlot;
    }

    @Override
    public void execute(ServerInterface campusServer, CampusID campusID) {
        try {
            if (this.operationType.equals("bookingChange")) {
                String resultLog = campusServer.changeReservation(studentID, bookingID, newCampusID, newRoomNo, newTimeSlot);
                transferStatus = resultLog.contains("success");
            } else if (this.operationType.equals("getAvailableTimeSlots")) {
                availableTimeSlot = campusServer.getLocalAvailableTimeSlot();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
}