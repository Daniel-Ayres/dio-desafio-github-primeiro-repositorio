package equipamentos.estabelecimento;

import equipamentos.copiadora.Copiadora;
import equipamentos.digitalizadora.Digitalizadora;
import equipamentos.impressora.Deskjet;
import equipamentos.impressora.Impressora;
import equipamentos.impressora.Laserjet;
import equipamentos.multifuncional.EquipamentoMultifuncional;

public class Loja {
	 public static void main(String[] args) {
	        Impressora impressora = new EquipamentoMultifuncional();
	        
	        impressora.imprimir();
	    }
}

