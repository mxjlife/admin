package com.mxjlife.admin.common.util;

import java.security.NoSuchAlgorithmException;
import java.util.Calendar;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.commons.codec.binary.Base64;

/**
 * 类说明: 慧信通平台需要使用JWT协议
 * base64encode(header).base64encode(claim).HS256(base64encode(header).base64encode(claim), secret)
 * @author mxj
 * @email xj.meng@sinowaycredit.com
 * @version 创建时间：2017年7月14日 上午9:35:46
 */
public class JWTUtil {
	
	private static String appKey = "fd6e6d6c468844bf9aec60ab9a74deb0";
	//进行hs256加密的secret
	private static String secret = "640ea250f1ff4c30bfdfe04114aa0e1b";
	
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			System.out.println(getJWTString());

		}
//		System.out.println(getClaim());
//		System.out.println(getHeaders());
	}
	
	/**
	 * 获取jwt字符串
	 * @return
	 */
	public static String getJWTString(){
		StringBuilder sb = new StringBuilder();
		sb.append(base64Encode(getHeaders())).append(".");
		sb.append(base64Encode(getClaim()));
		String signatrue = HMACSHA256(sb.toString().replace("=", ""));
		sb.append(".").append(signatrue);
		String result = sb.toString().replace("=", "");
		return result;
	}
	
	/**
	 * header部分
	 * @return
	 */
	private static String getHeaders(){
		ObjectNode header = new ObjectMapper().createObjectNode();
		header.put("typ", "JWT");
		header.put("alg", "HS256");
		return header.toString();
	}
	
	private static String getClaim(){
		ObjectNode claim = new ObjectMapper().createObjectNode();
		long iat = getDayBegin();
		claim.put("iss", appKey);
		claim.put("iat", iat);
		claim.put("exp", iat+86400);
		return claim.toString();
	}
	
	/**
	 * 获取当天时间为0点的时间戳, 精确到秒
	 * @return
	 */
	public static long getDayBegin() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.MILLISECOND, 001);
		return cal.getTimeInMillis();
	}

	/**
	 * base64编码
	 * @param data
	 * @return
	 */
	public static String base64Encode(String data) {
		return new Base64().encodeAsString(data.getBytes());
	}
	
	/**
	 * HMACSHA256加密调用的入口
	 * @param data
	 * @return
	 */
	public static String HMACSHA256(String data) {
		byte[] key = secret==null ? null : secret.getBytes();
		if(data == null || "".equals(data.trim())){
			return null;
		} else {
			return HMACSHA256(data.getBytes(), key);
		}
	}
	
	/**
	 * 使用HMACSHA256对数据进行进行加密
	 * @param data  需要进行加密的数据
	 * @param key  secret
	 * @return
	 */
	private static String HMACSHA256(byte[] data, byte[] key) {
		try {
			SecretKeySpec signingKey = new SecretKeySpec(key, "HmacSHA256");
			Mac mac = Mac.getInstance("HmacSHA256");
			mac.init(signingKey);
//			return	byte2hex(mac.doFinal(data));
			return	new Base64().encodeAsString(mac.doFinal(data));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 将byte[]转换为十六进制数
	 * 
	 * @param bArray
	 * @return
	 */
	public static String byte2hex(byte[] bArray) {
		StringBuffer sb = new StringBuffer(bArray.length);
		String sTemp;
		for (int i = 0; i < bArray.length; i++) {
			sTemp = Integer.toHexString(0xFF & bArray[i]);
			if (sTemp.length() < 2)
				sb.append(0);
			sb.append(sTemp.toUpperCase());
		}
		return sb.toString();
	}
	

}
