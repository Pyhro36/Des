

public class Table {
	
	/**
	 * Méthode pour l'indice d'un tableau de probabilité ayant la probabilité la plus haute
	 * @param proba le tableau de probabilités
	 * @return indMax l'indice ayant la probabilité la plus haute
	 * pour obtenir cette probabilité, il suffit de demander proba[indMax]
	 */
	
	public static int indMax(float[] proba){
		
		int indMax=0;
		float valMax=proba[0];
		for (int i=1;i<proba.length;i++){
			if(proba[i]>valMax){
				valMax=proba[i];
				indMax=i;
			}
		
		}
		return indMax;
	}
	
	public static int indMax(float[] proba, int p){
		
		int indMax=p;
		float valMax=proba[p];
		for (int i=p+1;i<proba.length;i++){
			if(proba[i]>valMax){
				valMax=proba[i];
				indMax=i;
			}
		
		}
		return indMax;
	}
	
	public static int indMax(int[] proba){
		
		int indMax=0;
		int valMax=proba[0];
		for (int i=1;i<proba.length;i++){
			if(proba[i]>valMax){
				valMax=proba[i];
				indMax=i;
			}
		
		}
		return indMax;
	}
	
	public static int indMax(int[] proba, int p){
		
		int indMax=p;
		int valMax=proba[p];
		for (int i=p+1;i<proba.length;i++){
			if(proba[i]>valMax){
				valMax=proba[i];
				indMax=i;
			}
		
		}
		return indMax;
	}
	
	/**
	 * Méthode pour l'indice d'un tableau correspondant à la valeur la plus haute à partir de l'indice p
	 * @param tab le tableau de probabilités
	 * @param p l'indice à partir duquel on recherche la valeur la plus haute
	 * @return indMax l'indice ayant la valeur la plus haute
	 * pour obtenir cette probabilité, il suffit de demander tab[indMax]
	 */
	
	public static int indMin(float[] proba){
		
		int indMin=0;
		float valMin=proba[0];
		for (int i=1;i<proba.length;i++){
			if(proba[i]<valMin){
				valMin=proba[i];
				indMin=i;
			}
		
		}
		return indMin;
	}
	
	public static int indMin(int[] tab, int p){
		
		int indMin=p;
		int valMin=tab[p];
		for (int i=p+1;i<tab.length;i++){
			if(tab[i]<valMin){
				valMin=tab[i];
				indMin=i;
			}
		
		}
		return indMin;
	}
	
	public static int indMin(float[] proba, int p){
		
		int indMin=p;
		float valMin=proba[p];
		for (int i=p+1;i<proba.length;i++){
			if(proba[i]<valMin){
				valMin=proba[i];
				indMin=i;
			}
		
		}
		return indMin;
	}
	
	public static int indMin(int[] tab){
		
		int indMin=0;
		int valMin=tab[0];
		for (int i=1;i<tab.length;i++){
			if(tab[i]<valMin){
				valMin=tab[i];
				indMin=i;
			}
		
		}
		return indMin;
	}
	
	
	
	/** 
	 * Méthode d'affichage d'un tableau de probabilités triées 
	 * @param proba Tableau de probabilités à afficher 
	 */
	
	public static void afficProbatri(float[] proba){
		
		// recopie de probas dans copieProbas
		float[] copyProba = new float [proba.length];
		for (int i=0; i<proba.length;i++){
			copyProba[i]=proba[i];
		}
		for (int i=0; i<proba.length;i++){
			System.out.println("la proba d'obtenir un "+(indMax(copyProba)+1)+" est de "+copyProba[indMax(copyProba)]);
			copyProba[indMax(copyProba)]=-1;
		}
	}
	
	/** 
	 * Méthode d'affichage d'un tableau d'entiers 
	 * @param tab Tableau d'entiers à afficher 
	 */
	
	public static void disp(int[] tab){
		
		for (int i=0; i<tab.length;i++){
			System.out.println(tab[i]);
		}
	}
	
	/**
	 * Méthode donnant l'écart-type des probabilités d'un tableau de probabilités
	 * @param proba le tableau de probabilités
	 * @return ecartType l'écart-type du tableau
	 */
	
	public static double ecartType(float[] proba){
		
		double moy=0;
		double var=0;
		for (int i=0;i<proba.length;i++){
			moy+=(double)proba[i]/(double)proba.length;
			var+=Math.pow(proba[i], 2);
		}
		return Math.sqrt(var/(double)proba.length-Math.pow(moy,2));
		
	}
	/**
	 * Méthode donnant le tableau-moyenne de n tableaux d'entiers
	 * @param args le tableau des n tableaux d'entiers
	 * @return moy le tableau-moyenne
	 */
	public static double[] moy(int[][] tot){
		
		double[] moy=new double[tot[0].length];
		
		for(int i=0;i<moy.length;i++){
			for(int n=0;n<tot.length;n++){
				moy[i]+=((double)tot[n][i]/(double)tot.length);
			}
		}
		
		return moy;
	}
}
