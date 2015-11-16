#include <CustomStepper.h>

// Pinos 8, 9, 10, 11 stepper
CustomStepper stepper(8, 9, 10, 11, (byte[]){8, B1000, B1100, B0100,
B0110, B0010, B0011, B0001, B1001}, 4075.7728395, 12, CW);

int l = 108; // Liga a luz
int o = 111; // Desliga a luz

int s = 115; // Sobe lona
int d = 100; // Desce lona

int v = 118; // Liga ventilador
int x = 120; // Desliga ventilador

int t = 116; // Lê temperatura

// Pinos
int luz = 13;
int ventilador = 7;
int pinTemperatura = 6;

int numeroVoltasLona = 8;

boolean rotate = false;

void setup() {
  Serial.begin(9600);
  pinMode(luz, OUTPUT);
  pinMode(ventilador, OUTPUT);

   //Define a velocidade do motor
   stepper.setRPM(18);
   //Define o numero de passos por rotacao
   stepper.setSPR(4075.7728395);
}

void loop() {
  if(rotate == false){
     stepper.setDirection(CCW);
     stepper.rotateDegrees(2);
     rotate = true;
  }

  if (Serial.available() > 0) {
    int recv = Serial.read();

    if (recv == l){
      digitalWrite(luz, HIGH);
      Serial.println("Ligando as luzes");
    } else if(recv == o) {
      digitalWrite(luz, LOW);
      Serial.println("Desligando as luzes");
    }

    if (recv == v){
      digitalWrite(ventilador, HIGH);
      Serial.println("Ligando os ventiladores");
    } else if(recv == x) {
      digitalWrite(ventilador, LOW);
      Serial.println("Desligando os ventiladores");
    }

    if (recv == t){
      float valTemperatura = analogRead(pinTemperatura);
      float temperatura = (valTemperatura * 0.00488)*100;
      //double temperatura;
      //temperatura = log(((10240000/valTemperatura) - 10000));
      //temperatura = 1 / (0.001129148 + (0.000234125 + (0.0000000876741 * temperatura * temperatura )) * temperatura);
      //temperatura = temperatura - 273.15;              // Convert Kelvin to Celsius
      Serial.print("Temperatura em celsius: ");
      Serial.println(temperatura);
    }

    if(recv == d){
        if (stepper.isDone()) {
          Serial.println("Lonas descendo");
          stepper.setDirection(CW);
          stepper.rotate(numeroVoltasLona);
        }
    } else if (recv == s){
        if (stepper.isDone()) {
          Serial.println("Lonas subindo");
          stepper.setDirection(CCW);
          stepper.rotate(numeroVoltasLona);
        }
    }

    // confirm values received in serial monitor window
    Serial.print("--Arduino received: ");
    Serial.println(recv);
  }

  stepper.run();
}