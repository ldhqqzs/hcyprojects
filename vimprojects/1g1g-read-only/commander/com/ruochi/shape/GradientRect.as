﻿package com.ruochi.shape{
	import flash.display.Shape;
	import flash.display.SpreadMethod;
	import flash.display.GradientType;
	import flash.geom.Matrix;
	import flash.geom.Rectangle;
	public class GradientRect extends Shape {
		private var _width:Number;
		private var _height:Number;
		private var _color1:uint;
		private var _color2:uint;
		private var _alpha1:Number;
		private var _alpha2:Number;
		public function GradientRect(w:Number=100,h:Number=100,c1:uint=0xffffff,c2:uint=0x000000,a1:Number=100,a2:Number=100) {
			super();
			_width = w;
			_height = h;
			_color1 = c1;
			_color2 = c2;
			_alpha1 = a1;
			_alpha2 = a2;
			buildUI();
		}
		public function buildUI():void {
			this.graphics.clear()
			var fillType:String = GradientType.LINEAR;
			var colors:Array = [_color1, _color2];
			var alphas:Array = [_alpha1, _alpha2];
			var ratios:Array = [0x00, 0xFF];
			var matr:Matrix = new Matrix();
			matr.createGradientBox(_width, _height, Math.PI / 2, 0, 0);
			var spreadMethod:String = SpreadMethod.PAD;
			this.graphics.beginGradientFill(fillType, colors, alphas, ratios, matr, spreadMethod);
            this.graphics.drawRect(0, 0, _width, _height);			
            this.graphics.endFill();			
		}
		public function set color1(col:uint):void {
			_color1 = col;
			buildUI();
		}
		public function set color2(col:uint):void {
			_color2 = col;
			buildUI();
		}
		public function get color1():uint {
			return _color1;
		}
		public function get color2():uint {
			return _color2;
		}
	}
}