package uit.se06.scholarshipweb.bus.factory;

import java.util.List;

import uit.se06.scholarshipweb.model.School;

public interface ISchoolBUS {

	public abstract School findById(int id);

	public abstract School findByName(String name);

	public abstract List<School> list();

}