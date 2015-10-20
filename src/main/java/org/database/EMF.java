package org.database;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public  class EMF {
    private static final EntityManagerFactory emfInstance =
    		 Persistence.createEntityManagerFactory("transactions-optional");
     
    private EMF() {}

    public static EntityManagerFactory get() {
        System.out.println("in EMF");
    	return emfInstance;
    }
}
/*import java.util.HashMap;
import java.util.Map;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

public final class PMF {
	
	private static PersistenceManagerFactory pmfInstance;
	static {
    Map<String, String> props = new HashMap();
    props.put("javax.jdo.PersistenceManagerFactoryClass", "org.datanucleus.store.appengine.jdo.DatastoreJDOPersistenceManagerFactory");
    props.put("javax.jdo.option.ConnectionURL", "appengine");
    props.put("javax.jdo.option.NontransactionalRead", "true");
    props.put("javax.jdo.option.NontransactionalWrite", "true");
    props.put("javax.jdo.option.RetainValues", "true");
    props.put("datanucleus.appengine.autoCreateDatastoreTxns", "true");
    pmfInstance = JDOHelper.getPersistenceManagerFactory(props);
}
	

	private PMF() {
	}*/
/*public final class EMF {
	
	private static EntityManagerFactory emfInstance;

	 private EMF() {}
	@SuppressWarnings("deprecation")
	public static EntityManagerFactory get() {
		//emfInstance = JDOHelper.getPersistenceManagerFactory(props);
		 if (emfInstance == null) {
		        Properties properties=new Properties();
		        properties.setProperty("provider","org.datanucleus.api.jpa.PersistenceProviderImpl");
		        properties.setProperty("class", "org.jagruti.javaweb.model.Student");
		        properties.setProperty("exclude-unlisted-classes", "true");
		        properties.setProperty("javax.persistence.query.timeout","5000");
		        properties.setProperty("datanucleus.appengine.datastoreReadConsistency","STRONG");
		        properties.setProperty("datanucleus.appengine.datastoreEnableXGTransactions","true");
		        properties.setProperty("datanucleus.NontransactionalRead","true");
		        properties.setProperty("datanucleus.NontransactionalWrite","true");
		        properties.setProperty("datanucleus.ConnectionURL","appengine");
		        //Persistence. PERSISTENCE_PROVIDER="org.datanucleus.api.jpa.PersistenceProviderImpl";
		     
		        emfInstance=Persistence.createEntityManagerFactory("activityInfo",properties);
		        System.out.println(" EntityManagerFACTORY created");
		      }
		      return emfInstance;
		    }
		
}*/