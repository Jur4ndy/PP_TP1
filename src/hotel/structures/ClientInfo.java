package hotel.structures;

/**
 * Class used to represent the information given by clients on the payment info screen.
 */
public class ClientInfo {
	public String name;
	public int cpf;
	public String adress;
	public int phoneNumber;
	
	public ClientInfo(String name, int cpf, String adress, int phoneNumber) {
		this.name = name;
		this.cpf = cpf;
		this.adress = adress;
		this.phoneNumber = phoneNumber;
	}
	
}
