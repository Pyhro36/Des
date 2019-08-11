import java.util.Scanner;

public class JeuDes {
	
	public static void main(String[] args) {
		
		//Rentr�e des informations sur le nombre de faces des d� utlis�s et sur le nombre de lanc�s
		System.out.println("Nombre de faces des d�s :");
		int nbfaces=Get.nextInt();
		while (nbfaces<4||nbfaces>100){
			System.out.println("Veuillez rentrer un nombre entre 4 et 100");
			nbfaces=Get.nextInt();
		}
		System.out.println("Nombre de lancers de chaque d� :");
		int lance=Get.nextInt();
		while (lance<50||lance>200){
			System.out.println("vous devez lancer le d� entre 50 et 200 fois");
			lance=Get.nextInt();
		}
		
		//Instantiation du premier d� et de sa distribution
		Des de1=new Des(nbfaces);
		de1.genDistrib(lance);
		//Affichage de l'histogramme de r�partition de la premi�re distribution
		System.out.println("Caract�re d'affichage de l'histogramme de r�partitions des r�sultats :");
		Scanner sc=new Scanner(System.in);
		String st=sc.nextLine();
		char c=st.charAt(0);
		Out.dispHisto(de1, c);
		
		//Affichage des probabilit�s de la premi�re distribution
		de1.dispProba();
		
		//Affichage des variables statistiques de la premi�re distribution
		System.out.println("La probabilit� max est de "+de1.getProba()[Table.indMax(de1.getProba())-1]+" pour la valeur "+Table.indMax(de1.getProba()));
		System.out.println("La probabilit� min est de "+de1.getProba()[Table.indMin(de1.getProba())-1]+" pour la valeur "+Table.indMin(de1.getProba()));
		System.out.println("L'�cart-type des probabilit�s est de "+Table.ecartType(de1.getProba()));
		
		//Affichage des probabilit�s trie�es par ordre d�croissantes de la premi�re distribution
		Table.afficProbatri(de1.getProba());
		
		//Recherche d'une distribution pour le d� 1 ayant un �cart-type <0;03
		while(Table.ecartType(de1.getProba())>0.03){
			
			System.out.println("G�n�ration d'une nouvelle distribution pour obtenir un �cart type < 0,03");
			de1.genDistrib(lance);
			System.out.println("Caract�re d'affichage de l'histogramme de r�partitions des r�sultats :");
			String str=sc.nextLine();
			char ch=str.charAt(0);
			Out.dispHisto(de1, ch);
			System.out.println("L'�cart-type des probabilit�s est de "+Table.ecartType(de1.getProba()));			
		}
		
		//Instanciation de sup d�s identiques pour avoir sup+1 distributions dont on fera la moyenne
		System.out.println("Nombre de distributions en plus de la premi�re dont il faut faire la moyenne :");
		int sup=sc.nextInt();
		Des[] de2=new Des[sup+1];
		int[][] tot=new int[sup][nbfaces];//Cr�ation d'un tableau 2D contenant les distributions des d�s
		de2[0]=de1;
		tot[0]=de1.getDistrib();
		for(int i=0;i<sup;i++){
			de2[i]=new Des(nbfaces);
			de2[i].genDistrib(lance);
			tot[i]=de2[i].getDistrib();
		}
		
		sc.close();
		
		//Cr�ation du tableau moyenne des distributions moy[]
		double moy[]=Table.moy(tot);
		System.out.println("Par la moyenne des deux distributions des d�s cr��s");
		for(int i=0;i<moy.length;i++){
			System.out.println(moy[i]+" lanc�s en moyenne ont donn� un "+(i+1));
		}
	}
}
