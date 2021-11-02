
package client.com;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for campusID.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="campusID">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="DVL"/>
 *     &lt;enumeration value="KKL"/>
 *     &lt;enumeration value="WST"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "campusID")
@XmlEnum
public enum CampusID {

    DVL,
    KKL,
    WST;

    public String value() {
        return name();
    }

    public static CampusID fromValue(String v) {
        return valueOf(v);
    }

}
