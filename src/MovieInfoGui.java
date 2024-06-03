import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;

public class MovieInfoGui extends JFrame {
    private final Movie movie;
    private final JPanel contentPanel, topPanel, centerPanel, infoPanel;
    private final JLabel topLabel, genreLabel, costLabel;
    private final TrailerPlayer trailerPlayer;

    private final BorderLayout frameLayout, contentLayout;
    private final GridBagLayout infoLayout;
    private final GridLayout topLayout, centerLayout;

    public MovieInfoGui(Movie m) {
        movie = m;

        frameLayout = new BorderLayout();
        contentLayout = new BorderLayout();
        topLayout = new GridLayout(1,1);
        infoLayout = new GridBagLayout();
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
                        0f // No opacity (invisible)
                ));
                super.paint(g);
            }
        };
        topLabel = new JLabel();
        genreLabel = new JLabel();
        costLabel = new JLabel();

        refresh();

        GridBagConstraints infoConstraints = new GridBagConstraints();
        infoConstraints.gridwidth = 1;
        infoConstraints.gridheight = 1;
        infoConstraints.gridx = 0;
        infoConstraints.gridy = 0;
        infoConstraints.weighty = 0.2;
        infoConstraints.weightx = 1;
        infoConstraints.fill = GridBagConstraints.VERTICAL;

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
        infoPanel.setLayout(null);
        infoPanel.setFocusable(false);

        topLabel.setName("TopLabel");
        topLabel.setText(movie.getName() + " (" + movie.getReleaseYear() + ")");
        topLabel.setFocusable(false);
        topLabel.setBackground(Color.BLACK);
        topLabel.setForeground(Color.WHITE);
        topLabel.setFont(new Font("Arial", Font.BOLD, 25));
        topLabel.setBorder(null);
        topLabel.setHorizontalAlignment(JLabel.CENTER);
        topLabel.setOpaque(true);

        revalidate();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }

    public static void main(String[] args) {
        new MovieInfoGui(RegisteredMovies.Horror.A_QUIET_PLACE);
    }
}
