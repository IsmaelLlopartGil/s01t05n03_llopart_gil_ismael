package edu.n3.exercise_1;

import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class AES {

	public static String decrypt(String data, String password) throws Exception {
		byte[] content = parseHexStr2Byte(data);
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		KeyGenerator kgen = KeyGenerator.getInstance("AES");
		kgen.init(128, new SecureRandom(password.getBytes("UTF-8")));
		SecretKey secretKey = kgen.generateKey();	
		SecretKey key = kgen.generateKey();
		byte[] keyBytes = key.getEncoded();
		IvParameterSpec iv = new IvParameterSpec(keyBytes);
		cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);
		byte[] decrypt = cipher.doFinal(content);
		return new String(decrypt, "UTF-8");
	}

	public static String encrypt(String content, String password) throws Exception {
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		KeyGenerator kgen = KeyGenerator.getInstance("AES");
		kgen.init(128, new SecureRandom(password.getBytes("UTF-8")));
		SecretKey secretKey = kgen.generateKey();
		SecretKey key = kgen.generateKey();
		byte[] keyBytes = key.getEncoded();
		IvParameterSpec iv = new IvParameterSpec(keyBytes);
		cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
		byte[] encrypt = cipher.doFinal(content.getBytes("UTF-8"));
		return parseByte2HexStr(encrypt);
	}

	public static String parseByte2HexStr(byte buf[]) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < buf.length; i++) {
			String hex = Integer.toHexString(buf[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			sb.append(hex.toUpperCase());
		}
		return sb.toString();
	}

	public static byte[] parseHexStr2Byte(String hexStr) {
		if (hexStr.length() < 1)
			return null;
		byte[] result = new byte[hexStr.length() / 2];
		for (int i = 0; i < hexStr.length() / 2; i++) {
			int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
			int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
			result[i] = (byte) (high * 16 + low);
		}
		return result;
	}
}
