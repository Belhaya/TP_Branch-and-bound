package B;

import java.util.*;


//import Ro.object;

//import G.object;



	

public class noeud 
{
   int numero;
   int z;
  double z_;

   object[] objct=new object[10];//les objets
   
   String Texte;
noeud filsGauche;
noeud filsDroit;
   boolean Feuille;
   public static noeud Racine;
   public static ArrayList<noeud> Liste=new ArrayList<noeud>();
   static int numeroCourant=1;
  public  static  double zz_;//z- variable global
 
  noeud(String txt)
  {
    this.numero=numeroCourant;
    this.Texte=txt;
    numeroCourant++;
  }
   
   public static noeud getRacine()
   {
     return noeud.Racine;
   }
   public static void setRacine(noeud r)
   {
     noeud.Racine=r;
   }
   

   public void tring(int n)//affichage le contenue de noeud
   {
	   System.out.println("z = "+this.z);  
	   System.out.println("z- = "+ zz_); 
		 for (int i=0; i<n; i++)   
		 {  
		this.objct[i].display(); 
		 }
    //  return "noeud = "+this.numero+"  texte= "+this.Texte+this.objct;
   }
   public void solution(int n)
   {
		 for (int i=0; i<n; i++)   
		 {  
		this.objct[i].dis(); 
		 }  
   }
   
   
   public static void tri( object[] ob,int n)
	{
		object y=new object();
		
		
		for(int i=0; i<n; i++) {
			

			
			for (int j = 0; j < n; j++) {
				
				double p1=ob[i].p;
				double p2=ob[j].p;
				double c1=ob[i].c;
				double c2= ob[i].c;
				double k1=c1/p1;
				double k2=c2/p2;
				//System.out.println(k1);
				//System.out.println(k2);

				

			if(k2<k1)//tri decroissant
			{
				y=ob[i];
				ob[i]=ob[j];//permutation des objets
				ob[j]=y;

				
				
			}
			}
			
			
		}
		
	
	}
   
   public static int solInit( object[] ob,int n,double pmax)//solution initial
	{
		int z=0;

		 double m=0;
		/*double p0= ob[0].p;
		int inddc=ob[0].indice;
		double c0=ob[0].c;
		ob[0]=new object();
		if(p0>pmax)
		{
			System.out.println(" pas de solution");
		}
		else {
			
			
			ob[0].bjct(inddc,p0,c0,1);
			  m=p0;
		}*/
		
		for(int i=0; i<n; i++) {
			int inddc1=ob[i].indice;
			double c1=ob[i].c;
			double p1= ob[i].p;
			
			m=m+p1;
			ob[i]=new object();
			
			if(m<pmax)
			{
				ob[i].bjct(inddc1,p1,c1,1);//mis a jour de x
				ob[i].bjctxsol(-1);//x de separation intialisation avec -1 
			}
			
			else {
				double mm=m-p1;
				double s=(pmax-mm)/p1;
				ob[i].bjct(inddc1,p1,c1,s);//mis a jour de x
				ob[i].bjctxsol(-1);//x de separation intialisation avec -1 
				break;
				/*for(int kk=0;kk<n;kk++)
				{
					if(kk==i+1)
					{
					int inddck=ob[kk].indice;
					double ck=ob[kk].c;
					double pk= ob[kk].p;
					ob[kk]=new object();
					 
						ob[kk].bjct(inddck,pk,ck,0);
				}}*/
					
			}
			
			
		}
		for(int i=0; i<n; i++) {//calcul le z pour la racine
			double c= ob[i].c;
			double x= ob[i].x;
			double H= c*x;

			z=z+(int)H;
		}
		
		
	return z;
	}
   
