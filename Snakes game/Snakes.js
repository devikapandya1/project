function init() {
    //console.log("init");

canvas = document.getElementById('mycanvas');
    pen = canvas.getContext('2d');
    W = canvas.width;
    H = canvas.height;
    
    food = getRendomFood();
    score =5;
   snake = {
       init_length:5,
       color:"aqua",
       cells:[],
       direction:"right",
       
       
       createSnake:function(){
           for(var i=this.init_length-1; i>=0;i--){
               this.cells.push({x:i,y:0});
           }
       },
       
       drawSnake:function(){
           for(var i=0;i<this.cells.length;i++){
               pen.fillStyle = this.color;
               pen.strokeStyle="black";
               pen.lineWidth =5;
               
               pen.fillRect(this.cells[i].x*10,this.cells[i].y*10,10,10);
               pen.strokeRect(this.cells[i].x*10,this.cells[i].y*10,10,10);
           }
       },
       updateSnakes:function(){
           var headX = this.cells[0].x;
           var headY = this.cells[0].y;
//           nextHeadX = headX+1;
           
           
           if(headX==food.x && headY==food.y){
               food = getRendomFood();
               score++;
           }
           else{
               this.cells.pop();
           }
           
//           this.cells.unshift({x:nextHeadX,y:headY});
           if(this.direction == "right"){
               nextX = headX+1;
               nextY = headY;
               
           }
           else if(this.direction=="left"){
               nextX = headX-1;
               nextY = headY;
           }
           else if (this.direction=="down"){
               nextX = headX;
               nextY = headY +1;
               
           }
           else{
               nextX = headX;
               nextY = headY -1;
           }
//          
           this.cells.unshift({x:nextX,y:nextY});
       }
      
      
   };
    snake.createSnake();
    
    
    function KeyPressed(e){
        console.log("you pressed a key");
        console.log(e);
        if(e.key == "ArrowRight"){
            snake.direction="right";
        }
        else if(e.key == "Arrowleft"){
            snake.direction="left";
        }
        else if(e.key== "ArrowDown"){
            snake.direction="down";
        }
        else{
            snake.direction="up";
        }
    }
    
    document.addEventListener('keydown',KeyPressed);
    
    
 }

function draw() {
    pen.clearRect(0,0,W,H);
    snake.drawSnake();
    pen.fillStyle = food.color;
    pen.fillRect (food.x*10,food.y*10,10,10);
//    console.log("draw");
//    
//    pen.fillStyle="green";
//    pen.fillRect(box.x, box.y, box.w, box.h);
//    
    
}
function update(){
    snake.updateSnakes();
    
}
function gameloop(){
    draw();
    update();
    
}
function getRendomFood(){
    var foodX = Math.round(Math.random()*(W-10)/10);
    var foodY = Math.round(Math.random()*(H-10)/10);
    
    foodColors=["red","green","coral"];
    var i = Math.round(Math.random()*foodColors.length);
    
    var food = {
        x:foodX,
        y:foodY,
        color:foodColors[i],
    }
    return food;
}

init();
setInterval(gameloop,100);

