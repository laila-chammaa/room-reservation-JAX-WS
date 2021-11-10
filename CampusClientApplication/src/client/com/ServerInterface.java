
package client.com;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ServerInterface", targetNamespace = "http://com/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ServerInterface {


    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg4
     * @param arg1
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://com/ServerInterface/bookRoomRequest", output = "http://com/ServerInterface/bookRoomResponse")
    public String bookRoom(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        CampusID arg1,
        @WebParam(name = "arg2", partName = "arg2")
        int arg2,
        @WebParam(name = "arg3", partName = "arg3")
        String arg3,
        @WebParam(name = "arg4", partName = "arg4")
        Timeslot arg4);

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://com/ServerInterface/createRoomRequest", output = "http://com/ServerInterface/createRoomResponse")
    public String createRoom(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        int arg1,
        @WebParam(name = "arg2", partName = "arg2")
        String arg2,
        @WebParam(name = "arg3", partName = "arg3")
        TimeslotArray arg3);

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://com/ServerInterface/deleteRoomRequest", output = "http://com/ServerInterface/deleteRoomResponse")
    public String deleteRoom(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        int arg1,
        @WebParam(name = "arg2", partName = "arg2")
        String arg2,
        @WebParam(name = "arg3", partName = "arg3")
        TimeslotArray arg3);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://com/ServerInterface/cancelBookingRequest", output = "http://com/ServerInterface/cancelBookingResponse")
    public String cancelBooking(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1);

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg4
     * @param arg1
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://com/ServerInterface/changeReservationRequest", output = "http://com/ServerInterface/changeReservationResponse")
    public String changeReservation(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        CampusID arg2,
        @WebParam(name = "arg3", partName = "arg3")
        int arg3,
        @WebParam(name = "arg4", partName = "arg4")
        Timeslot arg4);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://com/ServerInterface/getAvailableTimeSlotRequest", output = "http://com/ServerInterface/getAvailableTimeSlotResponse")
    public String getAvailableTimeSlot(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://com/ServerInterface/getLocalAvailableTimeSlotRequest", output = "http://com/ServerInterface/getLocalAvailableTimeSlotResponse")
    public int getLocalAvailableTimeSlot();

}