   public static void solutionoptimal(noeud g,int n)// cherche et afficher solution optimal
   {
	   boolean f=false;
		  for(int k=0; k<n;k++)
		  {
			  double xq=g.objct[k].x;
			 
			  if(xq!=0 &&xq!=1)
			  {
				  f=true;//truesi il ya x n'est pas entier
				  break;
			  }
			  
		  }

		  if(f==false)//si tous les x entier
		  {if((g.z!=0) &&(g.z!=-1)) {//si il ya des solution
			  if((g.z)==zz_)// si z de noeud =z-
			  {
				 g.tring(n);
				 System.out.println(" les x:");
				 g.solution(n);}//affichage le contenu de noeud
			 
			
			  
		  }
		   
			}
		  if(g.filsGauche !=null)
			 {
				 solutionoptimal(g.filsGauche,n);//recursive cherche dans le fils gauche
				 
			 }
			 if(g.filsDroit !=null)
			 {
				 solutionoptimal(g.filsDroit,n);//cherche dans le fils droit
				 
				 
			 }
	   
   }
   public static void Separation(noeud g,int n,double pmax,double zz){//separation des noeud
	   int jj;
	   noeud l =new noeud("left");
	   noeud r=new noeud("right");
	   
	   System.out.println("z- " +zz_);

		  
			   for(int j=0;j<n;j++) {
				   double x2=g.objct[j].x;
				   int inddc1=g.objct[j].indice;
					double c1=g.objct[j].c;
					double p1=g.objct[j].p;
					double xsol=g.objct[j].xsol;
				   if((x2==0 || x2==1) ) 
				   {
				  
				   l.objct[j]=new object();
				   l.objct[j].bjct(inddc1,p1,c1,0);//mis a jour de x
				   l.objct[j].bjctxsol(xsol);//mis a jour x de separation
				   Liste.add(l);
				   g.filsGauche=l;
				   
				   r.objct[j]=new object();
				   r.objct[j].bjct(inddc1,p1,c1,0);//mis a jour de x
				   r.objct[j].bjctxsol(xsol);//mis a jour x de separation
				   Liste.add(r);
				   g.filsDroit=r;
				   //g.filsGauche.objct[j]=new object();
				  // g.filsGauche.objct[j].bjct(inddc1,p1,c1,0);
				  }
				   
			   
		   
		   else if(x2!=0.0 && x2!=1.0)
		   {
			   l.objct[j]=new object();
			   l.objct[j].bjct(inddc1,p1,c1,0);//mis a jour de x
			   l.objct[j].bjctxsol(0);//mis a jour x de separation
			   Liste.add(l);
			   g.filsGauche=l;

				   r.objct[j]=new object();
				   r.objct[j].bjct(inddc1,p1,c1,1);//mis a jour de x
				   r.objct[j].bjctxsol(1);//mis a jour x de separation
				   Liste.add(r);
				   g.filsDroit=r;
				  // g.filsDroit.objct[j]=new object();
				  // g.filsDroit.objct[j].bjct(inddc1,p1,c1,1);
	
			 
		   
	   
	   
	   
   }
			   }
			   
			   
			   
	   evaluation(g.filsGauche,n,pmax);//calcul la solution sur le noeud gauche
	   
	    
	  evaluation(g.filsDroit,n,pmax);//calcul la solution sur le noeud droit
	 
	  
	  boolean fg=false;
	  boolean fd=false;
	  for(int k=0; k<n;k++)
	  {
		  double xq=g.filsGauche.objct[k].x;
		 
		  if(xq!=0 &&xq!=1)
		  {
			  fg=true;//true si il ya x n'est pas entier
			  break;
		  }
		  
	  }
	 // System.out.println("z-  " +zz_);
	  if(fg==false)//si les x sont entier
	  {if((g.filsGauche.z!=0) &&(g.filsGauche.z!=-1)) {//si il ya des solution
		  if((g.filsGauche.z)>zz_)//si z>z-
		  {
			  zz_=g.filsGauche.z;//mis a jour de z-
			// g.filsGauche.z_=zz_;
		  }
	  }}
	 
	 // g.filsGauche.z_=zz_;
	  for(int k=0; k<n;k++)
	  {
		  double xq=g.filsDroit.objct[k].x;
		  
		  if(xq!=0 &&xq!=1)
		  {
			  fd=true;//true si il ya x n'est pas entier
			  break;
		  }
		  
	  }
	  
	  if(fd==false)//si les x sont entier
	  {if((g.filsDroit.z!=0) &&(g.filsDroit.z!=-1)) {//si il ya des solution
		  if((g.filsDroit.z)>zz_)//si z>z-
		  {
			  zz_=g.filsDroit.z;//mis a jour de z-
			 
		  }}}
		 
		
	  //System.out.println("z-  " +zz_);
		 
		 g.filsGauche.tring(n);//affichage de fils gauche
		 g.filsDroit.tring(n);//affichage de fils droit
	
	 // g.filsDroit.z_=zz_;
		// System.out.println("z  "+zz);
	  if(zz>zz_)//z+>z-
	  {
	  if(fg==true)	{//si il a x n'est pas entier	
		  if(g.filsGauche.z!=0 && g.filsGauche.z!=-1 ) {//si il ya des solution
	     
		  Separation(g.filsGauche,n,pmax,zz);}}}//separation sur le noeud gauche
	 else  if(zz>zz_)//z+>z-
	  {if(fd==true)	{//si il a x n'est pas entier
		 if(g.filsDroit.z!=0 && g.filsDroit.z!=-1 ) {//si il ya des solution
		 
			

		   Separation(g.filsDroit,n,pmax,zz);}}}}//separation sur le noeud droit
	     
   
  
