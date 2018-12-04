package org.officeco.controller;
import de.hybris.platform.catalog.CatalogVersionService;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.officeco.data.OfficeData;
import org.officeco.facade.OfficeFacade;
 
@Controller
public class OfficeController
{
    private static final String CATALOG_ID = "officecoProductCatalog";
    private static final String CATALOG_VERSION_NAME = "Online";
    private CatalogVersionService catalogVersionService;
    private OfficeFacade officeFacade;
    
    @RequestMapping(value = "/offices")
    public String showOffices(final Model model)
    {
        final List<OfficeData> offices = officeFacade.getOffices();
        model.addAttribute("offices", offices);
        return "OfficeList";
    }
    @RequestMapping(value = "/offices/{code}")
    public String showOfficeDetails(@PathVariable final String code, final Model model) throws UnsupportedEncodingException
    {
        catalogVersionService.setSessionCatalogVersion(CATALOG_ID, CATALOG_VERSION_NAME);
        final String decodedCode = URLDecoder.decode(code, "UTF-8");
        final OfficeData office = officeFacade.getOffice(decodedCode);
        model.addAttribute("office", office);
        return "OfficeDetails";
    }
    @Autowired
    public void setCatalogVersionService(final CatalogVersionService catalogVersionServiceService)
    {
        this.catalogVersionService = catalogVersionServiceService;
    }
    @Autowired
    public void setFacade(final OfficeFacade facade)
    {
        this.officeFacade = facade;
    }
}