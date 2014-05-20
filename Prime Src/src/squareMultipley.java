//*************************************************************************************
//*********************************************************************************** *
//author Aritra Dhar																* *
//MT12004																			* *
//M.TECH CSE																		* * 
//INFORMATION SECURITY																* *
//IIIT-Delhi																		* *
//																					* *
//*********************************************************************************** *
//*************************************************************************************

import java.io.*;
import java.math.BigInteger;
import java.util.Random;


public class squareMultipley {
	
	private static final Random rnd = new Random();
	
	public static boolean evenORodd(BigInteger a)
	{
		BigInteger two=new BigInteger("2");
		BigInteger one=new BigInteger("1");
		if((a.remainder(two)).equals(one))
			return false;
		else
			return true;
	}

	public static BigInteger sqandmultiply(BigInteger radix,BigInteger exp,BigInteger mod)
	{
		int x=10000;
		BigInteger[] col=new BigInteger[x];
		
		BigInteger check=exp;
		BigInteger two=new BigInteger("2");
		BigInteger one=new BigInteger("1");
		//BigInteger zero=new BigInteger("0");
		
		
		int i=0;
		while(!check.equals(one))
		{
			//System.out.println(i);
			col[i]=check;
			//if((check.remainder(two)).equals(one))
			if(!squareMultipley.evenORodd(check))
			{
				check=check.subtract(one);
			}
			else
			{
				check=check.divide(two);
			}
			
			i++;
		}
		col[i++]=one;
		//for(int c=0;c<i;c++)
		//{
			//System.out .println(col[c]);
		//}
		
		BigInteger[] col2=new BigInteger[i];
		
		int count=i-1;
		col2[i-1]=radix.mod(mod);
		
		count--;
		//System.out.println(col[2]);
		while(count!=-1)
		{
			//if((col[count].remainder(two)).equals(zero))
			if(squareMultipley.evenORodd(col[count]))
				col2[count]=(col2[count+1].multiply(col2[count+1])).mod(mod);
			else
				col2[count]=(col2[count+1].multiply(radix)).mod(mod);
			
			count--;
		}
		
		//System.out.println(col2[0]);
		return col2[0];
	}
	
	public static BigInteger gcd(BigInteger a,BigInteger b)
	{
		BigInteger one=new BigInteger("1");
		BigInteger zero=new BigInteger("0");
		//int flag=0;
		BigInteger gcd;
		if(a.equals(b))
		{
			gcd=a;
			return gcd;
			//System.out.println("gcd : "+a);
		}
		else
		{
			while(!a.equals(b))
			{
				if(a.equals(one))
				{
					//System.out.println("gcd : "+a);
					gcd=a;
					return gcd;
					//flag=1;
					//break;

				}
				if(b.equals(one))
				{
					//System.out.println("gcd : "+b);
					gcd=b;
					return gcd;
					//flag=1;
					//break;
				}
				
				if(a.equals(zero))
				{
					//System.out.println("gcd : "+b);
					gcd=b;
					return gcd;
					//flag=1;
					//break;
				}
				if(b.equals(zero))
				{
					//System.out.println("gcd : "+b);
					gcd=a;
					return gcd;
					//flag=1;
					//break;
				}
				
				if(a.compareTo(b)>0)
				{
					//a=a.subtract(b);
					a=squareMultipley.mod(a, b);
				}
				else
				{
					//b=b.subtract(a);
					b=squareMultipley.mod(b, a);
				}				
			}
			//if(flag==0)
			gcd=a;
			return gcd;
			//System.out.println("gcd : "+a);
		}
	}
	
	@SuppressWarnings("unused")
	public static BigInteger gcd_Euc(BigInteger a1,BigInteger b1)
	{
		BigInteger zero=new BigInteger("0");
		BigInteger one=new BigInteger("1");
		BigInteger temp;
		BigInteger a=a1;
		BigInteger b=b1;
		
		if(a.equals(b))
			return a;
		if(a.compareTo(b)<0)
		{
			temp=a;
			a=b;
			b=temp;
		}
		if(a.equals(one) || b.equals(one))
			return one;
		
		BigInteger q,r = null;
		
		while(!squareMultipley.mod(a, b).equals(zero))
		{
			//System.out.println("in");
			q=a.divide(b);
			r=squareMultipley.mod(a,b);
			a=b;
			b=r;
			//System.out.println(b);
		}
		return r;
	}
	
