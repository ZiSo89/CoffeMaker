#include <Stepper.h>//bibliothiki gia to bimatiko kinitira
#include <MeetAndroid.h>//bibliothiki gia to android
#define motorSteps 200
//i times pou mporoume na paroume einai:
//(KZ==1 || KZ==0 && Ckoutalies>0 && Ckoutalies<=3 && 
//Skoutalies>=0 && Skoutalies<=3 && MIX==1 || MIX==0 && Gala==1 || Gala==0):
static int Skoutalies=1;//Global metabliti gia tis koutalies ti zaxaris
static int Ckoutalies=1;//Global metabliti gia tis koutalies tou kafe
static int KZ=1;//Global metabliti gia to zesto KZ-0 gia Kruo KZ=1
static int potiri=0;//simea gia to an yparxi potiri an nai potiri=1
static int Gala=0;//Global metabliti gia to gala
static int MIX=0;

int sp=0; //arxikopiisi ton bimatwn pros piso
static int st=0;//metritis gia ta bimata
const int STtime=28; //Diakopes gia miosi tis taxititas tou anadeutira pano/katw
const int pump_Gala=2;//relay (7) gia to gala 
const int buttonPin=3; //button 
const int motorPin2=4;//Bimatikos kinitiras Coin_2
const int motorPin1=5;//Bimatikos kinitiras Coin_1
const int pump_Kruo=6;//relay (1) gai to kruo nero
const int antistasi=7;//relay (8) h antistasi tou brastira 
const int panw =  8;  //relay (5) o arithmos tou relay gia kinisi tou anadeytira pros ta panw
const int katw =  9; // relay (6) o arithmos(PIN) tou relay gia kinisi tou anadeytira pros ta katw
const int sugar = 10; //relay (4) gia ti zaxari
const int pump =  11; //relay (2)gia ti antlia zestou neroy
const int coffe = 12; //relay (3)gia to kafe
const int ledPin =  13;//LED konnino gia ta sfalmata 
const int Apot=0;//LDR analog PIN input
const int Azaxar = 1;//LDR analog PIN input
const int Akafes = 2;//LDR analog PIN input


int ldr_readings = 0,a=0,b=0; ;//arxikopoiisi timoun gia to analogiko esthitira (LDR) potiriou
int buttonState = 0;//arxiki timi LOW sto Button 
Stepper myStepper(motorSteps, motorPin1,motorPin2);//sinartisi apo ti bibliothiki <Stepper.h> gia ti kinisi Bipolar kinitira
// MeetAndroid meetAndroid();
// you can define your own error function to catch messages
// where not fuction has been attached for
MeetAndroid meetAndroid(error);


void error(uint8_t flag, uint8_t values){
  Serial.print("ERROR: ");
  Serial.print(flag);
}
//sinartisi forStepPANW gia na miosoume ti taxitita tis anodoy tou anadeutira
//miwsi me polaples diakopes tasis


void forStepPANW(){
int i;
for (i=0; i<10; i++){
digitalWrite(panw, HIGH);
delay(STtime);
digitalWrite(panw,LOW);
delay(STtime);
                    }//for
            }//forStepPANW
//sinartisi forStepKATW gia na miosoume ti taxitita tis kathodou tou anadeutira
void forStepKATW(){
int i;
for (i=0; i<6; i++){
digitalWrite(katw, HIGH);
delay(STtime);
digitalWrite(katw,LOW);
delay(STtime);
                    }//for
            }//forStepPANW
//sinartisi toy anadeutira gia ti Mixi toy kafe            
  void anadeytiras(){
 //  if (MIX==0){  
    // turn on:    
    digitalWrite(panw, HIGH); //kinise pros ta epanw
    delay(500);    // wait for 500msec
    digitalWrite(panw, LOW);
    digitalWrite(katw, HIGH);   //kinise pros ta katw 
    delay(80);
    forStepKATW();
    digitalWrite(katw, LOW);
    delay(5000); //EDO ANAKATEBEI    
    forStepPANW();
    digitalWrite(panw, LOW);  
   //} else {digitalWrite(panw, LOW);
    //      digitalWrite(katw, LOW);}
}//anadeutiras



//kathorismos ton PIN tou Atmel328 gia eisodous-eksodous
//to pin 1,2 einai TX RX epikinonoun siriaka me to Bluetooth
void setup() {
  pinMode(ledPin, OUTPUT);      
  pinMode(buttonPin, INPUT); 
  pinMode(panw, OUTPUT); 
  pinMode(katw, OUTPUT);
  pinMode(sugar, OUTPUT); // sugar PIN   
  pinMode(coffe, OUTPUT); // coffe PIN
  pinMode(pump, OUTPUT);  // water pump 
  pinMode(pump_Kruo,OUTPUT);
  pinMode(pump_Gala,OUTPUT);
  pinMode(antistasi,OUTPUT);
  myStepper.setSpeed(60);//kathorismos taxutitas sto Bimatiko  
  Serial.begin(115200);
  // register callback functions, which will be called when an associated event occurs.
  // - the first parameter is the name of your function (see below)
  // - match the second parameter ('A', 'B', 'a', etc...) with the flag on your Android application
  meetAndroid.registerFunction(compass, 'A');  
}

