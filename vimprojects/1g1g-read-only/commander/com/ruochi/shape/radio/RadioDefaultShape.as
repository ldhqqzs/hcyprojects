﻿package com.ruochi.shape.radio{
	import flash.display.Shape;
	public class RadioDefaultShape extends Shape {
		private var _color:uint;
		private var r:int=6;
		public function RadioDefaultShape(c:uint=0xffffff):void {
			_color = c;
			draw();
		}
		private function draw():void {
			graphics.clear();
			graphics.beginFill(_color);
			graphics.drawCircle(r, r, r);
			graphics.drawCircle(r, r, r -1);
            graphics.endFill();
		}
		public function set color(c:uint):void {
			_color = c;
			draw();
		}
		public function get color():uint {
			return _color;
		}
	}
}