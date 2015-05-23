package uit.se06.scholarshipweb.bus.factory;

import java.util.List;

import uit.se06.scholarshipweb.model.FormOfParticipation;

public interface IFormOfParticipationBUS {

	public abstract FormOfParticipation findById(int id);

	public abstract FormOfParticipation findByName(String name);

	public abstract List<FormOfParticipation> list();

}