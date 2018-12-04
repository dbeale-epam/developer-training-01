/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2017 SAP SE
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * Hybris ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the
 * terms of the license agreement you entered into with SAP Hybris.
 */
package org.officeco.service;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import de.hybris.bootstrap.annotations.UnitTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.officeco.dao.OfficeDAO;
import org.officeco.model.OfficeModel;


/**
 * This test file tests and demonstrates the behavior of the OfficeService's methods getAllOffice, getOffice and
 * saveOffice.
 *
 * We already have a separate file for testing the Office DAO, and we do not want this test to implicitly test that in
 * addition to the OfficeService. This test therefore mocks out the Office DAO leaving us to test the Service in
 * isolation, whose behavior should be simply to wraps calls to the DAO: forward calls to it, and passing on the results
 * it receives from it.
 */
@UnitTest
public class DefaultOfficeServiceUnitTest
{
	private DefaultOfficeService officeService;
	private OfficeDAO officeDAO;
	private OfficeModel officeModel;
	/** Name of test office. */
	private static final String OFFICE_CODE = "RG1";
	/** Name of test office. */
	private static final String OFFICE_NAME = "Reading Central";

	/** History of test office. */
	//    private static final String BAND_HISTORY = "Medieval choir formed in 2001, based in Munich famous for authentic monastic chants";
    @Before
    public void setUp()
    {
		// We will be testing OfficeServiceImpl - an implementation of OfficeService
		officeService = new DefaultOfficeService();
        // So as not to implicitly also test the DAO, we will mock out the DAO using Mockito
		officeDAO = mock(OfficeDAO.class);
		// and inject this mocked DAO into the OfficeService
		officeService.setOfficeDAO(officeDAO);
		// This instance of a OfficeModel will be used by the tests
		officeModel = new OfficeModel();
		officeModel.setCode(OFFICE_CODE);
		officeModel.setName(OFFICE_NAME);

    }

	/**
	 * This test tests and demonstrates that the Service's getAllOffices method calls the DAOs' getOffices method and
	 * returns the data it receives from it.
	 */
    @Test
	public void testGetAllOffices()
    {
        // We construct the data we would like the mocked out DAO to return when called
		final List<OfficeModel> officeModels = Arrays.asList(officeModel);
        //Use Mockito and compare results
		when(officeDAO.findOffices()).thenReturn(officeModels);
		// Now we make the call to OfficeService's getOffices() which we expect to call the DAOs' findOffices() method
		final List<OfficeModel> result = officeService.getOffices();
        // We then verify that the results returned from the service match those returned by the mocked-out DAO
        assertEquals("We should find one", 1, result.size());
		assertEquals("And should equals what the mock returned", officeModel, result.get(0));
    }
    @Test
	public void testGetOffice()
    {
		// Tell Mockito we expect a call to the DAO's getOffice(), and, if it occurs, Mockito should return OfficeModel instance
		when(officeDAO.findOfficesByCode(OFFICE_CODE)).thenReturn(Collections.singletonList(officeModel));
		// We make the call to the Service's getOfficeForCode() which we expect to call the DAO's findOfficesByCode()
		final OfficeModel result = officeService.getOfficeForCode(OFFICE_CODE);
        // We then verify that the result returned from the Service is the same as that returned from the DAO
		assertEquals("Office should equals() what the mock returned", officeModel, result);
    }
}
