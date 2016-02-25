/**
 * 
 */

var createCanvas = function(rows, cols, cellWidth, cellHeight) {
	tetris_canvas = document.createElement("canvas");
	tetris_canvas.width = clos * cellWidth;
	tetris_canvas.height = rows * cellHeight;
	tetris_canvas.style.border = "1px solid black";
	//回去canvas上的绘图API
	tetris_ctx = tetris_canvas.getContext('2d');
	//开始创建路径
	tetris_ctx.beginePath();
	//绘制横向网格对应的路径
	for( var i=0; i<TETRIS_ROWS; i++){
		tetris_ctx.moveTo(0, i*CELL_SIZE);
		tetris_ctx.lineTo(TETRIS_COLS * CELL_SIZE, i*CELL_SIZE);
	}
	//绘制纵向网络对应的路径
	for( var i=0; i<TETRIS_COLS; i++){
		tetris_ctx.moveTo(i*CELL_SIZE, 0);
		tetris_ctx.lineTo(i*CELL_SIZE, TETRIS_COLS * CELL_SIZE);
	}
	
	tetris_ctx.closePath();
	//设置触笔的颜色
	tetris_ctx.strokeStyle = "#aaa";
	//设置线条粗细
	tetris_ctx.lineWidth = 0.3;
	tetris_ctx.stroke();
}