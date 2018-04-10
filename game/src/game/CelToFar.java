package game;

//Celsius/Fahrenheit, Fahrenheit/Celsius átváltó program grafikus felületen.
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class Ablak extends JFrame implements ActionListener{
	private JButton atvalt;
	private JPanel  also, alap, felso, kozep1, kozep2;
	private JLabel szoveg, C, F;
	private BorderLayout bl;
	private FlowLayout fl;
	private JTextField mezo1, mezo2;
	
	
	public Ablak(){
		
		this.setTitle("Celsius to Fahrenheit");
		this.setSize(700,150);
		
		szoveg = new JLabel("Adja meg az értéket! Az atvaltas oda-vissza mukodik!");
		C = new JLabel("Celsius:");
		F = new JLabel("Fahrenheit:");
		mezo1 = new JTextField(10);		
		mezo2 = new JTextField(10);
		fl = new FlowLayout();
	    bl = new BorderLayout();
		alap = (JPanel) this.getContentPane();
		alap.setLayout(bl);		
		atvalt = new JButton("Atvalt");
		atvalt.addActionListener(this);
		also = new JPanel();
		also.setLayout(fl);
		felso = new JPanel();
		kozep1 = new JPanel();
		kozep2 = new JPanel();

		felso.add(szoveg);
		also.add(atvalt);
		kozep1.add(C);
		kozep1.add(mezo1);
		kozep2.add(F);
		kozep2.add(mezo2);
		alap.add(kozep1, BorderLayout.WEST);
		alap.add(kozep2, BorderLayout.EAST);
		alap.add(felso,BorderLayout.PAGE_START);
		alap.add(also,BorderLayout.CENTER);

		this.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		float szam=0;
		if(!(mezo1.getText().isEmpty() && mezo2.getText().isEmpty())){
		if(mezo1.getText().length()>0) {
			try {
				szam=Float.parseFloat(mezo1.getText());
			}catch(Exception e1) {
				System.out.println(e1);
			}
			szam*=1.8;
			szam+=32;
			mezo2.setText(""+szam);
			mezo1.setText("");
		}else {
			try {
				szam=Float.parseFloat(mezo2.getText());
			}catch(Exception e1) {
				System.out.println(e1);
			}
			szam -=32;
			szam/=1.8;
			String valami = String.format("%.2f", szam);
			valami=valami.replace(',', '.');
			
			mezo1.setText(""+valami);
			mezo2.setText("");
		}
	  }	
	}	
}

public class  CelToFar {
	public static void main(String[] args) {
		Ablak a = new Ablak();
		a.setVisible(true);
	}
}
