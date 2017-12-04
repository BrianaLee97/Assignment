package ie.lyit.hotel;


public class Employee extends Person implements Payable {
    private Date dob;		
    private Date startDate;	
    private double salary;
    private int number;

	private static int nextNumber=1;	
	
	private final double MAX_SALARY = 150000;	

  
    public Employee(){
    	super();		
    	dob=new Date();
    	startDate=new Date();
 		salary=0.0;

 		number=nextNumber++;
    }
	

    public Employee(String t, String fN, String sn, String address, String phoneNo, 
    		        int d, int m, int y,Date startDate, double salary){
      
	   super(t, fN, sn, address, phoneNo);
	  
	   dob=new Date(d,m,y);
	   this.startDate=startDate;	
	   this.salary=salary;

	   number = nextNumber++;						
	}
    

	@Override
    public String toString(){
		return number + " " + super.toString() + " €" + salary;
	}


	@Override
	public boolean equals(Object obj){
		Employee eObject;
		if (obj instanceof Employee)
		   eObject = (Employee)obj;
		else
		   return false;
		   
	    return(this.number==eObject.number);
	}

	
	public void setDOB(Date dob){
		this.dob=dob;
	}
	public Date getDOB(){
		return dob;
	}
	public void setStartDate(Date startDate){
		this.startDate=startDate;
	}
	public Date getStartDate(){
		return startDate;
	}	
	public void setSalary(int salary){
		this.salary=salary;
	}
	public double getSalary(){
		return salary;
	}

	public int getNumber(){
		return number;
	}	
	
	@Override
	public double calculateWage(double taxPercentage) {
		
		double wage=salary/12;
		wage -= (wage * (taxPercentage/100));
		return wage;
	}

	@Override
	public double incrementSalary(double incrementAmount) {
		
		salary += incrementAmount;
		
		if(salary > MAX_SALARY)
			salary = MAX_SALARY;
		
		return salary;
	}

}
