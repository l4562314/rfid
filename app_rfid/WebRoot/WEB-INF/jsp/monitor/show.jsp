<%@page language="java" pageEncoding="UTF-8"%>
<%@page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title></title>
</head>
<body>
    <canvas id="rfidCanvas" width="1280" height="800">
        您的浏览器不支持canvas标签
    </canvas>

</body>
</html>
        <script type="text/javascript" language="JavaScript">

            var rfidCanvas=document.getElementById("rfidCanvas");
            var context=rfidCanvas.getContext("2d");




            var RfidAP=function(context,params){
                this.context=context;
                this.params=params;
            }

            RfidAP.prototype={
                drawBigCircle:function(){
                    this.context.beginPath();
                    this.context.lineWidth=2;
                    this.context.strokeStyle="red";
                    this.context.arc(this.params.x,this.params.y,this.params.r,0,2*Math.PI,true);
                    this.context.fillStyle="rgba(0,0,0,0.2)";
                    this.context.fill();
                    this.context.stroke();
                },
                drawCircleCenter:function(){
                    this.context.beginPath();
                    this.context.fillStyle="red";
                    this.context.arc(this.params.x,this.params.y,10,0,2*Math.PI,true);
                    this.context.fill();
                    this.context.strokeStyle="blue";
                    this.context.strokeText(this.params.name,this.params.x+12,this.params.y);
                },
                drawCards:function(){
                    var cardDatas=this.params.cardDatas;
                    if (cardDatas&&cardDatas.length>0){
                        for (var i in cardDatas){
                            var posi=this.buildCardPosition();
                            var ap={x:this.params.x,y:this.params.y};
                            var card=new RfidCard(this.context,{ap:ap,x:posi.x,y:posi.y,cd:cardDatas[i]});
                            card.draw();
                        }
                    }
                },
                buildCardPosition:function(){
                    var position=Math.floor(Math.random()*this.params.r-10);
                    var radian=Math.random()*2*Math.PI;
                    var x=Math.floor(Math.sin(radian)*position);
                    var y=Math.floor(Math.cos(radian)*position);
                    return {x:x,y:y};
                },
                draw:function(){
                    this.drawCircleCenter();
                    this.drawBigCircle();
                    this.drawCards();
                }



            }


            var RfidCard=function(context,params){
                this.context=context;
                this.params=params;
            }

            RfidCard.prototype={
                draw:function(){
                    if (!this.params.cd){
                        return;
                    }

//                    alert(this.params.cd.status);
                    var color=this.params.cd.status==0?"red":"blue";

                    this.context.save();
                    this.context.translate(this.params.ap.x,this.params.ap.y);
                    this.context.beginPath();
                    this.context.fillStyle=color;
                    this.context.lineWidth=1;
                    this.context.strokeStyle=color;
                    this.context.arc(this.params.x,this.params.y,5,0,2*Math.PI,true);
                    this.context.strokeText(this.params.cd.name,this.params.x,this.params.y);
                    this.context.fill();
                    this.context.stroke();
                    this.context.restore();
                }
            }

            var RfidPeople=function(context,params){
                this.context=context;
                this.params=params;
            }



            var drawRfid=function(){
                context.clearRect(0,0,1280,800);
                context.drawImage(img,0,0,1280,800);

                var apData={id:1,x:300,y:300,r:200,name:'ap111'};
                var cardDatas=[];
                for (var i=0;i<4;i++){
                    cardDatas.push({id:i,name:'card00'+i,code:'code00'+i,status:i});
                }


                var apData2={id:2,x:800,y:400,r:250,name:'ap222'};
                var cardDatas2=[];
                for (var i=0;i<7;i++){
                    cardDatas2.push({id:i,name:'card00'+i,code:'code00'+i,status:i});
                }





                var ap1=new RfidAP(context,{id:apData.id,name:apData.name,x:apData.x,y:apData.y,r:apData.r,cardDatas:cardDatas});
                ap1.draw();

                var ap2=new RfidAP(context,{id:apData2.id,name:apData2.name,x:apData2.x,y:apData2.y,r:apData2.r,cardDatas:cardDatas2});
                ap2.draw();
            }

            var img=new Image();
            img.src="http://a2.att.hudong.com/57/56/01300000082825125353565084336.jpg";

            window.onload=function(){
                drawRfid();
                window.setInterval(drawRfid,2000);
            }

//            alert(3334);


//            context.beginPath();
//            context.arc(300,300,200,0,2*Math.PI,true);

            //context.drawImage();
//            context.stroke();
//            context.closePath();



//            context.beginPath();
//            context.arc(300,300,10,0,2*Math.PI,true);
//            context.fill();






        </script>