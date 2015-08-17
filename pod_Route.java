import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class pod_Route {

        Long   route_id;
        String route_name;
        ArrayList<String> route_stations;

        public Long getRoute_id() {
                return route_id;
        }

        @XmlElement
        public void setRoute_id(Long this_route_id) {
                this.route_id = this_route_id;
        }

        public String getRoute_name() {
                return route_name;
        }

        @XmlElement
        public void setRoute_name(String this_route_name) {
                this.route_name = this_route_name;
        }

        public ArrayList<String> getRoute_stations() {
                return route_stations;
        }

        @XmlElement
        public void setRoute_stations(
                ArrayList<String> this_route_stations) {
                this.route_stations = this_route_stations;
        }

}