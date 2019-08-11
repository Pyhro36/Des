import java.util.Scanner;

public class JeuDes {
	
	public static void main(String[] args) {
		
		//Rentrée des informations sur le nombre de faces des dé utlisés et sur le nombre de lancés
		System.out.println("Nombre de faces des dés :");
		int nbfaces=Get.nextInt();
		while (nbfaces<4||nbfaces>100){
			System.out.println("Veuillez rentrer un nombre entre 4 et 100");
			nbfaces=Get.nextInt();
		}
		System.out.println("Nombre de lancers de chaque dé :");
		int lance=Get.nextInt();
		while (lance<50||lance>200){
			System.out.println("vous devez lancer le dé entre 50 et 200 fois");
			lance=Get.nextInt();
		}
		
		//Instantiation du premier dé et de sa distribution
		Des de1=new Des(nbfaces);
		de1.genDistrib(lance);
		//Affichage de l'histogramme de répartition de la première distribution
		System.out.println("Caractère d'affichage de l'histogramme de répartitions des résultats :");
		Scanner sc=new Scanner(System.in);
		String st=sc.nextLine();
		char c=st.charAt(0);
		Out.dispHisto(de1, c);
		
		//Affichage des probabilités de la première distribution
		de1.dispProba();
		
		//Affichage des variables statistiques de la première distribution
		System.out.println("La probabilité max est de "+de1.getProba()[Table.indMax(de1.getProba())-1]+" pour la valeur "+Table.indMax(de1.getProba()));
		System.out.println("La probabilité min est de "+de1.getProba()[Table.indMin(de1.getProba())-1]+" pour la valeur "+Table.indMin(de1.getProba()));
		System.out.println("L'écart-type des probabilités est de "+Table.ecartType(de1.getProba()));
		
		//Affichage des probabilités trieées par ordre décroissantes de la première distribution
		Table.afficProbatri(de1.getProba());
		
		//Recherche d'une distribution pour le dé 1 ayant un écart-type <0;03
		while(Table.ecartType(de1.getProba())>0.03){
			
			System.out.println("Génération d'une nouvelle distribution pour obtenir un écart type < 0,03");
			de1.genDistrib(lance);
			System.out.println("Caractère d'affichage de l'histogramme de répartitions des résultats :");
			String str=sc.nextLine();
			char ch=str.charAt(0);
			Out.dispHisto(de1, ch);
			System.out.println("L'écart-type des probabilités est de "+Table.ecartType(de1.getProba()));			
		}
		
		//Instanciation de sup dés identiques pour avoir sup+1 distributions dont on fera la moyenne
		System.out.println("Nombre de distributions en plus de la première dont il faut faire la moyenne :");
		int sup=sc.nextInt();
		Des[] de2=new Des[sup+1];
		int[][] tot=new int[sup][nbfaces];//Création d'un tableau 2D contenant les distributions des dés
		de2[0]=de1;
		tot[0]=de1.getDistrib();
		for(int i=0;i<sup;i++){
			de2[i]=new Des(nbfaces);
			de2[i].genDistrib(lance);
			tot[i]=de2[i].getDistrib();
		}
		
		sc.close();
		
		//Création du tableau moyenne des distributions moy[]
		double moy[]=Table.moy(tot);
		System.out.println("Par la moyenne des deux distributions des dés créés");
		for(int i=0;i<moy.length;i++){
			System.out.println(moy[i]+" lancés en moyenne ont donné un "+(i+1));
		}
	}
}
