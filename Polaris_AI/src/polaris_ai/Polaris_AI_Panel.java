package polaris_ai;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import javax.media.ControllerEvent;
import javax.media.ControllerListener;
import javax.media.EndOfMediaEvent;
import javax.media.Manager;
import javax.media.Player;
import javax.media.Time;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import static polaris_ai.Polaris_AI_Frame.*;
import javax.swing.JPanel;

public class Polaris_AI_Panel extends JPanel
{
    Component video = null;
    Player media_player = null;
    JPanel left_icon, right_icon;
    JLabel l1, l2, l3, l4, l5, l6;
    
    public Polaris_AI_Panel(URL media_url, URL left_url, URL right_url)
    {   
        String packet_1 = "░██╗░░░░░░░██╗███████╗██╗░░░░░░█████╗░░█████╗░███╗░░░███╗███████╗";
        String packet_2 = "░██║░░██╗░░██║██╔════╝██║░░░░░██╔══██╗██╔══██╗████╗░████║██╔════╝";
        String packet_3 = "░╚██╗████╗██╔╝█████╗░░██║░░░░░██║░░╚═╝██║░░██║██╔████╔██║█████╗░░";
        String packet_4 = "░░████╔═████║░██╔══╝░░██║░░░░░██║░░██╗██║░░██║██║╚██╔╝██║██╔══╝░░";
        String packet_5 = "░░╚██╔╝░╚██╔╝░███████╗███████╗╚█████╔╝╚█████╔╝██║░╚═╝░██║███████╗";
        String packet_6 = "░░░╚═╝░░░╚═╝░░╚══════╝╚══════╝░╚════╝░░╚════╝░╚═╝░░░░░╚═╝╚══════╝";
        
        l1 = new JLabel();
        l1.setText(packet_1);
        l1.setBounds(130, 20, 1000, 10);
        l1.setOpaque(false);
        l1.setForeground(Color.WHITE);
        this.add(l1);
        
        l2 = new JLabel();
        l2.setText(packet_2);
        l2.setBounds(130, 30, 1000, 10);
        l2.setOpaque(false);
        l2.setForeground(Color.WHITE);
        this.add(l2);
        
        l3 = new JLabel();
        l3.setText(packet_3);
        l3.setBounds(130, 40, 1000, 10);
        l3.setOpaque(false);
        l3.setForeground(Color.WHITE);
        this.add(l3);
        
        l4 = new JLabel();
        l4.setText(packet_4);
        l4.setBounds(130, 50, 1000, 10);
        l4.setOpaque(false);
        l4.setForeground(Color.WHITE);
        this.add(l4);
        
        l5 = new JLabel();
        l5.setText(packet_5);
        l5.setBounds(130, 60, 1000, 10);
        l5.setOpaque(false);
        l5.setForeground(Color.WHITE);
        this.add(l5);
        
        l6 = new JLabel();
        l6.setText(packet_6);
        l6.setBounds(130, 70, 1000, 10);
        l6.setOpaque(false);
        l6.setForeground(Color.WHITE);
        this.add(l6);
        
        left_icon = new JPanel();
        left_icon.setBounds(10, 100, 400, 200);
        left_icon.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mousePressed(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                left_icon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent e) {
                left_icon.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
        });
        
        String left_packet_1 = "█░░ ▄▀█ █▀ ▀█▀   █░░ █▀▀ █░█ █▀▀ █░░";
        String left_packet_2 = "█▄▄ █▀█ ▄█ ░█░   █▄▄ ██▄ ▀▄▀ ██▄ █▄▄";
        
        JLabel lp_1 = new JLabel();
        lp_1.setText(left_packet_1);
        lp_1.setFont(new Font(null, Font.PLAIN, 10));
        lp_1.setBounds(30, 310, 1000, 10);
        lp_1.setOpaque(false);
        lp_1.setForeground(Color.WHITE);
        this.add(lp_1);
        
        JLabel lp_2 = new JLabel();
        lp_2.setFont(new Font(null, Font.PLAIN, 10));
        lp_2.setText(left_packet_2);
        lp_2.setBounds(30, 320, 1000, 10);
        lp_2.setOpaque(false);
        lp_2.setForeground(Color.WHITE);
        this.add(lp_2);
        
