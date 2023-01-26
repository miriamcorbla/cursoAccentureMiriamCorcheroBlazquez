package interfaces02.progfuncional;

public interface Interface1 {
	
	public int cuenta(int a, int b);
	
	public default int resuelto (int a) {
		return a*2;
	}
	
	public default String saluda() {
		return "Hola qué tal?";
	}

}
