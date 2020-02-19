import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.event.*;
import java.util.*;
import java.awt.Graphics;

public class EggCatcher implements MouseMotionListener ,Runnable,ActionListener
{
	JFrame frame;
	JPanel mainpanel ,panel,rightpanel,rmainpanel,leftpanel,p ,scorepanel,pausepanel,gameoverpanel,addplayer,highscorepanel,helppanel;
	BorderLayout b1;
	Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
	double width=d.getWidth();
	double height=d.getHeight();
	int resumeflag;
	int b;
	JScrollPane scroll;
	Icon image,bu ,img,bimg;
	JButton start,help,highscore,exit,mainmenupause,resume,mainmenugameover,playagain,addok,addcancel,helpback,highscoreback;
	JButton pause;
	JLabel errorlabel;
	JLabel namelabel,helplabel,highscorepanellabel,highscorepanelnamelabel;
	JTextField nametext;
	JTextArea helptext;
	
	String playername,hsplayer,hsstr;
	
	JLabel l1,l2,l3,l4,l5,l6,l7,bucket;
	JTable table;
	
	JLabel HSnamelabel,HSlabel,lifeslabel,w,h,HSnamelabelpause,HSlabelpause,scorepause;
	Thread t1;
	JLabel life1,life2,life3,score,score1; 
	int gegg,begg;
	int scr,life,highscr;
	int y1,y2,y3,y4,y5,y6,y7,x7,x1,x2,x3,x4,x5,x6,bx;
	GridLayout g1;
	JLabel Blankl1,Blankl3,Blankl4,Blankl5;
	JLabel gameover ,gameoverhighscore,gameoverscore;
	
	Random r;
	public EggCatcher()
	{
		life=3;
		frame=new JFrame();
		panel=new Imgpanel("imgpanel.png",(int)(width),(int)(height));
		
		b1=new BorderLayout();
		mainpanel=new JPanel();
		r=new Random();
		
		x1=r.nextInt(900);
		x2=r.nextInt(900);
		x3=r.nextInt(950);
		x4=r.nextInt(950);
		x5=r.nextInt(950);
		x6=r.nextInt(950);
		//x7=r.nextInt(950);
		x7=10;
		t1=new Thread(this);
			
		startpanel();	
		createaddplayerpanel();
		createhighscorepanel();
		createhelppanel();
		createpausepanel();
		creategameoverpanel();

		mainpanel();
		bucket.setVisible(false);
		
		
		frame.add(mainpanel);
	//	p.setVisible(false);
		rightpanel.setVisible(false);
		rmainpanel.setVisible(false);
		leftpanel.setVisible(false);
		addplayer.setVisible(false);
		pausepanel.setVisible(false);
		gameoverpanel.setVisible(false);
		helppanel.setVisible(false);
		highscorepanel.setVisible(false);

		//frame.setUndecorated(true);
	
		frame.setSize((int)(width),(int)(height));
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) 
	{
			new EggCatcher();
	}
	public void mouseDragged(MouseEvent arg0) {
		
		
	}
	
	public void mouseMoved(MouseEvent e)
	{
		int x;
		x=e.getX();
		bx=x-100;
		if(bx<860 && bx>-20)
		{
			bucket.setBounds(bx, 520, 160, 117);
		}
	}
	
	
	
