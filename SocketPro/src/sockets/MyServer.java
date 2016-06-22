package sockets;

//import java.io.*;
//import java.net.*;
//
//public class MyServer {
//	public static void main(String[] args) {
//		try {
//			ServerSocket ss = new ServerSocket(6666);
//			Socket s = ss.accept();// establishes connection
//
//			DataInputStream dis = new DataInputStream(s.getInputStream());
//
//			String str = (String) dis.readUTF();
//			System.out.println("message= " + str);
//
//			ss.close();
//
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//	}
//}

import java.net.*;
import java.io.*;

public class MyServer {
	public static void main(String args[]) throws Exception {
		ServerSocket ss = new ServerSocket(3333);
		Socket s = ss.accept();
		DataInputStream din = new DataInputStream(s.getInputStream());
		DataOutputStream dout = new DataOutputStream(s.getOutputStream());
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Operation : \n");
		String str = "", str2 = "", op = null;
		int ch;
		double a = 0, b = 0, result;

		while (!str.equals("stop")) {
			str = din.readUTF();
			str2 = din.readUTF();
			op = din.readUTF();

			System.out.println(op);

			a = Integer.parseInt(str);
			b = Integer.parseInt(str2);

			if (op.equals("+")) {
				result = a + b;

				dout.writeUTF(String.valueOf(result));
			} else if (op.equals("-")) {
				result = a - b;
				dout.writeUTF(String.valueOf(result));
			} else if (op.equals("/")) {
				result = a / b;
				dout.writeUTF(String.valueOf(result));
			} else if (op.equals("*")) {
				result = a * b;
				dout.writeUTF(String.valueOf(result));
			} else if (op.equals("%")) {
				result = a % b;
				dout.writeUTF(String.valueOf(result));
			} else if (op.equals("s")) {
				result = Math.sin(a);
				dout.writeUTF(String.valueOf("Sin(" + a + ") :" + result));
			} else if (op.equals("c")) {
				result = Math.cos(a);

				dout.writeUTF(String.valueOf("Cos(" + a + ") :" + +result));
			} else if (op.equals("t")) {
				result = Math.tan(a);
				dout.writeUTF(String.valueOf("Tan(" + a + ") :" + result));
			} else if (op.equals("s1")) {
				result = Math.sqrt(a);
				dout.writeUTF(String.valueOf("Sqrt(" + a + ") :" + result));
			} else if (op.equals("s2")) {
				result = Math.pow(a, 2);
				dout.writeUTF(String.valueOf("Square(" + a + ") :" + result));
			} else if (op.equals("s3")) {
				result = Math.cbrt(a);
				dout.writeUTF(String.valueOf("QubicRoot(" + a + ") :" + result));
			} else if (op.equals("l")) {
				result = Math.log(a);
				dout.writeUTF(String.valueOf("Log(" + a + ") :" + result));
			} else if (op.equals("hy")) {
				result = Math.hypot(a, b);
				dout.writeUTF(String.valueOf("Hypoth(" + a + " and " + b
						+ ") :" + result));
			}

			dout.flush();
		}

		din.close();
		s.close();
		ss.close();
	}
}