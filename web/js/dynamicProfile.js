	function GraphDrawer (target,data) {
		this.target = target;
		this.data = data;
		this.drawGraph = function(){
		  RGraph.Clear(document.getElementById(target));
		  RGraph.ObjectRegistry.Clear();
		  var line = new RGraph.Line(target, data)
		      .Set('colors', ['green'])
		      .Set('linewidth', 1)
		      .Set('filled', true)
		      .Set('fillstyle', 'rgba(128,255,128,0.5)')
		      .Set('ymax', 60)
		      .Set('numxticks', 5)
		      .Set('labels', ['Now','10s','20s','30s','40s','50s','60s'])
		      .Draw();
		  r    = RGraph.random(20,55);
		  data = [r].concat(data);
		  data.pop();
		  this.timer = setInterval(this.drawGraph, 1000);
	  };
	  this.stopDrawing = function(){
	  	clearInterval(this.timer);
	  };
	}


	// var target;
	// var data;
	// function DrawGraph (str,data1) {
	// 	target = str;
	// 	data = data1;
	// 	DrawGraph2();
	// }
	// function DrawGraph2 (){
	//   RGraph.Clear(document.getElementById(target));
	//   RGraph.ObjectRegistry.Clear();
	//   var line = new RGraph.Line(target, data)
	//       .Set('colors', ['green'])
	//       .Set('linewidth', 1)
	//       .Set('filled', true)
	//       .Set('fillstyle', 'rgba(128,255,128,0.5)')
	//       .Set('ymax', 60)
	//       .Set('numxticks', 5)
	//       .Set('labels', ['Now','10s','20s','30s','40s','50s','60s'])
	//       .Draw();
	//   r    = RGraph.random(20,55);
	//   data = [r].concat(data);
	//   data.pop();
	//   setTimeout(DrawGraph2, 1000);
 //  }

