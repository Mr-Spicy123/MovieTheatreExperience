package src;

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

  public FoodCourtGUI() {
    GridLayout Grid = new GridLayout(0, 3);
    GridLayout optionGrid = new GridLayout(0, 2);
    //Label
    foodBackLabel.setIcon(foodCounter);
    drinkBackLabel.setIcon(drinkCounter);
    optionsBackLabel.setIcon(options);

    //Panel

    // The Food Back panel
    JPanel foodBackPanel = new JPanel();
    foodBackPanel.add(foodBackLabel);
    foodBackPanel.setBounds(0, 0, 998, 573);

    JPanel drinkBackPanel = new JPanel();
    drinkBackPanel.add(drinkBackLabel);
    drinkBackPanel.setBounds(0, 0, 998, 573);

    JPanel optionsBackPanel = new JPanel();
    optionsBackPanel.add(optionsBackLabel);
    optionsBackPanel.setBounds(0, 0, 998, 573);

    //Order Panel
    JPanel optionPanel = new JPanel();
    optionPanel.setBounds(0, 200, 997, 373);
    optionPanel.setOpaque(false);
    optionPanel.setLayout(optionGrid);

    //Drinks option Panel
    JPanel drinkPanel = new JPanel();
    drinkPanel.setBounds(0, 200, 997, 373);
    drinkPanel.setOpaque(false);
    drinkPanel.setLayout(Grid);

    //Meal option Panel
    JPanel mealPanel = new JPanel();
    mealPanel.setBounds(0, 200, 997, 373);
    mealPanel.setOpaque(false);
    mealPanel.setLayout(Grid);

    //Food Panel
    JPanel foodPanel = new JPanel();
    foodPanel.setBounds(0, 0, 998, 573);
    foodPanel.setBackground(Color.gray);

    // The Order List Panel
        /*

        // this will be continued if we have enough time.
        JPanel orderListPanel = new JPanel();
        orderListPanel.add(orderLabel);
        orderListPanel.setBackground(Color.gray);
        orderListPanel.setBounds(10, 300, 200, 100);
         */

    ActionListener listener = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source instanceof JButton) {
          JButton button = (JButton) source;

          switch (button.getText()) {
            //whatever the text of the button is set to is how it determines the button
            case "popcorn":
              TotalCost.addCost(Popcorn.price);
              TotalCost.print();
              JOptionPane.showMessageDialog(null, "Added popcorn to cart");
              break;
            case "nachos":
              TotalCost.addCost(Nachos.price);
              TotalCost.print();
              JOptionPane.showMessageDialog(null, "Added nachos to cart");
              break;
            case "hotdog":
              TotalCost.addCost(Hotdog.price);
              TotalCost.print();
              JOptionPane.showMessageDialog(null, "Added hotdog to cart");
              break;
            case "Coke":
              TotalCost.addCost(CocaCola.price);
              TotalCost.print();
              JOptionPane.showMessageDialog(null, "Added CocaCola to cart");
              break;
            case "Sprite":
              TotalCost.addCost(Sprite.price);
              TotalCost.print();
              JOptionPane.showMessageDialog(null, "Added Sprite to cart");
              break;
            case "Fanta":
              TotalCost.addCost(Fanta.price);
              TotalCost.print();
              JOptionPane.showMessageDialog(null, "Added Fanta to cart");
              break;
            case "Checkout":
              if (User.getBalance() >= TotalCost.getTotalCost()) {
                User.changeBalance(TotalCost.getTotalCost());
                Arrays.fill(TotalCost.costs, 0);
                TotalCost.totalCostInd = 0;
                JOptionPane.showMessageDialog(null, "purchase successful!\nBalance remaining: $" + User.getBalance());
              }
              else {
                JOptionPane.showMessageDialog(null, "not enough money. You only have $" + User.getBalance());
                Arrays.fill(TotalCost.costs, 0);
                TotalCost.totalCostInd = 0;
              }
          }
        }
      }
    };

    //popcorn button
    //Order panel food button
    JButton popcorn = new JButton();
    popcorn.setText("popcorn");
    popcorn.setFocusable(false);
    mealPanel.add(popcorn);
    popcorn.addActionListener(listener);

    //nachos button
    JButton nachos = new JButton();
    nachos.setText("nachos");
    nachos.setFocusable(false);
    mealPanel.add(nachos);
    nachos.addActionListener(listener);

    //Popcorn button
    JButton hotdog = new JButton();
    hotdog.setText("hotdog");
    hotdog.setFocusable(false);
    mealPanel.add(hotdog);
    hotdog.addActionListener(listener);

    //Coke button
    JButton Coke = new JButton();
    Coke.setText("Coke");
    Coke.setOpaque(false);
    Coke.setFocusable(false);
    drinkPanel.add(Coke);
    Coke.addActionListener(listener);

    //Sprite button
    JButton Sprite = new JButton();
    Sprite.setText("Sprite");
    Sprite.setOpaque(false);
    Sprite.setFocusable(false);
    drinkPanel.add(Sprite);
    Sprite.addActionListener(listener);

    //Fanta button
    JButton Fanta = new JButton();
    Fanta.setText("Fanta");
    Fanta.setOpaque(false);
    Fanta.setFocusable(false);
    drinkPanel.add(Fanta);
    Fanta.addActionListener(listener);


    //Frame

    //The option frame

    JFrame optionFrame = new JFrame();
    optionFrame.setSize(MainFrame.frameSize);
    optionFrame.setLocationRelativeTo(null);
    optionFrame.setLayout(null);
    optionFrame.add(optionsBackPanel);
    optionFrame.add(optionPanel);
    optionFrame.setVisible(true);
    optionFrame.setResizable(false); // Disables the feature to resize the frame
    optionFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    //The drinks frame

    JFrame drinkFrame = new JFrame();
    drinkFrame.setSize(MainFrame.frameSize);
    drinkFrame.setLocationRelativeTo(null);
    drinkFrame.setLayout(null);
    drinkFrame.add(drinkBackPanel);
    drinkFrame.add(drinkPanel);
    popcorn.setOpaque(false);
    nachos.setOpaque(false);
    hotdog.setOpaque(false);
    drinkFrame.setVisible(false);
    drinkFrame.setResizable(false); // Disables the feature to resize the frame
    drinkFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    //The food frame

    JFrame foodFrame = new JFrame();
    foodFrame.setSize(MainFrame.frameSize);
    foodFrame.setLocationRelativeTo(null);
    foodFrame.setLayout(null);
    foodFrame.add(foodBackPanel);
    foodFrame.add(mealPanel);
    popcorn.setOpaque(false);
    nachos.setOpaque(false);
    hotdog.setOpaque(false);
    foodFrame.setVisible(false);
    foodFrame.setResizable(false); // Disables the feature to resize the frame
    foodFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    //Food button
    JButton foodButton = new JButton();
    foodButton.setText("Food");
    foodButton.setOpaque(false);
    foodButton.setFocusable(false);
    optionPanel.add(foodButton);
    foodButton.setBounds(0, 0, 200, 100);
    foodButton.addActionListener(e -> {
      optionFrame.setVisible(false);
      foodFrame.setVisible(true);
      drinkFrame.setVisible(false);
    });

    //Drink button
    JButton drinkButton = new JButton();
    drinkButton.setText("Drink");
    drinkButton.setOpaque(false);
    drinkButton.setFocusable(false);
    optionPanel.add(drinkButton);
    drinkButton.setBounds(200, 0, 200, 100);
    drinkButton.addActionListener(e -> {
      optionFrame.setVisible(false);
      foodFrame.setVisible(false);
      drinkFrame.setVisible(true);
    });

    //the Drinks back button
    JButton drinksBackButton = new JButton();
    drinksBackButton.setBounds(12, 17, 150, 50);
    drinksBackButton.setText("Back");
    drinksBackButton.setOpaque(false);
    drinkFrame.add(drinksBackButton);
    drinksBackButton.addActionListener(e -> {
      optionFrame.setVisible(true);
      drinkFrame.setVisible(false);
    });

    //the meal back button
    JButton mealBackButton = new JButton();
    mealBackButton.setBounds(12, 17, 150, 50);
    mealBackButton.setText("Back");
    mealBackButton.setOpaque(false);
    foodFrame.add(mealBackButton);
    mealBackButton.addActionListener(e -> {
      optionFrame.setVisible(true);
      foodFrame.setVisible(false);
    });

    //Option checkout button
    JButton optionsCheckoutButton = new JButton();
    optionsCheckoutButton.setBounds(798, 55, 200, 75);
    optionsCheckoutButton.setText("Checkout");
    optionsCheckoutButton.setOpaque(false);
    optionFrame.add(optionsCheckoutButton);
    optionsCheckoutButton.addActionListener(listener);

    //Food checkout button
    JButton foodCheckoutButton = new JButton();
    foodCheckoutButton.setBounds(798, 70, 200, 75);
    foodCheckoutButton.setText("Checkout");
    foodCheckoutButton.setOpaque(false);
    foodFrame.add(foodCheckoutButton);
    foodCheckoutButton.addActionListener(listener);

    //Dink checkout button
    JButton drinksCheckoutButton = new JButton();
    drinksCheckoutButton.setBounds(798, 100, 200, 75);
    drinksCheckoutButton.setText("Checkout");
    drinksCheckoutButton.setOpaque(false);
    drinkFrame.add(drinksCheckoutButton);
    drinksCheckoutButton.addActionListener(listener);
  }
  public void initButtons(JButton button){

  }
}