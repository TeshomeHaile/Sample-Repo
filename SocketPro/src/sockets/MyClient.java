package sockets;

//import java.io.*;
//import java.net.*;
//
//public class MyClient {
//	public static void main(String[] args) {
//		try {
//			Socket s = new Socket("localhost", 6666);
//
//			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
//
//			dout.writeUTF("Hello Server");
//			dout.flush();
//
//			dout.close();
//			s.close();
//
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//	}
//}

import java.net.*;
import java.io.*;

class MyClient {
	public static void main(String args[]) throws Exception {
		Socket s = new Socket("localhost", 3333);
		DataInputStream din = new DataInputStream(s.getInputStream());
		DataOutputStream dout = new DataOutputStream(s.getOutputStream());
		System.out.println("Select choice here : ");
		System.out.println("\t+ for Addition ");
		System.out.println("\t- for Subtraction : ");
		System.out.println("\t/ for Division : ");
		System.out.println("\t* for Multiplication : ");
		System.out.println("\t% for Modul :");
		System.out.println("\ts for Sin : ");
		System.out.println("\tc for Cos ");
		System.out.println("\tt for Tan : ");
		System.out.println("\ts1 for Radical : ");
		System.out.println("\ts2 for Square : ");
		System.out.println("\ts3 for Qubic Root :");
		System.out.println("\tl for Log : ");
		System.out.println("\thy for Hypothenous : ");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = "", str2 = "", op, str3;
		int a = 0, b = 0, result;

		while (!str.equals("stop")) {
			System.out.println("Enter #1 Number : ");
			str = br.readLine();
			System.out.println("Enter #2 Number : ");
			str2 = br.readLine();
			System.out.println("Enter Operator : ");
			op = br.readLine();

			dout.writeUTF(str);
			dout.writeUTF(str2);
			dout.writeUTF(op);

			dout.flush();
			str3 = din.readUTF();

			System.out.println("Result Sent from Server: " + str3);
		}

		dout.close();
		s.close();
	}
}