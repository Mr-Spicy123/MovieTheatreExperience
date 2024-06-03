import javax.swing.*;
import java.awt.*;

public class MovieInfoGui extends JFrame {
    private final Movie movie;
    private final JPanel contentPanel, topPanel, centerPanel, infoPanel;
    private final JLabel topLabel, infoText;
    private final JScrollPane infoScrollPane;
    private final TrailerPlayer trailerPlayer;

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
                super.paint(g);
            }
        };
        topLabel = new JLabel();
        infoText = new JLabel();
        infoScrollPane = new JScrollPane();

        refresh();

//        infoScrollPane.add(infoText);
        infoPanel.add(infoScrollPane);
        topPanel.add(topLabel);
        contentPanel.add(centerPanel, BorderLayout.CENTER);
        contentPanel.add(topPanel, BorderLayout.NORTH);
        add(contentPanel, BorderLayout.CENTER);

        setVisible(true);

        trailerPlayer = new TrailerPlayer(m);
        centerPanel.add(trailerPlayer);
        centerPanel.add(infoPanel);

        repaint();
        revalidate();
    }

    public void refresh() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        setName("MovieDisplay");
        setTitle("Movie Viewer (" + movie.getName() + ")");
        setLayout(frameLayout);
        setBackground(new Color(0, 0, 0));
        getContentPane().setBackground(new Color(0, 0, 0, 0));
        setSize((int)(screenSize.getWidth()*0.75), (int)(screenSize.getHeight() * 0.5));
        setFocusable(true);
        setAlwaysOnTop(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setAutoRequestFocus(true);
        setType(Type.UTILITY);
        setLocation((screenSize.width/2) - (getWidth()/2), (screenSize.height/2) - (getHeight()/2));

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
        infoPanel.setBackground(Color.WHITE);

        topLabel.setName("TopLabel");
        topLabel.setText(movie.getName() + " (" + movie.getReleaseYear() + ")");
        topLabel.setFocusable(false);
        topLabel.setBackground(Color.BLACK);
        topLabel.setForeground(Color.WHITE);
        topLabel.setFont(new Font("Arial", Font.BOLD, (int)(screenSize.getHeight()/35)));
        topLabel.setBorder(null);
        topLabel.setHorizontalAlignment(JLabel.CENTER);
        topLabel.setOpaque(true);

        infoText.setName("TopLabel");
        infoText.setText("<html>" + // Set text using HTML formatting
                 "<b>" + movie.getName() + "</b> (" + movie.getReleaseYear() + ")<br/>" +
                "<b>Genre: </b>" + movie.getGenre() + "<br/>" +
                "<b>Duration: </b>" + movie.getMovieDurationMinutes() + " minutes<br/>" +
                "<b>Cost: </b>$" + movie.getCost() + "<br/><br/><br/>" +

                "\"" + movie.getDescription() + "\"" +
        "</html>");
        infoText.setFocusable(false);
        infoText.setBackground(Color.BLACK);
        infoText.setForeground(Color.WHITE);
        infoText.setFont(new Font("Arial", Font.PLAIN, (int)(screenSize.getWidth()/85)));
        infoText.setBorder(null);
        infoText.setHorizontalAlignment(JLabel.CENTER);
        infoText.setOpaque(true);

        infoScrollPane.setName("InfoScrollPane");
        infoScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        infoScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        infoScrollPane.setBackground(new Color(0, 0, 0, 0));
        infoScrollPane.getViewport().setBackground(new Color(0, 0,0 ,0));
        infoScrollPane.setViewportView(infoText);

        revalidate();
    }

    /**
     * Test the movies information gui
     */
    public static void main(String[] args) {
        MovieInfoGui test = new MovieInfoGui(RegisteredMovies.Action.MISSION_IMPOSSIBLE);
    }
}