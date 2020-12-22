package org.istic.fr.restlet.resources;

import org.istic.fr.csr.tp5.Requins;
import org.istic.fr.restlet.backend.Backend;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;
/**
*
* Resource .
*
* @author Marc TSIVANYO
* @author BAH Adama
*
*/
public class TunasResource  extends ServerResource{
	 /** Backend.*/
    private Backend backend_;
 

    /**
     * Constructor.
     * Call for every single user request.
     */
    public TunasResource()
    {
    	 backend_ = (Backend) getApplication().getContext().getAttributes()
                 .get("backend");
    }

    @Get("json")
    public Representation getRequin() throws Exception
    {
        String requinsIdString = (String) getRequest().getAttributes().get("RequinsId");
        int requinId = Integer.valueOf(requinsIdString);
        String result = backend_.getDatabase().getRequin(requinId);

        JSONObject requinObject = new JSONObject();
        requinObject.put("Retour : ", result); 
        return new JsonRepresentation(requinObject);
    }
}
