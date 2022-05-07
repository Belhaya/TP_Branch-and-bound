package B;

public class object {
	int indice;//indice de l'objet
	 double p;//poid d'objet
	double c;// c l'utilité de l'objet
	 double x;// x de l'objet
	 double xsol;// x de separation , on va separer le noeud par rapport le x de ce objet qui n'est pas entier le xsol va prend 0 pour le fils gauche et 1 pour fils droit
	 
	 
	 public void display()  
	 {  
	 System.out.print("object n�= "+indice + "  " + " object poid = "+p +" object utilit� c= "+c+"  x=  "+x+"  x de separation =  "+xsol);  //affichage le contenue d'objet
	 System.out.println();  
	 } 
	 public void dis()  
	 {  
	 System.out.print(" x"+indice + " = " +x +" ");  //affichage le contenue d'objet
	 
	 }
	 
	 
	 public void bjct(int indce,double pp, double cc,double xx) {//donner l'indice et poid et utilité et x pour un objet
		 this.indice=indce;
		 this.p=pp;
		 this.c=cc;

		 this.x= xx;

		 }
	 public void bjctx(double xx) {


		 this.x= xx;

		 }
	 public void bjctxsol(double xx) {//donner valeur de x de séparation pour un objet


		 this.xsol= xx;

		 }
}
