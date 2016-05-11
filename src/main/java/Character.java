package main.java;

import java.util.ArrayList;

import de.looksgood.ani.Ani;

/**
* This class is used to store states of the characters in the program.
* You will need to declare other variables depending on your implementation.
*/
public class Character
{
	
	private MainApplet parent;
	public String name;
	public int color;
	public float x, y, r, sx, sy;
	public boolean isMove = false, isIn = false;
	private ArrayList<Character> targets;
	
	public Character(MainApplet parent, String name, int color, int x, int y)
	{
		this.parent = parent;
		this.name = name;
		this.color = color;
		this.x = x;
		this.y = y;
		this.r = 30;
		this.sx = x;
		this.sy = y;
		targets = new ArrayList<Character>();
		Ani.init(this.parent);
	}

	public void display() //print a small circle to represent character
	{
		this.parent.fill(color);
		this.parent.stroke(color);
		this.parent.ellipse(x+40, y+40, r, r);		
	}
	
	public void mouseEvent() //how the position and click of mouse influence the character
	{
		int i=0;
		for(Character character : this.parent.characters) //find if there is a character moving now
		{
			if(character.isMove && !character.equals(this)) break;
			i++;
		}
		if(i==this.parent.characters.size()) //if there is not character moving now
		{
			//if the mouse put on the character
			if(this.parent.mouseX > x+25 && this.parent.mouseX < x+55 && this.parent.mouseY > y+25 && this.parent.mouseY < y+55)
			{
				//if press, start to move it
				if(this.parent.mousePressed) isMove = true;
				if(!isMove) showName(); //show name
				r=35; //increase the area of the character
			}
			else r=30; //set back to origin area
		}
		if(isMove) move();
	}
	
	public void move()
	{
		display(); //print it again, prevent it being covered by others
		if(this.parent.mousePressed)
		{
			//the character will follow the mouse
			x = this.parent.mouseX-40;
			y = this.parent.mouseY-40;
			showName();
		}
		else //if stop pressing
		{
			//if it is in the big circle, put it onto the big circle
			if(Math.pow(x-560, 2)+ Math.pow(y-280, 2) < Math.pow(250, 2))
			{
				isIn = true;
				adjustCircle();
			}
			else //otherwise, put it back to origin position with animation
			{
				isIn = false;
				adjustCircle();
				moveBack();
			}
			isMove = false; //stop moving
		}
	}
	
	public void moveBack()
	{
		Ani.to(this, (float)0.7, "x", sx);
		Ani.to(this, (float)0.7, "y", sy);
	}
	
	public void showName()
	{
		//show name, the width of rectangle depend on the length of word
		this.parent.fill(171, 202, 176);
		this.parent.stroke(171, 202, 176);
		this.parent.rect(x+40, y+25, name.length()*15, 30, 10);
		this.parent.fill(255);
		this.parent.textSize(18);
		this.parent.text(name, x+45, y+47);
	}
	
	public void adjustCircle()
	{
		double num = 0, i = 0, angle;
		//count how many is in big circle first
		for(Character character : this.parent.characters) if(character.isIn) num++;
		for(Character character : this.parent.characters)
		{
			if(character.isIn)
			{
				angle = 360/num * i; //divide to num parts, and multiply with increasing i
				angle = Math.toRadians(angle); //change to Radians
				i++;
				character.x = (float) (560 + 250 * Math.cos(angle)); //x = c + r * cos
				character.y = (float) (280 - 250 * Math.sin(angle)); //y = c - r * sin
				
			}
		}
	}

	public void addTarget(Character target){
		targets.add(target);
	}
}
