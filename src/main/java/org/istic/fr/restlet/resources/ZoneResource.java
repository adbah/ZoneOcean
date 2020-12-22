package org.istic.fr.restlet.resources;

import org.istic.fr.csr.tp5.Zones;
import org.istic.fr.restlet.backend.Backend; 
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Post; 

/**
 *
 * Resource .
 *
 * @author Marc TSIVANYO
 * @author BAH Adama
 *
 */
public class ZoneResource extends ServerResource
{

    /** Backend.*/
    private Backend backend_;

    /** Utilisateur géré par cette resource.*/
    private Zones zone_;

    /**
     * Constructor.
     * Call for every single user request.
     */
    public ZoneResource()
    {
        backend_ = (Backend) getApplication().getContext().getAttributes()
                .get("backend"); 
    }

    @Get("json")
    public Representation getZone() throws Exception
    {
        String zoneIdString = (String) getRequest().getAttributes().get("zoneId");
        int userId = Integer.valueOf(zoneIdString);
        zone_ = backend_.getDatabase().getZone(userId);
        JSONObject zoneObject = new JSONObject();
        if(zone_!=null) { 
            zoneObject.put("Sardine dispo : ", zone_.getNbreSardinesDispo());
            zoneObject.put("Etat", zone_.isZoneLibre());
            zoneObject.put("Requins dans la zone", zone_.getNbreRequin());
        }else {

            zoneObject.put("Vide", 0);
        }
        return new JsonRepresentation(zoneObject);
    }
 
}
