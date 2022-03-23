package gniazda;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame {
    private JPanel mainPanel;
    private JPanel Panel1;
    private JPanel ParentPanel;
    private JPanel card1;
    private JPanel card2;
    private JPanel card3;
    private JButton OfficeButton;
    private JButton GuideButton;
    private JButton TouristButton;
    private JButton uruchomButton;
    private JButton powrotButton;
    private JTextField txtMessage;
    private JTextField wiadomosc;
    private JButton registerButton;
    private JButton unregisterButton;
    private JButton listaTurystaButton;
    private JTextArea tekst1;
    private JPanel PanelWyborTurysta;
    private JPanel ZarejestrujPanel;
    private JTextField podajNaweWycieczkiDoTextField;
    private JTextField nazwaRejestr;
    private JTextField podajImieINazwiskoTextField;
    private JTextField DaneRejestr;
    private JButton zapiszButton12;
    private JButton powrotDoMenuGlownegoButton;
    private JPanel GlownyPanel;
    private JButton officeTerminalButton;
    private JPanel card4;
    private JTextArea text2;
    private JPanel CardOfficePanel;
    private JPanel MenuPanel;
    private JButton dodajWycieczkeButton;
    private JButton usunWycieczkeButton;
    private JButton wyswietlListeWycieczekButton;
    private JPanel dodajWycieczkeCard;
    private JTextField podajNazweWycieczkiTextField;
    private JTextField tekstPole1;
    private JTextField podajOpisWycieczkiTextField;
    private JTextField tekstPol2;
    private JTextField podajTerminWycieczkiTextField;
    private JTextField tekstPole3;
    private JTextField podajLiczbeMiejscNaTextField;
    private JTextField tekstPole4;
    private JButton dodajButton;
    private JButton powrotButon2;
    private JButton powrotButton3;
    private JPanel UsunWycieczkePanel;
    private JTextField guideImie;
    private JButton usunButton4;
    private JButton powrotButton1;
    private JTextField tekst65;
    private JPanel card5;
    private JButton button111;
    private JTextArea tekst3;
    private JButton button222;
    private JButton button333;
    private JTextField podajImieINazwiskoTextField1;
    private JButton button121;
    private JPanel WyrejestrujPanel;
    private JTextField nazwaWycieczkiDoWyrejestrowaniaTextField;
    private JTextField tu1;
    private JTextField podajImieINazwiskoTextField2;
    private JTextField tu2;
    private JButton button187;

    public void setTxtMessage(JTextField txtMessage) {
        this.txtMessage = txtMessage;
    }

    public JTextField getTxtMessage() {
        return txtMessage;
    }


    private Office o = null;
    private String typ=null;

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }


    public JPanel getMainPanel() {
        return mainPanel;
    }


    public MyFrame(){
        OfficeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ParentPanel.removeAll();
                ParentPanel.add(card2);
                ParentPanel.repaint();
                ParentPanel.revalidate();
            }
        });

        uruchomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                    o = new Office();
                    o.start();
            }
        });

        powrotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ParentPanel.removeAll();
                ParentPanel.add(card1);
                ParentPanel.repaint();
                ParentPanel.revalidate();

            }
        });


        TouristButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                ParentPanel.removeAll();
                ParentPanel.add(card3);
                ParentPanel.repaint();
                ParentPanel.revalidate();
                PanelWyborTurysta.removeAll();
                PanelWyborTurysta.add(GlownyPanel);
                PanelWyborTurysta.repaint();
                PanelWyborTurysta.revalidate();

            }
        });


        listaTurystaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                typ="l;";
                try {
                new TouristTerminal(tekst1).send(typ,"localhost",2000);
                }
                catch(NumberFormatException r){
                    r.printStackTrace();
                }
            }
        });


        powrotDoMenuGlownegoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ParentPanel.removeAll();
                ParentPanel.add(card1);
                ParentPanel.repaint();
                ParentPanel.revalidate();
            }
        });
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelWyborTurysta.removeAll();
                PanelWyborTurysta.add(ZarejestrujPanel);
                PanelWyborTurysta.repaint();
                PanelWyborTurysta.revalidate();
            }
        });
        officeTerminalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ParentPanel.removeAll();
                ParentPanel.add(card4);
                ParentPanel.repaint();
                ParentPanel.revalidate();
            }
        });
        dodajWycieczkeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardOfficePanel.removeAll();
                CardOfficePanel.add(dodajWycieczkeCard);
                CardOfficePanel.repaint();
                CardOfficePanel.revalidate();
            }
        });
        powrotButon2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardOfficePanel.removeAll();
                CardOfficePanel.add(MenuPanel);
                CardOfficePanel.repaint();
                CardOfficePanel.revalidate();
            }
        });
        powrotButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ParentPanel.removeAll();
                ParentPanel.add(card1);
                ParentPanel.repaint();
                ParentPanel.revalidate();
            }
        });

        dodajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = "soferta;" + tekstPole1.getText() + ";" + tekstPol2.getText() + ";" + tekstPole3.getText() + ";" + tekstPole4.getText() + ";";
                try {
                    new OfficeTerminal(text2).send(message,"localhost",2000);
                }
                catch(NumberFormatException r){
                    r.printStackTrace();
                }

                tekstPole1.setText("");
                tekstPol2.setText("");
                tekstPole3.setText("");
                tekstPole4.setText("");
            }
        });
        wyswietlListeWycieczekButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = "l;";
                try {
                    new OfficeTerminal(text2).send(message,"localhost",2000);
                }
                catch(NumberFormatException r){
                    r.printStackTrace();
                }
            }
        });
        usunWycieczkeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardOfficePanel.removeAll();
                CardOfficePanel.add(UsunWycieczkePanel);
                CardOfficePanel.repaint();
                CardOfficePanel.revalidate();
            }
        });
        powrotButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardOfficePanel.removeAll();
                CardOfficePanel.add(MenuPanel);
                CardOfficePanel.repaint();
                CardOfficePanel.revalidate();
            }
        });
        usunButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = "uo;" + tekst65.getText() + ";";
                try {
                    new OfficeTerminal(text2).send(message,"localhost",2000);
                }
                catch(NumberFormatException r){
                    r.printStackTrace();
                }
                tekst65.setText("");
            }
        });
        GuideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ParentPanel.removeAll();
                ParentPanel.add(card5);
                ParentPanel.repaint();
                ParentPanel.revalidate();
            }
        });
        button111.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ParentPanel.removeAll();
                ParentPanel.add(card1);
                ParentPanel.repaint();
                ParentPanel.revalidate();
            }
        });
        button333.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tekst = "zg;" + guideImie.getText() + ";";
                try {
                    new GuideTerminal(tekst3).send(tekst,"localhost",2000);
                }
                catch(NumberFormatException r){
                    r.printStackTrace();
                }

            }
        });
        button121.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tekst = "lg;" + guideImie.getText() + ";";
                try {
                    new GuideTerminal(tekst3).send(tekst,"localhost",2000);
                }
                catch(NumberFormatException r){
                    r.printStackTrace();
                }
            }
        });
        unregisterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelWyborTurysta.removeAll();
                PanelWyborTurysta.add(WyrejestrujPanel);
                PanelWyborTurysta.repaint();
                PanelWyborTurysta.revalidate();
            }
        });
        zapiszButton12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tekst1.setText("");
                typ="ru;" + nazwaRejestr.getText() + ";" + DaneRejestr.getText() + ";";
                try {
                    new TouristTerminal(tekst1).send(typ,"localhost",2000);
                }
                catch(NumberFormatException r){
                    r.printStackTrace();
                }
                nazwaRejestr.setText("");
                DaneRejestr.setText("");
            }
        });
        button187.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                typ="uru;" + tu1.getText() + ";" + tu2.getText() + ";";
                try {
                    new TouristTerminal(tekst1).send(typ,"localhost",2000);
                }
                catch(NumberFormatException r){
                    r.printStackTrace();
                }
                tu1.setText("");
                tu2.setText("");
            }
        });
        button222.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                typ= "gw;" + guideImie.getText() + ";";
                try {
                    new GuideTerminal(tekst3).send(typ,"localhost",2000);
                }
                catch(NumberFormatException r){
                    r.printStackTrace();
                }
            }
        });
    }

}
