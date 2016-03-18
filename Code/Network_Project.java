
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue; 
import javax.swing.*;


class Vertexes implements Comparable<Vertexes>
{
    public final String name;
    public Edges[] ed;
    public double minimum_distance = Double.POSITIVE_INFINITY;
    public Vertexes previous;
    public Vertexes(String argument_name) { name = argument_name; }
    public String toString() { return name; }
    
    public int compareTo(Vertexes other)  // In-Built Method
    {
        return Double.compare(minimum_distance, other.minimum_distance);
    }

}
class Edges
 {
	public final Vertexes target;
	public final double weight;

	public Edges(Vertexes argument_target, double argument_weight)
	{
		target = argument_target;
		weight = argument_weight;
	}
}

public class Network_Project 
{
	static Vertexes dest = null;	// dijkstra algorithm
	public static void calculation(Vertexes source)
	{
		source.minimum_distance = 0.;
		PriorityQueue<Vertexes> vertex_Queue = new PriorityQueue<Vertexes>();
		vertex_Queue.add(source);

		while (!vertex_Queue.isEmpty()) 
		{
			Vertexes u = vertex_Queue.poll();	
			for (Edges e : u.ed)
			{
				Vertexes v = e.target;
				double weight = e.weight;
				double distanceThroughU = u.minimum_distance + weight;
				if (distanceThroughU < v.minimum_distance)
				{
					vertex_Queue.remove(v);
					v.minimum_distance = distanceThroughU;
					v.previous = u;
					vertex_Queue.add(v);
				}}}}

	public static List<Vertexes> obtain_SP(Vertexes target)	// obtaining shortest path
	{
		List<Vertexes> path = new ArrayList<Vertexes>();
		for (Vertexes vertex = target; vertex != null; vertex = vertex.previous)
			path.add(vertex);
		Collections.reverse(path);
		return path;
	}
        
	public static Vertexes[] vertex=null;
	
