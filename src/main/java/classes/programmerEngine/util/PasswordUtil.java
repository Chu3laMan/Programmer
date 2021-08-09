package classes.programmerEngine.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

//PasswordUtil class use to hash and salt the password
public class PasswordUtil {
	
	
	public static String getSalt() throws NoSuchAlgorithmException {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[32];
        sr.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
		
	}
	
	//PasswordValidation() method compares the password stored in the programmersDB database within the password used by the user-end 
		//when he attempts to log in
   public static boolean PasswordValidation(String originalPassword, String storedPassword) throws NoSuchAlgorithmException, InvalidKeySpecException 
		
		{
	        String[] parts = storedPassword.split(":");
	        int iterations = Integer.parseInt(parts[0]);
	        byte[] salt = fromHex(parts[1]);
	        byte[] hash = fromHex(parts[2]);
	         
	        PBEKeySpec spec = new PBEKeySpec(originalPassword.toCharArray(), salt, iterations, hash.length * 8);
	        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
	        byte[] testHash = skf.generateSecret(spec).getEncoded();
	         
	        int diff = hash.length ^ testHash.length;
	        for(int i = 0; i < hash.length && i < testHash.length; i++)
	        {
	            diff |= hash[i] ^ testHash[i];
	        }
	        return diff == 0;
	    }
	
	public static String toHex(byte[] array) {
		BigInteger bi = new BigInteger(1, array);
        String hex = bi.toString(16);
        int paddingLength = (array.length * 2) - hex.length();
        if(paddingLength > 0)
        {
            return String.format("%0"  + paddingLength + "d", 0) + hex;
        }else{
            return hex;
        }
	}
	
	
	 private static byte[] fromHex(String hex) throws NoSuchAlgorithmException
	    {
	        byte[] bytes = new byte[hex.length() / 2];
	        for(int i = 0; i<bytes.length ;i++)
	        {
	            bytes[i] = (byte)Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
	        }
	        return bytes;
	    }
	 
	 public static String hashPassword(String password) throws NoSuchAlgorithmException {
			
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			md.reset();
			md.update(password.getBytes());
			byte[] mdArray = md.digest();
			StringBuilder sb = new StringBuilder(mdArray.length * 2);
			for(byte b : mdArray) {
				int v = b & 0xff;
				if(v < 16)
					sb.append('0');
				sb.append(Integer.toHexString(v));
			}
			
			
			
			return sb.toString();
			
		}

}