void loop(){
  meetAndroid.receive();
   a = analogRead(Apot);//i metabliti a perni mia timi fotos 
   delay(2000);
   b = analogRead(Apot);//i metabliti b perni mia timi fotos meta apo 1sec 
   ldr_readings=b-a;//i  ldr_readings apothikebei ti diafora
  Serial.print("to ldr_readings="); Serial.println(ldr_readings);//ektipono sti othoni toy PC tis times 
  Serial.print("to potiri=");  Serial.println(potiri);
  if(ldr_readings >15){potiri=1;//an i diafora einai megali kane ti simea "1"
  Serial.print("Mpike potiri ");
  digitalWrite(ledPin,HIGH);}// enimerose oti iparxei potiri
  if(analogRead(Akafes)<10){ Serial.println("Yparxei kafes"); }// enimerose oti iparxei kafes
  if(analogRead(Azaxar)<10){ Serial.println("Yparxei zaxari"); }// enimerose oti iparxei zaxari 
  delay(1000);
}//loop

void compass(byte flag, byte numOfValues)
{ 
int values[]={0,0,0,0,0};
meetAndroid.getIntValues(values);
int Skoutalies=values[0]; Serial.print("Skoutalies=");Serial.println(Skoutalies);
int Ckoutalies=values[1]; Serial.print("Ckoutalies=");Serial.println(Ckoutalies);
int KZ=values[2]; Serial.print("KZ=");Serial.println(KZ);
int Gala=values[3]; Serial.print("Gala=");Serial.println(Gala);
int MIX=values[4]; Serial.print("MIX=");Serial.println(MIX);
 // read the state of the value: 
buttonState = digitalRead(buttonPin);
if(potiri==1) { //an ta dedomena apo to kinito stalthikan kai eipaxei to potiri 

    Serial.println("START");     //ksekina ti paragogi ektipose sti ouoni
 digitalWrite(ledPin,LOW);
//pireiorise tis timese ton parametrion:
if(KZ==1 || KZ==0 && Ckoutalies>0 && Ckoutalies<=3 && Skoutalies>=0 && Skoutalies<=3 && MIX==1 || MIX==0 && Gala==1 || Gala==0 ){
// turn on:   

      if(KZ==0){//noInterrupts();
                digitalWrite(antistasi,HIGH);     
               // delay(60000);//Zestane to nero gia 2min
               // interrupts();
              }//antistasi}
  delay(500);
  //Zax:
  myStepper.step(390); st+=390; delay(500); //pane to potiri sti zaxari
  digitalWrite(sugar,HIGH);     delay(3000*Skoutalies);//bale ti zaxari
  digitalWrite(sugar,LOW);      delay(500);
  // Kaf:
  myStepper.step(158); st+=158; delay(500);//pane to potiri sto kafe
  digitalWrite(coffe,HIGH);     delay(5000*Ckoutalies);//bale ti kafe
  digitalWrite(coffe,LOW);      delay(500);
  
  //pane to potiri sta Ygra, anadeutira
  myStepper.step(-437); st=st-437; delay(500);
  digitalWrite(pump_Kruo,HIGH);    delay(500);
  digitalWrite(pump_Kruo,LOW);  
 if(MIX==0){ anadeytiras();} //kalese ti sinartisi tou gia MIX
   
   if(KZ==1){
          digitalWrite(pump_Kruo, HIGH);      delay(4000);
          digitalWrite(pump_Kruo,LOW); 
          if(Gala==1){
          digitalWrite(pump_Gala,HIGH);    delay(400);
          digitalWrite(pump_Gala,LOW);   
          }// if gala
          delay(4500);
      
        }// if KZ
    
    if(KZ==0) { 
           delay(50000);
           digitalWrite(pump,HIGH);      delay(1900);
           digitalWrite(pump,LOW);        
           if(Gala==1){
           digitalWrite(pump_Gala,HIGH);    delay(400);
           digitalWrite(pump_Gala,LOW); }// if gala 
           digitalWrite(antistasi,LOW);
           delay(4500);
        
           
       }// else KZ           
          
    
   else digitalWrite(pump_Gala,LOW);
  
  myStepper.step(-st);           delay(2000);//pane to potiri stin arxiki thesi
  digitalWrite(antistasi,LOW);     
  st=0;// midenise tin simea gia t bimata tou kinitira
  potiri=0;// midenise tin simea potirioy
  Serial.println("END PARE TO KAFE");
                             }//if ton parametrion:
  else 
    // turn off olo to sistima:
    Serial.println("LATHOS PARAMETROUS");
    digitalWrite(panw, LOW);
    digitalWrite(katw, LOW);
    digitalWrite(pump, LOW);
    digitalWrite(sugar, LOW);
    digitalWrite(coffe, LOW);
    digitalWrite(ledPin, LOW);
    digitalWrite(pump_Kruo, LOW);
    digitalWrite(pump_Gala, LOW);
    digitalWrite(antistasi, LOW);
}//heading
}//void compass

