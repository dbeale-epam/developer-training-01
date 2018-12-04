
package org.officeco.dao;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;

import java.util.List;

import org.officeco.model.OfficeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "OfficeDAO")
public class DefaultOfficeDAO implements OfficeDAO
{
    /**
    * Use SAP Commerce FlexibleSearchService for running queries against the database
     */
    @Autowired
    private FlexibleSearchService flexibleSearchService;
    
	/**
	 * Finds all Offices by performing a FlexibleSearch using the {@link FlexibleSearchService}.
	 */
    @Override
    public List<OfficeModel> findOffices()
    {
        // Build a query for the flexible search.
        final String queryString = //
                "SELECT {p:" + OfficeModel.PK + "} "//
                        + "FROM {" + OfficeModel._TYPECODE + " AS p} ";
        final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);
        // Note that we could specify paginating logic by providing a start and count variable (commented out below)
        // This can provide a safeguard against returning very large amounts of data, or hogging the database when there are
        // for example millions of items being returned.
		// As we know that there are only a few persisted offices in this use case we do not need to provide this.
        //query.setStart(start);
        //query.setCount(count);
		// Return the list of OfficeModels.
        return flexibleSearchService.<OfficeModel> search(query).getResult();
    }
    
	/**
	 * Finds all Offices by given code by performing a FlexibleSearch using the {@link FlexibleSearchService}.
	 */
    @Override
    public List<OfficeModel> findOfficesByCode(final String code)
    {
        final String queryString = //
                "SELECT {p:" + OfficeModel.PK + "}" //
                        + "FROM {" + OfficeModel._TYPECODE + " AS p} "//
                        + "WHERE " + "{p:" + OfficeModel.CODE + "}=?code ";
        final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);
        query.addQueryParameter("code", code);
        return flexibleSearchService.<OfficeModel> search(query).getResult();
    }
}