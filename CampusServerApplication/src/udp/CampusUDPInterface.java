package udp;

import model.CampusID;
import com.ServerInterface;

import java.io.Serializable;

public interface CampusUDPInterface extends Serializable {
    void execute(ServerInterface campusServer, CampusID campusID);
}
