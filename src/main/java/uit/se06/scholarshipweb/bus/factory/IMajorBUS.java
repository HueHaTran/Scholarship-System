package uit.se06.scholarshipweb.bus.factory;

import java.util.List;

import uit.se06.scholarshipweb.model.Major;

public interface IMajorBUS {

	public abstract Major findById(int id);

	public abstract Major findByName(String name);

	public abstract List<Major> list();

}