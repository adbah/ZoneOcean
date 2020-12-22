package org.inria.restlet.mta.backend;
 
import org.istic.fr.restlet.database.api.Database;
import org.istic.fr.restlet.database.api.impl.InMemoryDatabase;

/**
 *
 * Backend for all resources.
 * 
 * @author ctedeschi
 * @author msimonin
 *
 */
public class Backend
{
    /** Database.*/
    private Database database_;

    public Backend()
    {
        database_ = new InMemoryDatabase();
    }

    public Database getDatabase()
    {
        return database_;
    }

}