	public static BigInteger mod(BigInteger a,BigInteger b)
	{
		BigInteger in,res;
		if(a.compareTo(b)<0)
		{
			return a;
		}
		else
		{
			in=a.divide(b);
			res=a.subtract(in.multiply(b));
			return res;
		}
	} 
	
	public static BigInteger true_mod(BigInteger a,BigInteger b)
	{
		if(a.compareTo(b)<0)
		{
			return a;
		}
		
		BigInteger temp=a;
		while(true)
		{
			if(temp.compareTo(b)<=0)
				break;
			temp=temp.subtract(b);
			//System.out.println(temp);
		}
		return temp;
	}
       
    public static boolean miller_rabin_pass(BigInteger a, BigInteger n) 
    {
    	BigInteger zero=new BigInteger("0");
    	BigInteger one=new BigInteger("1");
    	BigInteger two=new BigInteger("2");
    	BigInteger n_inv = n.subtract(one);
        BigInteger d = n_inv;
        
        int s = d.getLowestSetBit();
        
        BigInteger a_to_power = squareMultipley.sqandmultiply(a, d, n);
        
        
        if (a_to_power.equals(one))
        	return true;
        if ((!a_to_power.equals(two)) && (a_to_power.mod(two)).equals(zero))
        	return false;
        for (int i = 0; i < s-1; i++) 
        {
            if (a_to_power.equals(n_inv))
            {
            	//System.out.println("in1");
            	return true;
            }
            a_to_power = squareMultipley.mod(a_to_power.multiply(a_to_power), n);
        }
        
        if (a_to_power.equals(n_inv)) 
        {
        	//System.out.println("in2");
        	return true;
        }
        return false;
    }

    public static boolean miller_rabin(BigInteger n,int try_t) 
    {
    	BigInteger zero=new BigInteger("0");
    	BigInteger one=new BigInteger("1");
        for (int i= 0; i < try_t; i++) 
        {
            BigInteger a;
            do 
            {
                a = new BigInteger(n.bitLength(), rnd);
            } while (a.equals(zero));
            if((squareMultipley.gcd_Euc(a, n)).compareTo(one)>0)
            	return false;
            if (!miller_rabin_pass(a, n)) 
            {
            	//System.out.println("in");
                return false;
            }
        }
        return true;
    }
    
    
    public static boolean Solovay_Strassen(BigInteger n,int try_t)
    {    	   	
    	//BigInteger zero=new BigInteger("0");
    	BigInteger one=new BigInteger("1");
    	BigInteger two=new BigInteger("2");
    	//BigInteger n_inv=n.subtract(one);
    	
    	for (int i= 0; i < try_t; i++) 
    	{
    		BigInteger a=new BigInteger(n.bitLength(), rnd);
    		a=squareMultipley.mod(a, n);
    		Integer x=squareMultipley.Legendre_symbol(a, n);
    		BigInteger temp=new BigInteger(x.toString());
    		//System.out.println(temp);
    		if(x==0)
    		{
    			System.out.println("in1");
    			return false;
    		}
    		if(!(squareMultipley.sqandmultiply(a, (n.subtract(one)).divide(two), n)).equals(temp))
    		{
    			System.out.println("in2");
    			return false;
    		}
    	}
    	return true;
    }
    public static boolean Solovoy(BigInteger p,int iteration)
    {
    	BigInteger zero=new BigInteger("0");
    	BigInteger one=new BigInteger("1");
    	BigInteger two=new BigInteger("2");
    	
        if(p.compareTo(two)<0)
        	return false;
        
        if ((!p.equals(two)) && (p.mod(two)).equals(zero))
        	return false;
        
        for(int i=0;i<iteration;i++)
        {
        	BigInteger a = (new BigInteger(p.bitLength(), rnd)).mod(p.subtract(one));
        	Integer jac_i=squareMultipley.Jacobian(a, p);
        	BigInteger jac= new BigInteger(jac_i.toString());
        	
            BigInteger jacobian=squareMultipley.mod((p.add(jac)),p);
            
            BigInteger mod=squareMultipley.sqandmultiply(a, (p.subtract(one)).divide(two), p);
            
            if(!jacobian.equals(zero) || !mod.equals(jacobian)){ 
                return false;
            }
        }
        return true;
    }
    public static int Jacobian(BigInteger a,BigInteger n)
    {
    	BigInteger zero=new BigInteger("0");
    	BigInteger one=new BigInteger("1");
    	BigInteger two=new BigInteger("2");
    	
    	 int flag=1;
    	 
    	 if(a.equals(one))
    		 flag=1;
    	 if(a.equals(zero))
    		 flag=0;
    	 if(a.compareTo(zero)<0)
    	 {
    		 a=a.multiply(new BigInteger("-1"));
    		 if((squareMultipley.mod(n, new BigInteger("4"))).equals(new BigInteger("3")))
    		 {
    			 flag=-1;
    		 }
    		 
    		 while((squareMultipley.mod(a, two)).equals(zero))
    		 {
    	            a=a.divide(two);
    	            
    	            if((squareMultipley.mod(n, new BigInteger("8"))).equals(new BigInteger("3")) || (squareMultipley.mod(n, new BigInteger("8"))).equals(new BigInteger("5")))
    	            	flag=-flag;    
    	     }
    		 
    		 BigInteger temp=a;
    		 a=n;
    		 n=temp;
    		 
    	    if((squareMultipley.mod(a, new BigInteger("4"))).equals(new BigInteger("3")) && (squareMultipley.mod(n, new BigInteger("4"))).equals(new BigInteger("3")))
    	    	flag=-flag;
    	    a=squareMultipley.mod(a, n);
    	    
    	    if(a.compareTo(n.divide(two))>0)
    	    	a=a.subtract(n); 
    		 
    		 
    	 }
    	 if(n.equals(one))
    		 return flag;
    	    return 0; 
    }
    
