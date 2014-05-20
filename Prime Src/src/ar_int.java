//*************************************************************************************
//*********************************************************************************** *
//author Aritra Dhar																* *
//MT12004																			* *
//M.TECH CSE																		* * 
//INFORMATION SECURITY																* *
//IIIT-Delhi																		* *
//custom build Integer class for high bit operation									* *
//*********************************************************************************** *
//*************************************************************************************

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;



//x bit integer
//0 positive
//1 negetive

public class ar_int 
{	
	public static int x=800, out_bit=2*x;
	
	public static int[] a=new int[x+1]; 
	public static int[] b=new int[x+1];
	public static int[] a_back=new int[x+1]; 
	public static int[] b_back=new int[x+1];
	public static int[] out=new int[out_bit+1];
	public static int[] gcd=new int[x];
	public static int[] temp=new int[x];
	public static int[] zero=new int[x];
	public static int[] one=new int[x]; 
	public static int[] r=new int[x+1];
	public static int[] q=new int[x]; 
	
	public ar_int()
	{
		//initialize
		for (int i=0;i<x;i++)
		{
			a[i]=0;
			b[i]=0;
		}
				
		int[] ran_a=new int [x];
		int[] ran_b=new int [x];
		
	
		for (int i=0;i<x;i++)
		{
			float t1=(float) (Math.random()*100);
			float t2=(float) (Math.random()*100);
			a[i]=(int) t1%10;
			b[i]=(int) t2%10;
			a_back[i]=(int) t1%10;
			b_back[i]=(int) t2%10;
			
		}
		float t1=(float) (Math.random()*10);
		float t2=(float) (Math.random()*100);
		a[x]=(int) t1%2;
		b[x]=(int) t2%2;
		a_back[x]=(int) t1%2;
		b_back[x]=(int) t2%2;
	}
	
