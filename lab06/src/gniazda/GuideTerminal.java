package gniazda;

import javax.swing.*;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class GuideTerminal {
    JTextArea tekst3;
    public GuideTerminal(JTextArea tekst3){
        this.tekst3 = tekst3;
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
            String tekst4;
            tekst3.setText("");
            do{
                tekst4 = br.readLine();
                tekst3.append(tekst4);
                tekst3.append("\n");

            }
            while(tekst4!=null);


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
