package poslovna_banka.resource;


import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poslovna_banka.model.Bank;
import poslovna_banka.model.Clearing;
import poslovna_banka.service.ClearingService;
import poslovna_banka.xml.ClearingXml;


@RestController
@RequestMapping(value = "/api/clearing")
public class ClearingResource {

	@Autowired
	private ClearingService clearingService;
	
	
	@PostMapping()
	public ResponseEntity<Void> generateClearing( @RequestBody Bank bank) throws JAXBException{
		
		List<Clearing> clearings = clearingService.getClearings();
		for(Clearing clearing : clearings) {
			if(!clearing.isDone() && (clearing.getBankFrom().getId() == bank.getId() || clearing.getBankTo().getId() == bank.getId())) {
				generateClearingXml(clearing);
				clearing.setDone(true);
				clearingService.saveClearing(clearing);
			}
		}
		return new ResponseEntity<Void>(HttpStatus.OK);		
	}
	
	
	private void generateClearingXml(Clearing clearing) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(ClearingXml.class);
		Marshaller m = jaxbContext.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		File file =new File("nalozi//clearing//clearing" +clearing.getId()+".xml");
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		m.marshal(new ClearingXml(clearing), file );
	}
	
	
}
