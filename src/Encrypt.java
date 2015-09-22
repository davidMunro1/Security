import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Encrypt {
	
	String textToBeEncrypted;
	private static byte [] theKey = new byte[16];
	private static byte [] initialisationVector = new byte[16];
	
	private static byte [] theMess;
	public static SecretKeySpec key;
	public static IvParameterSpec ivSpec;
	public static Cipher cipher;
	
	public static byte [] encrypt(String text){
		
		theMess = text.getBytes();
		key = new SecretKeySpec(theKey, "AES");
		ivSpec = new IvParameterSpec(initialisationVector);
		
		try {
			cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			e.printStackTrace();
		}
		
		byte [] encrypted = null;
		try {
			
			cipher.init(Cipher.ENCRYPT_MODE, key, ivSpec);
			encrypted = cipher.doFinal(theMess);			
			
		} catch (InvalidKeyException | InvalidAlgorithmParameterException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		
		return encrypted;
	}
	
	public static IvParameterSpec getIV(){
		return ivSpec;
	}
	
	public static SecretKeySpec getKey(){
		return key;
	}
	
	public static void setIV(IvParameterSpec sp){
		ivSpec = sp;
	}
	
	public static void setKey(SecretKeySpec k){
		key = k;
	}

	
}
