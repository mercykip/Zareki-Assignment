package javas;

public class MissingInteger {
	
	public void missingInteger(){
        int n [] ={1,2,3,4,5,6,7,8,9,10,11,12};
        int m=n.length;//array length
        int total = (m+1)*(m+2)/2;//sum of integer inclusive of the missing number
        for(int i=0;i<m; i++){//loop through the array while updating the value of the total
            total -=n[i];
        }
        System.out.println("missing number "+total);

    }
	public static void main(String[] args) {
		 MissingInteger mi=new MissingInteger();
		 mi.missingInteger();
	 }
}
