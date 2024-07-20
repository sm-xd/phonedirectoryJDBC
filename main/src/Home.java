package main.src;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;

import main.utilities.MobileNo;
import main.utilities.connectDB;


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
                MobileNo mobileNo = new MobileNo(tname.getText().trim(),  tmname.getText().trim(), tlname.getText().trim(), city.getText().trim(), tmobile.getText().trim());
                String err = checkConstarints(mobileNo);
                if(err != null){
                    textArea.setText(err);
                }
                else{
                    try {
                        AddMobileNo addMobileNo = new AddMobileNo();
                        addMobileNo.addData(mobileNo, conn);
                        textArea.setText(mobileNo.toString());
                        System.out.println("added 1 entry");
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }

            }
        });

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    connectDB.closeConnection();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                frame.dispose();
                System.exit(0);
            }
        });

        // frame.setLayout(new BorderLayout());
        frame.setVisible(true);
    }
    private String checkConstarints(MobileNo mobileNo) {

        boolean allFieldsFilled = true;
        StringBuilder errorMessage = new StringBuilder();

        if (mobileNo.getFname().isEmpty()) {
            errorMessage.append("First Name is required.\n");
            allFieldsFilled = false;
        }
        if (mobileNo.getCity().isEmpty()) {
            errorMessage.append("City is required.\n");
            allFieldsFilled = false;
        }
        if (mobileNo.getMobileNo().isEmpty()) {
            errorMessage.append("Mobile Number is required.\n");
            allFieldsFilled = false;
        }
        if (!mobileNo.getMobileNo().matches("\\d{10}")) {
            errorMessage.append("Mobile Number must be exactly 10 digits.\n");
            allFieldsFilled = false;
        }
        if (!mobileNo.getFname().matches("^[a-zA-Z]+$")) {
            errorMessage.append("Name Should contain only alphabets\n");
            allFieldsFilled = false;
        }
        if ((!mobileNo.getMname().isEmpty() && !mobileNo.getMname().matches("^[a-zA-Z]+$"))|| (!mobileNo.getLname().isEmpty() && !mobileNo.getLname().matches("^[a-zA-Z]+$"))) {
            errorMessage.append("Name Should contain alphabets only.\n");
            allFieldsFilled = false;
        }

        if (!allFieldsFilled) {
            return errorMessage.toString();
        }
        return null;
        
    }
}
