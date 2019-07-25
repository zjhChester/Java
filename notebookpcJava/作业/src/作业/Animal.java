package ื๗าต;

 class Animal {
	private String Animalname;
 	private int Animalage;
 	private int Animalweight;
 	private char Animalsex;
	public Animal(String Animalname,int Animalage,int Animalweight,char Animalsex){
		this.Animalname = Animalname;
		this.Animalage = Animalage;
		this.Animalweight = Animalweight;
		this.Animalsex = Animalsex;
		System.out.println("ddddd");
		
	}
	void setname(String Animalname){
		
		this.Animalname = Animalname;
	}
	String getname(){
	 return Animalname;	
	}
	void setage(int Animalage){
		this.Animalage = Animalage;
	}
	int getage(){
	 return Animalage;	
	}
	void setweight(int Animalweight){
		this.Animalweight = Animalweight;
	}
	int getweight(){
	 return Animalweight;	
	}
	void setsex(char Animalsex){
		this.Animalsex = Animalsex;
	}
	char getsex(){
	 return Animalsex;	
	}

	void move(){
		System.out.println("I can move!!!");
	}
}
class bird extends Animal{
	
	int number;
	public bird(String Animalname,int Animalage,int Animalweight,char Animalsex, int number){
		
	super( Animalname, Animalage, Animalweight, Animalsex);

		this.number = number;
	}
	int getage(){
		return (super.getage()+number);
	}
	void move(){
		System.out.println("I can fly!!!");
	}
	
}


	