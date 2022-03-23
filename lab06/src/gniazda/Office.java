package gniazda;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.Objects;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

class Office {


	private Thread t = null;
	public final static int defaultPort = 2000;
	private ServerSocket s = null;
	private List<Event> lista = new ArrayList<>();
	private List<String> przewodnikLista = new ArrayList<>();



	public void start() {
		t = new Thread(new Runnable() {
			@Override
			public void run() {
				try {

					int port = defaultPort;

					s = new ServerSocket(port);
					while (true) {
						Socket sc = s.accept();
							InputStream is = sc.getInputStream();
							InputStreamReader isr = new InputStreamReader(is);
							BufferedReader br = new BufferedReader(isr);
							OutputStream out = sc.getOutputStream();
							PrintWriter pw = new PrintWriter(out, true);
							String theLine=br.readLine();
							String[] splitedArray = null;
							splitedArray = theLine.split(";");

							if(splitedArray[0].equals(("uo"))){
								for(int i=0;i< lista.size();i++){
									if(lista.get(i).getNazwa().equals(splitedArray[1])){
										lista.remove(i);
									}
								}

							}

						if(splitedArray[0].equals(("zg"))){
							przewodnikLista.add(splitedArray[1]);
						}

						if(splitedArray[0].equals(("gw"))){
							for (int i=0;i< przewodnikLista.size();i++){
								if(przewodnikLista.get(i).equals(splitedArray[1])){
									przewodnikLista.remove(i);
									break;
								}
							}
							for(int i=0;i< lista.size();i++){
								if(lista.get(i).getPrzewodnicy().equals(splitedArray[1])){
									lista.get(i).setPrzewodnicy(null);
									for (int k=0;k<lista.get(i).getUczestnicy().size();k++) {
										lista.get(i).setWolneMiejsca(lista.get(i).getWolneMiejsca() + 1);
										lista.get(i).getUczestnicy().remove(k);
									}
								}
							}
						}


						if(splitedArray[0].equals(("ru"))){
							for(int i=0;i< lista.size();i++){
								if(lista.get(i).getNazwa().equals(splitedArray[1])){
									if(lista.get(i).getWolneMiejsca()<=0){
										pw.println("Brak wolnych miejsc");
										break;
									}
									if(lista.get(i).getPrzewodnicy()==null){
										pw.println("Brak przypisanych przewodnikow do wybranej wycieczki, poczekaj na przypisanie przewodnika lub wybierz inna wycieczke");
										break;
									}
									if(lista.get(i).getPrzewodnicy()!=null){
										lista.get(i).getUczestnicy().add(splitedArray[2]);
										lista.get(i).setWolneMiejsca(lista.get(i).getWolneMiejsca()-1);
										pw.println("Pomyslnie zarejestrowano do wybranej wycieczki");
									}
								}
							}
						}

						if(splitedArray[0].equals(("uru"))){
							int k=0;
							for(int i=0;i< lista.size();i++) {
								if (lista.get(i).getNazwa().equals(splitedArray[1])) {
									for (int j = 0; j < lista.get(i).getUczestnicy().size(); j++) {
										if (lista.get(i).getUczestnicy().get(j).equals(splitedArray[2])) {
											lista.get(i).getUczestnicy().remove(j);
											pw.println("Pomyslnie wyrejestrowano cie z wybranej wycieczki");
											lista.get(i).setWolneMiejsca(lista.get(i).getWolneMiejsca()+1);
											k=1;
											break;
										}
									}
									if(k==0){
									pw.println("Nie udalo sie wyrejestrowac " + splitedArray[2] + " z wybranej wycieczki");
									}
								}
							}
						}

						if(splitedArray[0].equals(("lg"))){
							for(int i=0;i< lista.size();i++) {
								if (lista.get(i).getPrzewodnicy() != null) {
									if (lista.get(i).getPrzewodnicy().equals(splitedArray[1])) {
										pw.println(lista.get(i).getNazwa());
										pw.println(lista.get(i).getOpis());
										String d = "Data wydarzenia: ";
										d = d + lista.get(i).getData();
										pw.println(d);
										String m = "Ilosc wolnychh miejsc: ";
										m = m + lista.get(i).getWolneMiejsca();
										pw.println(m);
										pw.println("Uzestnicy wycieczki: ");
										for (int j = 0; j < lista.get(i).getUczestnicy().size(); j++) {
											pw.println(lista.get(i).getUczestnicy().get(j));
										}
									}
								}
							}
						}

							if(splitedArray[0].equals(("soferta"))){
								String nazwa = splitedArray[1];
								String opis = splitedArray[2];
								String termin = splitedArray[3];
								String miejsca = splitedArray[4];
								int wolneMiejsca = Integer.parseInt(miejsca); //= Integer.parseInt(splitedArray[5]);
								List<String> uczestnicy = new ArrayList<>();
								String przewodnicy = null;
								lista.add(new Event(nazwa,opis,termin,miejsca,wolneMiejsca,uczestnicy,przewodnicy));
							}

							if(splitedArray[0].equals("l")){
								for(int i=0;i< lista.size();i++){
									pw.println(lista.get(i).getNazwa());
									pw.println(lista.get(i).getOpis());
									String d = "Data wydarzenia: ";
									d = d + lista.get(i).getData();
									pw.println(d);
									String m = "Ilosc wolnychh miejsc: ";
									m= m + lista.get(i).getWolneMiejsca();
									pw.println(m);
									pw.println("Uzestnicy wycieczki: ");
									for(int j=0;j< lista.get(i).getUczestnicy().size();j++){
										pw.println(lista.get(i).getUczestnicy().get(j));
									}
									pw.println("");
									pw.println("######################################");
									pw.println("");

								}
							}
							if(lista.size()>0){
							for(int i=0;i< lista.size();i++){
								if(lista.get(i).getPrzewodnicy()==null){
									if(przewodnikLista.isEmpty()==false) {
										lista.get(i).setPrzewodnicy(przewodnikLista.get(0));
										przewodnikLista.remove(0);
									}
								}
							}
							}

							pw.close();
							br.close();


						sc.close();
						}
				} catch(SocketException e){
					// TODO - podczas przerywania w¹tku metoda accept zg³osi wyj¹tek
				}
				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		t.start();
	}


}

