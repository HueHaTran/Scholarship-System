package uit.se06.scholarshipweb.bus.serviceprovider.loader;

import uit.se06.scholarshipweb.bus.factory.BUSAbstractFactory;
import uit.se06.scholarshipweb.bus.serviceprovider.proxy.DirectAccessBUSFactory;
import uit.se06.scholarshipweb.util.ProxyType;

public class BUSLoader {

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
