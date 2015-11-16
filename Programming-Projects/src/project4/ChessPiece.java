/**
 * 
 */
package project4;
import java.awt.*;
/**
 * @author joshreichman
 *
 */
public class ChessPiece {
	private Color pieceColor;
	private String label;
	private Icon icon;
	
	public void setColor(Color colorInput){
		pieceColor = colorInput;
	}
	public Color getColor(){
		return pieceColor;
	}
	public void setLabel(String labelInput){
		label = labelInput;
	}
	public String getLabel(){
		return label;
	}
	/*
	public void getIcon(Icon iconInput){
		icon = iconInput;
	}
	public Icon setIcon(){
		return icon;
	}
	*/
}