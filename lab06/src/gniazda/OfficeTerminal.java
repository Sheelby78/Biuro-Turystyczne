package gniazda;

import javax.swing.*;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class OfficeTerminal {
    JTextArea tekst2;

    public OfficeTerminal(JTextArea tekst2){
        this.tekst2 = tekst2;
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
            String tekst32;
            tekst2.setText("");
            do{
                tekst32 = br.readLine();
                tekst2.append(tekst32);
                tekst2.append("\n");

            }
            while(tekst32!=null);


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
