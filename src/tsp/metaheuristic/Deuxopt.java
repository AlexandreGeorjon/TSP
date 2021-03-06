package tsp.metaheuristic;

import tsp.Instance;
import tsp.Solution;

// TODO: Auto-generated Javadoc
/**
 * The Class Deuxopt.
 */
public class Deuxopt extends AMetaheuristic {

	/**
	 * Instantiates a new deuxopt.
	 *
	 * @param instance the instance
	 * @param name the name
	 * @throws Exception the exception
	 */
	public Deuxopt(Instance instance, String name) throws Exception {
		super(instance, name);
		// TODO Auto-generated constructor stub
	}

	/**optimize the current solution using the 2-opt algorithm
	 * (change the order of city in the solution when uncrossing 2 edge reduce the path)
	 * 
	 * @param a valid solution
	 * @return a 2-opt version of the solution
	 * 
	 * @see tsp.metaheuristic.AMetaheuristic#solve(tsp.Solution)
	 */
	@Override
	public Solution solve(Solution sol) throws Exception {
		boolean solutionidentique=false;
		int NBcities=this.m_instance.getNbCities();
		while(!solutionidentique) {
			solutionidentique=true;
			for(int i=1;i<NBcities;i++) {
				for(int j=0;j<i-1;j++) {
					double longueuractuelle=this.m_instance.getDistances(sol.getCity(i), sol.getCity(i+1))+this.m_instance.getDistances(sol.getCity(j), sol.getCity(j+1));
					double longueurremplacement=this.m_instance.getDistances(sol.getCity(i), sol.getCity(j))+this.m_instance.getDistances(sol.getCity(i+1), sol.getCity(j+1));
					if(longueuractuelle>longueurremplacement) {
						if(i<j) {
							inverser(sol,i+1,j);
						}else {
							inverser(sol,j+1,i);
						}
						solutionidentique=false;
					}
				}
				for(int j=i+2;j<NBcities;j++) {
					double longueuractuelle=this.m_instance.getDistances(sol.getCity(i), sol.getCity(i+1))+this.m_instance.getDistances(sol.getCity(j), sol.getCity(j+1));
					double longueurremplacement=this.m_instance.getDistances(sol.getCity(i), sol.getCity(j))+this.m_instance.getDistances(sol.getCity(i+1), sol.getCity(j+1));
					if(longueuractuelle>longueurremplacement) {
						if(i<j) {
							inverser(sol,i+1,j);
						}else {
							inverser(sol,j+1,i);
						}
						System.err.println(sol.evaluate());
						solutionidentique=false;
					}
				}
			}
			
		}
		sol.setCityPosition(sol.getCity(0), NBcities);
		return sol;
	}

	/**
	 * Inverse order of the city between i and j (with i<j)
	 *
	 * @param sol the solution
	 * @param i the first index
	 * @param j the second index
	 * @throws Exception
	 */
	public void inverser(Solution sol, int i, int j) throws Exception {
		for(int k=i;k<=(i+j)/2;k++) {
			int ville=sol.getCity(k);
			sol.setCityPosition(sol.getCity(j-k+i),k);
			sol.setCityPosition(ville, j-k+i);
			sol.setCityPosition(sol.getCity(0), this.m_instance.getNbCities());
		}
		
	}

}
