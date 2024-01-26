public class Student{

	private String name;
	private int idNumber;
	private int[] testScores = new int[3];
	private double average;
	private int validExamCount;

	public Student(String name, int idNumber){
		this.name = name;
		this.idNumber = idNumber;
		for(int i = 0; i<testScores.length;i++){
			this.testScores[i] = Integer.MIN_VALUE;
		}
	}

	/**
	 * Getter for student name
	 * 
	 * @return String student name
	 * 
	 **/
	public String getName(){
		return name;
	}

	/**
	 * Getter for student ID
	 * 
	 * @return int student ID number
	 * 
	 **/
	public int getID(){
		return idNumber;
	}

	/**
	 * Getter for student test score
	 * 
	 * @param int number of test to view, starts at 1
	 * @return int student test score
	 * 
	 **/
	public int getTestScore(int testNumber){
		return this.testScores[testNumber-1];
	}

	/**
	 * Adds a test score for a student. Test numbering starts at 1
	 * 
	 * @param int testNumber - test number to add score to
	 * @param int testScore - score received on the test
	 * **/
	public void addTestScore(int testNumber, int testScore){
		this.testScores[testNumber-1] = testScore;
	}

	/**
	 * Counts the number of valid exams
	 * 
	 * @return number of valid exams
	 * **/
	public int numValidExams(){
		this.validExamCount = 0;
		for(int i = 0; i < this.testScores.length; i++){
			if(testScores[i] != Integer.MIN_VALUE){
				validExamCount++;
			}
		} 
		return validExamCount;
	}

	/**
	 * Computer the average test values for a student
	 * @return the average of their valid test scores
	 * **/
	public double testAverage(){
		int sum = 0;
		this.validExamCount = 0;
		for(int i = 0; i < this.testScores.length; i++){
			if(testScores[i] != Integer.MIN_VALUE){
				sum += testScores[i];
				validExamCount++;
			}
		} 
		return (double)sum/validExamCount;
	}

	/**
	 * Removes and exam by setting it equal to the lowest integer value
	 * 
	 * @param int examNumber - the number of the exam to remove (starts at 1)
	 * 
	 * **/
	public void removeExam(int examNumber){
		this.testScores[examNumber-1] = Integer.MIN_VALUE;
	}

	@Override
	public String toString(){
		return "Student "+this.name+" with ID number "+this.idNumber+" has an average score of "+this.testAverage()+" for " + this.validExamCount + " exams.";
	}


}
