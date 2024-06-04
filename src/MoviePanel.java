package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


//Plan is to add images to the labels then make the buttons transparent
public class MoviePanel implements MouseListener, ActionListener{



    //film data
    int cost = 10;
    Movie YourName = new Movie("Your Name", cost, 2016, 107, Movie.Genres.Animation, "D:\\github program\\MovieTheatreExperience\\src\\Trailers\\YourName (2).mp4", "Unknown");
    Movie MIB = new Movie("Mission impossible: fall out", cost, 2018, 147, Movie.Genres.Action, "D:\\github program\\MovieTheatreExperience\\src\\Trailers\\Mission_ Impossible - Fallout (2018) - Official Trailer - Paramount Pictures.mp4", "Unknown");
    Movie StarWars = new Movie("Star Wars: Revenge of the Sith", cost, 2005, 140, Movie.Genres.Action, "D:\\github program\\MovieTheatreExperience\\src\\Trailers\\Star Wars_ Episode III - Revenge of the Sith (2005) Trailer #1 _ Movieclips Classic Trailers.mp4", "Unknown");
    Movie EndGame = new Movie("Avengers: End Game", cost, 2019, 182, Movie.Genres.Action, "D:\\github program\\MovieTheatreExperience\\src\\Trailers\\Marvel Studios' Avengers - Official Trailer.mp4", "Unknown");
    Movie IT = new Movie("It", cost, 2017, 135, Movie.Genres.Horror, "D:\\github program\\MovieTheatreExperience\\src\\Trailers\\It Trailer #1 (2017) _ Movieclips Trailers.mp4", "Unknown");
    Movie AQP = new Movie("A Quiet Place", cost, 2018, 90, Movie.Genres.Horror, "D:\\github program\\MovieTheatreExperience\\src\\Trailers\\A QUIET PLACE _ Official Trailer _ Paramount Movies.mp4", "Unknown");
    Movie Shining = new Movie("The Shining", cost, 1980, 136, Movie.Genres.Horror, "D:\\github program\\MovieTheatreExperience\\src\\Trailers\\shining.mp4", "Unknown");
    Movie FSN = new Movie("Fate/stay night: Heaven's Feel I. presage flow", cost, 2017, 120, Movie.Genres.Animation, "D:\\github program\\MovieTheatreExperience\\src\\Trailers\\FSNHF1.mp4", "Unknown");
    Movie Suzume = new Movie("Suzume", cost, 2022, 122, Movie.Genres.Animation, "D:\\github program\\MovieTheatreExperience\\src\\Trailers\\Suzume.mp4", "Unknown");






    JFrame frame;
    JLabel bGlabel, title, selectGenre;
    JButton backButton, button1, button2, button3, button4, button5, button6, button7, button8, button9,  genre1, genre2, genre3;
    int page;



    public static void main(String [] args){
        new MoviePanel();
    }


