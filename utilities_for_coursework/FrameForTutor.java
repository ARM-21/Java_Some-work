package com.utilities_for_coursework;


import com.main_classes.EntryGui;
import com.main_classes.Lecturer;
import com.main_classes.Teacher;
import com.main_classes.Tutor;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;



public class FrameForTutor extends JFrame {
    /*label for all attributes of tutor*/
    private UseLabel teacherIdLabel, teacherNameLabel, addressLabel, workingTypeLabel,
            employmentStatusLabel, workingHours, salaryLabel, specializationLabel, qualificationLabel,
            performanceIndexLabel;
    /*fields to write tutor's details */
    private UseTextField teacherIdField, teacherNameField, addressField, workingTypeField,
            employmentStatusField, workingHoursField, salaryField, specializationField,
            qualificationField, performanceIndexField;
    /*Buttons to remove a tutor, add a tutor and display the information available in database(ArrayList)*/
    private UseButton addTutorButton, removeTutorBtn, displayButton, setSalaryBtn, clearButton;
    static Boolean isValueValid = false;


    public FrameForTutor() {
        /*main gbc for whole frame and leftPanel*/
        UsePanel leftPanel = new UsePanel();
        leftPanel.setLayout(new GridBagLayout());
        leftPanel.setBackground(new Color(0xfffff));

        UsePanel rightPanel = new UsePanel();
        rightPanel.setLayout(new GridBagLayout());
        leftPanel.setBackground(new Color(0xffff0));


        GridBagConstraints gbc = new GridBagConstraints();


        /*Create centered panel*/
        //gbc for center panel
        GridBagConstraints gbcForCenterPanel = new GridBagConstraints();
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(1, 2));
        centerPanel.setBackground(new Color(0x83789A));
        setLayout(new FlowLayout(FlowLayout.CENTER));


        this.teacherIdLabel = new UseLabel("Teacher Id: ");
        this.teacherIdField = new UseTextField();

        this.teacherNameLabel = new UseLabel("Name: ");
        this.teacherNameField = new UseTextField();


        this.addressLabel = new UseLabel("Address: ");
        this.addressField = new UseTextField();


        this.workingTypeLabel = new UseLabel("Working Type: ");
        this.workingTypeField = new UseTextField();


        this.employmentStatusLabel = new UseLabel("Employed Status:");
        this.employmentStatusField = new UseTextField();

        this.workingHours = new UseLabel("Working Hours: ");
        this.workingHoursField = new UseTextField();

        this.salaryLabel = new UseLabel("Salary: ");
        this.salaryField = new UseTextField();

        this.specializationLabel = new UseLabel("Specialization:");
        this.specializationField = new UseTextField();

        this.qualificationLabel = new UseLabel("Qualification: ");
        this.qualificationField = new UseTextField();

        this.performanceIndexLabel = new UseLabel("PerformanceIndex: ");
        this.performanceIndexField = new UseTextField();

        /*selecting position for each field*/

        gbc.gridx = 0;
        gbc.gridy = 0;
        leftPanel.add(teacherIdLabel, gbc);
        gbc.gridx = 1;
        gbc.insets = new Insets(5, 0, 0, 0);
        leftPanel.add(teacherIdField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 0, 0);
        leftPanel.add(teacherNameLabel, gbc);
        gbc.insets = new Insets(5, 0, 0, 0);
        gbc.gridx = 1;
        gbc.gridy = 1;
        leftPanel.add(teacherNameField, gbc);
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.gridx = 0;
        gbc.gridy = 2;

        leftPanel.add(addressLabel, gbc);
        gbc.insets = new Insets(5, 0, 0, 0);
        gbc.gridx = 1;
        gbc.gridy = 2;
        leftPanel.add(addressField, gbc);
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.gridx = 0;
        gbc.gridy = 3;

        leftPanel.add(qualificationLabel, gbc);
        gbc.insets = new Insets(5, 0, 0, 0);
        gbc.gridx = 1;
        leftPanel.add(qualificationField, gbc);
        gbc.insets = new Insets(0, 0, 0, 0);

        gbc.gridx = 0;
        gbc.gridy = 4;
        leftPanel.add(salaryLabel, gbc);
        gbc.insets = new Insets(5, 0, 0, 0);
        gbc.gridx = 1;
        leftPanel.add(salaryField, gbc);


        gbc.gridx = 0;
        gbc.gridy = 0;

