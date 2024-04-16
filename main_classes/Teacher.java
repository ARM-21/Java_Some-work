package com.main_classes;

/** Teacher class which contains details of teacher
 * @author (Manoj Neupane)
 * @version (1 and date:- 2024/01/12)
 */
public class Teacher
{
    //instance variables 
    private int teacherId;
    private int workingHours;
    private String teacherName;
    private String workingType;
    private String employmentStatus;
    private String address;

    /*Constructor of Teacher class which 
     * accepts different parameters as below and assign them to their respective instance variable*/
    public Teacher(int teacherId,String teacherName,String address,String workingType,String employmentStatus)
    {
        this.teacherName = teacherName;
        this.address = address;
        this.workingType = workingType;
        this.teacherId = teacherId;
        this.employmentStatus = employmentStatus;

    }
    //accessor of teacherId, It returns integer value stored in teacherId.
    public int getTeacherId()
    {
        return teacherId;
    }
    //accessor of teacherName, It returns String value stored in teacherName.
    public String getTeacherName()
    {
        return teacherName;
    }
    //accessor of workingHours, It returns integer value stored in workingHours.
    public int getWorkingHour()
    {
        return workingHours;
    }
    //accessor of employmentStatus, It returns String value stored in employmentStatus.
    public String getEmploymentStatus()
    {
        return employmentStatus;
    }
    //accessor of address, It returns String value stored in address.
    public String getAddress()
    {
        return address;
    }
    //accessor of WorkingType, It returns String value stored in workingType
    public String getWorkingType()
    {
        return workingType;
    }
    //mutator of workingHours, It accepts a value and assign it to instance variable working hour
    public void setWorkingHour(int workingHour)
    {
        this.workingHours=workingHour;
    }
    //This method display a details of teacher according to different condition as below
    public void display()
    {   //This block of code will be executed if workingHours is empty or if it is negative which shows invalid message to request user to fill workingHours field.
        if(workingHours <= 0) {
            System.out.println("Kindly,fill the working hours.(workingHours is empty or invalid)");
        }
        //This block of code will be executed if workingHours value is greater than 0.
        else {
            System.out.println("teacherName: "+teacherName+"\n"+"teacherId: "+teacherId);
            System.out.println("Address: "+address+"\n"+"workingType: "+workingType);
            System.out.println("EmploymentStatus: "+employmentStatus+"\n"+"workingHours: "+workingHours);
        }
    }

}