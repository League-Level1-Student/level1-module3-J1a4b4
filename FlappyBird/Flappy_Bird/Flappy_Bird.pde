int birdY = 250;
int pipeX = 450;
int gap = 60;
int upperPipeHeight = 220;
int score = 0;
void setup(){
  size(250, 500);
}
void draw(){
  if (pipeX < -50){
     pipeX = 450;
     upperPipeHeight = (int) random(60, 440);
     score = score + 1;
  }
  background(100, 200, 255);
  fill(255, 255, 0);
  stroke(0, 0, 0);
   if (mousePressed){
    birdY = birdY - 2;
  }else {
    birdY = birdY + 1;
  }
  ellipse(25, birdY, 50, 50);
  fill(255, 255, 255);
  stroke(0, 0, 0);
  ellipse(44, birdY - 6, 10, 10);
  fill(0, 0, 0);
  ellipse(46, birdY - 6, 5, 5);
  fill(255, 150, 0);
  stroke(0, 0, 0);
  rect(35, birdY, 25, 9);
  fill(0, 0, 0);
  rect(40, birdY + 4, 20, 1);
  fill(0, 255, 0);
  stroke(0, 0, 0);
  rect(pipeX, upperPipeHeight + gap, 50, 500);
  fill(0, 255, 0);
  stroke(0, 0, 0);
  rect(pipeX, 0, 50, upperPipeHeight);
  pipeX = pipeX - 1;
 if (intersectsPipes()){
   exit();
 }
 fill(100, 255, 100);
 stroke(0, 0, 0);
 rect(0, 450, 250, 50);
 if (birdY > 420){
   exit();
 }
 if (birdY < 35){
  birdY = 36; 
 }
 fill(0, 0, 0);
 text(score, 5, 15);
}
 boolean intersectsPipes() { 
         if (birdY < upperPipeHeight && 25 > pipeX && 25 < (pipeX+50)){
            return true; }
        else if (birdY > upperPipeHeight + gap && 25 > pipeX && 25 < (pipeX+50)) {
            return true; }
        else { return false; }
  }
