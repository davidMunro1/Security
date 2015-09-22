
public class Command {

	public static void main(String[] args) {
		String message = "Light on yeahhhh this should be decrypted!";
		byte [] arr = Encrypt.encrypt(message);
		Decrypt.decrypt(arr);
	}

}
