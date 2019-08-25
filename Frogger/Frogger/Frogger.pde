int frogX = 400;
int frogY = 550;
Car carI = new Car(10, 0, 100, 20);
Car carII = new Car(10, 60, 100, 15);
Car carIII = new Car(10, 120, 100, 10);
Car carIV = new Car(10, 180, 100, 5);
void setup(){
size(800, 600); 
}
void draw(){
background(100, 100, 100);
fill(0, 200, 0);
ellipse(frogX, frogY, 50, 50);
keyPressed();
carI.left();
carII.right();
carIII.left();
carIV.right();
carI.display();
carII.display();
carIII.display();
carIV.display();
if(intersects(carI)){
 frogX = 400;
 frogY = 550;
}
if(intersects(carII)){
 frogX = 400;
 frogY = 550;
}
if(intersects(carIII)){
 frogX = 400;
 frogY = 550;
}
if(intersects(carIV)){
 frogX = 400;
 frogY = 550;
}
}
void keyPressed(){
      if(key == CODED){
            if(keyCode == UP)
            {
                  if(frogY < 25){
                    exit();
                  }else{
                    frogY = frogY - 10;
                  }  
          }
            else if(keyCode == DOWN)
            {
                  if(frogY > 575){
                    frogY = 575;
                  }else{
                    frogY = frogY + 10;
                  }  
          }
            else if(keyCode == RIGHT)
            {
                  if(frogX > 775){
                    frogX = 775;
                  }else {
                    frogX = frogX + 10;
                  }
            }
            else if(keyCode == LEFT)
            {
                  if(frogX < 25){
                    frogX = 25;
                  }else {
                    frogX = frogX - 10;
                  }  
          }
      }
}
boolean intersects(Car car) {
      if ((frogY > car.getY() && frogY < car.getY()+50) && (frogX > car.getX() && frogX < car.getX()+car.getSize()))
      {
             return true;
      }
      else 
      {
             return false;
      }
}
class Car{
  int carX;
  int carY;
  int size;
  int speed;
  
  Car(int carX, int carY, int size, int speed){
   this.carX = carX;
   this.carY = carY;
   this.size = size; 
   this.speed = speed;
  }
  void display() {
      fill(255,0,0);
      rect(carX , carY, size, 50);
      fill(255, 0, 0);
      rect(carX + size/4, carY, size/2, 50);
}
int getY() {
 return carY; 
}
int getX() {
 return carX; 
}
int getSize(){
 return size; 
}
int getSpeed(){
 return speed; 
}
void right(){
 if(carX > 800 - size){
   carX = 0;
 }
   carX = carX + speed;
}
void left(){
  if(carX < 0){
    carX = 800 - size;
  }
    carX = carX - speed;
}
}
