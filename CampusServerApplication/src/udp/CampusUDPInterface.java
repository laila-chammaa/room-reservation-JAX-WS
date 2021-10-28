package udp;

import model.CampusID;
import server.ServerInterface;

import java.io.Serializable;

public interface CampusUDPInterface extends Serializable {
    void execute(ServerInterface campusServer, CampusID campusID);
}
