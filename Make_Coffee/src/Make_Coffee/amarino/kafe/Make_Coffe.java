package Make_Coffee.amarino.kafe;

import android.app.Activity;
import Make_Coffee.amarino.kafe.R;
import android.os.Bundle;
import android.view.View;
//import android.widget.Button;
//import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.CheckBox;
import at.abraxas.amarino.Amarino;

public class Make_Coffe extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Amarino.connect(this, DEVICE_ADDRESS);
       
    }
    private static final String DEVICE_ADDRESS = "00:06:66:05:61:47";
	
    protected void onStop() {
		super.onStop();
		
		// if you connect in onStart() you must not forget to disconnect when your app is closed
		Amarino.disconnect(this, DEVICE_ADDRESS);
		
		// do never forget to unregister a registered receiver
		
	}
     
   int data[];
   int s=0;
   
    int kZ;
    int gala=0;
    int Ckoutalies=1;
    int Skoutalies=0;    
    int head=0;
    int MIX=0;
   
    
    public void click(View view){    	
    	
    	switch (view.getId()) {
    	case R.id.button1: 		
    	RadioButton frapes = (RadioButton) findViewById(R.id.frapes1);
    	if(frapes.isChecked()){kZ=1;}
    	RadioButton nes = (RadioButton) findViewById(R.id.nes1);
    	if(nes.isChecked()){kZ=0;}
    	RadioButton elafrys = (RadioButton) findViewById(R.id.elafrys1);
    	if(elafrys.isChecked()){Ckoutalies=1;}
    	RadioButton kanonikos = (RadioButton) findViewById(R.id.kanonikos1);
    	if(kanonikos.isChecked()){Ckoutalies=2;}
    	RadioButton varis = (RadioButton) findViewById(R.id.varis1);
    	if(varis.isChecked()){Ckoutalies=3;}
    	RadioButton sketos = (RadioButton) findViewById(R.id.sketos1);
    	if(sketos.isChecked()){Skoutalies=0;}
    	RadioButton metrios = (RadioButton) findViewById(R.id.metrios1);
    	if(metrios.isChecked()){Skoutalies=1;}
    	RadioButton glukos = (RadioButton) findViewById(R.id.glukos1);
    	if(glukos.isChecked()){Skoutalies=2;}
    	CheckBox megala=(CheckBox) findViewById(R.id.megala);
    	if(megala.isChecked()){gala=1;}
    	else{gala=0;}
    	CheckBox axtipitos=(CheckBox) findViewById(R.id.axtipitos);
    	if(axtipitos.isChecked()){MIX=1;}
    	else{MIX=0;}
    	
    	
    	
    	Amarino.sendDataToArduino(this, DEVICE_ADDRESS,'A',new int[]{Skoutalies,Ckoutalies,kZ,gala,MIX,});
    	break;
    						}//switch
    
       }//click
   
    }






