import java.util.Scanner;

public class MonthDays {
	static boolean isNumber(String s)
    {
        for (int i = 0; i < s.length(); i++)
            if (Character.isDigit(s.charAt(i)) == false)
                return false;
 
        return true;
    }
	public static int stringCompare(String str1, String str2)
    {
  
        int l1 = str1.length();
        int l2 = str2.length();
        int lmin = Math.min(l1, l2);
  
        for (int i = 0; i < lmin; i++) {
            int str1_ch = (int)str1.charAt(i);
            int str2_ch = (int)str2.charAt(i);
  
            if (str1_ch != str2_ch) {
                return str1_ch - str2_ch;
            }
        }
        if (l1 != l2) {
            return l1 - l2;
        }
        else {
            return 0;
        }
    }
	static int Day1(int m,int y )
	{
		int d=0;
		if(m==1 || m==3 ||m==5 ||m==7||m==8||m==10||m==12)
		{
			d=31;	 
		}
		else if(m==4||m==6||m==9||m==11)
		       {
			d=30;	  
		       }
		       else 
		       {
			if(m==2)
		       	{
			  if((y % 400 == 0) || ((y % 4 == 0) && (y % 100 != 0)))
			  {
				d=29;
			  }
			  else  
				d=28;			   
			}			 	       	
		        }	
		return d;              
	}
	static int Day2(String m,int y )
	{
		int d=0;
		if(stringCompare(m,"January")==0 || stringCompare(m,"Jan")==0 ||stringCompare(m,"Jan.")==0 ||stringCompare(m,"March")==0 ||stringCompare(m,"Mar")==0||stringCompare(m,"Mar.")==0 ||
				stringCompare(m,"May")==0|| stringCompare(m,"July")==0||stringCompare(m,"Jul")==0||stringCompare(m,"Aug.")==0 || stringCompare(m, "August")==0 || stringCompare(m, "Aug")==0
				|| stringCompare(m, "October")==0|| stringCompare(m, "Oct")==0 ||stringCompare(m,"Oct.")==0 || stringCompare(m, "December")==0|| stringCompare(m, "Dec")==0 || stringCompare(m,"Dec.")==0 )
		{
			d=31;	 
		}
		else if(stringCompare(m,"April")==0 ||stringCompare(m,"Apr")==0 ||stringCompare(m,"Apr.")==0 ||stringCompare(m,"June")==0 ||stringCompare(m,"Jun")==0 ||
				stringCompare(m,"September")==0 ||stringCompare(m,"Sep")==0 ||stringCompare(m,"Sept.")==0 ||stringCompare(m,"November")==0 ||stringCompare(m,"Nov")==0|| stringCompare(m,"Nov.")==0)
		       {
			d=30;	  
		       }
		       else 
		       {
			if(stringCompare(m,"February")==0 ||stringCompare(m,"Feb")==0 || stringCompare(m,"Feb.")==0)
		       	{
			  if((y % 400 == 0) || ((y % 4 == 0) && (y % 100 != 0)))
			  {
				d=29;
			  }
			  else  
				d=28;			   
			}			 	       	
		        }	
		return d;              
	}
	public static void main(String[] args) {
		int y;
		String str;
		while(true) {
		Scanner sc= new Scanner(System.in);
	    System.out.println("Enter month");
		str=sc.nextLine();
		if	(isNumber(str)) {
		System.out.println("Enter year");
		y=sc.nextInt();
		if(y<0) {
			System.out.println("You've entered invalid year.\n ");
		    continue;
		}
		int n=Integer.parseInt(str);  
		System.out.println("Number of days in " + n + " " + y + " is:" + Day1(n,y));	
		}
		else {
			System.out.println("Enter year");
			y=sc.nextInt();
			if(y<0) {
				System.out.println("You've entered invalid year.\n ");
			    continue;
			}
			System.out.println("Number of days in " + str + " " + y + " is:" + Day2(str,y));	
		}
	} 
	}
}
