package com.gmail.youknowjoejoe.bio1;

public class Individual {
	private boolean tagged;
	
	public Individual(){
		this.tagged = false;
	}
	
	public void tag(){
		this.tagged = true;
	}
	
	public boolean isTagged(){
		return tagged;
	}
}
