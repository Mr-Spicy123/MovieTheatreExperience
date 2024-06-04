import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class FoodCourtGUI extends JFrame {



  JLabel foodBackLabel = new JLabel();
  ImageIcon foodCounter = new ImageIcon("Res/Meals Interface_Sketch.png");
  JLabel drinkBackLabel = new JLabel();
  ImageIcon drinkCounter = new ImageIcon("Res/Drink Interface_Sketch.png");
  JLabel optionsBackLabel = new JLabel();
  ImageIcon options = new ImageIcon("Res/Food Court Interface_Sketch.png");
  JLabel moneyBackLabel = new JLabel();
  ImageIcon money = new ImageIcon("Res/Food Court $ Frame_Sketch.png");
  Image optionsimage = options.getImage();
  Image drinkCounterimage = drinkCounter.getImage();
  Image foodCounterimage = foodCounter.getImage();
  Image moneyimage = money.getImage();
  ActionListener listener;

  public FoodCourtGUI() {
    GridLayout Grid = new GridLayout(0, 3);
    GridLayout optionGrid = new GridLayout(0, 2);

    //Label

    int width = 1280; // New width for the scaled image
    int height = 770; // New height for the scaled image
    Image scaledImage = optionsimage.getScaledInstance(width, height, Image.SCALE_DEFAULT);
    ImageIcon scaledIcon = new ImageIcon(scaledImage);

    Image scaledImage2 = drinkCounterimage.getScaledInstance(width, height, Image.SCALE_DEFAULT);
    ImageIcon scaledIcon2 = new ImageIcon(scaledImage2);

    Image scaledImage3 = foodCounterimage.getScaledInstance(width, height, Image.SCALE_DEFAULT);
    ImageIcon scaledIcon3 = new ImageIcon(scaledImage3);

    Image scaledImage4 = moneyimage.getScaledInstance(250, 250, Image.SCALE_DEFAULT);
    ImageIcon scaledIcon4 = new ImageIcon(scaledImage4);

    foodBackLabel.setIcon(scaledIcon3);
    optionsBackLabel.setIcon(scaledIcon);
    drinkBackLabel.setIcon(scaledIcon2);
    moneyBackLabel.setIcon(scaledIcon4);
    //Panel

    // The Food Back panel
    JPanel foodBackPanel = new JPanel();
    commonPanelProperties(foodBackPanel, foodBackLabel, 0, 0, 1280, 800);

    JPanel drinkBackPanel = new JPanel();
    commonPanelProperties(drinkBackPanel, drinkBackLabel, 0, 0, 1280, 800);

    JPanel optionsBackPanel = new JPanel();
    commonPanelProperties(optionsBackPanel, optionsBackLabel, 0, 0, 1280, 800);

    JPanel moneyBackPanel = new JPanel();
    commonPanelProperties(moneyBackPanel, moneyBackLabel, 0, 0, 250, 250);

    //Order Panel
    JPanel optionPanel = new JPanel();
    commonPanelProperties(optionPanel,0, 200, 1280, 800, false, optionGrid);

    //Drinks option Panel
    JPanel drinkPanel = new JPanel();
    commonPanelProperties(drinkPanel,0, 200, 1280, 800, false, Grid);

    //Meal option Panel
    JPanel mealPanel = new JPanel();
    commonPanelProperties(mealPanel,0, 200, 1280, 800, false, Grid);

    JPanel moneyPanel = new JPanel();
    commonPanelProperties(moneyPanel, 0,0,250, 250, false, null);


    //Food Panel
    JPanel foodPanel = new JPanel();
    foodPanel.setBounds(0, 0, 1280, 800);
    foodPanel.setBackground(Color.gray);


    JFrame moneyFrame = new JFrame();
    JLabel bankLabel = new JLabel("$" + User.getBalance());
    JLabel cartLabel = new JLabel("$" + TotalCost.getTotalCost());

    listener = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source instanceof JButton) {
          JButton button = (JButton) source;
          String currentItem = "";
          switch (button.getText()) {
            //whatever the text of the button is set to is how it determines the button
            case "popcorn":
              TotalCost.addCost(Popcorn.price);
              TotalCost.print();
              bankLabel.setText("$" + User.getBalance());
              cartLabel.setText("$" + TotalCost.getTotalCost());
              JOptionPane.showMessageDialog(null, "Added popcorn to cart");
              currentItem = "popcorn";
              break;
            case "nachos":
              TotalCost.addCost(Nachos.price);
              TotalCost.print();
              bankLabel.setText("$" + User.getBalance());
              cartLabel.setText("$" + TotalCost.getTotalCost());
              JOptionPane.showMessageDialog(null, "Added nachos to cart");
              currentItem = "nachos";
              break;
            case "hotdog":
              TotalCost.addCost(Hotdog.price);
              TotalCost.print();
              bankLabel.setText("$" + User.getBalance());
              cartLabel.setText("$" + TotalCost.getTotalCost());
              JOptionPane.showMessageDialog(null, "Added hotdog to cart");
              currentItem = "hotdog";
              break;
            case "Coke":
              TotalCost.addCost(CocaCola.price);
              TotalCost.print();
              bankLabel.setText("$" + User.getBalance());
              cartLabel.setText("$" + TotalCost.getTotalCost());
              JOptionPane.showMessageDialog(null, "Added CocaCola to cart");
              currentItem = "CocaCola";
              break;
            case "Sprite":
              TotalCost.addCost(Sprite.price);
              TotalCost.print();
              bankLabel.setText("$" + User.getBalance());
              cartLabel.setText("$" + TotalCost.getTotalCost());
              JOptionPane.showMessageDialog(null, "Added Sprite to cart");
              currentItem = "Sprite";
              break;
            case "Fanta":
              TotalCost.addCost(Fanta.price);
              TotalCost.print();
              bankLabel.setText("$" + User.getBalance());
              cartLabel.setText("$" + TotalCost.getTotalCost());
              JOptionPane.showMessageDialog(null, "Added Fanta to cart");
              currentItem = "Fanta";
              break;
            case "Checkout":
              if (User.getBalance() >= TotalCost.getTotalCost()) {
                User.changeBalance(TotalCost.getTotalCost());
                TotalCost.removeAllItems();
                bankLabel.setText("$" + User.getBalance());
                cartLabel.setText("$" + TotalCost.getTotalCost());
                JOptionPane.showMessageDialog(null, "Purchase successful!");
              }
              else {
                bankLabel.setText("$" + User.getBalance());
                cartLabel.setText("$" + TotalCost.getTotalCost());
                JOptionPane.showMessageDialog(null, "Not enough money");
                TotalCost.removeAllItems();

              }
              break;
            case "Remove all":
              TotalCost.removeAllItems();
              bankLabel.setText("$" + User.getBalance());
              cartLabel.setText("$" + TotalCost.getTotalCost());
              JOptionPane.showMessageDialog(null, "All items in cart have been removed!");
              break;
            case "Remove recent":
              try {
                TotalCost.removeLastItem();
                bankLabel.setText("$" + User.getBalance());
                cartLabel.setText("$" + TotalCost.getTotalCost());
                JOptionPane.showMessageDialog(null, "Removed previous item!");
              } catch (ArrayIndexOutOfBoundsException f) {
                bankLabel.setText("$" + User.getBalance());
                cartLabel.setText("$" + TotalCost.getTotalCost());
                JOptionPane.showMessageDialog(null, "Cart is already empty");
                TotalCost.totalCostInd = 0;
              }

          }

          moneyFrame.revalidate();
          moneyFrame.repaint();
        }
      }
    };

    //popcorn button
    //Order panel food button
    JButton popcorn = new JButton();
    commonButtonProperties(mealPanel,popcorn, "popcorn", 0, 0, 0, 0, false, false);

    //nachos button
    JButton nachos = new JButton();
    commonButtonProperties(mealPanel,nachos, "nachos", 0, 0, 0, 0, false, false);

    //Popcorn button
    JButton hotdog = new JButton();
    commonButtonProperties(mealPanel,hotdog, "hotdog", 0, 0, 0, 0, false, false);

    //Coke button
    JButton Coke = new JButton();
    commonButtonProperties(drinkPanel,Coke, "Coke", 0, 0, 0, 0, false, false);
    //Sprite button
    JButton Sprite = new JButton();
    commonButtonProperties(drinkPanel,Sprite, "Sprite", 0, 0, 0, 0, false, false);

    //Fanta button
    JButton Fanta = new JButton();
    commonButtonProperties(drinkPanel,Fanta, "Fanta", 0, 0, 0, 0, false, false);


      //Frame
      //The option frame
      JFrame optionFrame = new JFrame();
      commonFrameProperties(optionFrame, optionsBackPanel, optionPanel, true, false);

      //The drinks frame
      JFrame drinkFrame = new JFrame();
      commonFrameProperties(drinkFrame, drinkBackPanel, drinkPanel, false, false);

      //The food frame
      JFrame foodFrame = new JFrame();
      commonFrameProperties(foodFrame, foodBackPanel, mealPanel, false, false);


      commonFrameProperties(moneyFrame, moneyBackPanel, moneyPanel, bankLabel, cartLabel, 0, 0, 250, 250, true, false);



      //Food button
      JButton foodButton = new JButton();
      commonButtonProperties(optionPanel,foodButton, "Food", 200, 0, 200, 100, false, false);
      foodButton.addActionListener(e -> {
        optionFrame.setVisible(false);
        foodFrame.setVisible(true);
        drinkFrame.setVisible(false);
      });

      //Drink button
      JButton drinkButton = new JButton();
      commonButtonProperties(optionPanel,drinkButton, "Drink", 200, 0, 200, 100, false, false);
      drinkButton.addActionListener(e -> {
        optionFrame.setVisible(false);
        foodFrame.setVisible(false);
        drinkFrame.setVisible(true);
      });

      //the Drinks back button
      JButton drinksBackButton = new JButton();
      commonButtonProperties(drinkFrame,drinksBackButton, "Back", 12, 17, 150, 50, false, false);
      drinksBackButton.addActionListener(e -> {
        optionFrame.setVisible(true);
        drinkFrame.setVisible(false);
        moneyFrame.setVisible(false);
      });

      JButton counterbackbutton = new JButton();
      commonButtonProperties(optionFrame,counterbackbutton, "Back", 12, 17, 150, 50, false, false);
      counterbackbutton.addActionListener(e -> {
        optionFrame.setVisible(false);
      });

      //the meal back button
      JButton mealBackButton = new JButton();
      commonButtonProperties(foodFrame,mealBackButton, "Back", 12, 17, 150, 50, false, false);
      mealBackButton.addActionListener(e -> {
        optionFrame.setVisible(true);
        foodFrame.setVisible(false);
      });

      //Option checkout button
      JButton optionsCheckoutButton = new JButton();
      commonButtonProperties(optionFrame,optionsCheckoutButton, "Checkout", 1000, 55, 200, 75, false, false);
      //Food checkout button
      JButton foodCheckoutButton = new JButton();
      commonButtonProperties(foodFrame,foodCheckoutButton, "Checkout", 1000, 100, 200, 75, false, false);

      //Drink checkout button
      JButton drinksCheckoutButton = new JButton();
      commonButtonProperties(drinkFrame,drinksCheckoutButton, "Checkout", 1000, 100, 200, 75, false, false);

      //Option remove-all button
    JButton optionsRemoveAllButton = new JButton();
    commonButtonProperties(optionFrame, optionsRemoveAllButton, "Remove all", 440, 150, 200, 75, false, false);

    //Food remove-all button
    JButton foodRemoveAllButton = new JButton();
    commonButtonProperties(foodFrame, foodRemoveAllButton, "Remove all", 440, 150, 200, 75, false, false);

    //drink remove-all button
    JButton drinkRemoveAllButton = new JButton();
    commonButtonProperties(drinkFrame, drinkRemoveAllButton, "Remove all", 440, 150, 200, 75, false, false);

    //option remove-recent button
    JButton optionRemoveRecentButton = new JButton();
    commonButtonProperties(optionFrame, optionRemoveRecentButton, "Remove recent", 660, 150, 200, 75, false, false);

    //food remove-recent button
    JButton foodRemoveRecentButton = new JButton();
    commonButtonProperties(foodFrame, foodRemoveRecentButton, "Remove recent", 660, 150, 200, 75, false, false);

    //drink remove-recent button
    JButton drinkRemoveRecentButton = new JButton();
    commonButtonProperties(drinkFrame, drinkRemoveRecentButton, "Remove recent", 660, 150, 200, 75, false, false);
    
  }
  public void commonPanelProperties(JPanel panel, JLabel label, int x,int y, int width, int height){
    panel.setBounds(x, y, width, height);
    panel.add(label);
  }
  public void commonPanelProperties(JPanel panel, int x,int y, int width, int height,boolean opaque,GridLayout layout){
    panel.setBounds(x, y, width, height);
    panel.setOpaque(opaque);
    panel.setLayout(layout);
  }
  public void commonButtonProperties(JFrame frameToAddButton,JButton button,String buttonName, int x,int y, int width, int height,boolean opaque, boolean focus){
    button.setText(buttonName);
    button.setBounds(x, y, width, height);
    button.setOpaque(opaque);
    button.setFocusable(focus);
    button.addActionListener(listener);
    frameToAddButton.add(button);
  }
  public void commonButtonProperties(JPanel panelToAddButton,JButton button,String buttonName, int x,int y, int width, int height,boolean opaque, boolean focus){
    button.setText(buttonName);
    button.setBounds(x, y, width, height);
    button.setOpaque(opaque);
    button.setFocusable(focus);
    button.addActionListener(listener);
    panelToAddButton.add(button);
  }
  public void commonFrameProperties(JFrame frame,JPanel backPanel, JPanel panel,boolean visible, boolean resize){
    frame.setSize(MainFrame.frameSize);
    frame.setLocationRelativeTo(null);
    frame.setLayout(null);
    frame.add(backPanel);
    frame.add(panel);
    frame.setVisible(visible);
    frame.setResizable(resize); // Disables the feature to resize the frame
  }

  //specifcally for moneyFrame
  public void commonFrameProperties(JFrame frame, JPanel backPanel, JPanel panel, JLabel label1, JLabel label2, int x, int y, int width, int height, boolean visible, boolean resize) {
    frame.setBounds(x, y, width, height);
    frame.setLocationRelativeTo(null);
    frame.setLayout(null);
    label1.setBounds(200,100 ,30,20);
    label2.setBounds(200,175,30,20);
    frame.add(label1);
    frame.add(label2);
    frame.add(backPanel);
    frame.add(panel);
    frame.setVisible(visible);
    frame.setResizable(resize); // Disables the feature to resize the frame
  }
}