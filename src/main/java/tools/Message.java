package tools;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Message {

	static String cp = System.getProperty("console.encoding", "UTF-8");

	public static void print(String msg) {

		msg += "\n";
		byte[] b;

		try {
			b = msg.getBytes(cp);
		} catch (UnsupportedEncodingException e) {
			b = msg.getBytes();

		}
		try {
			System.out.write(b);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
