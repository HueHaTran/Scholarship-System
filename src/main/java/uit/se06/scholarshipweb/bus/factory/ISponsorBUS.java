package uit.se06.scholarshipweb.bus.factory;

import java.util.List;

import uit.se06.scholarshipweb.model.Sponsor;

public interface ISponsorBUS {

	public abstract Sponsor findById(int id);

	public abstract Sponsor findByName(String name);

	public abstract List<Sponsor> list();

}