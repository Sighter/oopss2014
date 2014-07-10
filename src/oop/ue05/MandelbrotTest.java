import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class MandelbrotTest  extends JFrame {
	
	
	 public static void main(String[] args) {
		    JFrame frame = new MandelbrotTest();
		    frame.show();
		  } 
	 
// Stellen die Tittel der Graphen, mit width = 700 und hight = 700. 
	 public MandelbrotTest() {
		    setTitle("MandelbrotTest");
		    setSize(700, 700);
		    addWindowListener(new WindowAdapter() {
		      public void windowClosing(WindowEvent e) {
		        System.exit(0);
		      }
		    });
		    
// 2.Beispiel:
		    ComplexNumber ci=new ComplexNumber(-0.7672,0.0999);
		    ComplexNumber ck=new ComplexNumber(-0.7652,0.1016);
		    Container contentPane = getContentPane();
		    contentPane.add(new FracModel(ci,ck,150), "Center");
// 1.Beispiel:		    
//		    ComplexNumber ci=new ComplexNumber(-2,-1);
//		    ComplexNumber ck=new ComplexNumber(0.5,2);
//		    Container contentPane = getContentPane();
//		    contentPane.add(new FracModel(ci,ck,20), "Center");
		  }
		}

