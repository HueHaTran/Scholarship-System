package uit.se06.scholarshipweb.bus.factory;

import java.util.List;

import uit.se06.scholarshipweb.model.FamilyPolicy;

public interface IFamilyPolicyBUS {

	public abstract FamilyPolicy findById(int id);

	public abstract FamilyPolicy findByName(String name);

	public abstract List<FamilyPolicy> list();

}