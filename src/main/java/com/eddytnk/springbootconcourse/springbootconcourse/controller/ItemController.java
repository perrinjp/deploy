package com.eddytnk.springbootconcourse.springbootconcourse.controller;

import com.eddytnk.springbootconcourse.springbootconcourse.model.Item;
import com.eddytnk.springbootconcourse.springbootconcourse.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @GetMapping("/")
    String sayHello(){
    	return "<html>" + "\r\n" + 
			"<body>" + "\r\n" + 
			"<h1>Well done ! JPP</h1>" + "\r\n" +  
			"<script>" + "\r\n" +
			"</script>" + "\r\n" +
			"</body>" + "\r\n" +
			"</html>" ;
    }
	
    @GetMapping("/clock")
    String displayClock(){
        return "<!DOCTYPE html>" + "\n" + 
"<html>" + "\n" +
"<body>" + "\n" +
"<h1>Well done ! JPP</h1>" + "\n" +
"<canvas id=\"canvas\" width=\"400\" height=\"400\"" + "\n" +
"style=\"background-color:#333\">" + "\n" +
"</canvas>" + "\n" +

"<script>" + "\n" +
"var canvas = document.getElementById(\"canvas\");" + "\n" +
"var ctx = canvas.getContext(\"2d\");" + "\n" +
"var radius = canvas.height / 2;" + "\n" +
"ctx.translate(radius, radius);" + "\n" +
"radius = radius * 0.90" + "\n" +
"setInterval(drawClock, 1000);" + "\n" +

"function drawClock() {" + "\n" +
  "drawFace(ctx, radius);" + "\n" +
  "drawNumbers(ctx, radius);" + "\n" +
  "drawTime(ctx, radius);" + "\n" +
"}" + "\n" +

"function drawFace(ctx, radius) {" + "\n" +
  "var grad;" + "\n" +
  "ctx.beginPath();" + "\n" +
  "ctx.arc(0, 0, radius, 0, 2*Math.PI);" + "\n" +
  "ctx.fillStyle = 'white';" + "\n" +
  "ctx.fill();" + "\n" +
  "grad = ctx.createRadialGradient(0,0,radius*0.95, 0,0,radius*1.05);" + "\n" +
  "grad.addColorStop(0, '#333');" + "\n" +
  "grad.addColorStop(0.5, 'white');" + "\n" +
  "grad.addColorStop(1, '#333');" + "\n" +
  "ctx.strokeStyle = grad;" + "\n" +
  "ctx.lineWidth = radius*0.1;" + "\n" +
  "ctx.stroke();" + "\n" +
  "ctx.beginPath();" + "\n" +
  "ctx.arc(0, 0, radius*0.1, 0, 2*Math.PI);" + "\n" +
  "ctx.fillStyle = '#333';" + "\n" +
  "ctx.fill();" + "\n" +
"}" + "\n" +

"function drawNumbers(ctx, radius) {" + "\n" +
  "var ang;" + "\n" +
  "var num;" + "\n" +
  "ctx.font = radius*0.15 + \"px arial\";" + "\n" +
  "ctx.textBaseline=\"middle\";" + "\n" +
  "ctx.textAlign=\"center\";" + "\n" +
  "for(num = 1; num < 13; num++){" + "\n" +
    "ang = num * Math.PI / 6;" + "\n" +
    "ctx.rotate(ang);" + "\n" +
    "ctx.translate(0, -radius*0.85);" + "\n" +
    "ctx.rotate(-ang);" + "\n" +
    "ctx.fillText(num.toString(), 0, 0);" + "\n" +
    "ctx.rotate(ang);" + "\n" +
    "ctx.translate(0, radius*0.85);" + "\n" +
    "ctx.rotate(-ang);" + "\n" +
  "}" + "\n" +
"}" + "\n" +

"function drawTime(ctx, radius){" + "\n" +
    "var now = new Date();" + "\n" +
    "var hour = now.getHours();" + "\n" +
    "var minute = now.getMinutes();" + "\n" +
    "var second = now.getSeconds();" + "\n" +
    //hour
    "hour=hour%12;" + "\n" +
    "hour=(hour*Math.PI/6)+" + "\n" +
    "(minute*Math.PI/(6*60))+" + "\n" +
    "(second*Math.PI/(360*60));" + "\n" +
    "drawHand(ctx, hour, radius*0.5, radius*0.07);" + "\n" +
    //minute
    "minute=(minute*Math.PI/30)+(second*Math.PI/(30*60));" + "\n" +
    "drawHand(ctx, minute, radius*0.8, radius*0.07);" + "\n" +
    // second
    "second=(second*Math.PI/30);" + "\n" +
    "drawHand(ctx, second, radius*0.9, radius*0.02);" + "\n" +
"}" + "\n" +

"function drawHand(ctx, pos, length, width) {" + "\n" +
    "ctx.beginPath();" + "\n" +
    "ctx.lineWidth = width;" + "\n" +
    "ctx.lineCap = \"round\";" + "\n" +
    "ctx.moveTo(0,0);" + "\n" +
    "ctx.rotate(pos);" + "\n" +
    "ctx.lineTo(0, -length);" + "\n" +
    "ctx.stroke();" + "\n" +
    "ctx.rotate(-pos);" + "\n" +
"}" + "\n" +
"</script>" + "\n" +

"</body>" + "\n" +
"</html>";
    }

    @Autowired
    private ItemService itemService;

    @GetMapping("/items")
    public ResponseEntity<List<Item> >getItems(){
        List<Item> items = itemService.getItems();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }
}
