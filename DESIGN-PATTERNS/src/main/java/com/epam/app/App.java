package com.epam.app;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



import java.util.logging.Level; 
//import java.util.logging.Logger;

interface Study {

public void work();
}
class Normal_Study implements Study {

public void work() {
System.out.print("Study:\n");
}

}

class Study_Place implements Study {

protected Study Study;

public Study_Place(Study h){
this.Study=h;
}


public void work() {
this.Study.work();
}

}
 class National extends Study_Place {

public National(Study h) {
super(h);
}


public void work(){
super.work();
System.out.print("I want to study in a national college.\n");
}
}
 class Global extends Study_Place {

public Global(Study h) {
super(h);
}


public void work(){
super.work();
System.out.print("I want to study in an international college.\n");
}
}


public class App
{
	private static final Logger LOGGER = LogManager.getLogger(App.class);
   
    public static void main( String[] args )
    {
       LOGGER.log(null, null, Level.INFO,"use of memento,behaviour patterns and decorate,structural patterns.\n");
       Study national = new National(new Normal_Study());
       Study global =new Global(new Normal_Study());
national.work();
                global.work();
System.out.println("\n*****");

Study national_global = new National(new Global(new Normal_Study()));
national_global.work();
       LOGGER.log(null, null, Level.INFO,"program terminated.\n");
       
    }
}
