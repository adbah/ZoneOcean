package org.istic.fr.restlet.resources;

import org.istic.fr.csr.tp5.Requins;
import org.istic.fr.restlet.backend.Backend;
import org.json.JSONException;
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
public class SharksResource extends ServerResource {

	 /** Backend.*/
    private Backend backend_;

    /** Requin géré par cette resource.*/
    private Requins requins_;

    /**
     * Constructor.
     * Call for every single user request.
     */
    public SharksResource()
    {
        backend_ = (Backend) getApplication().getContext().getAttributes()
                .get("backend");
    }

    @Get("json")
    public Representation getRequins() throws Exception
    { 
        int result = backend_.getDatabase().getRequins(); 
        JSONObject requinObject = new JSONObject();
        requinObject.put("Nombre de requins presents dans la simulation  : ", result); 
        return new JsonRepresentation(requinObject);
    }
 
}
