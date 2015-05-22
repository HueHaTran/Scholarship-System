package uit.se06.scholarshipweb.controller;

import uit.se06.scholarshipweb.dao.loader.DAOLoader;
import uit.se06.scholarshipweb.dao.loader.DAOLoader.DatabaseConnectionProxyType;

public class BaseController {
	public BaseController() {
		// set up
		DAOLoader.loadDAOConcreteFactory(DatabaseConnectionProxyType.Jdbc);
	}
}
