package uit.se06.scholarshipweb.bus.factory;

import java.util.List;

import uit.se06.scholarshipweb.model.Ethnic;

public interface IEthnicBUS {

	public abstract Ethnic findById(int id);

	public abstract Ethnic findByName(String name);

	public abstract List<Ethnic> list();

}