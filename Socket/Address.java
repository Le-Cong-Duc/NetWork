package Socket;

import java.net.InetAddress;

public class Address {
	public static void main(String[] args) {
		try {
			String doman = "www.google.com";
			//InetAddress là đối tượng chứa thông tin về địa chỉ IP
			InetAddress addr = InetAddress.getByName(doman); //getByName- Tìm địa chỉ ip tương ứng với tên miền đã cho
			
			System.out.println("Ten mien: "+doman);
			System.out.println("IP: "+addr.getHostAddress()); // getHostAddress- lấy địa chỉ IP
			
			InetAddress localhost = InetAddress.getLocalHost();
			System.out.println("Dia chi IP cua localhost: "+ localhost.getHostAddress()); // lấy địa chỉ IP của máy
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
