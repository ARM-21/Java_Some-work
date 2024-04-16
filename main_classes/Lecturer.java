package com.main_classes;

/** Lecturer class which contains details of Lecturer and inherits the default ,protected,public property and methods in teacher class with the help of extends keyword
 * @author (Manoj Neupane)
 * @version (1 and date:- 2024/01/12)
 */
public class Lecturer extends Teacher
{
    //instance variables
    private int yearsOfExperience;
    private int gradedScore;
    private boolean hasGraded;
    private String department;
    /*child class constructor with 7 parameters where 
     * call to the constructor of parent class is made with five parameters with 
     * the assignment of different variables like(department,yearOfexperience) with 
     * respective parameters and hasGraded,gradedScore to false and 0 respectively*/
    public Lecturer(int teacherId,String teacherName,String address,String employmentStatus,int yearsOfExperience,String department,String workingType)
    {
        super(teacherId,teacherName,address,workingType,employmentStatus);
        this.gradedScore = 0;
        hasGraded = false;
        this.yearsOfExperience = yearsOfExperience;
        this.department = department;
    }
    //accessor of Department,It returns String value stored in department.
    public String getDepartment()
    {
        return department;
    }
    //accessor of yearOfExperience,It returns integer value stored in yearOfExperience.
    public int getYearsOfExperience()
    {
        return yearsOfExperience;
    }
    //accessor  of graded score, It returns integer value stored in gradedScore.
    public int getGradedScore()
    {
        return gradedScore;
    }
    //mutator of gradedScore, It accepts an integer value as a parameter and assign it to gradedScore instance variable.
    public void setGradedScore(int value)
    {
        gradedScore = value;
    }
    //accessor  of hasGraded ,It returns boolean value stored in hasGraded.
    public boolean isHasGraded()
    {
        return hasGraded;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    /*gradeAssignment method which accepts 3 parameters and assigns the graded by checking different condition as below.*/
    public  String gradeAssignment(int gradedScore,String department,int yearsOfExperience)
    {
        //this block of code will work if yearOfExperience is greater than or equal to 5
        if(yearsOfExperience >= 5) {
            //this condition will be true if and only if instance department is equal to local department
            System.out.println(this.department + " " + department);
            if(this.department.equals(department)) {

                /*checks whether the given value of gradedScore is less than 0 and greater than 100, if it's true shows invalid message as below.*/  
                if(gradedScore<0 || gradedScore>100){
//                    System.out.println("gradedScore is invalid");
                    return "Enter valid marks";
                }
                // checks whether the given value of gradedScore is greater than or equals to 70
                else if(gradedScore >= 70) {
                    System.out.println("you scored A");
                    return "A";
                }
                // checks whether the given value of gradedScore is greater than or equals to 60 and smaller than 70
                else if(gradedScore >= 60 && gradedScore < 70) {
                    System.out.println("you scored B");
                    return "B";
                }
                // checks whether the given value of gradedScore is greater than or equals to 50 and smaller than 60
                else if(gradedScore >= 50 && gradedScore < 60) {
                    System.out.println("you scored C");
                    return "C";
                }
                // checks whether the given value of gradedScore is greater than or equals to 40 and smaller than 50
                else if(gradedScore >= 40 && gradedScore < 50) {
                    System.out.println("you scored D");
                    return "D";
                }
                //this block of code will work if all the above condition are wrong
                else {
                    System.out.println("you scored E");
                    return "E";
                }
//                //assignment of instance variable with changed value while grading score
//                this.gradedScore=gradedScore;
//                this.yearsOfExperience=yearsOfExperience;
//                hasGraded = true;
            }
            //this block of code will work if teacher is not in same area of department.
            else {
                System.out.println("teacher is not in same area of interest");
                return "teacher is not in same area of interest";
            }

        }
        //this block of code will work if teacher has smaller than 5 years of experience
        else {
//            System.out.println("teacher has low experience");
            return "teacher has Low experience";
        }

    }
    //this method displays the details of Lecturer if lecturer has assign the grade to students otherwise displays warning message to grade the assignment
    @Override
    public void display()
    {
        //Checking whether the students has graded or not, this block of code will work if hasGraded is true.
        if(hasGraded) {
            super.display();
            System.out.println("Department: "+department+"\n"+"yearOfExperience: "+yearsOfExperience+"\n"+"gradedScore: "+gradedScore);
        }
        // This block of code will execute if hasGraded has value false.
        else {
            System.out.println("grade has not assigned yet.");
        }
    }
}