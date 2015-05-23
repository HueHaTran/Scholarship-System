package uit.se06.scholarshipweb.bus.factory;

import java.util.List;

import uit.se06.scholarshipweb.model.Scholarship;
import uit.se06.scholarshipweb.viewmodel.OverviewScholarshipViewModel;
import uit.se06.scholarshipweb.viewmodel.ScholarshipViewModel;

public interface IScholarshipBUS {

	public abstract ScholarshipViewModel findById(int id);

	public abstract ScholarshipViewModel findByName(String name);

	public abstract List<Scholarship> list();

	public abstract OverviewScholarshipViewModel findOverviewById(int id);

	public abstract OverviewScholarshipViewModel convertToOverviewViewModel(
			Scholarship scholarship);

}