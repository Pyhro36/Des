
public class Out {
	
	public static void disp(char c,int nb){
		for (int i=0;i<nb;i++){
			System.out.print(c);
		}
		System.out.println("("+nb+")");
	}
	
	public static void dispHisto(Des de, char c){
		for (int i=0;i<de.getDistrib().length;i++){
			System.out.print("Face "+(i+1)+" :");
			disp(c,de.getDistrib()[i]);
		}
	}
}
