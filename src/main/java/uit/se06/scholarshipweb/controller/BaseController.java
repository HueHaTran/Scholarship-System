package uit.se06.scholarshipweb.controller;

import uit.se06.scholarshipweb.bus.serviceprovider.loader.BUSLoader;
import uit.se06.scholarshipweb.dao.loader.DAOLoader;
import uit.se06.scholarshipweb.dao.loader.DAOLoader.DatabaseConnectionProxyType;
import uit.se06.scholarshipweb.util.ProxyType;

public class BaseController {
	public BaseController() {
		// set up
		BUSLoader.loadConcreteFactory(ProxyType.WebService);
		DAOLoader.loadConcreteFactory(DatabaseConnectionProxyType.Jdbc,
				ProxyType.DirectAccess);
	}
}