    public static int Legendre_symbol(BigInteger a,BigInteger p)
    {
    	BigInteger x=squareMultipley.mod(a, p);
    	BigInteger zero=new BigInteger("0");
    	BigInteger root=squareMultipley.sqrt(x);
    	if(squareMultipley.isSqrt(x, root) && (squareMultipley.mod(a, p)!=zero))
    		return 1;
    	if(!squareMultipley.isSqrt(x, root))
    		return -1;
    	if(squareMultipley.mod(a, p)==zero)
    		return 0;
    	return 2;
    }
    
    public static BigInteger sqrt(BigInteger n)
    {
    	BigInteger two=new BigInteger("2");
        if (n.signum() >= 0)
        {
            final int bitLength = n.bitLength();
            BigInteger root = BigInteger.ONE.shiftLeft(bitLength / 2);

            while (!isSqrt(n, root))
            {
                root = root.add(n.divide(root)).divide(two);
            }
            return root;
        }
        else
        {
            throw new ArithmeticException("square root of negative number");
        }
    }


    private static boolean isSqrt(BigInteger n, BigInteger root)
    {
        final BigInteger lowerBound = root.pow(2);
        final BigInteger upperBound = root.add(BigInteger.ONE).pow(2);
        return lowerBound.compareTo(n) <= 0 && n.compareTo(upperBound) < 0;
    }
    
