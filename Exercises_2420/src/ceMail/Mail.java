package ceMail;

import edu.princeton.cs.algs4.StdRandom;

/**
 * Represents mail defined by the delivery type and the mail code
 * 
 * @author Mark GW
 *
 */
public class Mail implements Comparable<Mail>{
	private DeliveryType type;
	private String mailCode;
	
	public Mail(DeliveryType type, String mailCode) {
		this.type = type;
		this.mailCode = mailCode;
	}
	
	public Mail() {
		this.type = randomType();
		this.mailCode = randomMailCode();
	}
	
	private String randomMailCode() {
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < 5; i++) {
			char letter = (char) StdRandom.uniformInt('A', 'Z' + 1);
			sb.append(letter);
		}
		
		return sb.toString();
	}
	
	private DeliveryType randomType() {
		DeliveryType[] allValues = DeliveryType.values();
		int randomIndex = StdRandom.uniformInt(allValues.length);
		
		return allValues[randomIndex]; 
	}

	

	@Override
	public String toString() {
		return mailCode + "(" + type + ")";
	}
	
	/**
	 * Compares to Mail objects based on the type.  If the types are the same the Mail objects are compared by MailCode
	 * <p>
	 * {@inheritDoc}
	 */
	@Override
	public int compareTo(Mail other) {
		if(this.type == other.type) {
			return this.mailCode.compareTo(other.mailCode);
		} else {
			return this.type.compareTo(other.type);
		}
		
	}
}