        gbc.insets = new Insets(0, 0, 0, 0);
        rightPanel.add(employmentStatusLabel, gbc);
        gbc.insets = new Insets(0, 5, 0, 0);
        gbc.gridx = 1;
        rightPanel.add(employmentStatusField, gbc);
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.gridx = 0;
        gbc.gridy = 1;

        rightPanel.add(workingTypeLabel, gbc);
        gbc.insets = new Insets(0, 5, 0, 0);
        gbc.gridx = 1;
        rightPanel.add(workingTypeField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(0, 0, 0, 0);
        rightPanel.add(performanceIndexLabel, gbc);
        gbc.insets = new Insets(5, 0, 0, 0);
        gbc.gridx = 1;
        rightPanel.add(performanceIndexField, gbc);


        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.insets = new Insets(0, 0, 0, 0);
        rightPanel.add(workingHours, gbc);
        gbc.insets = new Insets(5, 0, 0, 0);
        gbc.gridx = 1;
        rightPanel.add(workingHoursField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.insets = new Insets(0, 0, 0, 0);
        rightPanel.add(specializationLabel, gbc);
        gbc.insets = new Insets(5, 0, 0, 0);
        gbc.gridx = 1;
        rightPanel.add(specializationField, gbc);


        displayButton = new UseButton("Display");
        displayButton.setPreferredSize(new Dimension(80, 30));
        gbc.gridx = 0;
        gbc.insets = new Insets(20, 0, 0, 0);
        gbc.gridy = 5;
        leftPanel.add(displayButton, gbc);

        addTutorButton = new UseButton("Add Tutor");
        addTutorButton.setPreferredSize(new Dimension(120, 30));

        setSalaryBtn = new UseButton("Set Salary");
        setSalaryBtn.setPreferredSize(new Dimension(120, 30));
        setSalaryBtn.setVisible(false);


        gbc.gridx = 0;
        gbc.gridy = 5;
        rightPanel.add(addTutorButton, gbc);
        rightPanel.add(setSalaryBtn, gbc);
        removeTutorBtn = new UseButton("remove Tutor");
        removeTutorBtn.setEnabled(false);
        removeTutorBtn.setPreferredSize(new Dimension(120, 30));
        gbc.gridx = 1;
        gbc.gridy = 5;
        rightPanel.add(removeTutorBtn, gbc);

        clearButton = new UseButton("Clear");
        clearButton.setPreferredSize(new Dimension(70, 30));
        gbc.gridx = 1;
        gbc.insets = new Insets(20, 0, 0, 0);
        gbc.gridy = 5;
        leftPanel.add(clearButton, gbc);
        /*For button actionss listing*/
        actionPerformedBtnClick();

        centerPanel.add(leftPanel);
        centerPanel.add(rightPanel);
        centerPanel.setPreferredSize(new Dimension(800, 300));
        add(centerPanel);

        getContentPane().setBackground(new Color(116, 101, 101));
        setSize(new Dimension(900, 500));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public void disableTheFieldsForSetSalary() {
        this.addTutorButton.setVisible(false);
        this.setSalaryBtn.setVisible(true);
        this.addressLabel.setEnabled(false);
        this.workingTypeLabel.setEnabled(false);
        this.employmentStatusLabel.setEnabled(false);
        this.workingHours.setEnabled(false);
        this.removeTutorBtn.setVisible(false);
        this.specializationLabel.setEnabled(false);
        this.qualificationLabel.setEnabled(false);
        this.salaryLabel.setText("New Salary");
        this.teacherNameLabel.setEnabled(false);
        this.teacherNameField.setEnabled(false);
        this.addressField.setEnabled(false);
        this.workingTypeField.setEnabled(false);
        this.employmentStatusField.setEnabled(false);
        this.workingHoursField.setEnabled(false);

        this.specializationField.setEnabled(false);
        this.qualificationField.setEnabled(false);
//        performanceIndexField.setEnabled(false);
    }

    public void disableTheFieldsForRemoveTutor() {

        this.removeTutorBtn.setEnabled(true);
        this.addTutorButton.setEnabled(false);
        this.addressLabel.setEnabled(false);
        this.workingTypeLabel.setEnabled(false);
        this.employmentStatusLabel.setEnabled(false);
        this.workingHours.setEnabled(false);
        this.salaryLabel.setEnabled(false);
        this.specializationLabel.setEnabled(false);
        this.qualificationLabel.setEnabled(false);
        this.performanceIndexLabel.setEnabled(false);
        this.teacherNameLabel.setEnabled(false);
        this.teacherNameField.setEnabled(false);
        this.addressField.setEnabled(false);
        this.workingTypeField.setEnabled(false);
        this.employmentStatusField.setEnabled(false);
        this.workingHoursField.setEnabled(false);
        this.salaryField.setEnabled(false);
        this.specializationField.setEnabled(false);
        this.qualificationField.setEnabled(false);
        this.performanceIndexField.setEnabled(false);


    }



    public void actionPerformedBtnClick() {

        UseButton[] buttons = {addTutorButton, removeTutorBtn, displayButton, clearButton,setSalaryBtn};
        for (UseButton btn : buttons) {
            btn.addActionListener(new ActionListener() {
                                      @Override
                                      public void actionPerformed(ActionEvent e) {
                                          Object[] textFields = {teacherIdField, teacherNameField, addressField, workingTypeField,
                                                  employmentStatusField, workingHoursField, salaryField, specializationField,
                                                  qualificationField, performanceIndexField};
                                          Object[] valuesOfField = {teacherNameField.getText().strip(), addressField.getText().strip(), workingTypeField.getText().strip(),
                                                  employmentStatusField.getText().strip(), specializationField.getText().strip(), qualificationField.getText().strip()};

                                          String[] intValues = {performanceIndexField.getText().strip(), workingHoursField.getText().strip(), teacherIdField.getText().strip(), salaryField.getText().strip()};
                                          switch (e.getActionCommand()) {
                                              case "Add Tutor":
                                                  forAddTutorButton(valuesOfField, intValues);
                                                  break;
                                              case "Clear":
                                                  forClearButton(textFields);
                                                  break;
                                              case "Display":
                                                  forDisplayButton();
                                                  break;

                                              case "remove Tutor":
                                                  removeTutorBtn(teacherIdField.getText().strip());
                                                  break;
                                              case "Set Salary":
                                                  System.out.println("from set salry");
                                                  setSalaryBtn(teacherIdField.getText().strip(),salaryField.getText().strip(),performanceIndexField.getText().strip());

                                          }

                                      }
                                  }
            );
        }
    }


    public void forDisplayButton() {
        String[] headings = {"Teacher ID", "Name", "Address", "Qualification", "Salary", "Employed Status", "Working Type", "Performance Index", "Working Hours", "Specialization"};
//        Object[][] data = new Object[10][10];
//
//        Object[] combinedValuesOfAllField ={teacherIdField.getText().strip(),teacherNameField.getText(), addressField.getText(),qualificationField.getText(), salaryField.getText().strip(),
//                employmentStatusField.getText(),workingTypeField.getText(), performanceIndexField.getText().strip(),workingHoursField.getText().strip(),specializationField.getText().strip()};
//            if(isValueValid) {
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
//            }
//            else{
//                JOptionPane.showMessageDialog(this,"Values are Empty in Table","Message",JOptionPane.INFORMATION_MESSAGE);
//            }
        new FrameForDisplay(headings);

    }


    public void forClearButton(Object[] valuesOfField) {
        for (Object values : valuesOfField) {
            UseTextField btn = (UseTextField) values;
            btn.setText("");
        }
    }

    public void forAddTutorButton(Object[] valuesOfField, String[] intValues) {
        Boolean fieldChecker = false;
        Boolean isNum = false;
        for (int i = 0; i < intValues.length; i++) {

            if (intValues[i].length() >= 1) {
                try {
                    Integer castToInt = Integer.parseInt(intValues[i]);
                    isNum = true;
                } catch (NumberFormatException error) {
                    JOptionPane.showMessageDialog(FrameForTutor.this, "Enter a valid value for:1 " + intValues[i], "Invalid", JOptionPane.ERROR_MESSAGE);
                    isNum = false;
                    break;
                }
            }
        }
        for (Object valueField : valuesOfField) {
            if (((String) valueField).length() >= 3) {
                fieldChecker = true;
            } else {
                fieldChecker = false;
                break;
            }
        }

        if (fieldChecker) {

            if (isNum) {


                Tutor tutorDetail = new Tutor(Integer.parseInt(teacherIdField.getText()), teacherNameField.getText(), addressField.getText(), workingTypeField.getText(),
                        employmentStatusField.getText(), Integer.parseInt(workingHoursField.getText()), Integer.parseInt(salaryField.getText()), specializationField.getText(),
                        qualificationField.getText(), Integer.parseInt(performanceIndexField.getText()));
                /*Adding tutorDetails reference of tutor object in detailsOfTeacher arrayList of TeacherGui*/
                EntryGui.detailsOfTeacher.add(tutorDetail);
                JOptionPane.showMessageDialog(FrameForTutor.this, "Tutor has been added!Successfully");
//                 System.out.println(EntryGui.detailsOfTeacher.get(0).getWorkingHour());
                isValueValid = true;
//
            } else {
                JOptionPane.showMessageDialog(FrameForTutor.this, "Enter the value number in respective field", "Invalid", JOptionPane.ERROR_MESSAGE);
                isValueValid = false;
            }
        } else {
            JOptionPane.showMessageDialog(FrameForTutor.this, "Enter the value For all Field! OR length must be greater than 3(Except numbers field)", "Invalid", JOptionPane.ERROR_MESSAGE);
            isValueValid = false;
        }


    }

    public void removeTutorBtn(String teacherId) {

        Boolean isNum = false;

        if (teacherId.length() >= 1) {
            try {
                Integer.parseInt(teacherId);
                isNum = true;
            } catch (NumberFormatException error) {
                JOptionPane.showMessageDialog(FrameForTutor.this, "Enter a valid value for:1 " + teacherId, "Invalid", JOptionPane.ERROR_MESSAGE);
                isNum = false;

            }
            }

            if (isNum) {
                for (int i = 0; i < EntryGui.detailsOfTeacher.size(); i++) {
                    if (EntryGui.detailsOfTeacher.get(i) instanceof Tutor) {
                        System.out.println("instanceOf Tutor");
                        Tutor currentDetailsOfLecturer = (Tutor) EntryGui.detailsOfTeacher.get(i);
                        if (currentDetailsOfLecturer.getTeacherId() == Integer.parseInt(teacherId)) {

                            EntryGui.detailsOfTeacher.remove(i);
                            JOptionPane.showMessageDialog(this, "Tutor removed", "Message", JOptionPane.INFORMATION_MESSAGE);
                        } else {

                            JOptionPane.showMessageDialog(this, "The teacher id you have entered! doesn't exist", "Invalid", JOptionPane.ERROR_MESSAGE);
                            break;
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "We Don't have Tutor details!Try again later", "Invalid", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                }


            }
            else{
                JOptionPane.showMessageDialog(FrameForTutor.this, "Enter a valid value for:1 " + teacherId, "Invalid", JOptionPane.ERROR_MESSAGE);
            }



    }

    public void setSalaryBtn(String  teacherId,String  newSalary,String  performanceIndex){
        System.out.println("from set salary emthod");
        Boolean isNum = false;
        String[] intValues = {teacherId,newSalary,performanceIndex};
        for (int i = 0; i < intValues.length; i++) {

            if (intValues[i].length() >= 1) {
                try {
                    Integer.parseInt(intValues[i]);
                    isNum = true;
                } catch (NumberFormatException error) {
                    JOptionPane.showMessageDialog(this, "Enter a valid value for:1 " + intValues[i], "Invalid", JOptionPane.ERROR_MESSAGE);
                    isNum = false;
                    break;
                }
            }
        }
        if(isNum){
            System.out.println("from is NUm");

            for(int i=0;i<EntryGui.detailsOfTeacher.size();i++) {
                if(EntryGui.detailsOfTeacher.get(i) instanceof Tutor){
                    System.out.println("instance of tutor");
                    Tutor currentDetailsOfLecturer = (Tutor) EntryGui.detailsOfTeacher.get(i);
                    if(currentDetailsOfLecturer.getTeacherId()==Integer.parseInt(teacherId)){
                        currentDetailsOfLecturer.setSalary(Double.parseDouble(newSalary),Integer.parseInt(performanceIndex));
                        JOptionPane.showMessageDialog(this,"Salary: "+newSalary+"for "+currentDetailsOfLecturer.getTeacherName()+"has been set","Message",JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{

                        JOptionPane.showMessageDialog(this,"The teacher id you have entered! doesn't exist","Invalid",JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                }
                else{
                    JOptionPane.showMessageDialog(this,"We Don't have Tutor details!Try again later","Invalid",JOptionPane.ERROR_MESSAGE);
                    break;
                }
            }



        }
        else{
            JOptionPane.showMessageDialog(this, "Enter a valid value for:1 " + teacherId, "Invalid", JOptionPane.ERROR_MESSAGE);
        }


    }

}