	public static void main(String[] args) throws IOException, InterruptedException 
	{
		long startTime = System.currentTimeMillis();
		//BigInteger zero=new BigInteger("0");
    	//BigInteger one=new BigInteger("1");
    	//BigInteger two=new BigInteger("2");
    	
		//String s1=new String("127286875689756876598346877768734568758762578600");
		//String s2=new String("45897567685873249806876234768356872357600");
    	//String s1=new String("1");
    	//String s2=new String("56");
    	//String s3=new String("5");
		
		//BigInteger radix=new BigInteger(s1);
		//BigInteger exp=new BigInteger(s2);
		//BigInteger mod=new BigInteger(s3);
		
		//System.out.println(new squareMultipley().sqandmultiply(radix,exp,mod));
		//System.out.println(new squareMultipley().gcd(radix, exp));
		//System.out.println(squareMultipley.mod(radix, exp));
		//System.out.println(squareMultipley.true_mod(new BigInteger("5"), new BigInteger("2")));
		//System.out.println(squareMultipley.true_mod(radix, exp));
		//System.out.println(new squareMultipley().gcd_Euc(radix, exp));
		/*if(squareMultipley.miller_rabin(new BigInteger("359334085968622831041960188598043661065388726959079837"), 20))
			System.out.println("prime");
		
		else
			System.out.println("composite");
		*/
		
		/*
		for(int i=0;i<100;i++)
		{
		if(squareMultipley.miller_rabin(new BigInteger("359334085968622831041960188598043661065388726959079837"), 20))
			System.out.println("prime");
		
		else
			System.out.println("composite");
		}*/
		
		/*if(squareMultipley.Solovay_Strassen(new BigInteger("103"), 20))
			System.out.println("prime");
		
		else
			System.out.println("composite");
		*/
		
		/*if(squareMultipley.Solovoy(new BigInteger("113"), 20))
			System.out.println("prime");
		
		else
			System.out.println("composite");*/
			
		
		/*
		 * 
		 *single threaded
		Integer bitlen=100;
		FileWriter fw=new FileWriter("primes_bitlen"+bitlen+".txt");
		//BigInteger p = new BigInteger(bitlen, rnd);
		//BigInteger q= (p.multiply(two)).subtract(one);
		
		int iteration=10;
		//BigInteger p = new BigInteger(bitlen, rnd);
		while(true)
		{
			BigInteger p = new BigInteger(bitlen, rnd);
			//performance
			
		    if(p.equals(zero) || p.equals(one))
				continue;
			if((squareMultipley.mod(p, two)).equals(zero))
				continue;
			
			if(squareMultipley.miller_rabin(p, 20))
			{
				
				if(p.equals(zero) || p.equals(one))
					continue;
				if((squareMultipley.mod(p, two)).equals(zero))
					continue;
				
				BigInteger q= (p.multiply(two)).add(one);
				if(squareMultipley.miller_rabin(q, 20))
				{
					System.out.println(p);
					fw.append("q : "+p);
					System.out.println(q);
					fw.append("\n2q+1 : "+q);
					break;
				}
			}
		}
		fw.close();
		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		System.out.println(elapsedTime+" ms");*/
		
		//multithreaded
		Int_set flag=new Int_set(0);
		MyThread mt1 = new MyThread (flag);
		MyThread mt2 = new MyThread (flag);
		MyThread mt3 = new MyThread (flag);
		MyThread mt4 = new MyThread (flag);
	    
		mt1.setName("mt1");
	    mt2.setName("mt2");
	    mt3.setName("mt3");
	    mt4.setName("mt4");
	    
	    mt1.start ();
	    mt2.start ();
	    mt3.start ();
	    mt4.start ();
	    
	    
	    mt1.join();
	    mt2.join();
	    mt3.join();
	    mt4.join();
	    long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		System.out.println(elapsedTime+" ms");
	    
	   // System.out.println("In main"+flag.get());
	}

}

class Int_set
{
	private int val;
	public Int_set(int val) 
	{
		this.val=val;
	} 
	
	void set(int s)
	{
		val=s;
	}
	int get()
	{
		return val;
	}
}


class MyThread extends Thread
{
	
	public static final Random rnd = new Random();
	Int_set flag;
	int bitlen;
	public MyThread(Int_set flag) 
	{
		this.flag=flag;
	}

   public void run ()
   {
	   BigInteger zero=new BigInteger("0");
   	   BigInteger one=new BigInteger("1");
       BigInteger two=new BigInteger("2");
       BigInteger three=new BigInteger("3");
       BigInteger seven=new BigInteger("7");
       BigInteger elvn=new BigInteger("11");
		
	    Integer bitlen=128;	
		//int iteration=10;
		
		synchronized (flag) 
		{
			if(flag.get()==1)
				return;
			while(true)
			{
				BigInteger p = new BigInteger(bitlen, rnd);
				//performance
			
				if(p.equals(zero) || p.equals(one))
					continue;
				if((squareMultipley.mod(p, two)).equals(zero) || (squareMultipley.mod(p, three)).equals(zero) || (squareMultipley.mod(p, seven)).equals(zero) || (squareMultipley.mod(p, elvn)).equals(zero))
					continue;
			
				if(squareMultipley.miller_rabin(p, 5))
				{								
					BigInteger q= (p.multiply(two)).add(one);
					if(q.equals(zero) || q.equals(one))
						continue;
					if((squareMultipley.mod(p, two)).equals(zero) || (squareMultipley.mod(p, three)).equals(zero) || (squareMultipley.mod(p, seven)).equals(zero) || (squareMultipley.mod(p, elvn)).equals(zero))
						continue;
					if(squareMultipley.miller_rabin(q, 5))
					{
						flag.set(1);
						//System.out.println(flag.get());
						System.out.println(this.getName());
						System.out.println(p);	
						System.out.println(q);
						break;
					}
				}
			}
		}
   }
}
