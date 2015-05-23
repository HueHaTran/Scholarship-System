package uit.se06.scholarshipweb.dao.loader;

import uit.se06.scholarshipweb.dao.factory.DAOAbstractFactory;
import uit.se06.scholarshipweb.dao.proxy.JdbcDAOConnectionFactory;
import uit.se06.scholarshipweb.util.ProxyType;

public class DAOLoader {
	public enum DatabaseConnectionProxyType {
		Jdbc
	}

	public static void loadConcreteFactory(
			DatabaseConnectionProxyType databaseConnectionProxyType,
			ProxyType proxyType) {

		if (DAOAbstractFactory.INS != null) {
			System.err
					.println("DAOAbstractFactory.INS is already implemented!");
			return;
		}

		switch (databaseConnectionProxyType) {
		case Jdbc:
			if (proxyType.equals(ProxyType.WebService)) {
				//

			} else if (proxyType.equals(ProxyType.DirectAccess)) {
				DAOAbstractFactory.INS = new JdbcDAOConnectionFactory();
			}
			break;
		}
	}
}
