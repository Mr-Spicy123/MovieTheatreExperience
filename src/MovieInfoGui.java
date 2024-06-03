import javafx.application.Platform;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MovieInfoGui extends JFrame implements WindowListener, ActionListener {
    private final Movie movie;
    private final JPanel contentPanel, topPanel, centerPanel, infoPanel;
    private final JLabel infoText;
    private final JScrollPane infoScrollPane;
    private final TrailerPlayer trailerPlayer;
    private final JButton backButton;

    private final BorderLayout frameLayout, contentLayout;
    private final GridLayout topLayout, centerLayout, infoLayout;

    public MovieInfoGui(Movie m) {
        movie = m;

        frameLayout = new BorderLayout();
        contentLayout = new BorderLayout();
        topLayout = new GridLayout(1,1);
        infoLayout = new GridLayout(1, 1);
        centerLayout = new GridLayout(1, 2);

        // Create components with different opacities
        contentPanel = new JPanel() {
            @Override
            public void paint(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setComposite(AlphaComposite.getInstance(
                        AlphaComposite.SRC_OVER,
                        0.5f // Half opacity
                ));
                super.paint(g);
            }
        };
        topPanel = new JPanel() {};
        centerPanel = new JPanel() {
            @Override
            public void paint(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setComposite(AlphaComposite.getInstance(
                        AlphaComposite.SRC_OVER,
                        0f // No opacity (invisible)
                ));
                super.paint(g);
            }
        };
        infoPanel = new JPanel() {
            @Override
            public void paint(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setComposite(AlphaComposite.getInstance(
                        AlphaComposite.SRC_OVER,
                        1f // No opacity (invisible)
                ));
                g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                super.paint(g);
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                HighQualityImageIcon cover = new HighQualityImageIcon(m.getCoverFilePath());
                g2d.drawImage(cover.getImage(), -200, -100, 1000, 1400, null);
            }
        };
        infoText = new JLabel();
        infoScrollPane = new JScrollPane();
        backButton = new JButton();

        refresh();

//        infoScrollPane.add(infoText);
        infoPanel.add(infoScrollPane);
        topPanel.add(backButton);
        contentPanel.add(centerPanel, BorderLayout.CENTER);
        contentPanel.add(topPanel, BorderLayout.NORTH);
        add(contentPanel, BorderLayout.CENTER);

        setVisible(true);
        addWindowListener(this);

        trailerPlayer = new TrailerPlayer(m);
        centerPanel.add(trailerPlayer);
        centerPanel.add(infoPanel);

        repaint();
        revalidate();
    }

    public void refresh() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        setName("MovieDisplay");
        setUndecorated(true);
        setResizable(false);
        setTitle("Movie Viewer (" + movie.getName() + ")");
        setLayout(frameLayout);
        setBackground(new Color(0, 0, 0));
        getContentPane().setBackground(new Color(0, 0, 0, 0));
        setSize(1280, 800);
        setFocusable(true);
        setAlwaysOnTop(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setAutoRequestFocus(true);
        setType(Type.UTILITY);
        setLocationRelativeTo(null);
//        setLocation((screenSize.width/2) - (getWidth()/2), (screenSize.height/2) - (getHeight()/2));

        contentPanel.setName("ContentPanel");
        contentPanel.setBackground(Color.BLACK);
        contentPanel.setLayout(contentLayout);
        contentPanel.setFocusable(false);

        topPanel.setName("TopPanel");
        topPanel.setLayout(topLayout);
        topPanel.setBackground(Color.BLACK);
        topPanel.setFocusable(false);
        topPanel.setPreferredSize(new Dimension(
                screenSize.width,
                (int)(screenSize.getHeight() * 0.05)
        ));

        centerPanel.setName("CenterPanel");
        centerPanel.setLayout(centerLayout);
        centerPanel.setFocusable(false);
        centerPanel.setPreferredSize(new Dimension(
                screenSize.width,
                (int)(screenSize.getHeight() * 0.95)
        ));

        infoPanel.setName("InfoPanel");
        infoPanel.setFocusable(false);
        infoPanel.setLayout(infoLayout);
        infoPanel.setBackground(Color.BLACK);

//        topLabel.setName("TopLabel");
//        topLabel.setText(movie.getName() + " (" + movie.getReleaseYear() + ")");
//        topLabel.setFocusable(false);
//        topLabel.setBackground(Color.BLACK);
//        topLabel.setForeground(Color.WHITE);
//        topLabel.setFont(new Font("Arial", Font.BOLD, (int)(screenSize.getHeight()/35)));
//        topLabel.setBorder(null);
//        topLabel.setHorizontalAlignment(JLabel.CENTER);
//        topLabel.setOpaque(true);

        infoText.setName("TopLabel");
        infoText.setText("<html>" + // Set text using HTML formatting
                "<b>" + movie.getName() + "</b> (" + movie.getReleaseYear() + ")<br/>" +
                "<b>Genre: </b>" + movie.getGenre() + "<br/>" +
                "<b>Duration: </b>" + movie.getMovieDurationMinutes() + " minutes<br/>" +
                "<b>Cost: </b>$" + movie.getCost() + "<br/><br/><br/>" +

                "\"" + movie.getDescription() + "\"" +
                "</html>");
        infoText.setFocusable(false);
        infoText.setBackground(new Color(0, 0, 0, 150));
        infoText.setForeground(Color.WHITE);
        infoText.setFont(new Font("Arial", Font.PLAIN, (int)(screenSize.getWidth()/85)));
        infoText.setBorder(null);
        infoText.setHorizontalAlignment(JLabel.CENTER);

        infoScrollPane.setName("InfoScrollPane");
        infoScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        infoScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        infoScrollPane.setBackground(new Color(0, 0, 0, 0));
        infoScrollPane.getViewport().setBackground(new Color(0, 0,0 ,200));
        infoScrollPane.setViewportView(infoText);
        infoScrollPane.setOpaque(false);

        backButton.setName("BackButton");
        backButton.setText("Back To Movies");
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.setFocusable(false);
        backButton.addActionListener(this);
        backButton.setFont(new Font("Arial", Font.BOLD, (int)(screenSize.getHeight()/35)));

        revalidate();
    }

    @Override
    public void windowOpened(WindowEvent e) {}

    @Override
    public void windowClosing(WindowEvent e) {
        try {
            trailerPlayer.close();
        } catch (Exception err) {
            throw new RuntimeException(err);
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {}

    @Override
    public void windowIconified(WindowEvent e) {}

    @Override
    public void windowDeiconified(WindowEvent e) {}

    @Override
    public void windowActivated(WindowEvent e) {}

    @Override
    public void windowDeactivated(WindowEvent e) {}

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(backButton)) {
            dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        }
    }
}