
package B;
import java.util.*;


//import Ro.object;

//import G.object;



	

public class noeud 
{
   int numero;
   int z;
   object[] objct=new object[10];
   String valeurBinaire;
   String Texte;
   noeud filsGauche;
   noeud filsDroit;
   boolean Feuille;
   public static noeud Racine;
   public static ArrayList<noeud> Liste=new ArrayList<noeud>();
   static int numeroCourant=1;
 
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
   

   // methode qui affiche un noeud et ses descendants
   public void Affiche()
   {
    //tring();
     if(this.filsGauche!=null) filsGauche.Affiche();
     if(this.filsDroit!=null) filsDroit.Affiche();
   }
   public void tring(int n)
   {
	   System.out.println("z= "+this.z);  
		 for (int i=0; i<n; i++)   
		 {  
		this.objct[i].display(); 
		 }
    //  return "noeud = "+this.numero+"  texte= "+this.Texte+this.objct;
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

				

			if(k2<k1)
			{
				y=ob[i];
				ob[i]=ob[j];
				ob[j]=y;

				
				
			}
			}
			
			
		}
		
	
	}
   
   public static int solInit( object[] ob,int n,double pmax)
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
			if(i==0)
			{
				if(m>pmax)
				{
					return -1;
				}
				else {
					
					
					ob[0].bjct(inddc1,p1,c1,1);
					 
				}
				
			}
			else {
			if(m<pmax)
			{
				ob[i].bjct(inddc1,p1,c1,1);
			}
			
			else {
				double mm=m-p1;
				double s=(pmax-mm)/p1;
				ob[i].bjct(inddc1,p1,c1,s);
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
			
			
		}}
		for(int i=0; i<n; i++) {
			double c= ob[i].c;
			double x= ob[i].x;
			double H= c*x;

			z=z+(int)H;
		}
		
		
	return z;
	}
   public static void Separation(noeud g,int n,double pmax,double zz){
	   int jj;
	   
	   for(int i=0; i<n; i++) {
		   double x=g.objct[i].x;
		   double xx=(long)x;
		   double x1=x-xx;
		   int inddc11=g.objct[i].indice;
			double c11=g.objct[i].c;
			double p11=g.objct[i].p;
		   noeud l =new noeud("left");
		   noeud r=new noeud("right");
		   
		 
		  
			   for(int j=0;j<n;j++) {
				   double x2=g.objct[j].x;
				   int inddc1=g.objct[j].indice;
					double c1=g.objct[j].c;
					double p1=g.objct[j].p;
				   if(x2==0 || x2==1 )
				   {
				  
				   l.objct[j]=new object();
				   l.objct[j].bjct(inddc1,p1,c1,0);
				   l.objct[j].bjctxsol(-1);
				   Liste.add(l);
				   g.filsGauche=l;
				   
				   r.objct[j]=new object();
				   r.objct[j].bjct(inddc1,p1,c1,0);
				   r.objct[j].bjctxsol(-1);
				   Liste.add(r);
				   g.filsDroit=r;
				   //g.filsGauche.objct[j]=new object();
				  // g.filsGauche.objct[j].bjct(inddc1,p1,c1,0);
				   }
			   
		   
		   else if(x2!=0.0 && x2!=1.0)
		   {
			   l.objct[j]=new object();
			   l.objct[j].bjct(inddc1,p1,c1,0);
			   l.objct[j].bjctxsol(0);
			   Liste.add(l);
			   g.filsGauche=l;

				   r.objct[j]=new object();
				   r.objct[j].bjct(inddc1,p1,c1,1);
				   r.objct[j].bjctxsol(1);
				   Liste.add(r);
				   g.filsDroit=r;
				  // g.filsDroit.objct[j]=new object();
				  // g.filsDroit.objct[j].bjct(inddc1,p1,c1,1);
	
			 
		   
	   
	   
	   
   }
			   }
			   
			   
			   }
	   evaluation(g.filsGauche,n,pmax);
	  evaluation(g.filsDroit,n,pmax);
	  g.filsGauche.tring(n);
	  g.filsDroit.tring(n);
	  boolean fg=false;
	  boolean fd=false;
	  for(int k=0; k<n;k++)
	  {
		  double xq=g.filsGauche.objct[k].x;
		 
		  if(xq!=0 &&xq!=1)
		  {
			  fg=true;
		  }
		  
	  }
	  for(int k=0; k<n;k++)
	  {
		  double xq=g.filsDroit.objct[k].x;
		  
		  if(xq!=0 &&xq!=1)
		  {
			  fd=true;
		  }
		  
	  }
	   if(g.filsGauche.z!=-1) {
		   if(g.filsGauche.z<zz) {
	  if(fg==true)	{	   
		  Separation(g.filsGauche,n,pmax,zz);}}}
	 else if(g.filsDroit.z!=-1) {
		 if(fg==true)	{
			 if(g.filsDroit.z<zz) {

		   Separation(g.filsDroit,n,pmax,zz);}}}
	     
   }
  
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
				  if(ppmax<=0)
				  {
					  g.z=-1;
					  System.out.println("PAS D SOL ");
					  break;
				  }
			
	
		}}
	   for(int i=0;i<n;i++)
	   {
		  // if(i!=ii) {int z=0;
       double m=0;

	int inddc1=g.objct[i].indice;
	double c1=g.objct[i].c;
	double p1= g.objct[i].p;
	double xsoll=g.objct[i].xsol;
	
	g.objct[i]=new object();
	
	if(xsoll!=-1) {
		 


		if(xsoll==1){
		    	g.objct[i].bjct(inddc1,p1,c1,1);}
		    else{
		    	g.objct[i].bjct(inddc1,p1,c1,0);

		    }
		    
		    
		    
		
	}
	else {
		
		  m=m+p1;
			
		    if(i==0)
		    {
		        if(m>ppmax)
		        {
		            g.z=-1;
		            
		            break;
		        }
		        else {
		            
		            
		        	g.objct[0].bjct(inddc1,p1,c1,1);
		             
		        }
		        
		    }
		    else {
				if(m<ppmax)
				{
					g.objct[i].bjct(inddc1,p1,c1,1);
				}
				
				else {
					double mm=m-p1;
					double s=(ppmax-mm)/p1;
					g.objct[i].bjct(inddc1,p1,c1,s);
					break;
					
						
				}
				
				
			}
		
		
		
		
		
		
	}	
	}
	

	   
	   for(int i=0; i<n; i++) {
		  
			double c= g.objct[i].c;
			double x= g.objct[i].x;
			double H= c*x;
			if(g.z!=-1)
			{
			
			z=z+(int)H;}
		}
		
		
	g.z=z;
	   
	   
		 }

	
 
   public boolean equals(Object ob)
   {
     if(ob instanceof noeud) return (((noeud)ob).Texte.equals(this.Texte));
     else if(ob instanceof String) return this.Texte.equals((String) ob);
     else return false;
   }
   public static noeud getObj(String txt)
   {
     for(int i=0;i<Liste.size();i++)
     {
        noeud no=(noeud) Liste.get(i);
        if(no.Texte.equals(txt)) return no;
     }
     return null;
   }
   
   public static void main(String[] ar)
   {
	   
	   int n;
		 Scanner obj=new Scanner(System.in);  
		 System.out.print("Total number of objects: "); 
		 n=obj.nextInt();
		  noeud rac=new noeud("racine");
		// object[] objct=new object[10];
		 rac.objct=new object[10];
		 object[] o=new object[10];


		
		 int z;
		 double pmax=30;
		 
		 

		 
		 System.out.println("remplir les objet: ");  
		 for(int i=0; i<n; i++) 
			 
		 {
		
			 System.out.println("remplir l'objet n°"+i);
			 rac.objct[i]=new object();
			rac.objct[i].indice=i; 
			 
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
     Separation(rac,n,pmax,z);
     rac.tring(n);
     rac.filsGauche.tring(n);
     rac.filsDroit.tring(n);

     
   }
}
