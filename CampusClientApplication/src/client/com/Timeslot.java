
package client.com;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for timeslot complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="timeslot">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="end" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="start" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "timeslot", propOrder = {
    "end",
    "start"
})
public class Timeslot {

    protected float end;
    protected float start;

    public Timeslot() {
    }

    public Timeslot(float start, float end) {
        this.start = start;
        this.end = end;
    }

    /**
     * Gets the value of the end property.
     * 
     */
    public float getEnd() {
        return end;
    }

    /**
     * Sets the value of the end property.
     * 
     */
    public void setEnd(float value) {
        this.end = value;
    }

    /**
     * Gets the value of the start property.
     * 
     */
    public float getStart() {
        return start;
    }

    /**
     * Sets the value of the start property.
     * 
     */
    public void setStart(float value) {
        this.start = value;
    }

}
