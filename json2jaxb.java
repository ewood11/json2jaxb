import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class json2jaxb {
    public static void main(String[] args)
    {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("pod_routeA.json"));
            JSONObject jsonObject = (JSONObject) obj;
            Long route_id     = (Long) jsonObject.get("route_id");
            String route_name = (String) jsonObject.get("route_name");
            JSONArray route_stns = (JSONArray) jsonObject.get("route_stations");

            pod_Route routeA = new pod_Route();
            routeA.setRoute_id(route_id);
            routeA.setRoute_name(route_name);
            Iterator<String> iterator = route_stns.iterator();
            while (iterator.hasNext()) {
                if (routeA.route_stations == null) {
                    routeA.route_stations = new ArrayList<String>();
                }
                routeA.route_stations.add(iterator.next());
            }

        File routeA_FileOut_xml = new File("pod_routeA.xml");
            JAXBContext routeA_jaxbContext   = JAXBContext.newInstance(pod_Route.class);
            Marshaller routeA_jaxbMarshaller = routeA_jaxbContext.createMarshaller();
            routeA_jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            routeA_jaxbMarshaller.marshal(routeA, routeA_FileOut_xml);
            routeA_jaxbMarshaller.marshal(routeA, System.out);

        } catch (JAXBException e) {
                e.printStackTrace();
        } catch (FileNotFoundException e) {
                e.printStackTrace();
        } catch (IOException e) {
                e.printStackTrace();
        } catch (ParseException e) {
                e.printStackTrace();
        }

     }

}