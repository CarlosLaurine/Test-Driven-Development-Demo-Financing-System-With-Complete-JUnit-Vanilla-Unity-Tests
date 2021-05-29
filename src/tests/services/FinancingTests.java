package tests.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import exceptions.BusinessRuleException;
import services.Financing;
import tests.factory.FinancingFactory;

public class FinancingTests {

	@Test
	public void constructorShouldThrowExceptionWhenDataDoesNotAttendBusinessRules() {

		Assertions.assertThrows(BusinessRuleException.class, () -> {

			@SuppressWarnings("unused")
			Financing financingSystem = new Financing(100000.0, 2000.0, 20);

		});
	}

	@Test
	public void constructorShouldAllowObjectInstantiationWhenDataAttendsBusinessRules() {

		Financing financingSystem = FinancingFactory.getDefaultFinancing();

		Assertions.assertTrue(financingSystem != null);
	}

	@Test
	public void totalAmountSetterShouldThrowExceptionWhenDataDoesNotAttendBusinessRules() {

		Assertions.assertThrows(BusinessRuleException.class, () -> {

			Financing financingSystem = FinancingFactory.getDefaultFinancing();

			double newTotalAmount = 110000.0;

			financingSystem.setTotalAmount(newTotalAmount);

		});
	}

	@Test
	public void totalAmountSetterShouldSetTotalAmountWhenDataAttendsBusinessRules() {

		Financing financingSystem = FinancingFactory.getDefaultFinancing();

		double newTotalAmount = 90000.0;

		financingSystem.setTotalAmount(newTotalAmount);

		Assertions.assertEquals(newTotalAmount, financingSystem.getTotalAmount());

	}

	@Test
	public void incomeSetterShouldThrowExceptionWhenDataDoesNotAttendBusinessRules() {

		Assertions.assertThrows(BusinessRuleException.class, () -> {

			Financing financingSystem = FinancingFactory.getDefaultFinancing();

			double newIncome = 1500.0;

			financingSystem.setIncome(newIncome);

		});
	}

	@Test
	public void incomeSetterShouldSetIncomeWhenDataAttendsBusinessRules() {

		Financing financingSystem = FinancingFactory.getDefaultFinancing();

		double newIncome = 2100.0;

		financingSystem.setIncome(newIncome);

		Assertions.assertEquals(newIncome, financingSystem.getIncome());

	}

	@Test
	public void monthsSetterShouldThrowExceptionWhenDataDoesNotAttendBusinessRules() {

		Assertions.assertThrows(BusinessRuleException.class, () -> {

			Financing financingSystem = FinancingFactory.getDefaultFinancing();

			int newMonths = 70;

			financingSystem.setMonths(newMonths);

		});
	}

	@Test
	public void monthsAmountSetterShouldSetMonthsWhenDataAttendsBusinessRules() {

		Financing financingSystem = FinancingFactory.getDefaultFinancing();

		int newMonths = 100;

		financingSystem.setMonths(newMonths);

		Assertions.assertEquals(newMonths, financingSystem.getMonths());

	}

	/*
	 * Since Financing's Constructor and Getter/Setter Methods force the Object's
	 * Instantiation and Attribute Changes to obey the Business Rules, the only
	 * Scenario to be tested for Entry and Quota Methods are Outputs in case of
	 * Valid Data
	 */

	@Test
	public void EntryShouldReturnCorrectPercentageOfTotalAmountWhenCalled() {

		Financing financingSystem = FinancingFactory.getDefaultFinancing();

		double expectedEntry = financingSystem.getTotalAmount() * 0.2;

		double returnedEntry = financingSystem.entry();

		Assertions.assertEquals(expectedEntry, returnedEntry);

	}

	@Test
	public void QuotaShouldReturnCorrectRatioWhenCalled() {

		Financing financingSystem = FinancingFactory.getDefaultFinancing();

		double expectedQuota = financingSystem.getTotalAmount() * 0.8 / financingSystem.getMonths();

		double returnedQuota = financingSystem.quota();

		Assertions.assertEquals(expectedQuota, returnedQuota);

	}
}
