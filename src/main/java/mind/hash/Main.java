package mind.hash;

import mind.hash.model.Problem;

public class Main {
    public static void main( String[] args )
    {

        Problem problem = Problem.readFromFile( "a_example.in" );

        final Solution solution = problem.solve();
        solution.print();

        System.out.println( "Hello HashCode, we made it!" );
    }
}
