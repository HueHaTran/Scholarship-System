package uit.se06.scholarshipweb.bus.factory;

import java.util.List;

import uit.se06.scholarshipweb.model.ScholarshipType;

public interface IScholarshipTypeBUS {

	public abstract ScholarshipType findById(int id);

	public abstract ScholarshipType findByName(String name);

	public abstract List<ScholarshipType> list();

}