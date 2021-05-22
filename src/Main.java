import java.util.ArrayList;
import processing.core.PApplet;

public class Main extends PApplet{

		public static void main(String[] args) {
		PApplet.main("Main");
	}

		public void settings() {
		size(500,500);
	}	
	
		private Cuadrado cuadrado;
			
		public ArrayList<Cuadrado>listaCuadrados;
		
		public void setup() {
	
			listaCuadrados = new ArrayList<>();
			
			rectMode(CENTER);
			
			frameRate(60);
		}
		
		public void draw() {
			
			background (0);
			agregarCuadrados();
			dibujarCuadrados();
		}
		
		private void dibujarCuadrados () {
			for (int i = 0; i < listaCuadrados.size(); i++) {
				listaCuadrados.get(i).pintar(this);
			}
		}
		
		private void agregarCuadrados() {
			if (frameCount == 60) {
				int tamano = (int) random(30, 60);
				int posicionX = (int) random(50, 450);
				listaCuadrados.add(new Cuadrado(posicionX, -50, tamano, this));
				frameCount = 0;
			}
		}
		
		public void mousePressed() {
			clicCuadrados();
		}
		
		private void clicCuadrados() {
			for (int i = 0; i < listaCuadrados.size(); i++) {
				if (mouseX > (listaCuadrados.get(i).getPosicionX() - (listaCuadrados.get(i).getTamano() / 2)) && 
					mouseX < (listaCuadrados.get(i).getPosicionX() + (listaCuadrados.get(i).getTamano() / 2)) && 
					mouseY > (listaCuadrados.get(i).getPosicionY() - (listaCuadrados.get(i).getTamano() / 2)) && 
					mouseY < (listaCuadrados.get(i).getPosicionY() + (listaCuadrados.get(i).getTamano() / 2))) {
					listaCuadrados.get(i).setmover(!listaCuadrados.get(i).estadoCuadrado());
					}
				}
		}
	}