	public void run()
	{
		int g=0;
		b=0;
		int y=0;
		l1.setVisible(true);
		l2.setVisible(true);
		l3.setVisible(true);
		l4.setVisible(true);
		l5.setVisible(true);
		l6.setVisible(true);
		l7.setVisible(true);
		life1.setVisible(true);
		life2.setVisible(true);
		life3.setVisible(true);
		y1=-560;
		y2=-1050;
		y3=-1530;
		y4=-2000;
		y5=-400;
		y6=-3000;
		y7=-200;
		life=3;
		try
		{
			while(true)
			{
				if(highscr<scr)
				{
					int temp;
					temp=scr;
					HSnamelabelpause.setText("Highscore        "+temp);
					HSlabel.setText("         "+temp);
				}
				
				if(resumeflag==1)
				{
					t1.sleep(2000);
					resumeflag=0;
				}	
				
				y1++;y2++;y3++;y4++;y6++; g++;
				
				if(g>5000)
				{
					y5++;
				}
				
				if(life<3)
				{					
					b++;
					if(b>5000)
					{
						y7++;
					}	
				}
				
				if(y1>473)
				{
					y1=-560;
					x1=r.nextInt(900);
					
				}
				if(y2>473)
				{
					
					y2=-1110;
					x2=r.nextInt(900);
					
				}
				if(y3>473)
				{	
					y3=-1560;
					x3=r.nextInt(900);	
				}
				if(y4>473)
				{
				
					y4=-2000;
					x4=r.nextInt(900);
					
				}
				if(y5>473)
				{
					
					y5=-400;
					x5=r.nextInt(900);
					g=0;
					
				}
				if(y6>473)
				{
					y6=-3000;
					x6=r.nextInt(900);
				}
				
				if(y5>470)
				{
					gegg=1;	
				}
				if(y7>470)
				{
					begg=1;
				}
				
				
				Highscore(x1,y1,bx);
				Highscore(x2,y2,bx);
				Highscore(x3,y3,bx);
				Highscore(x4,y4,bx);
				Highscore(x5,y5,bx);
				Highscore(x6,y6,bx);
				Highscore(x7,y7,bx);
				
				l1.setBounds(x1, y1, 100, 100);
				l2.setBounds(x2, y2, 100, 100);
				l3.setBounds(x3, y3, 100, 100);
				l4.setBounds(x4, y4, 100, 100);
				l5.setBounds(x5, y5, 100, 100);
				l6.setBounds(x6, y6, 100, 100);
				l7.setBounds(x7, y7, 100, 100);
				
				
				
				t1.sleep(3);
			}
		}
		catch(Exception ee)
		{
			
		}
	}
	public void actionPerformed(ActionEvent evt) 
	{
		if(evt.getSource()==start)
		{
			addplayer.setVisible(true);
			p.setVisible(false);
			
		}
		if(evt.getSource()==highscore)
		{
			try
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con=DriverManager.getConnection("jdbc:odbc:MyJavaDb");
				PreparedStatement ps=con.prepareStatement("select * from eggcatcher where sno=1;");
				ResultSet rs=ps.executeQuery();		/// select
				if(rs.next())
				{
					hsplayer=rs.getString(2);
					hsstr=rs.getString(3);
				}	
			}
			catch(Exception ee)
			{}
			highscorepanellabel.setText(hsplayer+"                 "+hsstr);
			highscorepanel.setVisible(true);
			p.setVisible(false);
		}

