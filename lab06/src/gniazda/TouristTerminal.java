package gniazda;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;


class TouristTerminal{
	JTextArea tekst1;
	public TouristTerminal(JTextArea tekst1){
		this.tekst1 = tekst1;
	}
	public void send(String message, String host, int port){
		Socket s;
		try {
			s = new Socket(host,port);
			InputStream is = s.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			OutputStream out = s.getOutputStream();
			PrintWriter pw = new PrintWriter(out, true);
			pw.println(message);
			String tekst;
			tekst1.setText("");
			do{
				tekst = br.readLine();
				tekst1.append(tekst);
				tekst1.append("\n");

			}
			while(tekst!=null);


			pw.close();
			br.close();;
			s.close();


		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}