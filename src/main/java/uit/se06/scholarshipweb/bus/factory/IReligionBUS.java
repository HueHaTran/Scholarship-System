package uit.se06.scholarshipweb.bus.factory;

import java.util.List;

import uit.se06.scholarshipweb.model.Religion;

public interface IReligionBUS {

	public abstract Religion findById(int id);

	public abstract Religion findByName(String name);

	public abstract List<Religion> list();

}