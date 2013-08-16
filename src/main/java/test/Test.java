package test;

import java.net.InetAddress;
import java.net.InetSocketAddress;

import dao.MessageRedisDAO;
import server.DataAcquisitionServer;
import client.DataSendingClient;

public class Test {
	public static void main(String[] args) {
		try {
//			MessageRedisDAO conn = new MessageRedisDAO();
			InetAddress address = InetAddress.getByName("192.168.1.102");
			DataAcquisitionServer server = new DataAcquisitionServer(address);
			new Thread(server).start();
//			DataSendingClient client1 = new DataSendingClient(new InetSocketAddress(address, 8090));
//			new Thread(client1).start();
//			String msg1 = "|zd000001#1#zhendong|zd000002#2#zhengdong|wd000001#3#wendu|time#2013-08-15 13:24:60";
//            String msg2 = "|zd000001#4#zhendong|zd000002#5#zhengdong|wd000001#6#wendu|time#2013-08-15 13:25:60";
//            String msg3 = "|zd000001#7#zhendong|zd000002#8#zhengdong|wd000001#9#wendu|time#2013-08-15 13:26:60";
//            String msg4 = "|zd000001#10#zhendong|zd000002#11#zhengdong|wd000001#12#wendu|time#2013-08-15 13:27:60|" +
//                          "zd000001#13#zhendong|zd000002#14#zhengdong|wd000001#15#wendu|time#2013-08-15 13:28:60|" +
//                          "zd000001#16#zhendong|zd000002#17#zhengdong|wd000001#18#wendu|time#2013-08-15 13:29:60";
//            client1.send(msg1);
//			Thread.sleep(2000);
//			client1.send(msg2);
//			Thread.sleep(2000);
//			DataSendingClient client2 = new DataSendingClient(new InetSocketAddress(address, 8090));
//			new Thread(client2).start();
//			client2.send(msg3);
//			Thread.sleep(2000);
//			client2.send(msg4);
//			Thread.sleep(2000);
//			System.out.println(conn.getAllSensors());
//            System.out.println(conn.getMsgBySensor("zd000001"));
//            System.out.println(conn.getMsgBySensor("zd000002"));
//            System.out.println(conn.getMsgBySensor("wd000001"));
//			conn.destroy();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
