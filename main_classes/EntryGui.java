package com.main_classes;

import com.utilities_for_coursework.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class EntryGui extends JFrame {
         /*instance variable of UseButton Type and UsePanel type*/
        private UseButton displayBtn,addLecturerBtn,removeTutorBtn,gradeScoreBtn,setSalaryForTutorBtn,addTutorBtn;
        private static UsePanel panelForButtons;
        public static ArrayList<Teacher> detailsOfTeacher =new ArrayList<>() ;
    public EntryGui() {
        /*maingbc for whole frame*/
        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(new GridBagLayout());

        /*Create centered panel*/
         //gbc for center panel
        GridBagConstraints gbcForCenterPanel =new GridBagConstraints();
        UsePanel centerPanel = new UsePanel();
        getContentPane().setBackground(new Color(116,101,101));
        centerPanel.setBackground(new Color(250,235,215));
        centerPanel.setLayout(new GridBagLayout());


        /*creating name label*/
        JLabel nameLabel = new JLabel("Manoj Neupane");
        gbcForCenterPanel.insets = new Insets(-400, 0, 0, 0);
        gbcForCenterPanel.anchor = GridBagConstraints.CENTER;
        gbcForCenterPanel.gridx=0;
        gbcForCenterPanel.gridy=0;
        centerPanel.add(nameLabel, gbcForCenterPanel);

        /*Create image label*/
        ImageIcon imageIcon = new ImageIcon("Develoment/UtilitiesForDevelopment/Image/blog page.png");
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setSize(200,200);
        gbcForCenterPanel.insets = new Insets(0, 0, 0,  0);
        gbcForCenterPanel.gridy = 1;
        //position for image
        centerPanel.add(imageLabel, gbcForCenterPanel);

        /*Creating buttons*/
         //creating panel for storing buttons
        this.panelForButtons = new UsePanel();
        this.panelForButtons.setBackground(new Color(0xf0f0f0));
        GridBagConstraints gbcForBtns = new GridBagConstraints();
        this.panelForButtons.setLayout(new GridBagLayout());
            //display btn
        this.displayBtn = new UseButton("Display");
        gbcForBtns.gridx=2;
        gbcForBtns.gridy=2;
        gbcForBtns.insets = new Insets(20,0,0,0);
        this.panelForButtons.add(displayBtn,gbcForBtns);
            //lecturer btn
        this.addLecturerBtn = new UseButton("Add Lecturer");
        gbcForBtns.gridx=0;
        gbcForBtns.gridy=0;
        gbcForBtns.insets = new Insets(0,0,0,5);
        this.panelForButtons.add(addLecturerBtn,gbcForBtns);
            //tutor btn
        this.addTutorBtn = new UseButton("Add Tutor");
        gbcForBtns.gridx=3;
        gbcForBtns.gridy=0;

        gbcForBtns.insets = new Insets(0,0,0,0);
        this.panelForButtons.add(addTutorBtn,gbcForBtns);
            //remove tutor btn
        this.removeTutorBtn = new UseButton("Remove Tutor");
        gbcForBtns.gridx=3;
        gbcForBtns.gridy=3;
        gbcForBtns.insets = new Insets(30,0,0,0);
        this.panelForButtons.add(removeTutorBtn,gbcForBtns);
            //set salary btn
        this.setSalaryForTutorBtn = new UseButton("set salary");
        gbcForBtns.gridx=2;
        gbcForBtns.gridy=6;
        gbcForBtns.insets = new Insets(40,0,0,0);
        this.panelForButtons.add(setSalaryForTutorBtn,gbcForBtns);
           //gradeScoreBtn
        this.gradeScoreBtn = new UseButton("Grade Score");
        gbcForBtns.gridx=0;
        gbcForBtns.gridy=3;
        gbcForBtns.insets = new Insets(30,0,0,0);
        this.panelForButtons.add(gradeScoreBtn,gbcForBtns);
            //postion of panelForButtons in center panel
        gbcForCenterPanel.insets = new Insets(0,0,-290,0);
        this.panelForButtons.setPreferredSize(new Dimension(500,500));
        centerPanel.add(panelForButtons,gbcForCenterPanel);

        // Set window size and make it visible
        operationsForBtn();
//
        gbc.anchor = GridBagConstraints.CENTER;
//        centerPanel.setBorder(BorderFactory.createEmptyBorder(100,100,100,100));
        add(centerPanel,gbc);
        setSize(new Dimension(500, 700));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void operationsForBtn() {
//        FrameForTutor frameForLecturer = new FrameForTutor();
        Component[] buttons = panelForButtons.getComponents();
for (Component eachBtn:buttons){
    JButton btn = (JButton) eachBtn;
    btn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

//            System.out.println(e.getActionCommand());
            String valueForSwitch = e.getActionCommand();
            switch (valueForSwitch.toLowerCase()){
                case "display":
                    ///something
                    String[] headings = {"Teacher ID","Name","Address","Department","Employed Status","Experience Year","Working Type"};
                    new FrameForDisplay(headings);
                    break;
                case "add tutor":
                   new FrameForTutor(); 
                    break;
                case "grade score":
                    ///something
                    new FrameForGradeScore();
                    break;
                case "remove tutor":
                   new FrameForTutor().disableTheFieldsForRemoveTutor();
                    break;
                case "add lecturer":
                    ///something
                    new FrameForLecturer();

                    break;
                case "set salary":

                    new FrameForTutor().disableTheFieldsForSetSalary();
                    break;

            }

        }
    });

}


    }


    public static void main(String[] args) {
        new EntryGui();

    }
}