    public MoviePanel() {
        setPage();
    }
    public void setPage(){
        page = 0;
        frame = new JFrame();
        frame.setSize(1280, 800);
        frame.setLocationRelativeTo(null);



        bGlabel = new JLabel(new ImageIcon(getClass().getResource("brickwall.jpg")));
        bGlabel.setBounds(0, 0, 1280, 800);
        frame.add(bGlabel);

        title = new JLabel("MOVIES");
        title.setForeground(Color.BLACK);
        title.setBounds(475, 30, 500, 70);
        title.setFont(new Font("Comic Sans MS", Font.BOLD, 80));
        bGlabel.add(title);

        backButton = new JButton("Back");
        backButton.setBounds(565, 700, 150, 50);
        backButton.setBackground(Color.WHITE);
        backButton.addActionListener(this);
        bGlabel.add(backButton);

        selectGenre = new JLabel("Select genre");
        selectGenre.setBounds(540, 100, 300, 60);
        selectGenre.setForeground(Color.BLACK);
        selectGenre.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        bGlabel.add(selectGenre);

        genre1 = new JButton("Action");
        genre2 = new JButton("Horror");
        genre3 = new JButton("Animation");

        genre1.setBounds(50, 200, 227, 50);
        genre2.setBounds(527, 200, 227, 50);
        genre3.setBounds(1003, 200, 227, 50);

        genre1.setBackground(Color.WHITE);
        genre2.setBackground(Color.WHITE);
        genre3.setBackground(Color.WHITE);

        genre1.addActionListener(this);
        genre2.addActionListener(this);
        genre3.addActionListener(this);

        bGlabel.add(genre1);
        bGlabel.add(genre2);
        bGlabel.add(genre3);


        frame.setVisible(true);
    }
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent evt) {
    }

    @Override
    public void mouseExited(MouseEvent evt) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton clickedButton = (JButton) e.getSource();
            String textButton = clickedButton.getText();
            switch (textButton) {
                case "Back":
                    frame.dispose();

                    if (page == 1){
                        setPage();
                    }
                    break;
                case "Horror":
                    page = 1;
                    bGlabel.remove(genre1);
                    bGlabel.remove(genre3);
                    bGlabel.remove(genre2);
                    bGlabel.remove(selectGenre);
                    bGlabel.revalidate();
                    bGlabel.repaint();
                    title.setText(genre2.getText());
                    button1 = new JButton(new ImageIcon(getClass().getResource("It.jpg")));
                    button1.setBounds(69, 150, 335, 500);
                    button1.addActionListener(this);
                    bGlabel.add(button1);
                    button2 = new JButton(new ImageIcon(getClass().getResource("AQuietPlace.jpg")));
                    button2.setBounds(473, 150, 335, 500);
                    button2.addActionListener(this);
                    bGlabel.add(button2);
                    button3 = new JButton(new ImageIcon(getClass().getResource("Shining.jpg")));
                    button3.setBounds(877, 150, 335, 500);
                    button3.addActionListener(this);
                    bGlabel.add(button3);
                    break;
                case "Action":
                    page = 1;
                    bGlabel.remove(genre1);
                    bGlabel.remove(genre3);
                    bGlabel.remove(genre2);
                    bGlabel.remove(selectGenre);
                    bGlabel.revalidate();
                    bGlabel.repaint();
                    title.setText(genre1.getText());
                    button4 = new JButton(new ImageIcon(getClass().getResource("MissionImp.jpg")));
                    button4.setBounds(69, 150, 335, 500);
                    button4.addActionListener(this);
                    bGlabel.add(button4);
                    button5 = new JButton(new ImageIcon(getClass().getResource("Starwars.jpg")));
                    button5.setBounds(473, 150, 335, 500);
                    button5.addActionListener(this);
                    bGlabel.add(button5);
                    button6 = new JButton(new ImageIcon(getClass().getResource("Avengers.jpg")));
                    button6.setBounds(877, 150, 335, 500);
                    button6.addActionListener(this);
                    bGlabel.add(button6);
                    break;
                case "Animation":
                    page = 1;
                    bGlabel.remove(genre1);
                    bGlabel.remove(genre3);
                    bGlabel.remove(genre2);
                    bGlabel.remove(selectGenre);
                    bGlabel.revalidate();
                    bGlabel.repaint();
                    title.setText(genre3.getText());
                    button7 = new JButton(new ImageIcon(getClass().getResource("YourName.jpg")));
                    button7.setBounds(69, 150, 335, 500);
                    button7.addActionListener(this);
                    bGlabel.add(button7);
                    button8 = new JButton(new ImageIcon(getClass().getResource("FateNight.jpg")));
                    button8.setBounds(473, 150, 335, 500);
                    button8.addActionListener(this);
                    bGlabel.add(button8);
                    button9 = new JButton(new ImageIcon(getClass().getResource("Suzume.jpg")));
                    button9.setBounds(877, 150, 335, 500);
                    button9.addActionListener(this);
                    bGlabel.add(button9);
                    System.out.println(111);

            }
        }


        if (e.getSource() == button1){
            System.out.println(101);
            frame.add(IT.createTrailerPlayer(), BorderLayout.CENTER);

            button1.setVisible(false);
            button2.setVisible(false);
            button3.setVisible(false);
        }
        if (e.getSource() == button2){
            System.out.println(101);
            frame.add(AQP.createTrailerPlayer(), BorderLayout.CENTER);

            button1.setVisible(false);
            button2.setVisible(false);
            button3.setVisible(false);
        }
        if (e.getSource() == button3){
            System.out.println(101);
            frame.add(Shining.createTrailerPlayer(), BorderLayout.CENTER);

            button1.setVisible(false);
            button2.setVisible(false);
            button3.setVisible(false);
        }
        if (e.getSource() == button4){
            System.out.println(101);
            frame.add(MIB.createTrailerPlayer(), BorderLayout.CENTER);

            button4.setVisible(false);
            button5.setVisible(false);
            button6.setVisible(false);
        }
        if (e.getSource() == button5){
            System.out.println(101);
            frame.add(StarWars.createTrailerPlayer(), BorderLayout.CENTER);

            button4.setVisible(false);
            button5.setVisible(false);
            button6.setVisible(false);
        }
        if (e.getSource() == button6){
            System.out.println(101);
            frame.add(EndGame.createTrailerPlayer(), BorderLayout.CENTER);

            button4.setVisible(false);
            button5.setVisible(false);
            button6.setVisible(false);
        }
        if (e.getSource() == button7){
            System.out.println(101);
            frame.add(YourName.createTrailerPlayer(), BorderLayout.CENTER);

            button7.setVisible(false);
            button8.setVisible(false);
            button9.setVisible(false);
        }
        if (e.getSource() == button8){
            System.out.println(101);
            frame.add(FSN.createTrailerPlayer(), BorderLayout.CENTER);
            frame.setVisible(true);

            button7.setVisible(false);
            button8.setVisible(false);
            button9.setVisible(false);
        }
        if (e.getSource() == button9){
            System.out.println(101);
            frame.add(Suzume.createTrailerPlayer(), BorderLayout.CENTER);

            button7.setVisible(false);
            button8.setVisible(false);
            button9.setVisible(false);
        }
    }

}
