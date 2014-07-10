package oop.ue05;

public class ComplexNumber { 
	double re;  
	double im; 

	ComplexNumber(double real,double image){ 
		this.re = real;
		this.im = image;
	}

	public ComplexNumber() {	
	}

	public double getReal() {
		return re;
	}

	public void setReal(double real) {
		this.re = real;
	}

	public double getImage() {
		return im;
	}

	public void setImage(double image) {
		this.im = image;
	}
	
	public ComplexNumber add(ComplexNumber a){ 
		double real2 = a.getReal();
		double image2 = a.getImage();
		double newReal = re + real2;
		double newImage = im + image2;
		ComplexNumber result = new ComplexNumber(newReal,newImage);
		return result;
	}
	
	public ComplexNumber sub(ComplexNumber a){ 
		double real2 = a.getReal();
		double image2 = a.getImage();
		double newReal = re - real2;
		double newImage = im - image2;
		ComplexNumber result = new ComplexNumber(newReal,newImage);
		return result;
	}
	
	public ComplexNumber square(){ 
	
		double newReal = re*re - im*im;
		double newImage = im*re + re*im;
		ComplexNumber result = new ComplexNumber(newReal,newImage);
		return result;
	}
	
	
	public String toString(){
		return ""+ this.re + " + " +this.im + " i ";
	}
	
	
	
}
