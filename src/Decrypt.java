import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Decrypt {
	
	public static void decrypt(byte [] a){
		String s = new String(a);
		
		try {
			SecretKeySpec KEY = Encrypt.getKey();
			IvParameterSpec IV = Encrypt.getIV();
			
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, KEY, IV);
						
			System.out.println("The string before decryption " +s);
			
			String plainText = new String(cipher.doFinal(a));
			
			System.out.println("The string after decryption " +plainText);
			
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException | InvalidAlgorithmParameterException e) {
			e.printStackTrace();
		}
	}
}
