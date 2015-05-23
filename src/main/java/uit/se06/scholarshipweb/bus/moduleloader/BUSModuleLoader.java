package uit.se06.scholarshipweb.bus.moduleloader;

import uit.se06.scholarshipweb.bus.factory.BUSAbstractFactory;
import uit.se06.scholarshipweb.bus.proxy.DirectAccessBUSFactory;
import uit.se06.scholarshipweb.util.ProxyType;

public class BUSModuleLoader {

	public static void loadConcreteFactory(ProxyType proxyType) {

		if (BUSAbstractFactory.INS != null) {
			System.err
					.println("BUSAbstractFactory.INS is already implemented!");
			return;
		}

		switch (proxyType) {
		case WebService:
			// throw new IllegalArgumentException("Not implemented!");
			// break;
		case DirectAccess:
			BUSAbstractFactory.INS = new DirectAccessBUSFactory();
			break;
		}
	}
}
