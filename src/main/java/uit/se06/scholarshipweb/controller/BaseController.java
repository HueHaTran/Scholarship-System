package uit.se06.scholarshipweb.controller;

import uit.se06.scholarshipweb.bus.moduleloader.BUSModuleLoader;
import uit.se06.scholarshipweb.dao.moduleloader.DAOModuleLoader;
import uit.se06.scholarshipweb.dao.moduleloader.DAOModuleLoader.DatabaseConnectionProxyType;
import uit.se06.scholarshipweb.util.ProxyType;

public class BaseController {
	public BaseController() {
		// set up
		BUSModuleLoader.loadConcreteFactory(ProxyType.WebService);
		DAOModuleLoader.loadConcreteFactory(DatabaseConnectionProxyType.Jdbc,
				ProxyType.DirectAccess);
	}
}
