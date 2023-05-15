package com.example.flag;

public class Game {
	private String img;
	private String name;
	private String choice1;
	private String choice2;
	private String choice3;
	private String choice4;
	
	public String getImg() {
		return img;
	}
	
	public String getName() {
		return name;
	}
	
	public String getChoice1() {
		return choice1;
	}
	
	public String getChoice2() {
		return choice2;
	}
	
	public String getChoice3() {
		return choice3;
	}
	
	public String getChoice4() {
		return choice4;
	}
	
	Game(){
		this.img = "https://www.asahi-net.or.jp/~yq3t-hruc/img/JPL.GIF";
		this.name = "日本";
		this.choice1 = "韓国";
		this.choice2 = "日本";
		this.choice3 = "ブラジル";
		this.choice4 = "スイス";
	}

}