   public static void evaluation(noeud g,int n,double pmax)
   { int z=0;
	   double pp=0;
	   double cc=0;
	   double ppmax=pmax;
	   //pp=pp+(g.objct[ii].p)*(g.objct[ii].xsol);
	  // cc=cc+(g.objct[ii].c)*(g.objct[ii].xsol);
	   for(int k=0; k<n; k++) {
		   double p3= g.objct[k].p;
		   double xsol=g.objct[k].xsol;
		   
		   if(xsol!=-1) {
				  ppmax=ppmax-(p3*xsol);
				  
				 
			
	
		}}
	  // System.out.println(ppmax);
		 double m=0;
	   for(int i=0;i<n;i++)
	   {
		  // if(i!=ii) {int z=0;
      

	int inddc1=g.objct[i].indice;
	double c1=g.objct[i].c;
	double po;
	double p1= g.objct[i].p;

	
	double xsoll=g.objct[i].xsol;
	if(xsoll==-1)
	{
		po= g.objct[i].p;
		
	}
	else {
		 po=0;
		
	}
	
		
	  m=m+po;
	 // System.out.println(m);
	
	g.objct[i]=new object();
	
	 if(ppmax<=0)
	  {
		  g.z=-1;
		  System.out.println("PAS D SOL ");
		  break;
		  
	  }else {
	
	if(xsoll!=-1) {
		 


		if(xsoll==1){
		    	g.objct[i].bjct(inddc1,p1,c1,1);//mis a jour de x apartir de x de séparation
		    	g.objct[i].bjctxsol(xsoll);}
		    else{
		    	g.objct[i].bjct(inddc1,p1,c1,0);//mis a jour de x apartir de x de separation
		    	g.objct[i].bjctxsol(xsoll);

		    }
		    
		    
		    
		
	}
	else {
		  
			
				if(m<ppmax)
				{
					g.objct[i].bjct(inddc1,p1,c1,1);//mis a jour de x 
					g.objct[i].bjctxsol(xsoll);
					
				}
				
				else {
					double mm=m-p1;
					double s=(ppmax-mm)/p1;
					g.objct[i].bjct(inddc1,p1,c1,s);//mis a jour de x
					g.objct[i].bjctxsol(xsoll);
					break;
					
						
				}
				
				
			}
		
		
		
		
		
		
	}	}
	
	

	   
	   for(int i=0; i<n; i++) {//calcul z
		  
			double c= g.objct[i].c;
			double x= g.objct[i].x;
			double H= c*x;
			if(g.z!=-1)
			{
			
			z=z+(int)H;}
		}
		
		
	g.z=z;
	   
	   
		 }


   
   public static void main(String[] ar)
   {
	   int z;
		 double pmax;
		 Scanner objj=new Scanner(System.in);  
		 System.out.print("le poid maximum: "); 
		 pmax=objj.nextInt();
		 System.out.print("le poid maximum est: "+pmax); 

	   
	   
	   int n;
		 Scanner obj=new Scanner(System.in);  
		 System.out.print("\n Total number of objects: "); 
		 n=obj.nextInt();
		  noeud rac=new noeud("racine");
		// object[] objct=new object[10];
		 rac.objct=new object[10];
		 object[] o=new object[10];


		
		
		

		  
		 System.out.println("remplir les objet: ");  
		 for(int i=0; i<n; i++) 
			 
		 {
		
			 System.out.println("remplir l'objet n°"+i);
			 rac.objct[i]=new object();
			rac.objct[i].indice=i; 
			rac.objct[i].xsol=-1;
			 
			 System.out.println("remplir le poid de  l'objet");
		  rac.objct[i].p=obj.nextInt(); 
		   System.out.println("remplir l'utilité c de  l'objet");
		   rac.objct[i].c=obj.nextInt();//reads elements from the user 
		 }
		 
		 


	   
    // noeud rac=new noeud("racine");
     setRacine(rac);
     //getRacine(rac);
    // rac.addFilsG("filsG1");
    // rac.addFilsD("filsD1");
    // (getObj("filsG1")).addFilsG("filsG1_1");
    // (getObj("filsG1")).addFilsD("filsD1_1");
     rac.tring(n);
     rac.tri(rac.objct, n);
     z=solInit(rac.objct,n,pmax);
     rac.z=z;
    
    rac.z_=-100;
    zz_=rac.z_;
    
	  boolean f=false;
	  for(int k=0; k<n;k++)
	  {
		  double xq=rac.objct[k].x;
		 
		  if(xq!=0 &&xq!=1)
		  {
			  f=true;//x n'est pas entier
			  break;
		  }
		  
	  }
	
	  if(f==false) //Si tous les x sont entier
	  {if((rac.z!=0) &&(rac.z!=-1)) {
		  if((rac.z)>zz_)
		  {
			  zz_=rac.z;
			
		  }
	  }}
    
    
    
    
    
  
   
    
     rac.tring(n);
     for(int i=0; i<n; i++) 
		 
	 {
	
		 
		 o[i]=new object();
		 o[i]=rac.objct[i];
		 //
		// o[i].display();
		
	 }
     if(rac.z==-1) {
    	 System.out.println("pas de solution");
     }
     Separation(rac,n,pmax,z);//separation ,evaluation et l'affichage de l'arbre
     System.out.println("solution optimal est :");
    solutionoptimal(rac,n);//recherche de la solution optimal dans l'arbre et l'afficher


     
   }
}
