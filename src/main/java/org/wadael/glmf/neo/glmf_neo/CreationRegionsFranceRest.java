package org.wadael.glmf.neo.glmf_neo;

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
        GraphDatabaseService db = new RestGraphDatabase("http://localhost:7474/db/data");
        Label labelDepartement = DynamicLabel.label("Departement");
        Label labelRegion = DynamicLabel.label("Region");

        HashMap<String, String> regions = FranceAdministrativeHelper.libellesRegionsParCodeInsee;
        Node region = null;
        Node departement = null;

        for (String codeRegion : regions.keySet()) {
            // creation région
            try (Transaction tx = db.beginTx()) { // transaction sera fermée automatiquement
                region = db.findNodesByLabelAndProperty(labelRegion, "code", codeRegion).iterator().next();
            } catch (Exception pasTrouveException) {
                region = db.createNode();
                region.addLabel(labelRegion);
                region.setProperty("code", codeRegion);
                region.setProperty("name", regions.get(codeRegion));
            }
            // ses departements
            Set<String> depts = FranceAdministrativeHelper.getDepartements(codeRegion);

            for (String codeDpt : depts) {
                try {
                    departement = db.findNodesByLabelAndProperty(labelDepartement, "code", codeDpt).iterator().next();
                } catch (Exception e) {
                    departement = db.createNode(labelDepartement);
                    departement.setProperty("code", codeDpt);
                }

                if (!departement.hasProperty("name")) {
                    departement.setProperty("name", FranceAdministrativeHelper.getDepartementLabel(codeDpt));
                }
                departement.createRelationshipTo(region, NosRelationshipTypes.SITUE_DANS);
            }
        }
    }
}
