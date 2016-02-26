 package org.resources;


import javax.xml.bind.annotation.XmlElement;

@javax.xml.bind.annotation.XmlRootElement(name = "Addition")
public class Addition {
	private static final long serialVersionUID = 1L;
	long n1;
	public long getN1() {
		return n1;
	}

	public void setN1(long n1) {
		this.n1 = n1;
	}

	public long getN2() {
		return n2;
	}

	public void setN2(long n2) {
		this.n2 = n2;
	}
	long n2;
	long addn;
	
	
	public long getAddn() {
		return addn;
	}

	public void setAddn(long addn) {
		this.addn = addn;
	}

	
	public Addition() {
		// TODO Auto-generated constrring auctor stub
		super();	
	}
public Addition(long a,long b) {
		super();
		this.n1=a;
		this.n2=b;
		this.addn=a+b;
		// TODO Auto-generated constructor stub
		 
	}

}
