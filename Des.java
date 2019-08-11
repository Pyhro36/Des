
public class Des {
	
	private static int count=0;
	private int numDe;
	private int[] distrib;
	private float[] proba;
	
	/**
	 * Constructeur de l'objet dé, au nombre de faces déterminées par l'utilisateur
	 * @param nbface le nombre de faces du dé
	 */
	
	Des(){
		count++;
		this.numDe=count;
		System.out.println("Dé numéro "+this.numDe+" à "+0+" faces");
		this.distrib =new int[0];
		this.proba=new float[0];
	}
	
	Des(int nbface){
		
		count++;
		this.numDe=count;
		System.out.println("Dé numéro "+this.numDe+" à "+nbface+" faces");
		this.distrib =new int[nbface];
		this.proba=new float[nbface];
	}
	
	/** 
	* Génère une distribution aléatoire de lancés de dé et sa conversion en tableau de probabilités
	* @param iter Nombre de lancés nécessaires pour générer la distribution.
	* La distribution générée par l'ensemble des itérations est stockée dans le tableau distrib de l'objet dé.
	* La classe convertEnProba de l'énoncé est fusionnée avec celle-ci :
	* réutilise iter : Nombre d'itérations utilisées pour créer la distribution.
	* La probabilité pour chaque valeur du dé d'être obtenue est stockée dans le tableau proba de l'objet dé
	*/ 

	public void genDistrib (int iter){
		
		this.distrib =new int[this.distrib.length];
		this.proba=new float[this.distrib.length];
		for (int i=0;i<iter;i++){
			this.distrib[((int)(this.distrib.length*Math.random()))]++;
		}
		
		for (int i=0;i<this.proba.length;i++){
			this.proba[i]=((float)this.distrib[i]/(float)iter);
		}
	}
	
	/**
	 * Affiche la distribution des faces dans les lancés représentée par this.distrib
	 */
	public void dispDistrib(){
		
		for (int i=0;i<this.distrib.length;i++){
			System.out.println(this.distrib[i]+" lancés ont donné un "+(i+1));
		}
	}
	
	/**
	 * Affiche la probabilité de chaque face résultante des lancés et représentée par this.proba
	 */
	public void dispProba(){
		
		for (int i=0;i<this.proba.length;i++){
			System.out.println("la proba d'obtenir un "+(i+1)+" est de "+this.proba[i]);
		}
	}
	
	/**
	 * Accesseur de la distribution
	 * @return this.distrib la distribution des faces dans les lancés du dé
	 */
	
	public int[] getDistrib(){
		return this.distrib;
	}
	
	/**
	 * Accesseur de la distribution
	 * @return this.distrib la probabilité de chaque face résultante des lancés du dé
	 */
	
	public float[] getProba(){
		return this.proba;
	}

}
