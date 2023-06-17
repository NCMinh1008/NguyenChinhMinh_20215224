
public class SystemOfEquation {
	public static double[] solve2x2LinearEquation(
            double a11, double a12, 
            double a21, double a22,
            double b1,  double b2 )
    {
        double det = findDet2x2( a11, a12, a21, a22 );
        if( det == 0.0 )
        {
            return( null );    //No unique solution
        }
        double[] result = { (b1*a22 - b2*a12) / det, (b2*a11 - b1*a21) / det };
        return( result );
    }

    private static double findDet2x2( double a11, double a12, double a21, double a22 ){
        return( a11*a22 - a21*a12 );
    }
    public static void main(String[] args) {

        double[] answer = SystemOfEquation.solve2x2LinearEquation( 2, 3, 5, -10, -16, 30 );

        if( answer == null ){
            System.out.println( "No unique solution exists" );
        }
        else
        {
            System.out.println( "x1 = "  + answer[0] );	//x1 = -2
            System.out.println( "x2 = "  + answer[1] );	//x2 = -4
        }
    }
}
