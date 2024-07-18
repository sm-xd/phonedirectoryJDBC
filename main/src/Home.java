package main.src;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;


public class Home {

    private Frame frame = new Frame("Dynamic AWT Window");
    private Panel p1,p2, p3;
    private Label one, two, three, four, five; 
    private TextField tname, tlname, tmname, city, tmobile; 
    private Button buttonSave, buttonSearch; 
    private TextArea textArea;
    private FlowLayout layout = new FlowLayout();
    private Connection conn;
    
    public void createUI(Connection conn){
        
        if(conn == null) return;
        this.conn = conn;

        p1 = new Panel();
        p1.setLayout(new GridLayout(5, 2)); 
        p2 = new Panel(layout);
        p3 = new Panel(layout);
        p3.setSize(400, 200);

        one = new Label("  FIRST NAME"); 
        tname = new TextField(20); 
        two = new Label("  MIDDLE NAME"); 
        tmname = new TextField(20); 
        three = new Label("  LAST NAME"); 
        tlname = new TextField(20); 
        four = new Label("  CITY");
        city = new TextField(20);
        five = new Label("  MOBILE"); 
        tmobile = new TextField(20);
        buttonSave = new Button("SAVE"); 
        buttonSearch = new Button("SEARCH");
        textArea = new TextArea("TEXTAREA",10,45,TextArea.SCROLLBARS_VERTICAL_ONLY);

        p1.add(one);
        p1.add(tname); 
        p1.add(two); 
        p1.add(tmname); 
        p1.add(three); 
        p1.add(tlname); 
        p1.add(four); 
        p1.add(city); 
        p1.add(five); 
        p1.add(tmobile);
        p2.add(buttonSave); 
        p2.add(buttonSearch);
        p3.add(textArea);

        frame.add(p1, "North"); 
        frame.add(p2, "Center"); 
        frame.add(p3, "South"); 

        frame.setSize(400, 400);
        frame.setResizable(true);

        buttonSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle button click event
                System.out.println("Button was clicked!");
            }
        });

        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!checkConstarints()){

                }

            }
        });

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame.dispose();
                System.exit(0);
            }
        });

        // frame.setLayout(new BorderLayout());
        frame.setVisible(true);
    }
    private boolean checkConstarints() {
        String firstName = tname.getText().trim();
        String middleName = tmname.getText().trim();
        String lastName = tlname.getText().trim();
        String cityName = city.getText().trim();
        String mobileNumber = tmobile.getText().trim();

        if (firstName.isEmpty() || middleName.isEmpty() || lastName.isEmpty() || cityName.isEmpty() || mobileNumber.isEmpty()) {
            return false;
        }

        if (!mobileNumber.matches("\\d{10}")) {
            return false;
        }
        return true;
    }
}
