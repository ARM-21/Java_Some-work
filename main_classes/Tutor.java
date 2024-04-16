package com.main_classes;

/** Tutor class which contains details of tutor and inherits the protected,default,public property and methods in teacher class with the help of extends keyword
@author (Manoj Neupane)
@version (1 and date:- 2024/01/12)
 */
public class Tutor extends Teacher
{
    //instance variables 
    private double salary;
    private String specialization;
    private String academicQualification;
    private int performanceIndex;
    private boolean isCertified;
    /*constructor of child class which accepts 10 parameters as below and
     * assign them to respective instance variable along with call to the
     * accessor of workingHours of parent class and assignment of isCertified to false.*/
    public Tutor(int teacherId,String teacherName,String address,String workingType,String employmentStatus,int workingHours,double salary,String specialization,String academicQualification,int performanceIndex)
    {
        //calling parent class constructor with different values as below
        super(teacherId,teacherName,address,workingType,employmentStatus);
        super.setWorkingHour(workingHours);
        this.salary = salary;
        this.specialization = specialization;
        this.academicQualification = academicQualification;
        this.performanceIndex = performanceIndex;
        isCertified = false;

    }
    //accessor of salary, It returns double type of value stored in salary variable.
    public double getSalary()
    {
        return salary;
    }
    //accessor of specialization, It returns String value stored in specialization instance variable.
    public String getSpecialization()
    {
        return specialization;
    }
    //accessor of academicQualification, It returns String value stored in academicQualification.
    public String getAcademicQualification()
    {
        return academicQualification;
    }
    //accessor of performanceIndex,It returns integer value stored in performanceIndex.
    public int getPerformanceIndex()
    {
        return performanceIndex;
    }
    //accessor of isCertified, It returns boolean value stored in isCertified.
    public boolean hasIsCertified()
    {
        return isCertified;
    }
    //mutator of salary, It accepts two parameters and calculate the salary on the basis of different condition as below:-
    public  String setSalary(double newSalary,int performanceIndex)
    {
        /*checking if performanceIndex is greater than 5 and workingHour is greater than 20,
         * This block of code will be executed if peformanceIndex is greater than 5 and workingHour is greater than 20*/
        if(performanceIndex > 5 && super.getWorkingHour() > 20) {
            /* checking if performanceIndex is greater than 5 and performanceIndex is less than equals to 7,
            This block of code will be executed if peformanceIndex is greater than 5 and  performanceIndex is less than equals to 7*/
            if(performanceIndex > 5 && performanceIndex <= 7) {
                this.salary = newSalary + 0.05 * newSalary;
            }
            /* checking if performanceIndex is greater than 8 and performanceIndex is less than equals to 9,
            This block of code will be executed if peformanceIndex is greater than 8 and  performanceIndex is less than equals to 9*/
            else if(performanceIndex > 8 && performanceIndex <= 9) {
                this.salary = newSalary + 0.1 * newSalary;
            }
            /* checking if performanceIndex is greater than or equals to 10,
            This block of code will be executed if performanceIndex is equals to 10,*/
            else if(performanceIndex == 10) {
                this.salary = newSalary + 0.2 * newSalary;
            }
            //assigning isCertified to true and instance performanceIndex to performanceIndex local variable.
            isCertified = true;
            this.performanceIndex=performanceIndex;

        }
        //This block of code will be executed if peformanceIndex is less than or equals to 5 or workingHour is less than or equals to 20.
        else {
            return "index number is smaller or equals than 5 or workingHour is smaller or equals than 20";
        }
        return "sorry unable to set salary";
    }

    /* This method assigns the different variable like salary to 0,
     * specialization to empty string,academicQualification to emptyString,performanceIndex to 0
     * and isCertified to false if isCertified is false or display invalid message if isCerified is true*/
    public void removeTutor()
    {   //this condition will work if isCertified is false
        if(!isCertified) {
            salary = 0;
            specialization = "";
            academicQualification = "";
            performanceIndex = 0;
            isCertified = false;//??
        }
        else {
            System.out.println("removing tutor invalid teacher is certified");
        }
    }

    /* display method which is overrided from teacher class ,also which displays the details of Tutor as below condition*/
    @Override
    public void display()
    {
        //this block of code will work if isCertified is true
        if(isCertified) {
            //call to the display method of Parent class display method with of help of super keyword.
            super.display();
            //Displaying details like salary,specilization,academicQualification,academicQualfication,perfromanceIndex.
            System.out.println("salary: "+salary+"\n"+"specialization: "+specialization);
            System.out.println("academicQualification: "+academicQualification);
            System.out.println("performanceIndex: "+performanceIndex);
        }
        //this block of code will work if isCertified is false
        else {
            //call to the display method of Parent class display method with of help of super keyword.
            super.display();
        }
    }

}