	public ar_int(int ch) 
	{
		//initialize
		for (int i=0;i<x;i++)
		{
			a[i]=0;
			b[i]=0;
		}
		
		System.out.print("no 1 : ");
		String a_s = new String();
		try
		{
			a_s = new BufferedReader(new InputStreamReader(System.in)).readLine();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		System.out.print("no 2 : ");
		String b_s = new String();
		try 
		{
			b_s = new BufferedReader(new InputStreamReader(System.in)).readLine();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		for (int i=0;i<a_s.length();i++)
		{
			Character a_c=a_s.charAt(a_s.length()-i-1);
			a[i]=Integer.parseInt(a_c.toString());
			a_back[i]=Integer.parseInt(a_c.toString());
		}
		
		for (int i=0;i<b_s.length();i++)
		{
			Character b_c=b_s.charAt(b_s.length()-i-1);
			b[i]=Integer.parseInt(b_c.toString());
			b_back[i]=Integer.parseInt(b_c.toString());
		}
		
		for(int i=0;i<x;i++)
		{
			out[i]=a[i]+b[i];
		}
		
	}
	
	public static void Display() throws IOException
	{
		int flag_0=0,flag_1=0;
		FileWriter fw=new FileWriter("out.txt");
		System.out.print("Random no 1 : ");
		
		if(a_back[x]==0)
		{
			System.out.print("+ ");
			fw.append("+ ");
		}
		if(a_back[x]==1)
		{
			System.out.print("- ");
			fw.append("- ");
		}
		for(int i=x-1;i>=0;i--)
		{
			System.out.print(a_back[i]);
			fw.append(a_back[i]+"");
		}
		
		System.out.print("\n");
		fw.append("\n");
		
		System.out.print("Random no 2 : ");
		//fw.append("*");
		if(b_back[x]==0)
		{
			System.out.print("+ ");
			fw.append("+ ");
		}
		if(b_back[x]==1)
		{
			System.out.print("- ");
			fw.append("- ");
		}
		
		for(int i=x-1;i>=0;i--)
		{
			System.out.print(b_back[i]);
			fw.append(b_back[i]+"");
		}
		System.out.print("\n");
		fw.append("\n");
		
		
		System.out.print("Result : ");
		
		if(out[out_bit]==0)
		{
			System.out.print("+ ");
			fw.append("+ ");
		}
		if(out[out_bit]==1)
		{
			System.out.print("- ");
			fw.append("- ");
		}
		for(int i=out_bit-1;i>=0;i--)
		{
			flag_1=1;
			System.out.print(out[i]+"");
			fw.append(out[i]+"");
		}
		
		fw.close();
		System.out.println("\nDone!!!");
		
	}
	
	public static boolean evenORodd(int[] a)
	{
		if(a[0]%2==0)
			return true;
		else
			return false;
	}
	
	public static int length(int[] in)
	{
		Integer len=new Integer(0);
		for(int i=x-1;i>=0;i--)
		{
			if(in[i]==0)
				continue;
			if(in[i]>0)
			{
				len=i;
				break;
			}
		}
		//System.out.println(len+1);
	return (len+1);		
	}
	
	public static int one(int[] a)
	{
		// see if a vector is 1
		//1 yes
		//0 no
		int flag=0;
		int count=0;
		if(a[0]==1)
		{
			for(int i=x-1;i>=1;i--)
			{
				if(a[i]==0)
					count++;
			}
			if(count==x-1)
				flag=1;
			else
				flag=2;
		}
		
		if(a[0]!=1)
			flag=2;
		
		if(flag==1)
			return 1;
		else
			return 0;
	}
	
	public static int[] def_zero()
	{
		for(int i=0;i<x;i++)
		{
			zero[i]=0;
		}
		return zero;
	}
	
	public static int[] def_one()
	{
		one[0]=1;
		for(int i=1;i<x;i++)
		{
			one[i]=0;
		}
		return one;
	}
	
	public static int compare(int[] a1,int[] a2)
	{
		//System.out.println(a[x]+" "+b[x]);
		int p=ar_int.length(a1);
		int q=ar_int.length(a2);
		int c=0;
		int flag=0;
		// 0 a1>a2
		// 2 a1=a2
		// 1 a1<a2
		//System.out.println(a1[x]+""+a2[x]);
		if(a1[x]==0 && a2[x]==0)
		{
			//System.out.println("in 1"); 
			if(p>q)
				flag=0; 
			if(p==q)
			{
				for(int i=x-1;i>=0;i--)
				{
					if(a[i]==b[i])
					{
						//System.out.print("in");
						c++;
						continue;
					}
					if(a[i]>b[i])
					{
						flag=0;
						break;
					}
					if(a[i]<b[i])
					{
						flag=1;
						break;
					}					
				}
			}
			if (c==x)
			{
				//System.out.print("in");
				flag=2;
			}
			if(p<q)
				flag=1;
		}
		
		if(a1[x]==1 && a2[x]==1)
		{
			//System.out.println("in 2");
			if(p>q)
				flag=1; 
			if(p==q)
			{
				for(int i=x-1;i>=0;i--)
				{
					if(a[i]==b[i])
					{
						//System.out.print("in");
						c++;
						continue;
					}
					if(a[i]>b[i])
					{
						flag=1;
						break;
					}
					if(a[i]<b[i])
					{
						flag=0;
						break;
					}					
				}
			}
			if(c==x)
				flag=2;
			if(p<q)
				flag=1;
		}
		
		if(a1[x]==0 && a2[x]==1)
		{
			//System.out.println("in 3");
			flag=0;
		}
		if(a1[x]==1 && a2[x]==0)
		{
			//System.out.println("in 4");
			flag=1;
		}
		
		
		if(flag==0)
			return 0;
		if(flag==1)
			return 1;
		else
			return 2;
	}
	
	public static void addition(int[] a,int[] b) throws IOException
	{	
		//out_bit=x;
		int flag=0;
		for (int i=0;i<out_bit;i++)
		{
			out[i]=0;
		}
		int p=0;
		
		if((a[x]==0 && b[x]==0) || (a[x]==1 && b[x]==1))
		{
			for(int i=0;i<x;i++)
			{
				if(a[i]+b[i]>0)
				{
					out[p+1]=(a[i]+b[i])/10;
					out[p]=(out[p]+a[i]+b[i])%10;
					p++;
				}
				else
				{
					out[p]=(out[p]+a[i]+b[i]);
					out[p+1]=(a[i]+b[i])/10;
					p++;
				}
			}
		}
	
		if(a[x]==0 && b[x]==0)
			out[out_bit]=0;
		if(a[x]==1 && b[x]==1)
			out[out_bit]=1;	
		
		
		if(a[x]==0 && b[x]==1)
		{//System.out.println("in1");
			b[x]=0;
			
			if(ar_int.compare(a, b)==0 && flag==0)
			{
				//System.out.println("in1");
				for(int i=0;i<x;i++)
				{
					if(a[i]-b[i]<0)
					{
						out[i]=(a[i]+10)-b[i];
						b[i+1]=b[i+1]+1;
					}
					if(a[i]-b[i]>=0)
					{
						out[i]=a[i]-b[i];
					}
				}
				out[out_bit]=0;
				flag=1;
			}		
			if(ar_int.compare(a, b)==1 && flag==0)
			{
				//System.out.println("in2");
				for(int i=0;i<x;i++)
				{
					if(b[i]-a[i]<0)
					{
						out[i]=(b[i]+10)-a[i];
						a[i+1]=a[i+1]+1;
					}
					if(b[i]-a[i]>=0)
					{
						out[i]=b[i]-a[i];
					}
				}
				out[out_bit]=1;
				b[x]=1;
			}
			//b[x]=1;
		}
		
		
		if(a[x]==1 && b[x]==0 && flag==0)
		{
			System.out.println("in");
			a[x]=0;
			//System.out.println(ar_int.compare(a, b));
			if(ar_int.compare(a, b)==0)
			{
				System.out.println("in1");
				for(int i=0;i<x;i++)
				{
					if(a[i]-b[i]<0)
					{
						out[i]=(a[i]+10)-b[i];
						b[i+1]=b[i+1]+1;
					}
					if(a[i]-b[i]>=0)
					{
						out[i]=a[i]-b[i];
					}
				}
				out[out_bit]=1;
				flag=1;
				//System.out.println(out[out_bit]);
				//a[x]=1;
			}
			
			//System.out.println(ar_int.compare(a, b));
			if(ar_int.compare(a, b)==1 & flag==0)
			{
				System.out.println("in2");
				for(int i=0;i<x;i++)
				{
					if(b[i]-a[i]<0)
					{
						out[i]=(b[i]+10)-a[i];
						a[i+1]=a[i+1]+1;
					}
					if(b[i]-a[i]>=0)
					{
						out[i]=b[i]-a[i];
					}
				}
				out[out_bit]=0;
			}
			a[x]=0;
		}
		
		System.out.println(out[out_bit]);
		//return out;
		System.out.println("Addition");
		ar_int.Display();
	}
	
	public static void subtraction(int[]a, int[] b) throws IOException
	{	
		//out_bit=x;
		int p=0; 		
		for (int i=0;i<out_bit;i++)
		{
			out[i]=0;
		}
		
		//System.out.println(a[x]+" "+b[x]);
		int comp=ar_int.compare(a, b);
		System.out.println(comp);			
				
		if(comp==0)
		{
			if(a[x]==0 && b[x]==0)
			{
				for(int i=0;i<x;i++)
				{
					if(a[i]-b[i]<0)
					{
						out[i]=(a[i]+10)-b[i];
						b[i+1]=b[i+1]+1;
					}
					if(a[i]-b[i]>=0)
					{
						out[i]=a[i]-b[i];
					}
				}
				out[out_bit]=0;
			}
			if(a[x]==1 && b[x]==1)
			{
				//System.out.println("in");
				for(int i=0;i<x;i++)
				{
					if(b[i]-a[i]<0)
					{
						out[i]=(b[i]+10)-a[i];
						a[i+1]=a[i+1]+1;
					}
					if(b[i]-a[i]>=0)
					{
						out[i]=b[i]-a[i];
					}
				}
				out[out_bit]=0;
			}
			
			if(a[x]==0 && b[x]==1)
			{
				for(int i=0;i<x;i++)
				{
					if(a[i]+b[i]>0)
					{
						out[p+1]=(a[i]+b[i])/10;
						out[p]=(out[p]+a[i]+b[i])%10;
						p++;
					}
					else
					{
						out[p]=(out[p]+a[i]+b[i]);
						out[p+1]=(a[i]+b[i])/10;
						p++;
					}
				}
				out[out_bit]=0;
			}	
		}
		
		if(comp==1)
		{
			if(a[x]==0 && b[x]==0)
			{
				for(int i=0;i<x;i++)
				{
					if(b[i]-a[i]<0)
					{
						out[i]=(b[i]+10)-a[i];
						a[i+1]=a[i+1]+1;
					}
					if(b[i]-a[i]>=0)
					{
						out[i]=b[i]-a[i];
					}
				}
				out[out_bit]=1;
			}
			
			if(a[x]==1 && b[x]==1)
			{
				for(int i=0;i<x;i++)
				{
					if(a[i]-b[i]<0)
					{
						out[i]=(a[i]+10)-b[i];
						b[i+1]=b[i+1]+1;
					}
					if(a[i]-b[i]>=0)
					{
						out[i]=a[i]-b[i];
					}
				}
				out[out_bit]=1;
			}
			
			if(a[x]==1 && b[x]==0)
			{
				for(int i=0;i<x;i++)
				{
					if(a[i]+b[i]>0)
					{
						out[p+1]=(a[i]+b[i])/10;
						out[p]=(out[p]+a[i]+b[i])%10;
						p++;
					}
					else
					{
						out[p]=(out[p]+a[i]+b[i]);
						out[p+1]=(a[i]+b[i])/10;
						p++;
					}
				}
				out[out_bit]=1;
			}
		}
		
		//return out;
		System.out.println("Subtraction");
		ar_int.Display();
	}



	public  void multiplication(int[] a, int[] b) throws IOException
	{		 
		int[][] shift_mul=new int[x][out_bit];
		
		for (int i=0;i<x;i++)
		{
			for(int j=0;j<out_bit;j++)
			{
				shift_mul[i][j]=0;
			}
		}
		for (int i=0;i<out_bit;i++)
		{
			out[i]=0;
		}
		
		//multiplication
		
		int p=0,temp=0;
				
		int count=0;
		
		for(int i=0;i<x;i++)
		{
			p=0;
			for(int j=0;j<x;j++)
			{
				temp=0;
				if((a[j]*b[i])>0)
				{
					temp=shift_mul[i][p+count]+(a[j]*b[i]);
					shift_mul[i][p+count]=(shift_mul[i][p+count]+(a[j]*b[i]))%10;				
					shift_mul[i][p+count+1]=(temp)/10;	
					
					p++;
				}
				else
				{
					shift_mul[i][p+count]=(shift_mul[i][p+count])+(a[j]*b[i]);
					p++;
				}
			}
			count++;
		}
		
		for(int i=0;i<out_bit;i++)
		{
			for(int j=0;j<x;j++)
			{
				out[i]+=shift_mul[j][i];
			}
		}
		if((a[x]==0 && b[x]==0)||(a[x]==1 && b[x]==1))
		{
			out[out_bit]=0;
		}
		if((a[x]==0 && b[x]==1)||(a[x]==1 && b[x]==0))
		{
			out[out_bit]=1;
		}
		
		for(int i=0;i<out_bit;i++)
		{
			if(out[i]>0)
			{
				out[i+1]=out[i+1]+(int)(out[i]/10);
				out[i]=out[i]%10;
			}
		}
				
		/*for(int i=0;i<x;i++)
		{
			for(int j=out_bit-1;j>=0;j--)
				System.out.print(shift_mul[i][j]);
			System.out.print("\n");
		}*/
		//return out;
		System.out.println("Multiplication");
		 ar_int.Display();
		
	}
	
	public static void gcd(int[] a, int[] b) throws IOException
	{
		a[x]=0;
		b[x]=0;
		
		for (int i=0;i<x;i++)
		{
			temp[i]=0;
		}
		int[] temp1=new int[x];
		int c=0;
		while((ar_int.compare(a, b)!=2))
		{
			c++;
			/*if(ar_int.one(a)==1)
			{
				for (int i=0;i<x;i++)
				{
					gcd[i]=a[i];
				}
				break;
			}
			
			if(ar_int.one(b)==1)
			{
				for (int i=0;i<x;i++)
				{
					gcd[i]=b[i];
				}
				break;
			}*/
			
				
			for (int i=0;i<x;i++)
			{
				temp[i]=0;
			}
			for (int i=0;i<x;i++)
			{
				temp1[i]=0;
			}
			
			if(ar_int.compare(a, b)==0)
			{
				//System.out.println("in");
				for (int i=0;i<x;i++)
				{
					temp1[i]=b[i];
				}
				
				//for (int i=x-1;i>=0;i++)
			//	{
				//	System.out.print(temp[i]);
				//}

				for(int i=0;i<x;i++)
				{
					if(a[i]-temp1[i]<0)
					{
						temp[i]=(a[i]+10)-temp1[i];
						temp1[i+1]=temp1[i+1]+1;
						if(c==1)
						{
							//System.out.println(temp[i]);
						}
					}
					if(a[i]-temp1[i]>=0)
					{
						temp[i]=a[i]-temp1[i];
					}
				}
			
				
				for (int i=0;i<x;i++)
				{
					a[i]=temp[i];
				}
				a[x]=0;
				
				//debug
				/*System.out.print("1a:");
				for(int i=x-1;i>=0;i--)
				{
					System.out.print(a[i]);
				}
				System.out.print("\n");
				System.out.print("1b:");
				for(int i=x-1;i>=0;i--)
				{
					System.out.print(b[i]);
				}
				System.out.print("\n");
				*/
			}
			
			if(ar_int.compare(a, b)==1)
			{
				for (int i=0;i<x;i++)
				{
					temp1[i]=a[i];
				}
				//System.out.println("in1");
				for(int i=0;i<x;i++)
				{
					if(b[i]-temp1[i]<0)
					{
						temp[i]=(b[i]+10)-temp1[i];
						temp1[i+1]=temp1[i+1]+1;
					}
					if(b[i]-temp1[i]>=0)
					{
						temp[i]=b[i]-temp1[i];
					}
				}
				for (int i=0;i<x;i++)
				{
					b[i]=temp[i];
				}
				b[x]=0;				
				//debug
				/*
				System.out.print("2a:");
				for(int i=x-1;i>=0;i--)
				{
					System.out.print(a[i]);
				}
				System.out.print("\n");
				System.out.print("2b:");
				for(int i=x-1;i>=0;i--)
				{
					System.out.print(b[i]);
				}
				System.out.print("\n");
				*/
			}			
		}

		for (int i=0;i<x;i++)
		{
			gcd[i]=a[i];
		}
	}
	
	public void division(int[] a,int[] b)
	{
		int carry,temp;
		for(int i=0;i<x;i++)
		{
			r[i]=a[i];
		}
		int i=0;
		q[i]=(r[i+x]*10+r[i+x-1])/b[x-1];
		if(q[i]>=10)
			q[i]=9;
		carry=0;
		for(int j=0;j<x;j++)
		{
			temp=r[i+j]-q[i]*b[j]+carry;
			carry=temp/10;
			r[i+j]=temp%10;
		}
		r[i+x]=r[i+x]+carry;
		while(r[i+x]<0)
		{
			carry=0;
			for(int j=0;j<x;j++)
			{
				temp=r[i+j]+b[i]+carry;
				carry=temp/10;
				r[i+j]=temp%10;
			}
			r[i+x]=r[i+x]+carry;
			q[i]=q[i]-1;
		}
	}
	
	public static void main(String[] arg) throws IOException
	{
		
		FileWriter fw1=new FileWriter("a.txt");
		
		ar_int obj=new ar_int();
	    obj.multiplication(a,b);
		/*System.out.print("a::");
		for(int i=x-1;i>=0;i--)
		{
			System.out.print(a[i]);
		}
		System.out.println();
		System.out.print("b::");
		for(int i=x-1;i>=0;i--)
		{
			System.out.print(b[i]);
		}
		obj.division(a, b);
		for(int i=x-1;i>=0;i--)
		{
			System.out.print(q[i]);
		}
		System.out.print("\n\n");
		for(int i=x;i>=0;i--)
		{
			System.out.print(r[i]);
		}
		*/
		//obj.multiplication(a,a);
		//ar_int.addition(a,b);
		//obj.subtraction(a,b);
		//System.out.println(obj.compare(a, b));
		
		
		/*for(int i=x-1;i>=0;i--)
		{
			System.out.print(a_back[i]+"");
			fw1.append(a_back[i]+"");
		}
		System.out.print("\n");
		fw1.append("\n");
		for(int i=x-1;i>=0;i--)
		{
			System.out.print(b_back[i]+"");
			fw1.append(b_back[i]+"");
		}
		System.out.print("\n");
		fw1.append("\n"); 
		fw1.close();
		ar_int.gcd(a,b);
	
		for(int i=x-1;i>=0;i--)
		{
			System.out.print(gcd[i]+"");
		}
		*/
		
		
		//ar_int.Display();
	}

}
