package modelBuilder;


import exception.DNIException;
import exception.DuplicatedCodeException;
import exception.PossibleClientDataDuplication;
import model.ClientDAO;
import uml.Client;
import uml.Client.DocumentType;

public class ClientBuilder {
	
	public static Client buildClient(int codigoCliente, 
							   String nombreCliente, 
							   String apellidoContacto,
							   String telefono,
							   DocumentType documentType,
							   String DNI,
							   String email,
							   String password) throws DuplicatedCodeException, 
										   PossibleClientDataDuplication, 
										   DNIException{

		Client client = new Client(codigoCliente, 
								   nombreCliente, 
								   apellidoContacto,
								   telefono, 
								   dNI);
		
		ClientDAO clientDao = new ClientDAO();
				
		if (!(clientDao.getClient(codigoCliente) == null)) {
			throw new DuplicatedCodeException(client);
		}
		
		if(clientDao.getClient(codigoCliente).getDNI() == "") {
			throw new DNIException(client);
		}
		
		if ((clientDao.possibleDataDuplication(client))) {
			throw new PossibleClientDataDuplication(client);
		}
		
		return client;
	}	

}
