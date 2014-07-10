package oop.ue05;

import java.util.Observable;


public class FracModel extends Observable {
	
	private int[][] frameBuffer= null;
    private	ComplexNumber borderNumber1;
    private	ComplexNumber borderNumber2;  
	private int iterationstief;

	private int width;
	private int height;
	
   	public FracModel(ComplexNumber ci,ComplexNumber ck,int it, int w, int h){
		this.borderNumber1=ci;
		this.borderNumber2=ck;
		this.iterationstief=it;
		this.width = w;
		this.height = h;
		this.frameBuffer = new int[this.width][this.height];
	}

	/**
	 * get the framebuffer
	 */
	
	public int[][] getFrameBuffer() { return this.frameBuffer; }

	/*
	 * setters and getters for the border numbers
	 */

	public ComplexNumber getBorderNumber1() { return this.borderNumber1; }
	
	public FracModel setBorderNumber1(ComplexNumber v) { this.borderNumber1 = v; return this; }

	public ComplexNumber getBorderNumber2() { return this.borderNumber2; }
	
	public FracModel setBorderNumber2(ComplexNumber v) { this.borderNumber2 = v; return this; }

	public int getIterationDepth() { return this.iterationstief; }
	
	public FracModel setIterationDepth(int v) { this.iterationstief = v; return this; }

	/*
	 * setters and getters for the dimensions
	 */
	
	public int getWidth() { return this.width; }
	
	public FracModel setWidth(int v) {
		System.out.println("Setting width " + v);
		this.width = v; return this;
	}

	public int getHeight() { return this.height; }
	
	public FracModel setHeight(int v) {
		System.out.println("Setting height " + v);
		this.height = v; return this;
	}

	
	
	// ich definierte width* height = 500*500,
   	public int[][] calculateFrameBuffer() {		
	    int width = this.width;
	    int height = this.height;
	    
	    for (int i = 0; i < width; i++) {
	        for (int j = 0; j < height; j++) {
	        	this.frameBuffer[i][j]=0;
	        	double a = this.borderNumber1.getReal() + i * (this.borderNumber2.getReal() - this.borderNumber1.getReal()) / width;
		    	double b = this.borderNumber1.getImage() + j * (this.borderNumber2.getImage() - this.borderNumber1.getImage()) / height;
	        	if (inSetCheck(new ComplexNumber(a,b)))
	        		this.frameBuffer[i][j]=1;
	        }
	    }

	    setChanged();               
	    notifyObservers();

	    return this.frameBuffer;
	}
	
	private boolean inSetCheck(ComplexNumber z) {
		ComplexNumber start=new ComplexNumber(0,0);
	    int iterations = 0;
	    do {
	      double newRe = start.getReal() * start.getReal() - start.getImage() * start.getImage() + z.getReal();
	      double newIm = 2 * start.getReal() * start.getImage() + z.getImage();
	      start.setReal(newRe) ;
	      start.setImage(newIm) ;
	      iterations++;
	      if (iterations == this.iterationstief)
	      return true;
	    } while (start.getReal() <= 2 && start.getImage() <= 2);
	    return false;
	 }
	
	
  }
	

	

