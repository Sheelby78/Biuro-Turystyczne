package gniazda;

import java.util.ArrayList;
import java.util.List;

public class Event {

    public Event(String nazwa, String opis, String data, String miejsca, int wolneMiejsca,  List<String> uczestnicy, String przewodnicy){
        this.nazwa = nazwa;
        this.opis = opis;
        this.data = data;
        this. miejsca = miejsca;
        this. wolneMiejsca = wolneMiejsca;
        this.przewodnicy = przewodnicy;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    private String nazwa;

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    private String opis;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    private String data;

    public String getMiejsca() {
        return miejsca;
    }

    public void setMiejsca(String miejsca) {
        this.miejsca = miejsca;
    }

    private String miejsca;

    public int getWolneMiejsca() { return wolneMiejsca; }

    public void setWolneMiejsca(int wolneMiejsca) { this.wolneMiejsca = wolneMiejsca; }

    private int wolneMiejsca;

    public List<String> getUczestnicy() {
        return uczestnicy;
    }

    private List<String> uczestnicy = new ArrayList<>();

    public String getPrzewodnicy() {
        return przewodnicy;
    }

    public void setPrzewodnicy(String przewodnicy) { this.przewodnicy = przewodnicy; }

    private String przewodnicy;
}
