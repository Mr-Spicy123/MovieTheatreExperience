import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


//Plan is to add images to the labels then make the buttons transparent
public class MoviePanel implements MouseListener, ActionListener {
    JFrame frame;
    JLabel bGlabel, title, selectGenre;
    JButton backButton, button1, button2, button3, genre1, genre2, genre3;
    int page;

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
                    button1 = new JButton(new ImageIcon(getClass().getResource("MissionImp.jpg")));
                    button1.setBounds(69, 150, 335, 500);
                    button1.addActionListener(this);
                    bGlabel.add(button1);
                    button2 = new JButton(new ImageIcon(getClass().getResource("Starwars.jpg")));
                    button2.setBounds(473, 150, 335, 500);
                    button2.addActionListener(this);
                    bGlabel.add(button2);
                    button3 = new JButton(new ImageIcon(getClass().getResource("Avengers.jpg")));
                    button3.setBounds(877, 150, 335, 500);
                    button3.addActionListener(this);
                    bGlabel.add(button3);
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
                    button1 = new JButton(new ImageIcon(getClass().getResource("YourName.jpg")));
                    button1.setBounds(69, 150, 335, 500);
                    button1.addActionListener(this);
                    bGlabel.add(button1);
                    button2 = new JButton(new ImageIcon(getClass().getResource("FateNight.jpg")));
                    button2.setBounds(473, 150, 335, 500);
                    button2.addActionListener(this);
                    bGlabel.add(button2);
                    button3 = new JButton(new ImageIcon(getClass().getResource("Suzume.jpg")));
                    button3.setBounds(877, 150, 335, 500);
                    button3.addActionListener(this);
                    bGlabel.add(button3);
                    break;
            }
        }
    }
}
