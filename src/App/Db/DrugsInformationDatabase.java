package App.Db;

import App.Drug.Drug;
import App.Drug.DrugInformation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DrugsInformationDatabase extends AbstractDatabase<DrugInformation> {

    private Map<Drug, DrugInformation> drugsInformationMap = new HashMap<>();
    private Set<DrugInformation> allDrugInformation = new HashSet<>();

    public DrugsInformationDatabase(DrugsDatabase drugsDatabase) {
        // TODO serialization on all databases
        for (Drug drug : drugsDatabase.getAll()) {
            if (drug.getCode() == 25544) {
                DrugInformation information = new DrugInformation(
                    drug,

            "Jedna tableta obsahuje 500 mg kyseliny acetylsalicylovej (acidum acetylsalicylicum).\n" +
                    "\n" +
                    "Pomocné látky so známym účinkom: sacharóza 2 mg a sodík 293 mg v jednej šumivej tablete.\n" +
                    "Úplný zoznam pomocných látok, pozri časť 6.1.",

                "Dávkovanie je vždy individuálne a závisí od charakteru základného ochorenia, intenzity a frekvencie bolesti alebo od priebehu febrilného stavu. \n" +
                    "Obyčajne sa podáva dospelým a dospievajúcim starším ako 15 rokov 500-1000 mg kyseliny acetylsalicylovej (ASA) v jednej dávke, ktorú možno opakovať v intervale 4-8 hodín. Maximálna denná dávka je 4 g kyseliny acetylsalicylovej."
                );

                this.drugsInformationMap.put(drug, information);
                this.allDrugInformation.add(information);
            }
        }
    }

    public Set<DrugInformation> getAll() {
        return this.allDrugInformation;
    }

    public DrugInformation get(Drug drug) {
        return this.drugsInformationMap.get(drug);
    }

}
