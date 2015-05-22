package uit.se06.scholarshipweb.dao.loader;

import uit.se06.scholarshipweb.dao.factory.DAOAbstractFactory;
import uit.se06.scholarshipweb.dao.proxy.JdbcDAOConnectionFactory;
import uit.se06.scholarshipweb.util.ProxyType;

public class DAOLoader {
	public enum DatabaseConnectionProxyType {
		Jdbc
	}

	public static void loadDAOConcreteFactory(
			DatabaseConnectionProxyType databaseConnectionProxyType) {
		switch (databaseConnectionProxyType) {

		case Jdbc:
			DAOAbstractFactory.INS = new JdbcDAOConnectionFactory();
			break;
		}
	}

	public static void loadConcreteFactory(ProxyType proxyType) {
		switch (proxyType) {
		case WebService:
			//throw new IllegalArgumentException("Not implemented!");
			// break;
		case DirectAccess:
			// 
			break;
		}
	}
}
