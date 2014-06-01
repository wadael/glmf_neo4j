package org.wadael.glmf.neo.glmf_neo ;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Helper pour les régions et départements de France.
 * 
 * Sources http://www.insee.fr/fr/methodes/nomenclatures/cog/region.asp , 
 * http://fr.wikipedia.org/wiki/R%C3%A9gion_fran%C3%A7aise#Les_27_r.C3.A9gions_fran.C3.A7aises
 * 
 */
public class FranceAdministrativeHelper {

    /*
     * clef = code region insee , valeur = libelle region
     */
    static protected HashMap<String, String> libellesRegionsParCodeInsee = null;

    /*
     * clef = code insee departement, valeur = code region insee
     */
    static protected HashMap<String, String> regionsParDepartement = null;

    /*
     * clef = code region, valeur = set de codes departement
     */
    static protected HashMap<String, Set<String>> departementsParRegion = new HashMap<String, Set<String>>();

    /*
     * clef = code departement insee , valeur = libelle departement
     */
    static protected HashMap<String, String> libellesDepartementsParCodeInsee = null;

    static {
        libellesRegionsParCodeInsee = new HashMap<String, String>(27);

        libellesRegionsParCodeInsee.put("42", "Alsace"); // STRASBOURG
        libellesRegionsParCodeInsee.put("72", "Aquitaine"); // BORDEAUX
        libellesRegionsParCodeInsee.put("83", "Auvergne"); // CLERMONT-FERRAND
        libellesRegionsParCodeInsee.put("25", "Basse-Normandie"); // CAEN
        libellesRegionsParCodeInsee.put("26", "Bourgogne"); // DIJON
        libellesRegionsParCodeInsee.put("53", "Bretagne"); // RENNES
        libellesRegionsParCodeInsee.put("24", "Centre"); // ORL�ANS
        libellesRegionsParCodeInsee.put("21", "Champagne-Ardenne"); // CH�LONS-EN-CHAMPAGNE
        libellesRegionsParCodeInsee.put("94", "Corse"); // AJACCIO
        libellesRegionsParCodeInsee.put("43", "Franche-Comté"); // BESAN�ON
        libellesRegionsParCodeInsee.put("01", "Guadeloupe"); // BASSE-TERRE
        libellesRegionsParCodeInsee.put("03", "Guyane"); // CAYENNE
        libellesRegionsParCodeInsee.put("23", "Haute-Normandie"); // ROUEN
        libellesRegionsParCodeInsee.put("11", "Île-de-France"); // PARIS
        libellesRegionsParCodeInsee.put("04", "La Réunion"); // SAINT-DENIS
        libellesRegionsParCodeInsee.put("91", "Languedoc-Roussillon"); // MONTPELLIER
        libellesRegionsParCodeInsee.put("74", "Limousin"); // LIMOGES
        libellesRegionsParCodeInsee.put("41", "Lorraine"); // METZ
        libellesRegionsParCodeInsee.put("02", "Martinique"); // FORT-DE-FRANCE
        libellesRegionsParCodeInsee.put("06", "Mayotte"); // DZAOUDZI
        libellesRegionsParCodeInsee.put("73", "Midi-Pyrénées"); // TOULOUSE
        libellesRegionsParCodeInsee.put("31", "Nord-Pas-de-Calais"); // LILLE
        libellesRegionsParCodeInsee.put("52", "Pays de la Loire"); // NANTES
        libellesRegionsParCodeInsee.put("22", "Picardie"); // AMIENS
        libellesRegionsParCodeInsee.put("54", "Poitou-Charentes"); // POITIERS
        libellesRegionsParCodeInsee.put("93", "Provence-Alpes-Côte d'Azur"); // MARSEILLE
        libellesRegionsParCodeInsee.put("82", "Rhône-Alpes"); // LYON

        regionsParDepartement = new HashMap<String, String>(101);
        
        putRegionsParDepartement("67", "42");
        putRegionsParDepartement("68", "42");
        putRegionsParDepartement("24", "72");
        putRegionsParDepartement("33", "72");
        putRegionsParDepartement("40", "72");
        putRegionsParDepartement("47", "72");
        putRegionsParDepartement("64", "72");
        putRegionsParDepartement("03", "83");
        putRegionsParDepartement("15", "83");
        putRegionsParDepartement("43", "83");
        putRegionsParDepartement("63", "83");
        putRegionsParDepartement("21", "26");
        putRegionsParDepartement("58", "26");
        putRegionsParDepartement("71", "26");
        putRegionsParDepartement("89", "26");
        putRegionsParDepartement("22", "53");
        putRegionsParDepartement("29", "53");
        putRegionsParDepartement("35", "53");
        putRegionsParDepartement("56", "53");
        putRegionsParDepartement("18", "24");
        putRegionsParDepartement("28", "24");
        putRegionsParDepartement("36", "24");
        putRegionsParDepartement("37", "24");
        putRegionsParDepartement("41", "24");
        putRegionsParDepartement("45", "24");
        putRegionsParDepartement("08", "21");
        putRegionsParDepartement("10", "21");
        putRegionsParDepartement("51", "21");
        putRegionsParDepartement("52", "21");
        putRegionsParDepartement("2A", "94");
        putRegionsParDepartement("2B", "94");
        putRegionsParDepartement("25", "43");
        putRegionsParDepartement("39", "43");
        putRegionsParDepartement("70", "43");
        putRegionsParDepartement("90", "43");
        putRegionsParDepartement("971", "01");
        putRegionsParDepartement("973", "03");
        putRegionsParDepartement("75", "11");
        putRegionsParDepartement("91", "11");
        putRegionsParDepartement("92", "11");
        putRegionsParDepartement("93", "11");
        putRegionsParDepartement("77", "11");
        putRegionsParDepartement("94", "11");
        putRegionsParDepartement("95", "11");
        putRegionsParDepartement("78", "11");
        putRegionsParDepartement("11", "91");
        putRegionsParDepartement("30", "91");
        putRegionsParDepartement("34", "91");
        putRegionsParDepartement("48", "91");
        putRegionsParDepartement("66", "91");
        putRegionsParDepartement("19", "74");
        putRegionsParDepartement("23", "74");
        putRegionsParDepartement("87", "74");
        putRegionsParDepartement("54", "41");
        putRegionsParDepartement("55", "41");
        putRegionsParDepartement("57", "41");
        putRegionsParDepartement("88", "41");
        putRegionsParDepartement("972", "02");
        putRegionsParDepartement("976", "06");
        putRegionsParDepartement("09", "73");
        putRegionsParDepartement("12", "73");
        putRegionsParDepartement("31", "73");
        putRegionsParDepartement("32", "73");
        putRegionsParDepartement("46", "73");
        putRegionsParDepartement("65", "73");
        putRegionsParDepartement("81", "73");
        putRegionsParDepartement("82", "73");
        putRegionsParDepartement("59", "31");
        putRegionsParDepartement("62", "31");
        putRegionsParDepartement("14", "25");
        putRegionsParDepartement("50", "25");
        putRegionsParDepartement("61", "25");
        putRegionsParDepartement("27", "23");
        putRegionsParDepartement("76", "23");
        putRegionsParDepartement("44", "52");
        putRegionsParDepartement("49", "52");
        putRegionsParDepartement("53", "52");
        putRegionsParDepartement("72", "52");
        putRegionsParDepartement("85", "52");
        putRegionsParDepartement("02", "22");
        putRegionsParDepartement("60", "22");
        putRegionsParDepartement("80", "22");
        putRegionsParDepartement("16", "54");
        putRegionsParDepartement("17", "54");
        putRegionsParDepartement("79", "54");
        putRegionsParDepartement("86", "54");
        putRegionsParDepartement("04", "93");
        putRegionsParDepartement("05", "93");
        putRegionsParDepartement("06", "93");
        putRegionsParDepartement("13", "93");
        putRegionsParDepartement("83", "93");
        putRegionsParDepartement("84", "93");
        putRegionsParDepartement("974", "04");
        putRegionsParDepartement("01", "82");
        putRegionsParDepartement("07", "82");
        putRegionsParDepartement("26", "82");
        putRegionsParDepartement("38", "82");
        putRegionsParDepartement("42", "82");
        putRegionsParDepartement("69", "82");
        putRegionsParDepartement("73", "82");
        putRegionsParDepartement("74", "82");

        libellesDepartementsParCodeInsee = new HashMap<String, String>(101);
        libellesDepartementsParCodeInsee.put("01", "Ain"); //
        libellesDepartementsParCodeInsee.put("02", "Aisne"); //
        libellesDepartementsParCodeInsee.put("03", "Allier"); //
        libellesDepartementsParCodeInsee.put("04", "Alpes-de-Haute-Provence"); //
        libellesDepartementsParCodeInsee.put("05", "Hautes-Alpes"); //
        libellesDepartementsParCodeInsee.put("06", "Alpes-Maritimes"); //
        libellesDepartementsParCodeInsee.put("07", "Ardèche"); //
        libellesDepartementsParCodeInsee.put("08", "Ardennes"); //
        libellesDepartementsParCodeInsee.put("09", "Ariège"); //
        libellesDepartementsParCodeInsee.put("10", "Aube"); //
        libellesDepartementsParCodeInsee.put("11", "Aude"); //
        libellesDepartementsParCodeInsee.put("12", "Aveyron"); //
        libellesDepartementsParCodeInsee.put("13", "Bouches-du-Rh�ne"); //
        libellesDepartementsParCodeInsee.put("14", "Calvados"); //
        libellesDepartementsParCodeInsee.put("15", "Cantal"); //
        libellesDepartementsParCodeInsee.put("16", "Charente"); //
        libellesDepartementsParCodeInsee.put("17", "Charente-Maritime"); //
        libellesDepartementsParCodeInsee.put("18", "Cher"); //
        libellesDepartementsParCodeInsee.put("19", "Corrèze"); //
        libellesDepartementsParCodeInsee.put("2A", "Corse-du-Sud"); //
        libellesDepartementsParCodeInsee.put("2B", "Haute-Corse"); //
        libellesDepartementsParCodeInsee.put("21", "Côte-d'Or"); //
        libellesDepartementsParCodeInsee.put("22", "Côtes-d'Armor"); //
        libellesDepartementsParCodeInsee.put("23", "Creuse"); //
        libellesDepartementsParCodeInsee.put("24", "Dordogne"); //
        libellesDepartementsParCodeInsee.put("25", "Doubs"); //
        libellesDepartementsParCodeInsee.put("26", "Drôme"); //
        libellesDepartementsParCodeInsee.put("27", "Eure"); //
        libellesDepartementsParCodeInsee.put("28", "Eure-et-Loir"); //
        libellesDepartementsParCodeInsee.put("29", "Finist�re"); //
        libellesDepartementsParCodeInsee.put("30", "Gard"); //
        libellesDepartementsParCodeInsee.put("31", "Haute-Garonne"); //
        libellesDepartementsParCodeInsee.put("32", "Gers"); //
        libellesDepartementsParCodeInsee.put("33", "Gironde"); //
        libellesDepartementsParCodeInsee.put("34", "Hérault"); //
        libellesDepartementsParCodeInsee.put("35", "Ille-et-Vilaine"); //
        libellesDepartementsParCodeInsee.put("36", "Indre"); //
        libellesDepartementsParCodeInsee.put("37", "Indre-et-Loire"); //
        libellesDepartementsParCodeInsee.put("38", "Isère"); //
        libellesDepartementsParCodeInsee.put("39", "Jura"); //
        libellesDepartementsParCodeInsee.put("40", "Landes"); //
        libellesDepartementsParCodeInsee.put("41", "Loir-et-Cher"); //
        libellesDepartementsParCodeInsee.put("42", "Loire"); //
        libellesDepartementsParCodeInsee.put("43", "Haute-Loire"); //
        libellesDepartementsParCodeInsee.put("44", "Loire-Atlantique"); //
        libellesDepartementsParCodeInsee.put("45", "Loiret"); //
        libellesDepartementsParCodeInsee.put("46", "Lot"); //
        libellesDepartementsParCodeInsee.put("47", "Lot-et-Garonne"); //
        libellesDepartementsParCodeInsee.put("48", "Lozère"); //
        libellesDepartementsParCodeInsee.put("49", "Maine-et-Loire"); //
        libellesDepartementsParCodeInsee.put("50", "Manche"); //
        libellesDepartementsParCodeInsee.put("51", "Marne"); //
        libellesDepartementsParCodeInsee.put("52", "Haute-Marne"); //
        libellesDepartementsParCodeInsee.put("53", "Mayenne"); //
        libellesDepartementsParCodeInsee.put("54", "Meurthe-et-Moselle"); //
        libellesDepartementsParCodeInsee.put("55", "Meuse"); //
        libellesDepartementsParCodeInsee.put("56", "Morbihan"); //
        libellesDepartementsParCodeInsee.put("57", "Moselle"); //
        libellesDepartementsParCodeInsee.put("58", "Nièvre"); //
        libellesDepartementsParCodeInsee.put("59", "Nord"); //
        libellesDepartementsParCodeInsee.put("60", "Oise"); //
        libellesDepartementsParCodeInsee.put("61", "Orne"); //
        libellesDepartementsParCodeInsee.put("62", "Pas-de-Calais"); //
        libellesDepartementsParCodeInsee.put("63", "Puy-de-Dôme"); //
        libellesDepartementsParCodeInsee.put("64", "Pyrénées-Atlantiques"); //
        libellesDepartementsParCodeInsee.put("65", "Hautes-Pyrénées"); //
        libellesDepartementsParCodeInsee.put("66", "Pyrénées-Orientales"); //
        libellesDepartementsParCodeInsee.put("67", "Bas-Rhin"); //
        libellesDepartementsParCodeInsee.put("68", "Haut-Rhin"); //
        libellesDepartementsParCodeInsee.put("69", "Rhône"); //
        libellesDepartementsParCodeInsee.put("70", "Haute-Saône"); //
        libellesDepartementsParCodeInsee.put("71", "Saône-et-Loire"); //
        libellesDepartementsParCodeInsee.put("72", "Sarthe"); //
        libellesDepartementsParCodeInsee.put("73", "Savoie"); //
        libellesDepartementsParCodeInsee.put("74", "Haute-Savoie"); //
        libellesDepartementsParCodeInsee.put("75", "Paris"); //
        libellesDepartementsParCodeInsee.put("76", "Seine-Maritime"); //
        libellesDepartementsParCodeInsee.put("77", "Seine-et-Marne"); //
        libellesDepartementsParCodeInsee.put("78", "Yvelines"); //
        libellesDepartementsParCodeInsee.put("79", "Deux-Sêvres"); //
        libellesDepartementsParCodeInsee.put("80", "Somme"); //
        libellesDepartementsParCodeInsee.put("81", "Tarn"); //
        libellesDepartementsParCodeInsee.put("82", "Tarn-et-Garonne"); //
        libellesDepartementsParCodeInsee.put("83", "Var"); //
        libellesDepartementsParCodeInsee.put("84", "Vaucluse"); //
        libellesDepartementsParCodeInsee.put("85", "Vend�e"); //
        libellesDepartementsParCodeInsee.put("86", "Vienne"); //
        libellesDepartementsParCodeInsee.put("87", "Haute-Vienne"); //
        libellesDepartementsParCodeInsee.put("88", "Vosges"); //
        libellesDepartementsParCodeInsee.put("89", "Yonne"); //
        libellesDepartementsParCodeInsee.put("90", "Territoire de Belfort"); //
        libellesDepartementsParCodeInsee.put("91", "Essonne"); //
        libellesDepartementsParCodeInsee.put("92", "Hauts-de-Seine"); //
        libellesDepartementsParCodeInsee.put("93", "Seine-Saint-Denis"); //
        libellesDepartementsParCodeInsee.put("94", "Val-de-Marne"); //
        libellesDepartementsParCodeInsee.put("95", "Val-d'Oise"); //
        libellesDepartementsParCodeInsee.put("971", "Guadeloupe"); //
        libellesDepartementsParCodeInsee.put("972", "Martinique"); //
        libellesDepartementsParCodeInsee.put("973", "Guyane"); //
        libellesDepartementsParCodeInsee.put("974", "La Réunion"); //
        libellesDepartementsParCodeInsee.put("976", "Mayotte"); //
    }

