
public class Des {
	
	private static int count=0;
	private int numDe;
	private int[] distrib;
	private float[] proba;
	
	/**
	 * Constructeur de l'objet d�, au nombre de faces d�termin�es par l'utilisateur
	 * @param nbface le nombre de faces du d�
	 */
	
	Des(){
		count++;
		this.numDe=count;
		System.out.println("D� num�ro "+this.numDe+" � "+0+" faces");
		this.distrib =new int[0];
		this.proba=new float[0];
	}
	
	Des(int nbface){
		
		count++;
		this.numDe=count;
		System.out.println("D� num�ro "+this.numDe+" � "+nbface+" faces");
		this.distrib =new int[nbface];
		this.proba=new float[nbface];
	}
	
	/** 
	* G�n�re une distribution al�atoire de lanc�s de d� et sa conversion en tableau de probabilit�s
	* @param iter Nombre de lanc�s n�cessaires pour g�n�rer la distribution.
	* La distribution g�n�r�e par l'ensemble des it�rations est stock�e dans le tableau distrib de l'objet d�.
	* La classe convertEnProba de l'�nonc� est fusionn�e avec celle-ci :
	* r�utilise iter : Nombre d'it�rations utilis�es pour cr�er la distribution.
	* La probabilit� pour chaque valeur du d� d'�tre obtenue est stock�e dans le tableau proba de l'objet d�
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
	 * Affiche la distribution des faces dans les lanc�s repr�sent�e par this.distrib
	 */
	public void dispDistrib(){
		
		for (int i=0;i<this.distrib.length;i++){
			System.out.println(this.distrib[i]+" lanc�s ont donn� un "+(i+1));
		}
	}
	
	/**
	 * Affiche la probabilit� de chaque face r�sultante des lanc�s et repr�sent�e par this.proba
	 */
	public void dispProba(){
		
		for (int i=0;i<this.proba.length;i++){
			System.out.println("la proba d'obtenir un "+(i+1)+" est de "+this.proba[i]);
		}
	}
	
	/**
	 * Accesseur de la distribution
	 * @return this.distrib la distribution des faces dans les lanc�s du d�
	 */
	
	public int[] getDistrib(){
		return this.distrib;
	}
	
	/**
	 * Accesseur de la distribution
	 * @return this.distrib la probabilit� de chaque face r�sultante des lanc�s du d�
	 */
	
	public float[] getProba(){
		return this.proba;
	}

}
