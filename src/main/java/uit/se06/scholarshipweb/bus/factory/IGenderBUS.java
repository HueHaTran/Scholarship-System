package uit.se06.scholarshipweb.bus.factory;

import java.util.List;

import uit.se06.scholarshipweb.model.Gender;

public interface IGenderBUS {

	public abstract Gender findById(int id);

	public abstract Gender findByName(String name);

	public abstract List<Gender> list();

}