    /**
     * Renvoie le code Insee de la region dont on passe le code Insee en parametre.
     * 
     * @param departement
     *            sur 2 ou 3 caracteres (DOM)
     * @return code (sur deux caract�res)
     */
    public static String getCodeInseeRegion(final String departement) {
        return regionsParDepartement.get(departement);
    }

    private static void putRegionsParDepartement(final String codeDepartement, final String codeRegion) {
        // phase 2
        regionsParDepartement.put(codeDepartement, codeRegion);

        // phase 1
        Set<String> departements = departementsParRegion.get(codeRegion);
        if (departements == null) {
            departements = new HashSet<String>();
            departements.add(codeDepartement);
            departementsParRegion.put(codeRegion, departements);
        } else {
            departements.add(codeDepartement);
        }

    }

    /**
     * Renvoie le libell� de la r�gion (ou null)
     * 
     * @param codeInseeRegion
     *            (sur deux caract�res)
     * @return
     */
    public static String getRegionLabel(final String codeInseeRegion) {
        return libellesRegionsParCodeInsee.get(codeInseeRegion);
    }

    /**
     * Renvoie le libell� d'un d�partement.
     * 
     * @param codeInseeDepartement
     *            (sur deux caract�res)
     * @return
     */
    public static String getDepartementLabel(final String codeInseeDepartement) {
        return libellesDepartementsParCodeInsee.get(codeInseeDepartement);
    }

    public static final Set<String> getDepartements(final String codeRegion) {
        return departementsParRegion.get(codeRegion);
    }

    /**
     * Renvoie la liste des departements de la r�gion du d�partement pass� en param�tre
     * 
     * @param codeDepartement
     * @return
     */
    public static final Set<String> getDepartementsMemeRegion(final String codeDepartement) {
        return getDepartements(getCodeInseeRegion(codeDepartement));
    }

}