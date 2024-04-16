package com.utilities_for_coursework;

import com.main_classes.EntryGui;
import com.main_classes.Lecturer;
import com.main_classes.Teacher;
import com.main_classes.Tutor;

import javax.swing.JFrame;
import  javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class FrameForDisplay extends JFrame {


   public FrameForDisplay(String[] heading){
        setLayout(new GridLayout(2,1));
       DefaultTableModel titles = new DefaultTableModel(heading,0);
        JTable table = new JTable(titles);

        for(Teacher columns:EntryGui.detailsOfTeacher){
            System.out.println("hello");

            if(columns instanceof Tutor){

//               JTable table1 = new JTable(titles);
                titles.addRow(new Object[]{columns.getTeacherId(),columns.getTeacherName(),columns.getAddress(),((Tutor) columns).getAcademicQualification(),((Tutor) columns).getSalary(),columns.getEmploymentStatus(),columns.getWorkingType(),((Tutor) columns).getPerformanceIndex(),columns.getWorkingHour(),((Tutor) columns).getSpecialization()});
                table.setPreferredSize(new Dimension(700,200));
                table.setBackground(new Color(50,50,50));
                table.setForeground(new Color(0xf0f0f0));
//                add(new JScrollPane(table));
            }
            else if(columns instanceof Lecturer) {


                table.setPreferredSize(new Dimension(700,200));
                titles.addRow(new Object[]{columns.getTeacherId(),columns.getTeacherName(),columns.getAddress(),((Lecturer) columns).getDepartment(),columns.getEmploymentStatus(),((Lecturer) columns).getYearsOfExperience(),columns.getWorkingType()});
                table.setBackground(new Color(50,50,50));
                table.setForeground(new Color(0xf0f0f0));
//                add(new JScrollPane(table));
            }

//            else{
//                DefaultTableModel titles = new DefaultTableModel(heading,0);
//               JTable table2 = new JTable(titles);
//                table2.setPreferredSize(new Dimension(700,200));
//                titles.addRow(new Object[]{columns.getTeacherId(),columns.getTeacherName(),columns.getAddress(),columns.getEmploymentStatus(),columns.getWorkingType()});
//                table2.setBackground(new Color(50,50,50));
//                table2.setForeground(new Color(0xf0f0f0));
//                add(new JScrollPane(table2));
//            }


//
        }
       add(new JScrollPane(table));
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700, 700);



    }
//    FrameForDisplay(Object[][] data, String[] headings, String fromWhere) {
//        setLayout(new GridLayout(2, 1));
//        if (fromWhere.equals("fromTutor")) {
//
//            this.table1 = new JTable(data, headings);
//            add(new JScrollPane(table1));
//        } else if (fromWhere.equals("fromLecturer")) {
//            this.table1 = new JTable(data, headings);
//            add(new JScrollPane(table1));
//        } else {
//            table1 = new JTable(data, headings);
//            add(table1);
//            add(table2);
//        }
//        setVisible(true);
//        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        setSize(700, 700);
//    }

//        public static void main(String[] args){
//
////            String[] headings = {"Teacher ID", "Name", "Address", "Qualification", "Salary", "Employed Status", "Working Type", "Performance Index", "Working Hours", "Specialization"};
////            DefaultTableModel model = new DefaultTableModel(headings);
////            JTable table = new JTable(model);
//            new FrameForDisplay(EntryGui.detailsOfTeacher.get(0),);
//        }







}
