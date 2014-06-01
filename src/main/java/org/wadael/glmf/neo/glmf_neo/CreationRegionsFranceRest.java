package org.wadael.glmf.neo.glmf_neo ;


import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.neo4j.graphdb.DynamicLabel;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.Transaction;
import org.neo4j.rest.graphdb.RestGraphDatabase;
import static org.wadael.glmf.neo.glmf_neo.CreationRegionsFranceRest.NosRelationshipTypes.SITUE_DANS;

/**
 * Creation des regions , update de leurs departements
 */

public class CreationRegionsFranceRest {

    	public static enum NosRelationshipTypes implements RelationshipType {
		SITUE_DANS
	}
    
    public static void main(String[] args) { // throws Exception {

		Date deb = new Date();
		GraphDatabaseService db = new RestGraphDatabase("http://localhost:7474/db/data");

		Label labelDepartement = DynamicLabel.label("Departement");
		Label labelRegion = DynamicLabel.label("Region");

		HashMap<String, String> regions = FranceAdministrativeHelper.libellesRegionsParCodeInsee;
		

		Iterator<String> it = regions.keySet().iterator();
		String code = ""; // null ;
		String lib = null;

		Node region = null;
		Node departement = null;

		while (it.hasNext()) {
			code = it.next();
			Transaction tx = db.beginTx();

			// creation région
			try {
				region = db.findNodesByLabelAndProperty(labelRegion, "code", code).iterator().next();
			} catch (Exception e1) {
				region = null;
			}

			if (region == null) {
				region = db.createNode();
				region.addLabel(labelRegion);
				region.setProperty("code", code);
				region.setProperty("name", regions.get(code));
			}

			
			
			// ses departements
			Set<String> depts = FranceAdministrativeHelper.getDepartements(code);
			Iterator<String> itDepts = depts.iterator();
			String codeDpt;

			while (itDepts.hasNext()) {
				codeDpt = itDepts.next();
				try {
					departement = db.findNodesByLabelAndProperty(labelDepartement, "code", codeDpt).iterator().next();
				} catch (Exception e) {
					departement = null;
				}

				if (departement == null) {
					departement = db.createNode(labelDepartement);
					departement.setProperty("code", codeDpt);
				}

                                if ( !departement.hasProperty("name") ) 
						departement.setProperty("name", FranceAdministrativeHelper.getDepartementLabel(codeDpt));

				departement.createRelationshipTo(region, SITUE_DANS);
			}

			tx.success();
			tx.close();
		}

		Date fin = new Date();
		long delta = (fin.getTime() - deb.getTime()) / 1000;
		System.out.println("Temps écoulé " + delta + " secondes");
	}
}
