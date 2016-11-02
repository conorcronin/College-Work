/*Create a java program to check if an IP address is a blacklisted IP
Author: Conor Cronin
Date: 15/10/15 */
import java.net.*;

public class SpamCheck {
    public static void main(String[] args) {
		String IP = args[0];// User Input IP, we will Reverse it 
		String website = "sbl.spamhaus.org"; //www.spamhaus.org/sbl/
		try {
			InetAddress address = InetAddress.getByName(IP);
			byte[] quad = address.getAddress();
			String query = website;
			for (byte octet : quad) {
				int unsignedByte = octet < 0 ? octet + 256 : octet;
				query = unsignedByte + "." + query;
				System.out.println( query);
			}
			InetAddress.getByName(query);
			System.out.println( IP + " is a known spammer.");
		} 
		catch (Exception e) {
			System.out.println(IP + " appears legitimate");
		}		
	}
}
