package services;

import exceptions.BusinessRuleException;

public class Financing {

	double totalAmount;
	double income;
	Integer months;

	public Financing(double totalAmount, double income, Integer months) {

		this.totalAmount = totalAmount;
		this.income = income;
		this.months = months;

		if (quota() > income * 0.5) {

			throw new BusinessRuleException("Quota cannot be greater than half the monthly Income");

		}

	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {

		this.totalAmount = totalAmount;

		if (quota() > income * 0.5) {

			throw new BusinessRuleException("Quota cannot be greater than half the monthly Income");

		}
	}

	public double getIncome() {
		return income;
	}

	public void setIncome(double income) {

		this.income = income;

		if (quota() > income * 0.5) {

			throw new BusinessRuleException("Quota cannot be greater than half the monthly Income");

		}
	}

	public Integer getMonths() {
		return months;
	}

	public void setMonths(Integer months) {

		this.months = months;

		if (quota() > income * 0.5) {

			throw new BusinessRuleException("Quota cannot be greater than half the monthly Income");

		}
	}

	public double entry() {
		return totalAmount * 0.2;
	}

	public double quota() {
		return (totalAmount * 0.8) / (months);
	}

}
