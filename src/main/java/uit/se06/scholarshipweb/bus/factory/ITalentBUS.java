package uit.se06.scholarshipweb.bus.factory;

import java.util.List;

import uit.se06.scholarshipweb.model.Talent;

public interface ITalentBUS {

	public abstract Talent findById(int id);

	public abstract Talent findByName(String name);

	public abstract List<Talent> list();

}