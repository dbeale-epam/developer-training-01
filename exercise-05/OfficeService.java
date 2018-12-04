package org.officeco.service;

import java.util.List;

import org.officeco.model.OfficeModel;

public interface OfficeService
{
	/**
	 * Gets all offices in the system.
	 *
	 * @return all offices in the system
	 */
	List<OfficeModel> getOffices();

	/**
	 * Gets the office for the given code.
	 *
	 * @throws de.hybris.platform.servicelayer.exceptions.AmbiguousIdentifierException
	 *            in case more then one office is found for the given code
	 * @throws de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException
	 *            in case no office for the given code can be found
	 */
	OfficeModel getOfficeForCode(String code);
}