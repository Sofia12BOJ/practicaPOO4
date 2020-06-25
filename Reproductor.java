import javax.sound.midi.*;
class Reproductor
{
	private Synthesizer synthe = null;
	private int intensity = 100;
	private MidiChannel [] channels;
	private MidiChannel channel;


	public Reproductor()
	{
      try{
      	synthe = MidiSystem.getSynthesizer();
      } catch(Exception e){
      	System.out.println("Error al obtener synthe.");
      } 

	}
  public void inicializar(){
  	try{
  		synthe.open();
  		channels = synthe.getChannels();

  	}catch(Exception e){
  		System.out.println("Error al inicializar synthe.");
  	}
  }
public void reproducirNota(int nota, int canal, int duracion){
	channel = channels[canal];
	channel.noteOn(nota, intensity);

	try{
		Thread.sleep(duracion);
	}catch(Exception e){
		System.out.println("Error en sleep.");

}
  channel.noteOff(nota);
}
     public void finalizar(){
     	try{
     		synthe.close();
     	}catch(Exception e){
     		System.out.println("Error al finalizar en sleep.");
     	}
     }
}