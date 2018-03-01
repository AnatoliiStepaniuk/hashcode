package mind.hash;

import mind.hash.model.Optimizer;
import mind.hash.model.Problem;

public class Main {
    public static void main( String[] args )
    {
        solve("a_example", ".in");
        solve("b_should_be_easy", ".in");
        solve("c_no_hurry", ".in");
        solve("d_metropolis", ".in");
        solve("e_high_bonus", ".in");
    }

    private static void solve(String fileName, String extension) {
        Problem problem = Problem.readFromFile( fileName + extension );
        final Solution solution = problem.solve();
        solution.print(fileName);
    }
}
