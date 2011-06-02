package proyecto.p4.piezaOldWarriorTales.Unidades;



public class King extends proyecto.p4.PiezasOldWarriorTales.PiezaOldWarriorTales {
	
	public King()
	{
		movement=2;
		defense=10;
		attack=20;
		probability=100;
		blindness=false;
		poisson=false;
		counterattack=false;
		type= this.getClass().getSimpleName();
	}
	@Override
	protected void cargarHabilidades() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void restartProbability() {
		probability=100;
		
	}

}
