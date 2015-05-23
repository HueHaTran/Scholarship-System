package uit.se06.scholarshipweb.bus.factory;

import java.util.List;

import uit.se06.scholarshipweb.model.AcademicLevel;

public interface IAcademicLevelBUS {

	/**
	 * with detail
	 * 
	 * @param id
	 * @return
	 */
	public abstract AcademicLevel findById(int id);

	/**
	 * with detail
	 * 
	 * @param name
	 * @return
	 */
	public abstract AcademicLevel findByName(String name);

	/**
	 * general info only, no detail
	 * 
	 * @return
	 */
	public abstract List<AcademicLevel> list();

	/**
	 * with detail
	 * 
	 * @return
	 */
	public abstract List<AcademicLevel> listWithDetails();

}