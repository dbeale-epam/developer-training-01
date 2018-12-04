package org.officeco.dao;
import java.util.List;

import org.officeco.model.OfficeModel;


/**
 * An interface for the Office DAO including various operations for retrieving persisted Office model objects
 */
public interface OfficeDAO
{
	/**
	 * Return a list of Office models that are currently persisted. If none are found an empty list is returned.
	 *
	 * @return all the offices in the system
	 */
	List<OfficeModel> findOffices();

	/**
	 * Finds all offices with given code. If none is found, an empty list will be returned.
	 *
	 * @param code
	 *           the code to search for offices
	 * @return All offices with the given code.
	 */
	List<OfficeModel> findOfficesByCode(String code);
}