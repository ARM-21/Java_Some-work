package com.utilities_for_coursework;

import com.main_classes.EntryGui;
import com.main_classes.Lecturer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameForGradeScore extends JFrame {
    private UseButton clearButton,displayButton,setGradeBtn;
    private UseLabel teacherIdLabel,departmentLabel,gradedScoreLabel,experienceYearsLabel;
    private UseTextField teacherIdField,departmentField,gradedScoreField,experienceYearsField;
    public FrameForGradeScore(){
        /*main gbc for whole frame and insideCenterPanel*/
        JPanel insideCenterPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(new GridBagLayout());

        /*Create centered panel*/
        //gbc for center panel
        GridBagConstraints gbcForCenterPanel = new GridBagConstraints();
        UsePanel centerPanel = new UsePanel();
        getContentPane().setBackground(new Color(116, 101, 101));
        centerPanel.setBackground(new Color(0xf0f0f0));
        centerPanel.setLayout(new GridBagLayout());

        teacherIdLabel = new UseLabel("Teacher Id: ");
        teacherIdField = new UseTextField();

        departmentLabel = new UseLabel("Department: ");
       departmentField = new UseTextField();

        experienceYearsLabel = new UseLabel("Experience yrs:");
         experienceYearsField = new UseTextField();

        gradedScoreLabel = new UseLabel("Graded Score: ");
         gradedScoreField = new UseTextField();

        /*selecting position for each field*/
        gbc.insets =new Insets(0,0,0,0);
        gbc.gridx = 0;
        gbc.gridy = 0;
        insideCenterPanel.add(teacherIdLabel, gbc);
        gbc.gridx = 1;
        gbc.insets =new Insets(5,0,0,0);
        insideCenterPanel.add(teacherIdField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets =new Insets(0,0,0,0);
        insideCenterPanel.add(departmentLabel, gbc);
        gbc.insets =new Insets(5,0,0,0);
        gbc.gridx = 1;
        gbc.gridy=1;
        insideCenterPanel.add(departmentField, gbc);


        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(15,0,0,5);
        insideCenterPanel.add(experienceYearsLabel, gbc);
        gbc.insets =new Insets(20,0,0,0);
        gbc.gridx = 1;
        insideCenterPanel.add(experienceYearsField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.insets = new Insets(0,0,0,0);
        insideCenterPanel.add(gradedScoreLabel, gbc);
        gbc.insets =new Insets(5,0,0,0);
        gbc.gridx = 1;
        insideCenterPanel.add(gradedScoreField, gbc);

         displayButton = new UseButton("Display");
        displayButton.setPreferredSize(new Dimension(80,30));
        gbc.gridx =0;
        gbc.insets = new Insets(20,20,0,0);
        gbc.gridy=8;
        insideCenterPanel.add(displayButton, gbc);

         setGradeBtn = new UseButton("set Grade");
        setGradeBtn.setPreferredSize(new Dimension(120,30));
        gbc.insets = new Insets(20,-130,0,0);
        gbc.gridx=1;
        gbc.gridy =7;
        insideCenterPanel.add(setGradeBtn, gbc);

         clearButton = new UseButton("Clear");
        clearButton.setPreferredSize(new Dimension(70,30));
        gbc.gridx=1;
        gbc.insets = new Insets(20,20,0,0);
        gbc.gridy = 8;
        insideCenterPanel.add(clearButton, gbc);


        gbc.insets = new Insets(10,0,0,0);
        centerPanel.add(insideCenterPanel,gbc);
        centerPanel.setPreferredSize(new Dimension(400, 300));
        add(centerPanel, gbc);

actionPerformedBtnClick();



        setSize(new Dimension(800, 500));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public  void actionPerformedBtnClick() {

        UseButton[] buttons = {setGradeBtn,displayButton, clearButton};
        for (UseButton btn : buttons) {
            btn.addActionListener(new ActionListener() {
                                      @Override
                                      public void actionPerformed(ActionEvent e) {
                                          Object[] textFields ={teacherIdField,departmentField,gradedScoreField,experienceYearsField};
                                          Object[] valuesOfField = {teacherIdField.getText().strip(),departmentField.getText().strip(),gradedScoreField.getText().strip(),experienceYearsField.getText().strip()};

                                          String[] intValues = {teacherIdField.getText().strip()};
                                          switch (e.getActionCommand()){
                                              case "set Grade":
                                                  System.out.println("hello");
                                                  validatingEnteredValue();
                                                  break;
                                              case "Clear":
                                                  forClearBtn(textFields);
                                                  break;
                                              case "Display":
                                                 forDisplayButton();
                                                  break;


                                          }

                                      }
                                  }
            );
        }
    }
public void validatingEnteredValue(){
    String[] valuesForField = {departmentField.getText().strip()};
    String[] intValues = {teacherIdField.getText().strip(), experienceYearsField.getText().strip(),gradedScoreField.getText().strip()};

    Boolean fieldChecker = false;
    Boolean isNum = false;
    /*Checking whether the entered value is greater than or equal to 1 length and trying to handle
 exception it user enters alphabhetical value instead of numeric value*/
    for (int i = 0; i < intValues.length; i++) {

        if (intValues[i].length() >= 1) {
            try {
                Integer castToInt = Integer.parseInt(intValues[i]);
                isNum = true;
            } catch (NumberFormatException error) {
                JOptionPane.showMessageDialog(this, "Enter a valid value for:1 " + intValues[i], "Invalid", JOptionPane.ERROR_MESSAGE);
                isNum = false;
                break;
            }
        }
    }
    /*Checking whether the entered value is greater than or equal to 3 length */

        if (departmentField.getText().length() >= 2) {
            fieldChecker = true;
        } else {
            fieldChecker = false;

        }



/*Setting grade if and only if value entered are greater than length(2) and the value in integer field are number*/
    if (fieldChecker) {
        System.out.println("from file checker");
        if (isNum) {
            System.out.println("from isNum");
            gradeAssignmentLogic(Integer.parseInt(teacherIdField.getText().strip()), Integer.parseInt(gradedScoreField.getText().strip()), departmentField.getText().strip(), Integer.parseInt(experienceYearsField.getText().strip()));
        }
        else {
            JOptionPane.showMessageDialog(this, "Enter the value number in respective field", "Invalid", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(this, "Enter the value For all Field! OR length must be greater than 2(Except numbers field)", "Invalid", JOptionPane.ERROR_MESSAGE);
    }
    }


    public  void forClearBtn(Object[] valuesOfField) {
        for(Object values:valuesOfField){
            UseTextField btn =(UseTextField) values;
            btn.setText("");
        }
    }

    public  void gradeAssignmentLogic(int teacherId,int gradeScore,String department,int experienceYrs) {
        System.out.println("From logic");
        for(int i=0;i<EntryGui.detailsOfTeacher.size();i++) {
            if(EntryGui.detailsOfTeacher.get(i) instanceof Lecturer){
                System.out.println("instanceOf lecturer");
                Lecturer currentDetailsOfLecturer = (Lecturer) EntryGui.detailsOfTeacher.get(i);
                if(currentDetailsOfLecturer.getTeacherId()== teacherId){
                    String resultValue = currentDetailsOfLecturer.gradeAssignment(gradeScore,department,experienceYrs);
                    currentDetailsOfLecturer.setGradedScore(gradeScore);
                    currentDetailsOfLecturer.setDepartment(department);
                    currentDetailsOfLecturer.setYearsOfExperience(experienceYrs);

                    JOptionPane.showMessageDialog(this,"Congratulations! you got "+resultValue+" Grade","Message",JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    System.out.println("From logic else");
                    JOptionPane.showMessageDialog(this,"The teacher id you have entered! doesn't exist","Invalid",JOptionPane.ERROR_MESSAGE);
                break;
                }
            }
            else{
                JOptionPane.showMessageDialog(this,"We Don't have Lecturer details!Try again later","Invalid",JOptionPane.ERROR_MESSAGE);
                break;
            }
        }

    }
public void forDisplayButton(){
    String[] headings = {"Teacher ID","Name","Address","Department","Employed Status","Experience Year","Working Type"};
    new FrameForDisplay(headings);
}



}
