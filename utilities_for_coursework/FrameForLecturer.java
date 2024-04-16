package com.utilities_for_coursework;


import com.main_classes.EntryGui;
import com.main_classes.Lecturer;
import com.main_classes.Tutor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FrameForLecturer extends  JFrame {
    private UseLabel teacherIdLabel, teacherNameLabel, addressLabel, departmentLabel, employmentStatusLabel, experienceYearsLabel, workingTypeLabel;
    private UseTextField teacherIdField, teacherNameField, addressField, departmentField, employmentStatusField, experienceYearsField, workingTypeField;
    private UseButton addLecturerButton, displayButton, clearButton;
    static Boolean isValueValid;

    public FrameForLecturer() {
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

        teacherNameLabel = new UseLabel("Name: ");
        teacherNameField = new UseTextField();


        addressLabel = new UseLabel("Address: ");
        addressField = new UseTextField();


        workingTypeLabel = new UseLabel("Working Type: ");
        workingTypeField = new UseTextField();


        employmentStatusLabel = new UseLabel("Employed Status:");
        employmentStatusField = new UseTextField();


        experienceYearsLabel = new UseLabel("Experience yrs:");
        experienceYearsField = new UseTextField();

        departmentLabel = new UseLabel("Department: ");
        departmentField = new UseTextField();

        /*selecting position for each field*/
        gbc.insets = new Insets(0, 0, 0, -40);
        gbc.gridx = 0;
        gbc.gridy = 0;
        insideCenterPanel.add(teacherIdLabel, gbc);
        gbc.gridx = 1;
        gbc.insets = new Insets(5, 0, 0, 0);
        insideCenterPanel.add(teacherIdField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(5, 0, 0, -80);
        insideCenterPanel.add(teacherNameLabel, gbc);
        gbc.insets = new Insets(5, 0, 0, 0);
        gbc.gridx = 1;
        gbc.gridy = 1;
        insideCenterPanel.add(teacherNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        insideCenterPanel.add(workingTypeLabel, gbc);
        gbc.insets = new Insets(5, 0, 0, 0);
        gbc.gridx = 1;
        insideCenterPanel.add(workingTypeField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(20, 0, 0, -55);
        insideCenterPanel.add(addressLabel, gbc);
        gbc.insets = new Insets(25, 0, 0, 0);
        gbc.gridx = 1;
        gbc.gridy = 2;
        insideCenterPanel.add(addressField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.insets = new Insets(20, 0, 0, 20);
        insideCenterPanel.add(employmentStatusLabel, gbc);
        gbc.insets = new Insets(25, 0, 0, 0);
        gbc.gridx = 1;
        insideCenterPanel.add(employmentStatusField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.insets = new Insets(0, 0, 0, 5);
        insideCenterPanel.add(experienceYearsLabel, gbc);
        gbc.insets = new Insets(5, 0, 0, 0);
        gbc.gridx = 1;
        insideCenterPanel.add(experienceYearsField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.insets = new Insets(0, 0, 0, -10);
        insideCenterPanel.add(departmentLabel, gbc);
        gbc.insets = new Insets(5, 0, 0, 0);
        gbc.gridx = 1;
        insideCenterPanel.add(departmentField, gbc);

        displayButton = new UseButton("Display");
        displayButton.setPreferredSize(new Dimension(80, 30));
        gbc.gridx = 0;
        gbc.insets = new Insets(20, 0, 0, 0);
        gbc.gridy = 8;
        insideCenterPanel.add(displayButton, gbc);

        addLecturerButton = new UseButton("Add Lecturer");
        addLecturerButton.setPreferredSize(new Dimension(120, 30));
        gbc.insets = new Insets(20, -180, 0, 0);
        gbc.gridx = 1;
        gbc.gridy = 7;
        insideCenterPanel.add(addLecturerButton, gbc);

        clearButton = new UseButton("Clear");
        clearButton.setPreferredSize(new Dimension(70, 30));
        gbc.gridx = 1;
        gbc.insets = new Insets(20, 0, 0, 0);
        gbc.gridy = 8;
        insideCenterPanel.add(clearButton, gbc);


        gbc.insets = new Insets(10, 0, 0, 0);
        centerPanel.add(insideCenterPanel, gbc);
        centerPanel.setPreferredSize(new Dimension(400, 450));
        add(centerPanel, gbc);

        operationForBtn();
        setSize(new Dimension(800, 700));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);


    }

    public void forAddingLecturer() {
//        String[] heading = {""}
        String[] valuesForField = {teacherNameField.getText().strip(), addressField.getText().strip(), employmentStatusField.getText().strip(), workingTypeField.getText().strip(),departmentField.getText().strip()};
        String[] intValues = {teacherIdField.getText().strip(), experienceYearsField.getText().strip()};

        Boolean fieldChecker = false;
        Boolean isNum = false;
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
        for (Object valueField : valuesForField) {
            if (((String) valueField).length() >= 3) {
                fieldChecker = true;
            } else {
                fieldChecker = false;
                break;


            }

        }
        if (fieldChecker) {

            if (isNum) {
                Lecturer lecturerDetail = new Lecturer(Integer.parseInt(teacherIdField.getText().strip()), teacherNameField.getText(), addressField.getText(), employmentStatusField.getText(), Integer.parseInt(experienceYearsField.getText().strip()),departmentField.getText(), workingTypeField.getText());
                /*Adding tutorDetails reference of tutor object in detailsOfTeacher arrayList of TeacherGui*/
                EntryGui.detailsOfTeacher.add(lecturerDetail);
                JOptionPane.showMessageDialog(this, "Lecturer has been added!Successfully");
//                System.out.println(EntryGui.detailsOfTeacher.get(0).getTeacherName());
                isValueValid = true;
//
            } else {
                JOptionPane.showMessageDialog(this, "Enter the value number in respective field", "Invalid", JOptionPane.ERROR_MESSAGE);
                isValueValid = false;
            }
        }
        else{
                JOptionPane.showMessageDialog(this, "Enter the value For all Field! OR length must be greater than 3(Except numbers field)", "Invalid", JOptionPane.ERROR_MESSAGE);
                isValueValid = false;
            }

    }

    public void operationForBtn(){
        UseButton[] buttons = {addLecturerButton,clearButton,displayButton};
        for (UseButton btn : buttons) {
            btn.addActionListener(new ActionListener() {
                                      @Override
                                      public void actionPerformed(ActionEvent e) {
                                          Object[] textFields ={teacherIdField,teacherNameField,addressField,workingTypeField,
                                                  employmentStatusField,departmentField,experienceYearsField};
                                          Object[] valuesOfField = {teacherNameField.getText().strip(), addressField.getText().strip(), workingTypeField.getText().strip(),
                                                  employmentStatusField.getText().strip()};

                                          String[] intValues = { teacherIdField.getText().strip(), experienceYearsField.getText().strip()};
                                          switch (e.getActionCommand()){
                                              case "Add Lecturer":
                                                  forAddingLecturer();
                                                  break;
                                              case "Clear":
                                                  forClearButton(textFields);
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
    public  void forDisplayButton() {
        String[] headings = {"Teacher ID","Name","Address","Department","Employed Status","Experience Year","Working Type"};
//        Object[][] data = new Object[10][10];
//        Object[] valuesOfField = {teacherNameField.getText(), addressField.getText(), workingTypeField.getText(), employmentStatusField.getText()};
//        String[] intValues = { experienceYearsField.getText().strip(),teacherIdField.getText().strip()};
//        Object[] combinedValuesOfAllField ={teacherIdField.getText().strip(),teacherNameField.getText(),addressField.getText(),departmentField.getText(), employmentStatusField.getText(),experienceYearsField.getText(),workingTypeField.getText()};
//        if(isValueValid) {
//            for (int i = 0; i < EntryGui.detailsOfTeacher.size(); i++) {
//                System.out.println(EntryGui.detailsOfTeacher.size());
//                for (int j=0;j<combinedValuesOfAllField.length;j++) {
//
//                    data[i][j] = combinedValuesOfAllField[j];
//
//
//                }
//            }
//
//        }
//        else{
//            JOptionPane.showMessageDialog(this,"Values are Empty in Table","Message",JOptionPane.INFORMATION_MESSAGE);
//        }
        new FrameForDisplay(headings);

    }

    public  void gradeAssignmentLogic(int teacherId,int gradeScore,String department,int experienceYrs) {
        for(int i=0;i<EntryGui.detailsOfTeacher.size();i++) {
            if(EntryGui.detailsOfTeacher.get(i) instanceof Lecturer){
            Lecturer currentDetailsOfLecturer = (Lecturer) EntryGui.detailsOfTeacher.get(i);
                if(currentDetailsOfLecturer.getTeacherId() == teacherId){
                    String resultValue = currentDetailsOfLecturer.gradeAssignment(gradeScore,department,experienceYrs);
                    currentDetailsOfLecturer.setGradedScore(gradeScore);
                    currentDetailsOfLecturer.setDepartment(department);
                    currentDetailsOfLecturer.setYearsOfExperience(experienceYrs);

                    JOptionPane.showMessageDialog(this,"Congratulations! you got "+resultValue+" Grade","Message",JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(this,"The teacher id you have entered! doesn't exist","Invalid",JOptionPane.ERROR_MESSAGE);
                }
            }
            else{
                JOptionPane.showMessageDialog(this,"We Don't have Lecturer details!Try again later","Invalid",JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    public  void forClearButton(Object[] valuesOfField){
        for(Object values:valuesOfField){
            UseTextField btn =(UseTextField) values;
            btn.setText("");
        }
    }




}



