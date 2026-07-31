package Functions.src;;

import javax.swing.*;
import javax.swing.text.AbstractDocument;


public class EX3 {
    /*The software allows users to input grades for courses and calculate GPA*/
    public static void main(String[] args) {
        JFrame frame = new JFrame("Chuyển điểm sang hệ GPA và xếp loại.");

        JLabel labelCourses = new JLabel("Courses");
        labelCourses.setBounds(20, 20, 100, 20);
        JLabel labelPoint = new JLabel("Point");
        labelPoint.setBounds(120,20,100,20);

        // Nhap diem
        JLabel labelDatabase = new JLabel("DataBase");
        labelDatabase.setBounds(20, 50, 100, 20);
        JTextField textFieldDatabase = new JTextField();
        textFieldDatabase.setBounds(120, 50, 150, 30);
        ((AbstractDocument) textFieldDatabase.getDocument())
                .setDocumentFilter(new NumberFilter());

        JLabel labelC = new JLabel("C");
        labelC.setBounds(20, 80, 100, 20);
        JTextField textFieldC = new JTextField();
        textFieldC.setBounds(120, 80, 150, 30);
        ((AbstractDocument) textFieldC.getDocument())
                .setDocumentFilter(new NumberFilter());

        JLabel labelOOP = new JLabel("OOP");
        labelOOP.setBounds(20, 110, 100, 20);
        JTextField textFieldOOP = new JTextField();
        textFieldOOP.setBounds(120, 110, 150, 30);
        ((AbstractDocument) textFieldOOP.getDocument())
                .setDocumentFilter(new NumberFilter());

        JLabel labelJava = new JLabel("Java");
        labelJava.setBounds(20, 140, 110, 20);
        JTextField textFieldJava = new JTextField();
        textFieldJava.setBounds(120, 140, 150, 30);
        ((AbstractDocument) textFieldJava.getDocument())
                .setDocumentFilter(new NumberFilter());

        // xuat diem

        JLabel labelGPA = new JLabel("GPA :");
        labelGPA.setBounds(120, 250, 50, 30);
        JLabel labelShowGPA = new JLabel("");
        labelShowGPA.setBounds(170, 250, 500, 30);


        JLabel labelRank = new JLabel("Rank: ");
        labelRank.setBounds(120, 300, 50, 30);
        JLabel labelShowRank = new JLabel("");
        labelShowRank.setBounds(170, 300, 500, 30);

        //button
        JButton buttonInput = new JButton("Input mark");
        buttonInput.setBounds(20, 200, 100, 30);

        JButton buttonQuit = new JButton("Quit");
        buttonQuit.setBounds(20, 350, 100, 30);

        // hành động khi nhấn button
        buttonInput.addActionListener(e -> {
                    if (!textFieldDatabase.getText().equalsIgnoreCase("") &&
                            !textFieldC.getText().equalsIgnoreCase("") &&
                            !textFieldOOP.getText().equalsIgnoreCase("") &&
                            !textFieldJava.getText().equalsIgnoreCase("") &&
                            Double.parseDouble(textFieldDatabase.getText()) <= 10 &&
                            Double.parseDouble(textFieldDatabase.getText()) >= 0 &&
                            Double.parseDouble(textFieldC.getText()) <= 10 &&
                            Double.parseDouble(textFieldC.getText()) >= 0 &&
                            Double.parseDouble(textFieldOOP.getText()) <= 10 &&
                            Double.parseDouble(textFieldOOP.getText()) >= 0 &&
                            Double.parseDouble(textFieldJava.getText()) <= 10 &&
                            Double.parseDouble(textFieldJava.getText()) >= 0

                    ) {

                        labelShowGPA.setText(String.valueOf(calculateGPA(Double.parseDouble(textFieldDatabase.getText()),
                                Double.parseDouble(textFieldC.getText()),
                                Double.parseDouble(textFieldOOP.getText()),
                                Double.parseDouble(textFieldJava.getText())
                        )));
                        labelShowRank.setText(setRankGPA(calculateGPA(Double.parseDouble(textFieldDatabase.getText()),
                                Double.parseDouble(textFieldC.getText()),
                                Double.parseDouble(textFieldOOP.getText()),
                                Double.parseDouble(textFieldJava.getText()))));
                    } else {
                        labelShowGPA.setText("Please check all the information.");
                        labelShowRank.setText("The point must not be less than zero or greater than 10.");
                        JOptionPane.showMessageDialog(frame,
                                "Please enter all the information.");
                    }
                }
        );








        buttonQuit.addActionListener(e -> System.exit(0));


        frame.add(labelCourses);
        frame.add(labelPoint);

        frame.add(labelDatabase);
        frame.add(textFieldDatabase);
        frame.add(labelC);
        frame.add(textFieldC);
        frame.add(labelOOP);
        frame.add(textFieldOOP);
        frame.add(labelJava);
        frame.add(textFieldJava);

        frame.add(buttonInput);
        frame.add(buttonQuit);

        frame.add(labelGPA);
        frame.add(labelRank);
        frame.add(labelShowGPA);
        frame.add(labelShowRank);


        frame.setSize(520, 460); // chiều rộng, chiều cao
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // tuy chinh nhan nut X de tat cua so
        frame.setVisible(true); // 'true' để hieện cữa sổ, nếu không sẽ chạy ngầm


//            JFrame frame = new JFrame("My Application");
//
//            JLabel label = new JLabel("Nhap ten:");
//            label.setBounds(20, 20, 100, 30);
//
//            JTextField textField = new JTextField();
//            textField.setBounds(120, 20, 150, 30);
//
//            JButton button = new JButton("OK");
//            button.setBounds(120, 70, 80, 30);
//
//            button.addActionListener(e ->
//                    JOptionPane.showMessageDialog(frame,
//                            "Xin chao " + textField.getText())
//            );
//
//            frame.add(label);
//            frame.add(textField);
//            frame.add(button);
//
//            frame.setSize(350, 180);
//            frame.setLayout(null);
//            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            frame.setVisible(true);
    }

    // ham tinh GPA
    public static double calculateGPA(double pointDatabase, double pointC, double pointOOP, double pointJava) {
        // lam tron den 2 chu so.
        double pointGPA;
        pointGPA = ((pointDatabase + pointC + pointOOP + pointJava) / 4) / 10 * 4;
        pointGPA = (int) (pointGPA * 100);
        pointGPA /= 100;
        return pointGPA;
    }

    public static String setRankGPA(double pointGPA) {
        if (pointGPA >= 3.6 && pointGPA <= 4)
            return "Excellent";
        else if (pointGPA >= 3.2)
            return "Good";
        else if (pointGPA >= 2.5)
            return "Fair";
        else if (pointGPA > 2.0)
            return "Average";
        else return "Weak";
    }

}








