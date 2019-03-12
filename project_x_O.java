import java.util.*;
import java.awt.*;
import java.io.*;
class project_x_O
{
	public static void main(String args[])throws InterruptedException, IOException
	{	
		Thread td=new Thread();
		Scanner sc=new Scanner(System.in);
		char[][] a=new char[5][5];
		char[][] b=new char[5][5];
		String[] p=new String[2];
		int j=0,k=1,p1_wins=0,p2_wins=0,i=0,draw=0,in=10,ch,level;
		do
		{
	        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		System.out.println("Enter \n1-To play single player\n2-To play two player\n3-To exit");
		ch=sc.nextInt();		
		if(ch==2)
		{
		        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			p1_wins=0;p2_wins=0;draw=0;
			System.out.println("Enter your names");
			p[0]=sc.nextLine();
			p[0]=sc.nextLine();
			p[1]=sc.nextLine();

			do
			{
				a=initial_a();
				display(a);
				System.out.println();
				System.out.println();
				char n='x',che;
				int range[]={1,2,3,4,5,6,7,8,9},end=0,d=0;
				win_end :
				do
				{	
					if(k==0)
					k=1;
					else
					k=0;
					System.out.println("Player "+p[k]+" enter position on which "+n+" to be placed   ");
					in=sc.nextInt();
					for(i=0;i<(range.length-d);i++)
					{
						if(range[i]==in)
						{
							j=1;
							for(i=i;i<(range.length-d-1);i++)
							range[i]=range[(i+1)];
							d++;
							a=change(a,in,n);
							System.out.println();
							System.out.println();
							System.out.println();
							display(a);
							System.out.println();
							System.out.println();
							System.out.println();
							che=check_win(a,'x');
							if(che!='x')
								che=check_win(a,'O');
							if(che!='0')
							{
								System.out.println(p[k]+" win playing with "+che+"\n\n");
								if(k==0)
								p1_wins++;
								else
								p2_wins++;
								break win_end;
							}
							end++;
							if(n=='x')
							n='O';
							else
							n='x';
						}
					}
					if(j==0)
						System.out.println("\n\nInvalid option\n\n");
					j=0;
				}while(end!=9);
				if(end==9)
				{	
					System.out.println("\nThe game is draw\n\n");
					draw++;
				}
				score(p1_wins,p2_wins,draw,p);
				j=redo();							
			}while(j==0);
		}
		else if(ch==1)
		{
		        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			p1_wins=0;p2_wins=0;draw=0;
			do
			{
				System.out.println("Select level\n1-EASE\n2-MODERATE\n3-DIFFICULT");
				level=sc.nextInt();
				if(level>3&&level<1)
					System.out.println("Invalid choice");	
			}while(level>3&&level<1);
			System.out.println("Enter your name");
			p[0]=sc.nextLine();
			p[0]=sc.nextLine();
			p[1]="Computer";
			do
			{
		        	new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
				a=initial_a();
				display(a);
				System.out.println();
				System.out.println();
				char n='x',che;
				int e,range[]={1,2,3,4,5,6,7,8,9},end=0,d=0;
				win_end :
				do
				{	
					if(k==0)
						k=1;
					else
						k=0;
					if(k==0)
					{	
						do
						{
						j=0;
						System.out.print(p[0]+" enter position on which "+n+" to be placed  : ");
						in=sc.nextInt();
						System.out.println();
						System.out.println();
						System.out.println();
						for(i=0;i<(range.length-d);i++)
						{
							if(range[i]==in)
							{
								j=1;
								for(i=i;i<(range.length-d-1);i++)
								range[i]=range[(i+1)];
								d++;
								a=change(a,in,n);
								display(a);
								System.out.println();
								System.out.println();
								System.out.println();
								che=check_win(a,'x');
								if(che!='x')
									che=check_win(a,'O');
								if(che!='0')
								{
									System.out.println(p[k]+" win playing with "+che);
									if(k==0)
									p1_wins++;
									else
									p2_wins++;
									break win_end;
								}
								end++;
							}
						}
						if(j==0)
						System.out.println("Invalid option");
						}while(j==0);
					}
					else if(k==1)
					{
						if(level==1)
						{
							in=AI(a,n,range,d,1,2);
							if(in==10)
								in=AI_2(range,d);
						}
						else if(level==2)
						{
							in=AI(a,n,range,d,1,2);
							if(in==10)
							{
								in=AI(a,n,range,d,2,2);
								if(in==10)
									in=AI_2(range,d);
							}
						}
						else if(level==3)
						{
							in=AI(a,n,range,d,1,2);
							if(in==10)
							{
								in=search_hard(a,n,d,range);
								if(in==10)
								{
									in=AI(a,n,range,d,2,2);
									if(in==10)
										in=AI_2(range,d);
								}
							}
						}
						j=0;
						for(i=0;i<(range.length-d);i++)
						{
							if(range[i]==in)
							{
								j=1;
								for(i=i;i<(range.length-d-1);i++)
									range[i]=range[(i+1)];
								d++;
								System.out.println("Wait its computer's turn");
								System.out.println();
								System.out.println();
								td.sleep(1000);
								a=change(a,in,n);
								display(a);
								System.out.println();
								System.out.println();
								System.out.println();
								che=check_win(a,'x');
								if(che!='x')
									che=check_win(a,'O');
								if(che!='0')
								{
									System.out.println(p[k]+" win playing with "+che);
									if(k==0)
										p1_wins++;
									else
										p2_wins++;
									break win_end;
								}
								end++;
							}
						}
						if(j==0)
							System.out.println("Invalid option");	
						j=0;
					}				
					if(n=='x')
						n='O';
					else
						n='x';
				}while(end!=9);
				if(end==9)
				{	
					System.out.println("The game is draw");
					draw++;
				}
				score(p1_wins,p2_wins,draw,p);
				j=redo();						
			}while(j==0);
		}			
		else if(ch==3)
			break;
		else 
			System.out.println("Invalid choice");
		}while((ch!=1)||(ch!=2)||(ch!=3));
	}
	static int AI(char a[][],char ni,int range[],int d,int tuf,int ease)
	{
		int e=0,in=10,i,j,k;
		char che,no;
		char[][] b=new char[5][5];
		b=a;
		for(k=0;k<2;k++)
		{
			in=0;
			no='0'; 
			if(ease>1)
			{
				if(k==1)
				{
					if(ni=='x')
					ni='O';
					else
					ni='x';
				}
			}
			for(i=0;i<5;i=i+2)
			{
				for(j=0;j<5;j=j+2)
				{
					no++;
					in++;
					e=0;
					if(Arrays.equals(a,b))
					e=1;
					if(e==1)
					{	
						if(a[i][j]==no)
						{
							b=change(a,in,ni);
							che=check_win(b,ni);
							if(che!=ni)
							{
								if(tuf==2)
								{	
									int y=0;
									char[][] c=new char[5][5];
									char g=ni;
									for(int r=0;r<2;r++)
									{
										c=b;
										y=0;
										int s=0;
										char t='0'; 
										if(r==1)
										{
											if(g=='x')
											g='O';
											else
											g='x';
										}
										for(int u=0;u<5;u=u+2)
										{
											for(int v=0;v<5;v=v+2)
											{
												t++;
												s++;
												e=0;
												if(Arrays.equals(c,b))
												e=1;
												if(e==1)
												{	
													if(b[u][v]==t)
													{	
														c=change(b,s,g);			
														che=check_win(c,g);			
														if(che!=g)
														b=change(b,s,t);
														else
														{
															y++;
															b=change(b,s,t);
														}
													}
												}
											}
										}
										if(y>1)
											return in;	
									}
									
								}
								b=change(b,in,no);
							}
							else
							{
								b=change(b,in,no);
								return in;
							}	
						}
					}
				}
			}	
		}
	return 10;
	}
	static int AI_2(int range[],int d)
	{	
		int in=9;
		there :
		for(int j=0;j<100;j++)
		{
			in=(int)(Math.random()*10);
			for(int i=0;i<(range.length-d);i++)
			{
				if((in==range[i]))
				break there;
			}
		}
	return in;
	}		
	static char[][] initial_a()
	{
		char[][] a=new char[5][5];
		a[0][0]='1'; a[0][1]='|'; a[0][2]='2'; a[0][3]='|'; a[0][4]='3';
		a[1][0]='-'; a[1][1]='-'; a[1][2]='-'; a[1][3]='-'; a[1][4]='-';
		a[2][0]='4'; a[2][1]='|'; a[2][2]='5'; a[2][3]='|'; a[2][4]='6';
		a[3][0]='-'; a[3][1]='-'; a[3][2]='-'; a[3][3]='-'; a[3][4]='-';
		a[4][0]='7'; a[4][1]='|'; a[4][2]='8'; a[4][3]='|'; a[4][4]='9';
		return a;
	}
	static void score(int p1_wins,int p2_wins,int draw,String[] p)
	{
		System.out.println("\n\nScore board\n"+p[0]+"\t=>\t"+p1_wins+"\n"+p[1]+"\t=>\t"+p2_wins+"\nDraw\t\t=>\t"+draw+"\n\n\n");			
	}
	static int redo()
	{		
		Scanner sc=new Scanner(System.in);
		int d;	
		System.out.println("\nEnter \n1-To play again \n2-To exit \n\n");
		d=sc.nextInt();
		switch(d)
		{
			case 1 :
				return 0;
			case 2 :
				return 1;
			default :
				System.out.println("Invalid option");
				return (redo());
		}
	}
	static char check_win(char a[][],char n)
	{
		if(((a[0][0]==n)&&(a[2][0]==n)&&(a[4][0]==n))||((a[0][2]==n)&&(a[2][2]==n)&&(a[4][2]==n))||((a[0][4]==n)&&(a[2][4]==n)&&(a[4][4]==n))||((a[0][0]==n)&&(a[0][2]==n)&&(a[0][4]==n))||((a[2][0]==n)&&(a[2][2]==n)&&(a[2][4]==n))||((a[4][0]==n)&&(a[4][2]==n)&&(a[4][4]==n))||((a[0][0]==n)&&(a[2][2]==n)&&(a[4][4]==n))||((a[0][4]==n)&&(a[2][2]==n)&&(a[4][0]==n)))
	return n;
	else
	return '0';
	}
	static char[][] change(char a[][],int in,char n)
	{
		switch(in)
		{
			case 1 :
				a[0][0]=n;
				break;
			case 2 :
				a[0][2]=n;
				break;
			case 3 :
				a[0][4]=n;
				break;
			case 4 :
				a[2][0]=n;
				break;
			case 5 :
				a[2][2]=n;
				break;
			case 6 :
				a[2][4]=n;
				break;
			case 7 :
				a[4][0]=n;
				break;
			case 8 :
				a[4][2]=n;
				break;
			case 9 :
				a[4][4]=n;
				break;
			default :
				System.out.println("invalid choice");
		}
	return a;
	}
	static void display(char a[][])
	{
		System.out.println();	
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
			{
				System.out.print(a[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	static int search_hard(char c[][],char n,int d,int range[])
	{
		int i,z,in=10;
		char[][] b=new char[5][5];
		z=(int)(Math.random()*100);
		if(d==1)
		{
			if(c[0][0]=='x')
			{
				if(z<50)
					in=5;
				else if(z<100)
					in=9;
			}
			if(c[0][4]=='x')
			{
				if(z<50)
					in=5;
				else if(z<100)
					in=7;
			}
			if(c[4][0]=='x')
			{
				if(z<50)
					in=5;
				else if(z<100)
					in=3;
			}
			if(c[4][4]=='x')
			{
				if(z<50)
					in=5;
				else if(z<100)
					in=1;
			}
			if(c[2][0]=='x')
			{
				if(z<50)
					in=5;
				else if(z<100)
					in=6;
			}
			if(c[0][2]=='x')
			{
				if(z<50)
					in=5;
				else if(z<100)
					in=8;
			}
			if(c[4][2]=='x')
			{
				if(z<50)
					in=5;
				else if(z<100)
					in=2;
			}
			if(c[2][4]=='x')
			{
				if(z<50)
					in=5;
				else if(z<100)
					in=4;
			}
			if(c[2][2]=='x')
				if(z<25)
					in=1;
				else if(z<50)
					in=3;
				else if(z<75)
					in=7;
				else if(z<100)
					in=9;
		}
		else
		{
			in=find_hard1(c,z,n);
			for(i=0;i<2;i++)
			{
				if(in==10)
				{
					if(i==1)
						c=transpose(c);
					in=find_hard2(c,z,n,d,range);
					if(in==10)
					{
						b=flip_L_R(c);
						in=find_hard2(b,z,n,d,range);
						in=flip_L_R_no(in);
						if(in==10)
						{
							b=flip_T_B(c);
							in=find_hard2(b,z,n,d,range);
							in=flip_T_B_no(in);
							if(in==10)
							{	
								b=flip_L_R(c);
								b=flip_T_B(b);
								in=find_hard2(b,z,n,d,range);
								in=flip_T_B_no(in);
								in=flip_L_R_no(in);			
							}
						}
					}
					if(i==1)
						in=flip_transpose_no(in);
				}
			}
		}
		return in;
	}
	static int find_hard1(char a[][],int z,char n)	
	{
		int in=10;
		char m;
		if(n=='x')
			m='O';
		else
			m='x';
		if(((a[0][0]==m)&&(a[0][2]=='2')&&(a[0][4]=='3')&&(a[2][0]=='4')&&(a[2][2]==n)&&(a[2][4]=='6')&&(a[4][0]=='7')&&(a[4][2]=='8')&&(a[4][4]==m))||((a[0][0]=='1')&&(a[0][2]=='2')&&(a[0][4]==m)&&(a[2][0]=='4')&&(a[2][2]==n)&&(a[2][4]=='6')&&(a[4][0]==m)&&(a[4][2]=='8')&&(a[4][4]=='9')))
		{
			if(z<25)
			in=2;
			if(z<50)
			in=4;
			if(z<75)
			in=6;
			if(z<100)
			in=8;
		}	
		if(((a[0][0]==m)&&(a[0][2]=='2')&&(a[0][4]=='3')&&(a[2][0]=='4')&&(a[2][2]==m)&&(a[2][4]=='6')&&(a[4][0]=='7')&&(a[4][2]=='8')&&(a[4][4]==n))||((a[0][0]==n)&&(a[0][2]=='2')&&(a[0][4]=='3')&&(a[2][0]=='4')&&(a[2][2]==m)&&(a[2][4]=='6')&&(a[4][0]=='7')&&(a[4][2]=='8')&&(a[4][4]==m)))
		{
			if(z<50)
			in=3;
			if(z<100)
			in=7;
		 }
		if(((a[0][0]=='1')&&(a[0][2]=='2')&&(a[0][4]==m)&&(a[2][0]=='4')&&(a[2][2]==m)&&(a[2][4]=='6')&&(a[4][0]==n)&&(a[4][2]=='8')&&(a[4][4]=='9'))||((a[0][0]=='1')&&(a[0][2]=='2')&&(a[0][4]==n)&&(a[2][0]=='4')&&(a[2][2]==m)&&(a[2][4]=='6')&&(a[4][0]==m)&&(a[4][2]=='8')&&(a[4][4]=='9')))
		{
			if(z<50)
			in=1;
			if(z<100)
			in=9;
		}
		return in;
	}
	static int AI_O(int q,int y,int u,int w,int v,int x)
	{	
		int a=1,in=10;
		there :
		do
		{
			in=(int)(Math.random()*10);
			{
				if((in!=0)&&(in!=10)&&(in!=q)&&(in!=y)&&(in!=u)&&(in!=w)&&(in!=v)&&(in!=x))
				{
					a=0;
					break there;
				}
			}
		}while(a==1);
	return in;
	}
	static int find_hard2(char a[][],int z,char n,int d,int range[])	
	{	
		int q,in=10,u=10,v=10,w=10,x=10,y=10;
		char m;
		if(n=='x')
			m='O';
		else
			m='x';
		if(d==2)
		{
			if(a[0][0]==n)
			{
				y=1;
				q=find_pos(a,m);
				switch(q)
				{
					case 3 :
						u=2;
						break;
					case 6 :
						u=2;	
						v=4;
						break;
					case 9 :
						u=2;
						v=4;
						break;
				}			
			in=AI_O(q,y,u,v,w,x);			
			}
			if(a[0][2]==n)
			{
				y=2;
				q=find_pos(a,m);
				switch(q)
				{
					case 1 :
						u=3;
						v=6;
						w=8;
						x=9;
						break;
					case 4 :
						u=3;
						break;	
					case 5 :
						u=8;
						break;
					case 7 :
						u=3;
						v=4;
						w=6;
						x=8;
						break;
					case 8 :
						u=1;
						v=3;
						break;
				}
			in=AI_O(q,y,u,v,w,x);			
			}
		}
		if(d==3)
		{
			if((a[0][2]==m)&&(a[2][0]==m))
			{
				q=find_pos(a,n);
				switch(q)
				{
					case 1 :	
						if(z<50)
						in=6;
						else if(z<100)
						in=8;
						break;
					case 3 :	
						if(z<50)
						in=5;
						else if(z<100)
						in=9;
						break;
					case 5 :	
						if(z<33)
						in=1;
						else if(z<66)
						in=3;
						else if(z<100)	
						in=7;
						break;
					case 6 :
						if(z<100)
						in=7;
						break;
					case 7 :
						if(z<33)
						in=5;
						else if(z<66)
						in=6;
						else if(z<100)
						in=9;
						break;
					case 8 :
						if(z<100)
						in=3;
						break;
					case 9 :
						if(z<50)
						in=7;
						else if(z<100)
						in=3;
						break;	
				}
			}
			if((a[0][2]==m)&&(a[4][0]==m))
			{
				q=find_pos(a,n);
				switch(q)
				{
					case 1 :
					if(z<100)
						in=5;
						break;
					case 3 :
						if(z<100)
						in=5;
						break;
					case 4 :	
						if(z<100)
						in=5;
						break;
					case 5 :
						if(z<33)
						in=1;
						else if(z<66)
						in=3;
						else if(z<100)
						in=6;
						break;
					case 6 :
						if(z<50)
						in=3;
						else if(z<100)
						in=5;
						break;
					case 8 :
						if(z<50)
						in=1;
						else if(z<100)
						in=3;
						break;
					case 9 :
						if(z<100)
						in=3;
						break;
				}
			}
		}
		if(d==5)
		{
			if((a[0][0]=='1')&&(a[0][2]==m)&&(a[0][4]=='3')&&(a[2][0]==n)&&(a[2][2]==n)&&(a[2][4]==m)&&(a[4][0]==m)&&(a[4][2]=='8')&&(a[4][4]=='9'))
			{
				if(z<33)
					in=1;
				else if(z<66)
					in=3;
				else if(z<100)
					in=9;
			}
			if((a[0][0]==n)&&(a[0][2]==m)&&(a[0][4]=='3')&&(a[2][0]=='4')&&(a[2][2]=='5')&&(a[2][4]=='6')&&(a[4][0]==m)&&(a[4][2]==n)&&(a[4][4]==m))	
			{
				if(z<33)
					in=3;
				else if(z<66)
					in=5;
				else if(z<100)
					in=6;
			}
			if((a[0][0]=='1')&&(a[0][2]==m)&&(a[0][4]==n)&&(a[2][0]=='4')&&(a[2][2]=='5')&&(a[2][4]=='6')&&(a[4][0]==m)&&(a[4][2]==n)&&(a[4][4]==m))
			{
				if(z<33)
					in=1;
				else if(z<66)
					in=4;
				else if(z<100)
					in=5;
			}
			if((a[0][0]=='1')&&(a[0][2]==m)&&(a[0][4]==n)&&(a[2][0]=='4')&&(a[2][2]=='5')&&(a[2][4]==m)&&(a[4][0]==m)&&(a[4][2]=='8')&&(a[4][4]==n))
			{
				if(z<33)
					in=4;
				else if(z<66)
					in=5;
				else if(z<100)
					in=8;
			}
		}
		return in;
	}
	static char[][] flip_L_R(char c[][])
	{
		char[][] b=new char[5][5];
		char f='x';
		int l,i,j,k;
		b=initial_a();
		for(k=0;k<2;k++)
		{
			if(k==1)
				f='O';
			for(i=0;i<5;i++)
			{
				l=5;
				for(j=0;j<5;j++)
				{
					l--;
					if(c[i][j]==f)
					{
						b[i][l]=f;
					}		
				}
			}
		}
	return b;
	}
	static char[][] flip_T_B(char c[][])
	{
		char[][] b=new char[5][5];
		char f='x';
		int l,i,j,k;
		b=initial_a();
		for(k=0;k<2;k++)
		{
			if(k==1)
				f='O';
			l=5;
			for(i=0;i<5;i++)
			{
				l--;
				for(j=0;j<5;j++)
				{
					if(c[i][j]==f)
					{
						b[l][j]=f;
					}		
				}
			}
		}
	return b;
	}
	static char[][] transpose(char c[][])
	{
		char[][] b=new char[5][5];
		char f='x';
		int l,i,j,k;
		b=initial_a();
		for(k=0;k<2;k++)
		{
			if(k==1)
				f='O';
			for(i=0;i<5;i=i+2)
			{
				for(j=0;j<5;j=j+2)
				{
					if(c[i][j]==f)
						b[j][i]=f;
				}
			}
		}
		return b;
	}
	static int flip_L_R_no(int no)
	{
		if(no==1)
			no=3;		
		else if(no==4)
			no=6;	
		else if(no==7)
			no=9;
		else if(no==3)
			no=1;
		else if(no==6)
			no=4;
		else if(no==9)
			no=7;
		return no;
	}
	static int flip_T_B_no(int no)
	{
		if(no==1)
			no=7;
		else if(no==2)
			no=8;	
		else if(no==3)
			no=9;
		else if(no==7)
			no=1;
		else if(no==8)
			no=2;
		else if(no==9)
			no=3;
		return no;
	}
	static int flip_transpose_no(int no)
	{
		if(no==2)
			no=4;
		else if(no==3)
			no=7;	
		else if(no==4)
			no=2;
		else if(no==6)
			no=8;
		else if(no==7)
			no=3;
		else if(no==8)
			no=6;
		return no;
	}
	static int find_pos(char a[][],char n)
	{
		int k=0;
		for(int i=0;i<5;i=i+2)
		{
			for(int j=0;j<5;j=j+2)
			{	
				k++;	
				if(a[i][j]==n)
				return k;
			}
		}
		return k;
	}
}