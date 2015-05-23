package uit.se06.scholarshipweb.bus.factory;

import java.util.List;

import uit.se06.scholarshipweb.model.Disability;

public interface IDisabilityBUS {

	public abstract Disability findById(int id);

	public abstract Disability findByName(String name);

	public abstract List<Disability> list();

}