package es.unileon.prg1.date;

public class Date {
	private int day;
	private int month;
	private int year;
	
	public Date (int day, int month, int year) throws DateException {
		//this.month = month;
		this.setMonth(month);
		//this.day = day;
		this.setDay(day);
		//this.year = year;
		this.setYear(year);
	}
	
	public Date (Date date) { //Constructor para clonar una fecha
		this.day=date.getDay();
		this.month=date.getMonth();
		this.year=date.getYear();
	}
	
	public void setDay(int day) throws DateException {
		if ( day < 1 || day > this.getDaysOfMonth() ) {
			throw new DateException("Date error: Day " + day + " of month " + this.month + " not valid");			
		}
		this.day = day;
	}
	
	public void setMonth (int month) throws DateException {
		if ( month < 1 || month > 12) {
			throw new DateException("Date error: Month " + month + " not valid");
		}
		this.month = month;
	}
	
	public void setYear (int year) {
		this.year = year;
	}
	
	public int getDay() {
		return this.day;
	}
	
	public int getMonth() {
		return this.month;
	}
	
	public int getYear() {
		return this.year;
	}
	
	private int getDaysOfMonth() {
		int numDays;
		
		numDays = 0;
		switch (this.month) {
		case 1: //next
		case 3: //next
		case 5: //next
		case 7: //next
		case 8: //next
		case 10: //next
		case 12:
			numDays = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			numDays = 30;
			break;
		case 2:
			numDays = 28;
			break;			
		}
		
		return numDays;
	}
	
	public boolean isSameYear(Date date) {
		if(this.getYear()==date.getYear())
			return true;
		else 
			return false;
	}
	
	public boolean isSameMonth(Date date) {
		if(this.getMonth()==date.getMonth())
			return true;
		else 
			return false;
	}
	
	public boolean isSameDay(Date date) {
		if(this.getDay()==date.getDay())
			return true;
		else 
			return false;
	}
	
	public boolean isSame(Date date) {
		if(isSameYear(date)&&isSameMonth(date)&&isSameDay(date))
			return true;
		else
			return false;
	}
	
	public boolean isSameYearNoIf(Date date) {
		return this.getYear()==date.getYear();
	}
	
	public boolean isSameMonthNoIf(Date date) {
		return this.getMonth()==date.getMonth();
	}
	
	public boolean isSameDayNoIf(Date date) {
		return this.getDay()==date.getDay();
	}
	
	public boolean isSameNoIf(Date date) {
		return isSameYear(date)&&isSameMonth(date)&&isSameDay(date);
	}
	
	public String getMonthName() {
		String name="";
		switch(getMonth()) {
		case 1: name="Enero";
			break;
		case 2: name="Febrero";
			break;
		case 3: name="Marzo";
			break;
		case 4: name="Abril";
			break;
		case 5: name="Mayo";
			break;
		case 6: name="Junio";
			break;
		case 7: name="Julio";
			break;
		case 8:name="Agosto";
			break;
		case 9: name="Septiembre";
			break;
		case 10: name="Octubre";
			break;
		case 11: name="Noviembre";
			break;
		case 12: name="Diciembre";
			break;
		}
		return name;
	}
	
	public String getMonthSeason() {
		String s="";
		switch(this.month){
			case 1: 
			case 2:
			case 3: s="Invierno";
				break;
			case 4: 
			case 5: 
			case 6: s="Primavera";
				break;
			case 7: 
			case 8: 
			case 9: s="Verano";
				break;
			case 10: 
			case 11: 
			case 12: s="Otoño";
				break;
		}
		return s;
	}
	
	public int getMonthsUntilEndOfYear() {//No contamos el mes actual
		return 12-getMonth();
	}
	
	public String datesUntilEndOfMonth() {//No incluimos la fecha actual
		StringBuffer s = new StringBuffer();
		Date aux= new Date(this);
		for(int i=getDay()+1; i<=getDaysOfMonth(); i++) {
			aux.day=i;
			s.append(aux.toString()+"\n");
		}
		return s.toString();
	}
	
	public String monthsSameDays() {//No incluimos el mismo mes de la fecha
		StringBuffer s =new StringBuffer();
		Date aux = new Date(this);
		for(int i=1; i<13; i++) {
			aux.month=i;
			if(aux.getMonth()!=getMonth()) {
				if(getDaysOfMonth()==aux.getDaysOfMonth()) 
					s.append(aux.getMonthName()+ "   ");
			}
		}
		return s.toString();
	}
	
	public int daysUntilStartOfYear() {//Incluimos el dia de la fecha actual
		int days=getDay();
		Date aux= new Date(this);
		for(int i=1; i<getMonth(); i++) {
			aux.month=i;
			days+=aux.getDaysOfMonth();
		}
		
		return days;
	}
	
	public int attemptsRandomDate() {
		int att=0;
		Date aux = new Date(this);
		aux.day++;
		while(!isSame(aux)) {
			aux.month=(int)Math.floor(Math.random()*12+1);
			aux.day=(int)Math.floor(Math.random()*31+1);
			att++;
		}
		return att;
	}
	
	public int attemptsRandomDateDoWhile() {
		int att=0;
		Date aux = new Date(this);
		do {
			aux.month=(int)Math.floor(Math.random()*12+1);
			aux.day=(int)Math.floor(Math.random()*31+1);
			att++;
		}while(!isSame(aux));
		return att;
	}
	
	public String dayOfTheWeek(int FirstDay) {
		String s= "";
		int day=FirstDay;
		for(int i=1; i<daysUntilStartOfYear(); i++) {
			day++;
		}
		day=day%7;
		switch(day) {
		case 1: s="Lunes";
				break;
		case 2: s="Martes";
				break;
		case 3:	s="Miercoles";
				break;	
		case 4:	s="Jueves";
				break;	
		case 5: s="Viernes";
				break;
		case 6: s="Sabado";
				break;
		case 0: s="Domingo";
				break;	
			
		}
		return s;
	}
	
	public String toString() {
		return this.day + "/" + this.month + "/" + this.year;
	}

}