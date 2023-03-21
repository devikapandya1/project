
 box = {
        x:10,
        y:20,
        w:10,
        h:10,
        speed:5,
    }
function update(){
    
 console.log("update");
    box.x +=box.speed;
    box.y +=3;
    if(box.x>W){
        box.speed *= -1;
    }
}

