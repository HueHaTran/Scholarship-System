package uit.se06.scholarshipweb.bus.factory;

import java.util.List;

import uit.se06.scholarshipweb.model.TerminalIll;

public interface ITerminalIllBUS {

	public abstract TerminalIll findById(int id);

	public abstract TerminalIll findByName(String name);

	public abstract List<TerminalIll> list();

}