	public static List<Vertexes> Find_Shortest_Path(String source, String destination, int a)
	{
		vertex=null;
       
		List<Vertexes> path = null;

		Vertexes N1 = new Vertexes("N1");
        Vertexes N2 = new Vertexes("N2");
        Vertexes N3 = new Vertexes("N3");
        Vertexes N4 = new Vertexes("N4");
        Vertexes N5 = new Vertexes("N5");
        Vertexes N6= new Vertexes("N6");
        Vertexes N7 = new Vertexes("N7");
        Vertexes N8 = new Vertexes("N8");
        Vertexes N9 = new Vertexes("N9");
        Vertexes N10 = new Vertexes("N10");
        
        // set the edges and weight
        if(a==0)
        {
        N1.ed = new Edges[]{ new Edges(N2, 10),
        				   new Edges(N9, 5),
        				   new Edges(N5, 9),
        				   new Edges(N10,10),
        				   new Edges(N7,8)};
        N2.ed = new Edges[]{ new Edges(N3, 5)};
        N3.ed = new Edges[]{ new Edges(N4, 2)};
        N4.ed = new Edges[]{ new Edges(N4, 0)};
        N5.ed = new Edges[]{ new Edges(N6, 7)};
        N6.ed = new Edges[]{ new Edges(N4, 9)};
        N7.ed = new Edges[]{ new Edges(N8, 9)};
        N8.ed = new Edges[]{ new Edges(N4, 8)};
        N9.ed = new Edges[]{ new Edges(N4, 7)};
        N10.ed = new Edges[]{ new Edges(N4, 12)};
        
        }
        else if(a==1)
        {
        	N1.ed = new Edges[]{ new Edges(N2, 10),		   
 				   new Edges(N5, 9),
 				   new Edges(N10,10),
 				   new Edges(N7,8)};
        	N2.ed = new Edges[]{ new Edges(N3, 5)};
        	N3.ed = new Edges[]{ new Edges(N4, 2)};
        	N4.ed = new Edges[]{ new Edges(N4, 0)};
        	N5.ed = new Edges[]{ new Edges(N6, 7)};
        	N6.ed = new Edges[]{ new Edges(N4, 9)};
        	N7.ed = new Edges[]{ new Edges(N8, 9)};
        	N8.ed = new Edges[]{ new Edges(N4, 8)};
        	N9.ed = new Edges[]{ new Edges(N4, 0)};
        	N10.ed = new Edges[]{ new Edges(N4, 12)};
        	
        }
        else if(a==2)
        {
        	N1.ed = new Edges[]{ 
 				   new Edges(N5, 9),
 				   new Edges(N10,10),
 				   new Edges(N7,8)};
        	N2.ed = new Edges[]{ new Edges(N3, 5)};
        	N3.ed = new Edges[]{ new Edges(N4, 0)};
        	N4.ed = new Edges[]{ new Edges(N4, 0)};
        	N5.ed = new Edges[]{ new Edges(N6, 7)};
        	N6.ed = new Edges[]{ new Edges(N4, 9)};
        	N7.ed = new Edges[]{ new Edges(N8, 9)};
        	N8.ed = new Edges[]{ new Edges(N4, 8)};
        	N9.ed = new Edges[]{ new Edges(N4, 0)};
        	N10.ed = new Edges[]{ new Edges(N4, 12)};
        }
        
        Vertexes[] ver = { N1,N2,N3,N4,N5,N6,N7,N8,N9,N10};
        vertex = ver;
        
		for (Vertexes v : ver) {
			if (source == v.name)
				calculation(v);
			if (destination == v.name)
				dest = v;
		}

		
		System.out.println("Distance to " + dest + ": " + dest.minimum_distance);
		
		path = obtain_SP(dest);		// calling the obtain shortest path algorithm
		
		return path;
	}
	
	
	public static void main(String[] args)
	{		
		Runnable runner = new Runnable()
		{		
			public void run()
			{
				JFrame frame = new JFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(700, 450);				
				Container contentPane = frame.getContentPane();
				frame.setLocationRelativeTo(null);
			
    			JButton pp = new JButton("Primary Path");
				JButton	slf = new JButton("Single Link Failure");
				JButton mlf = new JButton("Multi Link Failure");
				
				pp.setBackground(new Color(255,140,0));
				slf.setBackground(new Color(255,140,0));
				mlf.setBackground(new Color(255,140,0));
				
				final JTextArea result = new JTextArea(5,5);
				
				final JRadioButton sppa  = new JRadioButton("SPP Algorithm");
				final JRadioButton dlbsppa = new JRadioButton("DLBSPP Algorithm");
				
				ImageIcon image = new ImageIcon("Image1.jpg");
				final ImageIcon image1 = new ImageIcon("Image2.jpg");
				final ImageIcon image2 = new ImageIcon("Image3.jpg");
				final ImageIcon image3 = new ImageIcon("Image4.jpg");
				final ImageIcon image4 = new ImageIcon("Image5.jpg");
				
				final JLabel label = new JLabel(image);
				
				
				JPanel page = new JPanel();
				JPanel Total = new JPanel();
				
				JPanel algorithms = new JPanel();
				JPanel  failures= new JPanel();
				JPanel results = new JPanel();
				
				JPanel alg = new JPanel();
				JPanel fa = new JPanel();
				JPanel res = new JPanel();
				
				ActionListener primary_listener	= new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent arg0) 
					{
						// TODO Auto-generated method stub
						if(sppa.isSelected())
						{
							List<Vertexes> r= Find_Shortest_Path ("N1", "N4", 0);
							result.setText("\n Primary Path " + r +"\n"+
							" Distance to " + dest + " from N1: " + dest.minimum_distance);
							label.setIcon(image1);
						}
						else if(dlbsppa.isSelected())
						{
							List<Vertexes> r= Find_Shortest_Path("N1", "N4", 0);
							result.setText("\n Primary Path " + r +"\n"+
									" Distance to " + dest + " from N1: " + dest.minimum_distance);
							label.setIcon(image1);
						}
					}
					
				};
				
				ActionListener singlelink_listener = new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						// TODO Auto-generated method stub
						if(sppa.isSelected())
						{
							List<Vertexes> r1= Find_Shortest_Path("N1", "N4",1);
							result.setText("\n Backup Shared Path " + r1 +"\n"+
									" Distance to " + dest + " from N1: " + dest.minimum_distance);
							label.setIcon(image2);
						}
						else if(dlbsppa.isSelected())
						{
							List<Vertexes> r1= Find_Shortest_Path("N1", "N4",1);
							result.setText("\n Backup Path " + r1+"\n"+
									" Distance to " + dest + " from N1: " + dest.minimum_distance);
							label.setIcon(image2);
						}
							
					}
					
				};
				
				ActionListener multilink_listener = new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						if(sppa.isSelected())
						{
							
							result.setText("\n Connection request is dropped");
							label.setIcon(image3);
						}
						else if(dlbsppa.isSelected())
						{
							List<Vertexes> r2= Find_Shortest_Path("N1", "N4",2);
							result.setText("\n Alternate Path " + r2 +"\n"+
									" Distance to " + dest + " from N1: " + dest.minimum_distance);
							label.setIcon(image4);
						}
					}
				};
				
				alg.setLayout(new GridLayout(1,2));
				alg.add(sppa);
				alg.add(dlbsppa);
				
				fa.setLayout(new GridLayout(3,1));
				fa.add(pp);
				fa.add(slf);
				fa.add(mlf);
				
				res.setLayout(new GridLayout(1,2));
				res.add(result);
				res.add(label);
				
				Total.setLayout(new BorderLayout());
				//page.setLayout(new BorderLayout());
				//frame.setLayout(new BorderLayout());
				
				algorithms.setLayout(new GridLayout(1,2,50,100));
				failures.setLayout(new GridLayout(1,1));
				results.setLayout(new GridLayout(1,1));
				
				algorithms.add(alg);
				failures.add(fa);
				results.add(res);
				
				Total.add(algorithms,BorderLayout.NORTH);
				Total.add(failures,BorderLayout.CENTER);
				Total.add(results,BorderLayout.SOUTH);
					
				
				page.add(Total);
				//page.add(Total,BorderLayout.CENTER);
				frame.add(page,BorderLayout.CENTER);
		
				pp.addActionListener(primary_listener);
				slf.addActionListener(singlelink_listener);	
				mlf.addActionListener(multilink_listener);
				frame.setVisible(true);
			}
		};
		EventQueue.invokeLater(runner);
		
	}
	
}