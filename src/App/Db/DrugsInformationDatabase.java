package App.Db;

import App.Drug.DrugInformation;

import java.util.HashSet;
import java.util.Set;

public class DrugsInformationDatabase implements Database<DrugInformation> {

    private Set<DrugInformation> allDrugInformation = new HashSet<>();

    private DrugsDatabase drugsDatabase;

    public DrugsInformationDatabase(DrugsDatabase drugsDatabase) {
        this.drugsDatabase = drugsDatabase;

        this.deserializeAll();
    }

    public Set<DrugInformation> getAll() {
        return this.allDrugInformation;
    }

    public void addDeserialized(DrugInformation drugInformation) {
        // set drug to same instance as drug in drugsDatabase in deserialization
        drugInformation.setDrug(this.drugsDatabase.getByCode(drugInformation.getDrug().getCode()));

        this.allDrugInformation.add(drugInformation);
    }
}
