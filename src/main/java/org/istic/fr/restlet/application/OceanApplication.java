package org.istic.fr.restlet.application;


import javax.naming.Context;

import org.istic.fr.restlet.resources.SharkResource;
import org.istic.fr.restlet.resources.SharksResource; 
import org.istic.fr.restlet.resources.ZoneResource;
import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;
import org.istic.fr.restlet.resources.TunasResource; 
/**
 *
 * Application.
 *
 * @author Marc TSIVANYO
 * @author BAH Adama
 *
 *
 */
public class OceanApplication extends Application
{

    public OceanApplication(org.restlet.Context context)
    {
        super(context);
    }

    @Override
    public Restlet createInboundRoot()
    {
        Router router = new Router(getContext());
        router.attach("/zones/{zoneId}", ZoneResource.class);
        router.attach("/sharks", SharksResource.class);
        router.attach("/users", ZoneResource.class);
        router.attach("/sharks/{userId}", SharkResource.class);
        router.attach("/tunas", TunasResource.class);
        return router;
    }
}
