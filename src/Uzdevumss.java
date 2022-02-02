import java.text.DecimalFormat;
import java.util.Scanner;

public class Uzdevumss {
	public static void main(String[] args) {
		int studSk, kritSk;
		Scanner scan = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("0.#");
		     
		do {
			System.out.println("Cik studentiem apr��in�si gala v�rt�jumu?");
			studSk = scan.nextInt();
		}while(studSk<1);
		String[] studenti = new String[studSk];
		
		do {
			System.out.println("K�ds b�s krit�riju skaits?");
			kritSk = scan.nextInt();
		}while(kritSk<1);
		String[] kriteriji = new String[kritSk];
		int[] kriterijaSvars = new int[kritSk];
		int[][] kriterijaVertejums = new int[studSk][kritSk];
		double[] semestraVertejums = new double[studSk];
		
		//Ievada studentu v�rdus, uzv�rdus
		for(int i=0; i<studenti.length; i++) {
			System.out.println("Ievadi "+(i+1)+". studentu");
			studenti[i] = scan.next();
		}
		
		//Defin� krit�rijus
		int maxSvars = 100;
		for(int i=0; i<kriteriji.length; i++) {
			System.out.println("Ievadi "+(i+1)+". krit�riju");
			kriteriji[i] = scan.next();
			//Nor�da katra krit�rija svaru
			do {
				System.out.println("Ievadi "+(i+1)+". krit�rija svaru");
				kriterijaSvars[i] = scan.nextInt();
			}while(kriterijaSvars[i]>maxSvars || 
					kriterijaSvars[i]<1 || 
					(kriterijaSvars[0]==100 && kritSk > 1));
			maxSvars -= kriterijaSvars[i];
		}
		
		//Nor�da v�rt�jumu k�du ieguvis katrs students par katru krit�riju
		for(int i=0; i<kriterijaVertejums.length; i++) {
			for(int j=0; j<kriterijaVertejums[i].length; j++) {
				do {
					System.out.println("Ievadi "+studenti[i]+" v�rt�jumu par krit�riju "+kriteriji[j]);
					kriterijaVertejums[i][j] = scan.nextInt();
				}while(kriterijaVertejums[i][j]<0 || kriterijaVertejums[i][j]>10);
			}
		}
		
		double rezultats;
		for(int i=0; i<studenti.length; i++) {
			rezultats=0;
			for(int j=0; j<kriteriji.length; j++) {
				rezultats += ((double) kriterijaSvars[j]/100)*kriterijaVertejums[i][j];
			}
			semestraVertejums[i] = rezultats;
		}
		
		for(int i=0; i<studenti.length; i++) {	
			for(int j=0; j<kriteriji.length; j++) {
				System.out.println("Studenta "+studenti[i]+" v�rt�jums par krit�riju "+kriteriji[j]+" ir "+kriterijaVertejums[i][j]+", kura svars ir "+kriterijaSvars[j]);
			}
			System.out.println("Semestra v�rt�jums ir "+df.format(semestraVertejums[i])+"\n");
		}
		scan.close();
	}
}