		if(evt.getSource()==help)
		{
			helppanel.setVisible(true);
			p.setVisible(false);
		}
		if(evt.getSource()==exit)
		{
			System.exit(1);
		}
		if(evt.getSource()==addok)
		{
			if(nametext.getText().length()==0)
			{
				errorlabel.setVisible(true);
			}
			else
			{
				playername=nametext.getText();
				nametext.setText("");
				rightpanel.setVisible(true);
				rmainpanel.setVisible(true);
				leftpanel.setVisible(true);
				addplayer.setVisible(false);
				bucket.setVisible(true);
				t1=new Thread(this);
				t1.start();
				scr=0;
				score.setText("        "+scr+"      ");
				
			}
		}
		if(evt.getSource()==addcancel)
		{
			
			nametext.setText("");
			p.setVisible(true);
			addplayer.setVisible(false);
			
		}
		if(evt.getSource()==helpback)
		{
			helppanel.setVisible(false);
			p.setVisible(true);
			
		}
		if(evt.getSource()==highscoreback)
		{
			
			p.setVisible(true);
			highscorepanel.setVisible(false);
		}
		if(evt.getSource()==pause)
		{
			t1.suspend();
			if(scr>highscr)
			{	
				try
				{
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection con=DriverManager.getConnection("jdbc:odbc:MyJavaDb");
					PreparedStatement ps=con.prepareStatement("update eggcatcher set player='"+playername+"',highscore='"+scr+"'  where sno=1");
					int rs=ps.executeUpdate();		/// select
				
				}
				catch(Exception ee)
				{
			
				}
			}
			
			scorepause.setText("Score                "+scr);
			pausepanel.setVisible(true);
			l1.setVisible(false);
			l2.setVisible(false);
			l3.setVisible(false);
			l4.setVisible(false);
			l5.setVisible(false);
			l6.setVisible(false);
			l7.setVisible(true);
			bucket.setVisible(false);
			
		}
		if(evt.getSource()==resume)
		{
			pausepanel.setVisible(false);
			bucket.setVisible(true);
			l1.setVisible(true);
			l2.setVisible(true);
			l3.setVisible(true);
			l4.setVisible(true);
			l5.setVisible(true);
			l6.setVisible(true);
			l7.setVisible(true);
			resumeflag=1;
			t1.resume();
		}
		if(evt.getSource()==mainmenupause)
		{
			pausepanel.setVisible(false);
			bucket.setVisible(false);
			
			l1.setVisible(false);
			l2.setVisible(false);
			l3.setVisible(false);
			l4.setVisible(false);
			l5.setVisible(false);
			l6.setVisible(false);
			l7.setVisible(false);
			rightpanel.setVisible(false);
			rmainpanel.setVisible(false);
			p.setVisible(true);
			leftpanel.setVisible(false);
			t1.stop();
			
		}
		if(evt.getSource()==mainmenugameover)
		{
			bucket.setVisible(false);
			l1.setVisible(false);
			l2.setVisible(false);
			l3.setVisible(false);
			l4.setVisible(false);
			l5.setVisible(false);
			l6.setVisible(false);
			l7.setVisible(false);
			rightpanel.setVisible(false);
			rmainpanel.setVisible(false);
			leftpanel.setVisible(false);
			gameoverpanel.setVisible(false);
			p.setVisible(true);
		}
		if(evt.getSource()==playagain)
		{
			life=3;
			t1=new Thread(this);
			t1.start();
			scr=0;
			
			score.setText("        "+scr+"      ");
			life1.setVisible(true);
			life2.setVisible(true);
			life3.setVisible(true);
			gameoverpanel.setVisible(false);
			bucket.setVisible(true);
		}
				
	}
	
	private void startpanel()
	{
		p=new Imgpanel("b2.png",500,500);
		//start=new JButton("Start");
		start=new RoundButton("Start");
		help=new RoundButton("Help");
		highscore=new RoundButton("Highscore");
		exit=new RoundButton("Exit");
		
		start.setFont(new Font("Segoe UI Semibold",Font.PLAIN,30));
		help.setFont(new Font("Segoe UI Semibold",Font.PLAIN,30));
		highscore.setFont(new Font("Segoe UI Semibold",Font.PLAIN,30));
		exit.setFont(new Font("Segoe UI Semibold",Font.PLAIN,30));
		
		start.setBorderPainted(false);
		help.setBorderPainted(false);
		highscore.setBorderPainted(false);
		exit.setBorderPainted(false);
		
		start.addActionListener(this);
		help.addActionListener(this);
		highscore.addActionListener(this);
		exit.addActionListener(this);
		
		start.setBackground(Color.RED);
		help.setBackground(Color.RED);
		highscore.setBackground(Color.RED);
		exit.setBackground(Color.RED);
		
		start.setForeground(Color.white);
		help.setForeground(Color.white);
		highscore.setForeground(Color.white);
		exit.setForeground(Color.white);
		
		
		start.setBounds(125, 55, 250, 50);
		help.setBounds(125, 145, 250, 50);
		highscore.setBounds(125, 225, 250, 50);
		exit.setBounds(125, 310,245, 50);
		
		
		
		p.add(start);
		p.add(help);
		p.add(highscore);
		p.add(exit);
		
		p.setLayout(null);	
		int a,b;
		a=((int)(width)-500)/2;
		b=((int)(height)-500)/2;
		p.setBounds(a,b,500,500);
		p.setBackground(new Color(239,145,16));
		p.setVisible(true);
		
	}
	
	
	private void mainpanel()
	{
		rightpanel=new JPanel();
		rmainpanel=new JPanel();
		leftpanel=new JPanel();
		
		
		pause=new RoundButton("pause");
		pause.setBackground(Color.RED);
		pause.setFont(new Font("Segoe UI Semibold",Font.PLAIN,30));
		
		pause.addActionListener(this);
		image=new ImageIcon("egg1.png");
		img=new ImageIcon("gold.png");
		bimg=new ImageIcon("blueegg.png");
		
		bu=new ImageIcon("bucket.png");
		bucket=new JLabel(bu);
		
		g1=new GridLayout(7,1);
		
		Blankl1=new JLabel();
		
		Blankl3=new JLabel();
		Blankl4=new JLabel();
		Blankl5=new JLabel();
	
		score=new JLabel("         0 ");
		score1=new JLabel("      score   ");
		
		score1.setFont(new Font("Segoe UI Semibold",Font.PLAIN,30));
		score.setFont(new Font("Segoe UI Semibold",Font.PLAIN,30));
		life1=new JLabel(image);
		life2=new JLabel(image);
		life3=new JLabel(image); 
		
		l1=new JLabel(image);
		l2=new JLabel(image);
		l3=new JLabel(image);
		l4=new JLabel(image);
		l5=new JLabel(img);
		l6=new JLabel(image);
		l7=new JLabel(bimg);
		
		HSnamelabel=new JLabel("   Highscore   ");
		HSlabel=new JLabel("         "+highscr);
		HSnamelabel.setFont(new Font("Segoe UI Semibold",Font.PLAIN,30));
		HSlabel.setFont(new Font("Segoe UI Semibold",Font.PLAIN,30));
		lifeslabel=new JLabel("  Lifes Spans ");
		
		lifeslabel.setFont(new Font("Segoe UI Semibold",Font.PLAIN,30));
	
		rightpanel.setLayout(new GridLayout(15,1));
	
		leftpanel.setLayout(g1);
		
		
	//	HSlabel.setBounds();
		lifeslabel.setBounds(20, 200, 40, 40);
		
		y1=-560;
		y2=-1050;
		y3=-1530;
		y4=-2000;
		y5=-400;
		y6=-3000;
		y7=-1200;
		
		l1.setBounds(x1, y1, 100, 100);
		l2.setBounds(x2, y2, 100, 100);
		l3.setBounds(x3, y3, 100, 100);
		l4.setBounds(x4, y4, 100, 100);
		l5.setBounds(x5, y5, 100, 100);
		l6.setBounds(x6, y6, 100, 100);
		l7.setBounds(x7, y7, 100, 100);
		bucket.setBounds(0,520,160,117);
	//	bucket.setVisible(false);
		
		
		panel.add(l1);
		panel.add(l2);
		panel.add(l3);
		panel.add(l4);
		panel.add(l5);
		panel.add(l6);
		panel.add(l7);
		panel.add(bucket);
		
		rightpanel.add(Blankl1);
		
		rightpanel.add(HSnamelabel);
		rightpanel.add(HSlabel);
		rightpanel.add(score1);
		rightpanel.add(score);
		rightpanel.add(Blankl4);
		rightpanel.add(pause);
		
		
		leftpanel.add(Blankl5);
		leftpanel.add(lifeslabel);
		leftpanel.add(life1);
		leftpanel.add(life2);
		leftpanel.add(life3);
	
		
		rightpanel.setSize(400, 800);
		leftpanel.setSize(400,800 );
		
		
		mainpanel.setLayout(b1);
		leftpanel.setBackground(new Color(239,145,16));
		rightpanel.setBackground(new Color(239,145,16));	
		rmainpanel.setBackground(new Color(239,145,16));	
		
		rmainpanel.add(rightpanel);
			
		mainpanel.add(panel,BorderLayout.CENTER);	
		mainpanel.add(rmainpanel,BorderLayout.EAST);
		mainpanel.add(leftpanel,BorderLayout.WEST);
				
		
		panel.add(addplayer);
		panel.add(helppanel);
		panel.add(highscorepanel);
		panel.add(p);
		panel.add(pausepanel);
		panel.add(gameoverpanel);
	
		panel.addMouseMotionListener(this);
		panel.setLayout(null);
		
		rightpanel.setVisible(true);
		
	}
	
	
	private void Highscore(int xe,int ye ,int xb )
	{
		if(ye>472)
		{
			
			
			if(gegg==1)
			{
				if(xb<0)
				{
					xb=xb+20;
				}
				if(xe>=xb && xe+100<=xb+170  )
				{
					scr=scr+500;
					score.setText("        "+scr+"      ");
				}
				gegg=0;
			}
			else if(begg==1)
			{
				if(xb<0)
				{
					xb=xb+20;
				}
				if(xe>=xb && xe+100<=xb+170  )
				{
					life=life+1;
					lifefun2(life);
					b=0;
				}	
				begg=0;
				y7=-200;
				x7=r.nextInt(900);
			}
			else 
			{
				if(xb<0)
				{
					xb=xb+20;
				}
				if(xe>=xb && xe+100<=xb+170)
				{
					scr=scr+100;
					score.setText("        "+scr+"      ");
				}
				else
				{
					if(life>0)
					{
						life=life-1;
					}
					lifefun(life);
				}
			}
			
		}
	}
	
	private void lifefun(int a)
	{
		if(a==2)
		{
			life1.setVisible(true);
			life2.setVisible(true);
			life3.setVisible(false);
		
		}
		else if(a==1)
		{
			life1.setVisible(true);
			life2.setVisible(false);
			
		
		}
		else if(a==0)
		{
			life1.setVisible(false);
			
			if(scr>highscr)
			{
				try
				{
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection con=DriverManager.getConnection("jdbc:odbc:MyJavaDb");
					PreparedStatement ps=con.prepareStatement("update eggcatcher set player='"+playername+"',highscore='"+scr+"'  where sno=1");
					int rs=ps.executeUpdate();		/// select
				
				}
				catch(Exception ee)
				{
					
				}
			}
			y1=-560;
			y2=-1050;
			y3=-1530;
			y4=-2000;
			y5=-400;
			y6=-3000;
			y7=-200;
			
			l1.setBounds(x1, y1, 100, 100);
			l2.setBounds(x2, y2, 100, 100);
			l3.setBounds(x3, y3, 100, 100);
			l4.setBounds(x4, y4, 100, 100);
			l5.setBounds(x5, y5, 100, 100);
			l6.setBounds(x6, y6, 100, 100);
			l7.setBounds(x7, y7, 100, 100);
			bucket.setVisible(false);
			gameoverhighscore.setText("Highscore        "+highscr); 
			gameoverscore.setText("Score                "+scr);
			gameoverpanel.setVisible(true);
			t1.destroy();
		
		}
	}
	
	private void lifefun2(int a)
	{
		if(a==3)
		{
			life1.setVisible(true);
			life2.setVisible(true);
			life3.setVisible(true);
		}
		if(a==2)
		{
			life1.setVisible(true);
			life2.setVisible(true);
			life3.setVisible(false);
			
		}
		else if(a==1)
		{
			life1.setVisible(true);
			life2.setVisible(false);
		}
	}
	private void createpausepanel()
	{
		pausepanel=new Imgpanel("b2.png",500,500);
		pausepanel.setLayout(null);
		HSnamelabelpause=new JLabel("Highscore        "+highscr);
		HSnamelabelpause.setFont(new Font("Segoe UI Semibold",Font.PLAIN,30));
		HSnamelabelpause.setBounds(100,55,300,50);
		
		scorepause=new JLabel("Score                "+scr);
		scorepause.setFont(new Font("Segoe UI Semibold",Font.PLAIN,30));
		scorepause.setBounds(100,135,300,50);
		
		mainmenupause=new RoundButton(" Mainmenu");
		mainmenupause.addActionListener(this);
		resume=new RoundButton("Resume");
		resume.addActionListener(this);
		mainmenupause.setFont(new Font("Segoe UI Semibold",Font.PLAIN,20));
		resume.setFont(new Font("Segoe UI Semibold",Font.PLAIN,20));
		
		mainmenupause.setBackground(Color.yellow);
		resume.setBackground(Color.yellow);
		mainmenupause.setBounds(70, 225, 150, 50);
		resume.setBounds(270, 225, 150, 50);
		
		pausepanel.add(HSnamelabelpause);
		pausepanel.add(scorepause);
		pausepanel.add(mainmenupause);
		pausepanel.add(resume);
		
		
		int a,b;
		a=((int)(width)-900)/2;
		b=((int)(height)-500)/2;
		pausepanel.setBounds(a,b,500,500);
		
	}
	
	private void creategameoverpanel()
	{
		gameoverpanel=new Imgpanel("b2.png",500,500);
		gameoverpanel.setLayout(null);
		gameover =new JLabel("  Game Over!!!");
		gameoverhighscore=new JLabel("Highscore        "+highscr); 
		gameoverscore=new JLabel("Score                "+scr);
		
		gameover.setFont(new Font("Segoe UI Semibold",Font.PLAIN,40));
		gameover.setForeground(Color.red);
		gameover.setBounds(100, 55, 300, 50);
		
		gameoverhighscore.setFont(new Font("Segoe UI Semibold",Font.PLAIN,30));
		gameoverhighscore.setBounds(100, 135, 300, 50);
		
		gameoverscore.setFont(new Font("Segoe UI Semibold",Font.PLAIN,30));
		gameoverscore.setBounds(100, 225, 300, 50);
		
		mainmenugameover=new RoundButton(" Mainmenu");
		mainmenugameover.addActionListener(this);
	
		playagain=new RoundButton("Play Again");
		playagain.addActionListener(this);
		
		mainmenugameover.setFont(new Font("Segoe UI Semibold",Font.PLAIN,20));
		playagain.setFont(new Font("Segoe UI Semibold",Font.PLAIN,20));
		
		mainmenugameover.setBackground(Color.yellow);
		playagain.setBackground(Color.yellow);
		mainmenugameover.setBounds(70, 315, 150, 50);
		playagain.setBounds(270, 315, 150, 50);
		
		
		gameoverpanel.add(gameover);
		gameoverpanel.add(gameoverhighscore);
		gameoverpanel.add(gameoverscore);
		gameoverpanel.add(mainmenugameover);
		gameoverpanel.add(playagain);
		
		int a,b;
		a=((int)(width)-900)/2;
		b=((int)(height)-500)/2;
		gameoverpanel.setBounds(a,b,500,500);
	}
	private void createaddplayerpanel()
	{
		addplayer=new Imgpanel("nampanel.png",384,272);
		addplayer.setLayout(null);
		
		namelabel=new JLabel("Enetr Player Name :");	
		namelabel.setFont(new Font("Segoe UI Semibold",Font.PLAIN,25));
		namelabel.setForeground(Color.yellow);
		namelabel.setBounds(50, 40, 250,50);
		
		nametext=new JTextField(20);
		
		nametext.setFont(new Font("Segoe UI Semibold",Font.PLAIN,25));
		nametext.setOpaque(false);
		nametext.setBorder(null);
		nametext.setForeground(Color.yellow);
		nametext.setBounds(50, 100, 250,50);
		
		nametext.setHorizontalAlignment(JTextField.CENTER);
		errorlabel=new JLabel("Enter player name!!!");
		errorlabel.setFont(new Font("Segoe UI Semibold",Font.PLAIN,25));
		errorlabel.setForeground(Color.yellow);
		errorlabel.setBounds(50, 140, 250,50);
		errorlabel.setVisible(false);
		
		addok=new RoundButton("Ok");
		addok.addActionListener(this);
		addok.setFont(new Font("Segoe UI Semibold",Font.PLAIN,20));
		addok.setBounds(50, 195, 100, 50);
		addok.setBackground(Color.red);
		
		addcancel=new RoundButton("Cancel");
		addcancel.addActionListener(this);
		addcancel.setFont(new Font("Segoe UI Semibold",Font.PLAIN,20));
		addcancel.setBounds(225, 195, 100, 50);
		addcancel.setBackground(Color.red);
		
		addplayer.add(namelabel);
		addplayer.add(nametext);
		addplayer.add(errorlabel);
		addplayer.add(addok);
		addplayer.add(addcancel);
		
		int a,b;
		a=((int)(width)-384)/2;
		b=((int)(height)-272)/2;
		addplayer.setBounds(a,b,384,272);
		
		
	}
	
	private void createhelppanel()
	{
		helppanel=new Imgpanel("b2.png",500,500);
		helppanel.setLayout(null);
	
		String temp=" 1. Use your mouse to move \n the bucket.\n 2. Each white gives you 100 \n points.\n 3. golden egg give you 500 \n points \n 4. blue colour egg give \n you extra life ";
		helplabel=new JLabel("Help!!");
		helplabel.setFont(new Font("Segoe UI Semibold",Font.PLAIN,40));
		helplabel.setForeground(Color.yellow);
		helplabel.setBounds(190, 50, 150, 50);
		
		helptext=new JTextArea(20,20);
		helptext.setFont(new Font("Segoe UI Semibold",Font.PLAIN,25));
		helptext.setForeground(Color.yellow);
		helptext.setBounds(70,100 , 350, 300);
		helptext.setEditable(false);
		helptext.setText(temp);
		
		helptext.setOpaque(false);
		

	
		helpback=new RoundButton("Back");
		helpback.setFont(new Font("Segoe UI Semibold",Font.PLAIN,25));
		helpback.setBackground(Color.red);
		helpback.addActionListener(this);
		helpback.setBounds(190, 390, 100, 50);
		
		helppanel.add(helplabel);
		helppanel.add(helptext);
		helppanel.add(helpback);
		
		int a,b;
		a=((int)(width)-500)/2;
		b=((int)(height)-500)/2;
		helppanel.setBounds(a,b,500,500);
		
		
	}
	private void createhighscorepanel()
	{
		int i=1;
		highscorepanel=new Imgpanel("b2.png",500,500);
		highscorepanel.setLayout(null);
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con=DriverManager.getConnection("jdbc:odbc:MyJavaDb");
			PreparedStatement ps=con.prepareStatement("select * from eggcatcher where sno=1;");
			ResultSet rs=ps.executeQuery();		/// select
			if(rs.next())
			{
				hsplayer=rs.getString(2);
				hsstr=rs.getString(3);
			}	
		}
		catch(Exception ee)
		{
			
		}
		highscr=Integer.parseInt(hsstr);
		highscorepanelnamelabel=new JLabel("Highscore");
		highscorepanelnamelabel.setFont(new Font("Segoe UI Semibold",Font.PLAIN,40));
		highscorepanelnamelabel.setForeground(Color.red);
		highscorepanelnamelabel.setBounds(150, 50, 200, 50);
	
		highscorepanellabel=new JLabel(hsplayer+"                 "+highscr);
		highscorepanellabel.setFont(new Font("Segoe UI Semibold",Font.PLAIN,30));
		highscorepanellabel.setBounds(100, 220, 300, 50);
		highscorepanellabel.setForeground(Color.yellow);
		
		highscoreback=new RoundButton("Back");
		highscoreback.setFont(new Font("Segoe UI Semibold",Font.PLAIN,25));
		highscoreback.setBackground(Color.red);
		highscoreback.addActionListener(this);
		highscoreback.setBounds(190, 390, 100, 50);
		
		highscorepanel.add(highscorepanelnamelabel);
		highscorepanel.add(highscorepanellabel);
		highscorepanel.add(highscoreback);
	
	
		int a,b;
		a=((int)(width)-500)/2;
		b=((int)(height)-500)/2;
		highscorepanel.setBounds(a,b,500,500);
	}
}
