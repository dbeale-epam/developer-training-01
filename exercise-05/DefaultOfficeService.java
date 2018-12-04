
package org.officeco.service;
import de.hybris.platform.servicelayer.exceptions.AmbiguousIdentifierException;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;
import java.util.List;
import org.springframework.beans.factory.annotation.Required;
import org.officeco.dao.OfficeDAO;
import org.officeco.model.OfficeModel;

 
public class DefaultOfficeService implements OfficeService
{
    private OfficeDAO officeDAO;
    /**
     * Gets all Offices by delegating to {@link OfficeDAO#findOffices()}.
     */
    @Override
    public List<OfficeModel> getOffices()
    {
        return officeDAO.findOffices();
    }
    /**
     * Gets all Offices for given code by delegating to {@link OfficeDAO#findOfficesByCode(String)} and then assuring
     * uniqueness of result.
     */
    @Override
    public OfficeModel getOfficeForCode(final String code) throws AmbiguousIdentifierException, UnknownIdentifierException
    {
        final List<OfficeModel> result = officeDAO.findOfficesByCode(code);
        if (result.isEmpty())
        {
            throw new UnknownIdentifierException("Office with code '" + code + "' not found!");
        }
        else if (result.size() > 1)
        {
            throw new AmbiguousIdentifierException("Office code '" + code + "' is not unique, " + result.size() + " Offices found!");
        }
        return result.get(0);
    }
    @Required
    public void setOfficeDAO(final OfficeDAO officeDAO)
    {
        this.officeDAO = officeDAO;
    }
}