        try
        {
            Manager.setHint(Manager.LIGHTWEIGHT_RENDERER, true);
            Player left_media = Manager.createRealizedPlayer(media_url);
            Component left_video = left_media.getVisualComponent();
            
            if(left_video != null)
            {
                left_video.setBounds(0, 0, 400, 200);
                left_icon.add(left_video);
                left_media.addControllerListener(new ControllerListener(){
                    public void controllerUpdate(ControllerEvent event) {
                        if (event instanceof EndOfMediaEvent) {
                            left_media.setMediaTime(new Time(0));
                            left_media.start();
                        }
                    }
                });
                left_media.start(); 
            }
        }
        catch(Exception e)
        {
            System.err.println("ERROR ENCOUNTERED!");
        }
        left_icon.setLayout(null);
        this.add(left_icon);
        
        String right_packet_1 = "█▄░█ █▀▀ ▀▄▀ ▀█▀   █░░ █▀▀ █░█ █▀▀ █░░";
        String right_packet_2 = "█░▀█ ██▄ █░█ ░█░   █▄▄ ██▄ ▀▄▀ ██▄ █▄▄";
        
        JLabel rp_1 = new JLabel();
        rp_1.setText(right_packet_1);
        rp_1.setFont(new Font(null, Font.PLAIN, 10));
        rp_1.setBounds(710, 310, 1000, 10);
        rp_1.setOpaque(false);
        rp_1.setForeground(Color.WHITE);
        this.add(rp_1);
        
        JLabel rp_2 = new JLabel();
        rp_2.setFont(new Font(null, Font.PLAIN, 10));
        rp_2.setText(right_packet_2);
        rp_2.setBounds(710, 320, 1000, 10);
        rp_2.setOpaque(false);
        rp_2.setForeground(Color.WHITE);
        this.add(rp_2);
        
        right_icon = new JPanel();
        right_icon.setBounds(690, 100, 400, 200);
        try
        {
            Manager.setHint(Manager.LIGHTWEIGHT_RENDERER, true);
            Player right_media = Manager.createRealizedPlayer(right_url);
            Component right_video = right_media.getVisualComponent();
            
            if(right_video != null)
            {
                right_video.setBounds(0, 0, 400, 200);
                right_icon.add(right_video);
                right_media.addControllerListener(new ControllerListener(){
                    public void controllerUpdate(ControllerEvent event) {
                        if (event instanceof EndOfMediaEvent) {
                            right_media.setMediaTime(new Time(0));
                            right_media.start();
                        }
                    }
                });
                right_media.start();
            }
        }
        catch(Exception e)
        {
            System.err.println("ERROR ENCOUNTERED!");
        }
        
        right_icon.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mousePressed(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                right_icon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent e) {
                right_icon.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
        });
        right_icon.setLayout(null);
        this.add(right_icon);
        
        JLabel version_info = new JLabel();
        version_info.setText("Version 1.0.0.12");
        version_info.setFont(new Font(null, Font.PLAIN, 12));
        version_info.setBounds(1000, 540, 100, 20);
        version_info.setOpaque(false);
        version_info.setForeground(Color.WHITE);
        this.add(version_info);
        
        JLabel copyright = new JLabel();
        copyright.setText("Copyright ©™ 2021 @tuhinnn-py. All rights reserved");
        copyright.setFont(new Font(null, Font.PLAIN, 12));
        copyright.setBounds(5, 540, 300, 20);
        copyright.setOpaque(false);
        copyright.setForeground(Color.WHITE);
        this.add(copyright);
        
        try
        {
            Manager.setHint(Manager.LIGHTWEIGHT_RENDERER, true);
            media_player = Manager.createRealizedPlayer(left_url);
            video = media_player.getVisualComponent();
            video.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
            if (video != null)
            {
                media_player.addControllerListener(new ControllerListener(){
                    public void controllerUpdate(ControllerEvent event) {
                        if (event instanceof EndOfMediaEvent) {
                            media_player.setMediaTime(new Time(0));
                            media_player.start();
                        }
                    }
                });
                media_player.start();
            }
            this.add(video);
        }
        catch(Exception e)
        {
            System.err.println("ERROR ENCOUNTERED!");
        }
        
        this.setLayout(null);
    }
}