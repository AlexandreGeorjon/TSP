package tsp.heuristic;

import java.util.ArrayList;

import tsp.Instance;

	// Nous d�clarons la m�thode d'insertion
public class Insertion extends AHeuristic {

	public Insertion(Instance instance, String name) throws Exception {
		super(instance, name);
		// TODO Auto-generated constructor stub
	}

	// � partir du d�p�t 0, nous d�terminons le n�ud le plus proche "C" 
	
	public int getplusproche(int i,ArrayList<Integer> nonvisite) {
		long[] distancei=this.m_instance.getDistances()[i];
		int NBcities=this.m_instance.getNbCities();
		int min = nonvisite.get(0);
		long distmin=distancei[min];
		for(int k :nonvisite) {
			if(distancei[k]<distmin) {
				min=k;
				distmin=distancei[k];
			}
		}
		nonvisite.remove(nonvisite.indexOf(min));
		return min;
	}
	
	// Nous avons construit le subtour 0-c-0
	
	public void solve() throws Exception {
		ArrayList<Integer> nonvisite=new ArrayList<Integer>(this.m_instance.getNbCities());
		for(int k=1;k<this.m_instance.getNbCities();k++) {
			nonvisite.add(k);
		}
		int villeprecedente=0;
		int villesuivante=0;
		for(int k=0;k<this.m_instance.getNbCities()-1;k++) {
			System.err.println(villeprecedente);
			villesuivante=this.getplusproche(villeprecedente, nonvisite);
			System.err.println(villesuivante);
			System.err.println(nonvisite);
			villeprecedente=villesuivante;

			this.m_solution.setCityPosition(villesuivante, k+1);
			
			/*Nous trouvons le n�ud "K" le plus proche (qui n'est pas dans le subtour)
		 	� n'importe quel n�ud du subtour.*/
			
			
			
			
			
			
			
			
			
		}
	
	
	
	
	
	
	/*On trouve l'arc (i, j) du subtour qui permet l'insertion la plus 
	 �conomique dans le n�ud K
	 
	 co�t d'insertion = d(i,k) + d(k,j) */
	
	
	
	
	//ici, on ins�re le noeud k entre i et j
	
	
	
	
	
	
	
	
	
	
	
	}

	
}


