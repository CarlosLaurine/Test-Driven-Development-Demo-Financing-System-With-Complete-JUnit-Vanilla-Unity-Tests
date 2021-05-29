package tests.factory;

import services.Financing;

public class FinancingFactory {

	public static Financing getDefaultFinancing() {
		return new Financing (100000.0, 2000.0, 80);
	}
}
