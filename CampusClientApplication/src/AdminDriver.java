import client.com.Timeslot;
import client.com.TimeslotArray;
import com.sun.tools.javac.util.List;

public class AdminDriver {
    public static void main(String[] args) {
        TimeslotArray listOfTimeSlots = new TimeslotArray();
        listOfTimeSlots.getItem().addAll(List.of(new Timeslot(19, 20), new Timeslot(12, 13), new Timeslot(15, 16)));
        TimeslotArray listOfTimeSlots2 = new TimeslotArray();
        listOfTimeSlots2.getItem().add(new Timeslot(1, 2));
        TimeslotArray listOfTimeSlots3 = new TimeslotArray();
        listOfTimeSlots3.getItem().add(new Timeslot(15, 16));

        String aid1 = "KKLA1234";
        String aid2 = "WSTA1234";
        String aid3 = "DVLA1234";
        String aid4 = "KKLS1214";

        try {
            AdminClient testClient1 = new AdminClient(aid1);
            AdminClient testClient2 = new AdminClient(aid2);
            AdminClient testClient3 = new AdminClient(aid3);

            //testing synchronization with multiple admins
            testClient1.createRoom(201, "01/01/2020", listOfTimeSlots);
            testClient3.createRoom(201, "01/01/2020", listOfTimeSlots);
            testClient1.createRoom(201, "03/01/2020", listOfTimeSlots2);
            testClient2.createRoom(211, "04/01/2020", listOfTimeSlots);
            testClient2.deleteRoom(211, "04/01/2020", listOfTimeSlots3);
            testClient3.createRoom(203, "01/01/2020", listOfTimeSlots);


//            testing invalid admin
//            AdminClient studentClient = new AdminClient(args, aid4);
//            studentClient.createRoom((short) 201, "01/01/2020", listOfTimeSlots);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
